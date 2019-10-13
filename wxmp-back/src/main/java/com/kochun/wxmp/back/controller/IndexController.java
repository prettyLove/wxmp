package com.kochun.wxmp.back.controller;

import com.alibaba.fastjson.JSONArray;
import com.kochun.wxmp.core.entity.system.SysUser;
import com.kochun.wxmp.back.service.system.SysUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class IndexController {

    @Resource
    SysUserService sysUserService;

    @GetMapping("/getUserList")
    public String getUserList(){

        List<SysUser> list=sysUserService.list();

        System.out.println(JSONArray.toJSONString(list));

        return "111";
    }

    @PostMapping("/test")
    public String test(){

        List<SysUser> list=sysUserService.list();

        System.out.println(JSONArray.toJSONString(list));

        return "111";
    }

    @PostMapping("/user/list")
    public String list(){

        List<SysUser> list=sysUserService.list();

        System.out.println(JSONArray.toJSONString(list));

        return "user:list";
    }

    @PostMapping("/user/view")
    public String view(){

        List<SysUser> list=sysUserService.list();

        System.out.println(JSONArray.toJSONString(list));

        return "user:view";
    }
}
