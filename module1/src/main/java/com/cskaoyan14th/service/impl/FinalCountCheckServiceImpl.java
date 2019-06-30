package com.cskaoyan14th.service.impl;

import com.cskaoyan14th.bean.*;
import com.cskaoyan14th.mapper.FinalCountCheckMapper;
import com.cskaoyan14th.service.FinalCountCheckService;
import com.cskaoyan14th.vo.Vo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.aspectj.weaver.ast.Var;
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

    @Override
    public int finalCountInsert(FinalCountCheck finalCountCheck) {
        int insert = finalCountCheckMapper.insert(finalCountCheck);
        return insert;
    }

    @Override
    public int finalCountUpdate(FinalCountCheck finalCountCheck) {
        int i = finalCountCheckMapper.updateByPrimaryKey(finalCountCheck);
        return i;
    }

    @Override
    public int deleteCountCheckByIds(List<String> list) {
        FinalCountCheckExample finalCountCheckExample = new FinalCountCheckExample();
        FinalCountCheckExample.Criteria criteria = finalCountCheckExample.createCriteria();
        criteria.andFCountCheckIdIn(list);
        int delete = finalCountCheckMapper.deleteByExample(finalCountCheckExample);
        System.out.println(delete);
        return delete;
    }

    @Override
    public int updateFinalCountNoteByFCId(FinalCountCheck finalCountCheck) {
        int i = finalCountCheckMapper.updateByPrimaryKeySelective(finalCountCheck);
        return i;
    }

    @Override
    public Vo<FinalCountCheck> searchfcCheckByOId(String searchValue, int page, int rows) {
        PageHelper.startPage(page,rows);

        FinalCountCheckExample finalCountCheckExample = new FinalCountCheckExample();
        FinalCountCheckExample.Criteria criteria = finalCountCheckExample.createCriteria();
        criteria.andOrderIdLike("%" + searchValue + "%");
        List<FinalCountCheck> finalCounttChecks = finalCountCheckMapper.selectByExample(finalCountCheckExample);/*使用逆向工程中的select方法*/

        PageInfo<FinalCountCheck> pageInfo = new PageInfo<>(finalCounttChecks);

        Vo<FinalCountCheck> finalCountCheckList = new Vo<>(pageInfo.getTotal(),pageInfo.getList());
        return finalCountCheckList;
    }

    @Override
    public Vo<FinalCountCheck> searchfCCheckByFCId(String searchValue, int page, int rows) {
        PageHelper.startPage(page,rows);

        FinalCountCheckExample finalCountCheckExample = new FinalCountCheckExample();
        FinalCountCheckExample.Criteria criteria = finalCountCheckExample.createCriteria();
        criteria.andFCountCheckIdLike("%" + searchValue + "%");
        List<FinalCountCheck> finalCounttChecks = finalCountCheckMapper.selectByExample(finalCountCheckExample);        /*使用逆向工程中的select方法*/

        PageInfo<FinalCountCheck> pageInfo = new PageInfo<>(finalCounttChecks);

        Vo<FinalCountCheck> finalCountCheckList = new Vo<>(pageInfo.getTotal(),pageInfo.getList());
        return finalCountCheckList;
    }
}
