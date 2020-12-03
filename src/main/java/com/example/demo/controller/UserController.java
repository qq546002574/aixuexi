package com.example.demo.controller;


import com.example.demo.common.utils.DataResult;
import com.example.demo.entity.RoleEntity;
import com.example.demo.entity.UserEntity;
import com.example.demo.service.RoleService;
import com.example.demo.service.UserService;
import com.example.demo.vo.RoleVO;
import com.example.demo.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/roleuser", method = RequestMethod.POST)
    public DataResult roleuser(RoleVO roleVO) {
        try {
            List<RoleEntity> list = roleService.getByRoleUser(roleVO);
            return DataResult.success(list);
        } catch (Exception e) {
            e.printStackTrace();
            return DataResult.fail("请求错误");
        }
    }

    @RequestMapping(value = "/{id}/changepw", method = RequestMethod.POST)
    public DataResult changepw(@PathVariable Integer id, String password) {
        try {
            int updateNum = userService.updatePw(id, password);
            return DataResult.success();
        } catch (Exception e) {
            e.printStackTrace();
            return DataResult.fail("请求错误");
        }
    }

    @RequestMapping(value = "/{roleId}/base", method = RequestMethod.POST)
    public DataResult base(@PathVariable Integer roleId) {
        try {
            RoleEntity roleEntity = roleService.getById(roleId);
            return DataResult.success(roleEntity);
        } catch (Exception e) {
            e.printStackTrace();
            return DataResult.fail("请求错误");
        }
    }
}
