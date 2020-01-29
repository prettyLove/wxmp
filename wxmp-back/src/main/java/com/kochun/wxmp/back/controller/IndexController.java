package com.kochun.wxmp.back.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kochun.wxmp.back.il8n.LocaleMessage;
import com.kochun.wxmp.core.entity.system.SysUser;
import com.kochun.wxmp.back.service.system.SysUserService;
import com.kochun.wxmp.core.vo.internal.response.ResponseResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class IndexController {

    @Resource
    SysUserService sysUserService;

    @Resource
    LocaleMessage localeMessage;

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
    public ResponseEntity<?>  list(){

        //List<SysUser> list=sysUserService.list();
        IPage<SysUser> iPage=new Page<>(1,10);
        iPage=sysUserService.page(iPage);
        System.out.println(JSONArray.toJSONString(iPage));

        ResponseResult responseResult = ResponseResult.successResponse(localeMessage.getMessage("SUCCESS"));
        responseResult.setData(iPage);
        return new ResponseEntity<>(responseResult, HttpStatus.OK);
    }

    @PostMapping("/user/view")
    public String view(){

        List<SysUser> list=sysUserService.list();

        System.out.println(JSONArray.toJSONString(list));

        return "user:view";
    }


    @ApiOperation(value="新增用户", notes="")
    @PostMapping("/user/insert")
    public ResponseEntity<?> insert(SysUser sysUser){

        System.out.println(JSONObject.toJSONString(sysUser));
        sysUserService.save(sysUser);
        //QueryWrapper<SysUser> queryWrapper=new QueryWrapper<>();

        ResponseResult responseResult = ResponseResult.successResponse(localeMessage.getMessage("SUCCESS"));

        return new ResponseEntity<>(responseResult, HttpStatus.OK);
    }
}
