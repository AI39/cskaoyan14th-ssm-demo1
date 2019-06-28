package com.cskaoyan14th.service.impl;

import com.cskaoyan14th.bean.Custom;
import com.cskaoyan14th.bean.CustomExample;
import com.cskaoyan14th.mapper.CustomMapper;
import com.cskaoyan14th.service.CustomService;
import com.cskaoyan14th.vo.Vo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    @Override
    public Vo<Custom> queryCustomListPage(int page, int rows) {
        PageHelper.startPage(page,rows);
        //查询
        CustomExample example = new CustomExample();
        CustomExample.Criteria criteria = example.createCriteria();
        criteria.andCustomIdIsNotNull();
        List<Custom> list = customMapper.selectByExample(example);

        PageInfo<Custom> pageInfo = new PageInfo<>(list);
        //一个包含数目和当前页对象列表的封装对象
        Vo<Custom> customList = new Vo<>(pageInfo.getTotal(),pageInfo.getList());
        return customList;
    }

    @Override
    public int addCustom(Custom custom) {
        return customMapper.insert(custom);
    }

    @Override
    public int updateCustom(Custom custom) {
        return customMapper.updateByPrimaryKey(custom);
    }

    @Override
    public int deleteCustomsByIds(String[] ids) {
        List<String> idList = new ArrayList<>();
        for (String id : ids) {
            idList.add(id);
        }
        CustomExample example = new CustomExample();
        CustomExample.Criteria criteria = example.createCriteria();
        criteria.andCustomIdIn(idList);
        return customMapper.deleteByExample(example);
    }


}
