package com.kochun.wxmp.back.init;

import com.alibaba.fastjson.JSONObject;
import com.kochun.wxmp.back.config.RedisService;
import com.kochun.wxmp.common.Constant;
import com.kochun.wxmp.core.bo.system.RoleSystemModuleVO;
import com.kochun.wxmp.back.service.system.SystemModuleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * 初始化加载菜单，用于角色权限判断
 * @Author: kochun
 * @Date: 2019-09-12 22:11
 * @version: 1.0
 */
@Slf4j
@Component
public class InitModuleData implements ApplicationRunner {

    @Resource
    RedisService redisService;

    @Resource
    SystemModuleService systemModuleService;


    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("初始化基础数据  start");
        List<RoleSystemModuleVO> list=systemModuleService.listRoleSystemModuleVO();

        list.forEach(roleSystemModuleVO -> {
            redisService.set(roleSystemModuleVO.getRoleCode()+Constant.PREFIX_ROLE_SYSMODULE_KEY.replace("{regex}",roleSystemModuleVO.getModuleUrl()),roleSystemModuleVO);
        });
        log.info("初始化基础数据  end");
    }

}
