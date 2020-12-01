package com.example.demo.controller;


import com.example.demo.common.utils.DataResult;
import com.example.demo.entity.UserEntity;
import com.example.demo.service.UserService;
import com.example.demo.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public UserEntity getEntity(@PathVariable Integer id) {
        System.out.println("id:" + id);
        return userService.getById(id);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public DataResult login(UserVO userVO) {
        try {
            System.out.println("*****"+ userVO.getUsername());
            UserEntity userEntity = userService.getByUserName(userVO.getUsername());
            if (userEntity.getPassword().equals(userVO.getPassword())) {
                return DataResult.success();
            } else {
                return DataResult.fail("账号密码错误");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return DataResult.fail("请求错误");
        }
    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public DataResult logout() {
        try {
            return DataResult.success("退出成功");
        } catch (Exception e) {
            return DataResult.fail("请求错误");
        }
    }
}
