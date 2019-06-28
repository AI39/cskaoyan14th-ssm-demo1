package com.cskaoyan14th.service.impl;

import com.cskaoyan14th.bean.FinalCountCheck;
import com.cskaoyan14th.bean.FinalCountCheckVo;
import com.cskaoyan14th.bean.FinalMeasuretCheckVo;
import com.cskaoyan14th.mapper.FinalCountCheckMapper;
import com.cskaoyan14th.service.FinalCountCheckService;
import com.cskaoyan14th.vo.Vo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Yuechao Yang
 * @version 2019-06-28-11:21
 */
@Service
public class FinalCountCheckServiceImpl implements FinalCountCheckService {
    @Autowired
    FinalCountCheckMapper finalCountCheckMapper;

    @Override
    public Vo<FinalCountCheck> queryFinalCountLeftEmployee(int page, int rows) {
        PageHelper.startPage(page,rows);                                                                                /*这里是设置生成的page数和行数，由前端实现*/

        List<FinalCountCheck> finalCountCheckList1 = finalCountCheckMapper.queryFinalCountCheckLeftEmployee();/*调用底层的方法查询到三张表中的符合条件的合并成一个list*/

        PageInfo<FinalCountCheck> pageInfo = new PageInfo<>(finalCountCheckList1);                                 /*根据生成到的list再生成一个pageInfo文件*/

        //一个包含数目和当前页对象列表的封装对象，意思是把它封装成page对象
        Vo<FinalCountCheck> finalCountCheckList = new Vo<>(pageInfo.getTotal(),pageInfo.getList());

        return finalCountCheckList;
    }
}
