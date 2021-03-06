package com.kochun.wxmp.back.service.system.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kochun.wxmp.core.entity.system.EmailTemplate;
import com.kochun.wxmp.back.mapper.system.EmailTemplateMapper;
import com.kochun.wxmp.back.service.system.EmailTemplateService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author kochun
 * @since 2019-08-26
 */
@Service
public class EmailTemplateServiceImpl extends ServiceImpl<EmailTemplateMapper, EmailTemplate> implements EmailTemplateService {

    @Resource
    EmailTemplateMapper emailTemplateMapper;

    @Override
    public EmailTemplate getByOperation(String operation) {
        QueryWrapper<EmailTemplate> queryWrapper=new QueryWrapper();
        queryWrapper.eq("operation",operation);
        return emailTemplateMapper.selectOne(queryWrapper);
    }
}
