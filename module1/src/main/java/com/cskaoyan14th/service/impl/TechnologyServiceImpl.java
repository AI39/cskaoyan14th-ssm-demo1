package com.cskaoyan14th.service.impl;

import com.cskaoyan14th.bean.Material;
import com.cskaoyan14th.bean.Technology;
import com.cskaoyan14th.bean.TechnologyExample;
import com.cskaoyan14th.mapper.TechnologyMapper;
import com.cskaoyan14th.service.TechnologyService;
import com.cskaoyan14th.vo.Vo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TechnologyServiceImpl implements TechnologyService {
    @Autowired
    TechnologyMapper technologyMapper;

    @Override
    public Vo<Technology> getTechnologyVo(int page, int rows) {
        PageHelper.startPage(page,rows);

        TechnologyExample technologyExample = new TechnologyExample();
        TechnologyExample.Criteria criteria = technologyExample.createCriteria();
        criteria.andTechnologyIdIsNotNull();
        List<Technology> list = technologyMapper.selectByExample(technologyExample);
        PageInfo<Technology> pageInfo = new PageInfo<>(list);
        Vo<Technology> technologyVo = new Vo<>(pageInfo.getTotal(), pageInfo.getList());

        return technologyVo;
    }
}
