package com.cskaoyan14th.service.impl;

import com.cskaoyan14th.bean.Work;
import com.cskaoyan14th.mapper.WorkMapper;
import com.cskaoyan14th.service.WorkService;
import com.cskaoyan14th.vo.Vo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkServiceImpl implements WorkService {
    @Autowired
    WorkMapper workMapper;

    @Override
    public Vo<Work> getWorkList(int page, int rows) {
        PageHelper.startPage(page, rows);
        List<Work> workList1 = workMapper.multiSelectAll();
        PageInfo<Work> pageInfo = new PageInfo<Work>(workList1);
        Vo<Work> workList = new Vo<Work>(pageInfo.getTotal(), pageInfo.getList());
        return workList;
    }
}
