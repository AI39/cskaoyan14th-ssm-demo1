package com.cskaoyan14th.service.impl;

import com.cskaoyan14th.bean.FinalCountCheckVo;
import com.cskaoyan14th.bean.ProcessCountCheckVo;
import com.cskaoyan14th.mapper.ProcessCountCheckMapper;
import com.cskaoyan14th.service.ProcessCountCheckService;
import com.cskaoyan14th.vo.Vo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Yuechao Yang
 * @version 2019-06-28-14:53
 */
@Service
public class ProcessCountCheckServiceImpl implements ProcessCountCheckService {

    @Autowired
    ProcessCountCheckMapper processCountCheckMapper;

    @Override
    public Vo<ProcessCountCheckVo> queryProcessCountLeftEmployee(int page, int rows) {
        PageHelper.startPage(page,rows);                                                                                /*这里是设置生成的page数和行数，由前端实现*/

        List<ProcessCountCheckVo> processCountCheckVoList1 = processCountCheckMapper.queryProcessCountCheckLeftEmployee();/*调用底层的方法查询到三张表中的符合条件的合并成一个list*/

        PageInfo<ProcessCountCheckVo> pageInfo = new PageInfo<>(processCountCheckVoList1);                                 /*根据生成到的list再生成一个pageInfo文件*/

        //一个包含数目和当前页对象列表的封装对象，意思是把它封装成page对象
        Vo<ProcessCountCheckVo> processCountCheckVoList = new Vo<>(pageInfo.getTotal(),pageInfo.getList());

        return processCountCheckVoList;
    }
}
