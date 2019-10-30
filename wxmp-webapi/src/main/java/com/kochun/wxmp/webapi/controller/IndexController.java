package com.kochun.wxmp.webapi.controller;

import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kochun.wxmp.core.entity.system.SysUser;
import com.kochun.wxmp.back.service.system.SysUserService;
import org.springframework.web.bind.annotation.GetMapping;
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

        //List<SysUser> list1=sysUserService.selectTest();
        IPage<SysUser> page=new Page<>();
        page.setPages(2);
        page.setSize(10);
        Page<SysUser> pageList= (Page<SysUser>) sysUserService.page(page);

        System.out.println(JSONArray.toJSONString(list));

        //System.out.println(JSONArray.toJSONString(list1));

        System.out.println(JSONArray.toJSONString(pageList));
        return "111";
    }
}