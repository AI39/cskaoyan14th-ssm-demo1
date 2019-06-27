package com.cskaoyan14th.service.impl;

import com.cskaoyan14th.bean.Manufacture;
import com.cskaoyan14th.mapper.ManufactureMapper;
import com.cskaoyan14th.service.manufactureService;
import com.cskaoyan14th.vo.Vo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class manufactureServiceImpl implements manufactureService {
    @Autowired
    ManufactureMapper manufactureMapper;

    @Override
    public Vo<Manufacture> getManufactureList(int page, int rows) {
        PageHelper.startPage(page, rows);
        List<Manufacture> manufacture1 = manufactureMapper.multiSelectAll();
        PageInfo<Manufacture> pageInfo = new PageInfo<Manufacture>(manufacture1);
        Vo<Manufacture> manufactureList = new Vo<Manufacture>(pageInfo.getTotal(), pageInfo.getList());
        return manufactureList;
    }
}
