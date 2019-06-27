package com.cskaoyan14th.service.impl;

import com.cskaoyan14th.bean.Custom;
import com.cskaoyan14th.bean.CustomExample;
import com.cskaoyan14th.mapper.CustomMapper;
import com.cskaoyan14th.service.CustomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomServiceImpl implements CustomService {
    @Autowired
    CustomMapper customMapper;

    @Override
    public List<Custom> queryCustoms(){
        CustomExample example = new CustomExample();
        CustomExample.Criteria criteria = example.createCriteria();
        criteria.andCustomIdIsNotNull();
        List<Custom> customs = customMapper.selectByExample(example);
        return customs;
    }

    @Override
    public Custom queryCustomById(String id) {
        Custom custom = customMapper.selectByPrimaryKey(id);
        return custom;
    }


}
