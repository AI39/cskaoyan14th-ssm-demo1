package com.cskaoyan14th.service.impl;

import com.cskaoyan14th.bean.*;
import com.cskaoyan14th.mapper.ProcessMeasureCheckMapper;
import com.cskaoyan14th.service.ProcessMeasureCheckService;
import com.cskaoyan14th.vo.Vo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Yuechao Yang
 * @version 2019-06-28-14:54
 */
@Service
public class ProcessMeasureCheckServiceImpl implements ProcessMeasureCheckService {

    @Autowired
    ProcessMeasureCheckMapper processMeasureCheckMapper;

    @Override
    public Vo<ProcessMeasureCheck> queryProcessMeasureLeftEmployee(int page, int rows) {
        PageHelper.startPage(page,rows);                                                                                /*这里是设置生成的page数和行数，由前端实现*/

        List<ProcessMeasureCheck> processMeasureCheckVoList1 = processMeasureCheckMapper.queryProcessMeasureCheckLeftEmployee();/*调用底层的方法查询到三张表中的符合条件的合并成一个list*/

        PageInfo<ProcessMeasureCheck> pageInfo = new PageInfo<>(processMeasureCheckVoList1);                                 /*根据生成到的list再生成一个pageInfo文件*/

        //一个包含数目和当前页对象列表的封装对象，意思是把它封装成page对象
        Vo<ProcessMeasureCheck> processMeasureCheckVoList = new Vo<>(pageInfo.getTotal(),pageInfo.getList());

        return processMeasureCheckVoList;
    }

    @Override
    public int processMeasureInsert(ProcessMeasureCheck processMeasureCheck) {
        int insert = processMeasureCheckMapper.insert(processMeasureCheck);
        return insert;
    }

    @Override
    public int processMeasureUpdate(ProcessMeasureCheck processMeasureCheck) {
        int update = processMeasureCheckMapper.updateByPrimaryKey(processMeasureCheck);
        return update;
    }

    @Override
    public int deletePMCheckByIds(List<String> list) {
        ProcessMeasureCheckExample processMeasuretCheckExample = new ProcessMeasureCheckExample();
        ProcessMeasureCheckExample.Criteria criteria = processMeasuretCheckExample.createCriteria();
        criteria.andPMeasureCheckIdIn(list);
        int delete = processMeasureCheckMapper.deleteByExample(processMeasuretCheckExample);
        return delete;
    }

    @Override
    public Vo<ProcessMeasureCheck> searchPmCheckByPId(String searchValue, int page, int rows) {
        PageHelper.startPage(page,rows);

        ProcessMeasureCheckExample processMeasureCheckExample = new ProcessMeasureCheckExample();
        ProcessMeasureCheckExample.Criteria criteria = processMeasureCheckExample.createCriteria();
        criteria.andPMeasureCheckIdLike("%" + searchValue + "%");
        List<ProcessMeasureCheck> processMeasureChecks = processMeasureCheckMapper.selectByExample(processMeasureCheckExample);/*使用逆向工程中的select方法*/

        PageInfo<ProcessMeasureCheck> pageInfo = new PageInfo<>(processMeasureChecks);

        Vo<ProcessMeasureCheck> processMeasureCheckList = new Vo<>(pageInfo.getTotal(),pageInfo.getList());
        return processMeasureCheckList;
    }

    @Override
    public int updateProcessMeasureNoteByPMeasureId(ProcessMeasureCheck processMeasureCheck) {
        int i = processMeasureCheckMapper.updateByPrimaryKeySelective(processMeasureCheck);
        return i;
    }
}
