package com.example.demo.controller;


import com.example.demo.common.utils.DESUtil;
import com.example.demo.common.utils.DataResult;
import com.example.demo.config.redis.RedisCount;
import com.example.demo.config.redis.RedisKey;
import com.example.demo.config.redis.RedisUtil;
import com.example.demo.entity.UserEntity;
import com.example.demo.service.UserService;
import com.example.demo.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@CrossOrigin
@RequestMapping("/admin")
public class AdminController {
    private Logger logger = LoggerFactory.getLogger(AdminController.class);
    @Autowired
    private UserService userService;

    @Autowired
    private RedisUtil redisUtil;

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public UserEntity getEntity(@PathVariable Integer id) {
        System.out.println("id:" + id);
        return userService.getById(id);
    }

    @RequestMapping(value = "/login", method = {RequestMethod.POST, RequestMethod.GET })
    public DataResult login(UserVO userVO) {
        try {
            logger.info("根据token获取用户信息,token:{}", userVO.getUsername());
            UserEntity userEntity = userService.getByUserName(userVO.getUsername());
            String userName = userEntity.getUsername();
            if (userEntity.getStatus() != 1) {
                return DataResult.fail("账号已被禁用，无法登录");
            }
            if (userEntity.getPassword().equals(userVO.getPassword())) {
                redisUtil.setex(RedisKey.TMS_WELL_KEY + userName, RedisCount.OUTTIMECOUNT, userEntity.toString());
                UUID uuid = UUID.randomUUID();
                String wow = DESUtil.encrypt(uuid + userName, DESUtil.CRYPTKEY);
                return DataResult.success(wow);
            } else {
                return DataResult.fail("账号密码错误");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return DataResult.fail("请求错误");
        }
    }

    @RequestMapping(value = "/getObjectByToken", method = {RequestMethod.POST ,RequestMethod.GET })
    public DataResult getObjectByToken(String token) {
        try {
            logger.info("根据token获取用户信息,token:{}", token);
            if (token == null || token.length() < 36) {
                logger.info("token异常,为空或非法token:{}", token);
                return DataResult.fail("token异常,为空或非法token");
            }
            String decrypt = DESUtil.decrypt(token, DESUtil.CRYPTKEY);
            String redisKey = decrypt.substring(36);
            String tokenInfoBytes = redisUtil.get(RedisKey.TMS_WELL_KEY + redisKey, 0);
            if (tokenInfoBytes == null) {
                return DataResult.fail("token异常,为空或非法token");
            }
            return DataResult.success(tokenInfoBytes);
        } catch (Exception e) {
            e.printStackTrace();
            return DataResult.fail("请求错误");
        }
    }

    @RequestMapping(value = "/logout", method = {RequestMethod.POST ,RequestMethod.GET })
    public DataResult logout(String token) {
        try {
            logger.info("根据token获取用户信息,token:{}", token);
            if (token == null || token.length() < 36) {
                logger.info("token异常,为空或非法token:{}", token);
                return DataResult.fail("token异常,为空或非法token");
            }
            String decrypt = DESUtil.decrypt(token, DESUtil.CRYPTKEY);
            String redisKey = decrypt.substring(36);
            redisUtil.del(RedisKey.TMS_WELL_KEY + redisKey);
            return DataResult.success("退出成功");
        } catch (Exception e) {
            return DataResult.fail("请求错误");
        }
    }
}
