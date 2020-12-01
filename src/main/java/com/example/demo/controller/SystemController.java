package com.example.demo.controller;


import com.example.demo.common.utils.DataResult;
import com.example.demo.service.UserService;
import com.example.demo.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sys")
public class SystemController {

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/config", method = RequestMethod.POST)
    public DataResult config(UserVO userVO) {
        try {
            return DataResult.success();
        } catch (Exception e) {
            e.printStackTrace();
            return DataResult.fail("请求错误");
        }
    }

}
