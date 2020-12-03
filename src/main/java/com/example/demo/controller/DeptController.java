package com.example.demo.controller;


import com.example.demo.common.utils.DataResult;
import com.example.demo.entity.DeptEntity;
import com.example.demo.service.DeptService;
import com.example.demo.service.UserService;
import com.example.demo.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dept")
public class DeptController {

    @Autowired
    private DeptService deptService;

    @RequestMapping(value = "/sub", method = RequestMethod.POST)
    public DataResult sub(UserVO userVO) {
        try {
            return DataResult.success();
        } catch (Exception e) {
            e.printStackTrace();
            return DataResult.fail("请求错误");
        }
    }

    @RequestMapping(value = "/docmark", method = RequestMethod.POST)
    public DataResult docmark(UserVO userVO) {
        try {
            return DataResult.success();
        } catch (Exception e) {
            e.printStackTrace();
            return DataResult.fail("请求错误");
        }
    }

    @RequestMapping(value = "/refresh", method = RequestMethod.POST)
    public DataResult refresh(UserVO userVO) {
        try {
            return DataResult.success();
        } catch (Exception e) {
            e.printStackTrace();
            return DataResult.fail("请求错误");
        }
    }

    @RequestMapping(value = "/tree", method = RequestMethod.POST)
    public DataResult tree(UserVO userVO) {
        try {
            List<DeptEntity> list = deptService.getAll();
            return DataResult.success(list);
        } catch (Exception e) {
            e.printStackTrace();
            return DataResult.fail("请求错误");
        }
    }
}
