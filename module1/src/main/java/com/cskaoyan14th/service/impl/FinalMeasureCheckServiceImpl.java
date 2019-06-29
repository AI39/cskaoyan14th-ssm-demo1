package com.cskaoyan14th.service.impl;

import com.cskaoyan14th.bean.FinalMeasuretCheck;

import com.cskaoyan14th.bean.FinalMeasuretCheckExample;
import com.cskaoyan14th.bean.UnqualifyApply;
import com.cskaoyan14th.bean.UnqualifyApplyExample;
import com.cskaoyan14th.mapper.FinalMeasuretCheckMapper;
import com.cskaoyan14th.service.FinalMeasureCheckService;
import com.cskaoyan14th.vo.Vo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Yuechao Yang
 * @version 2019-06-28-11:04
 */
@Service
public class FinalMeasureCheckServiceImpl implements FinalMeasureCheckService {
    @Autowired
    FinalMeasuretCheckMapper finalMeasuretCheckMapper;

    @Override
    public Vo<FinalMeasuretCheck> queryFinalMeasureLeftEmployee(int page, int rows) {
        PageHelper.startPage(page,rows);                                                                                /*这里是设置生成的page数和行数，由前端实现*/

        List<FinalMeasuretCheck> finalMeasuretCheckList1 = finalMeasuretCheckMapper.queryFinalMeasureCheckLeftEmployee();/*调用底层的方法查询到三张表中的符合条件的合并成一个list*/

        PageInfo<FinalMeasuretCheck> pageInfo = new PageInfo<>(finalMeasuretCheckList1);                                 /*根据生成到的list再生成一个pageInfo文件*/

                                                                                                                            //一个包含数目和当前页对象列表的封装对象，意思是把它封装成page对象
        Vo<FinalMeasuretCheck> finalMeasuretCheckList = new Vo<>(pageInfo.getTotal(),pageInfo.getList());

        return finalMeasuretCheckList;
    }

    @Override
    public int finalMseaureInsert(FinalMeasuretCheck finalMeasuretCheck) {
        int insert = finalMeasuretCheckMapper.insert(finalMeasuretCheck);
        return insert;
    }

    @Override
    public int finalMeasureUpdate(FinalMeasuretCheck finalMeasuretCheck) {
        int i = finalMeasuretCheckMapper.updateByPrimaryKey(finalMeasuretCheck);
        return i;
    }

    @Override
    public int deleteFMCheckByIds(List<String> list) {
        FinalMeasuretCheckExample finalMeasuretCheckExample = new FinalMeasuretCheckExample();
        FinalMeasuretCheckExample.Criteria criteria = finalMeasuretCheckExample.createCriteria();
        criteria.andFMeasureCheckIdIn(list);
        int delete = finalMeasuretCheckMapper.deleteByExample(finalMeasuretCheckExample);
        return delete;
    }

    @Override
    public int updateFinalMeasureNoteByUnqualifyId(FinalMeasuretCheck finalMeasuretCheck) {
        int i = finalMeasuretCheckMapper.updateByPrimaryKeySelective(finalMeasuretCheck);
        return i;
    }

    @Override
    public Vo<FinalMeasuretCheck> searchfmCheckByCId(String searchValue, int page, int rows) {
        PageHelper.startPage(page,rows);

        FinalMeasuretCheckExample finalMeasuretCheckExample = new FinalMeasuretCheckExample();
        FinalMeasuretCheckExample.Criteria criteria = finalMeasuretCheckExample.createCriteria();
        criteria.andFMeasureCheckIdLike("%" + searchValue + "%");
        List<FinalMeasuretCheck> finalMeasuretChecks = finalMeasuretCheckMapper.selectByExample(finalMeasuretCheckExample);/*使用逆向工程中的select方法*/

        PageInfo<FinalMeasuretCheck> pageInfo = new PageInfo<>(finalMeasuretChecks);

        Vo<FinalMeasuretCheck> finalMeasuretCheckList = new Vo<>(pageInfo.getTotal(),pageInfo.getList());
        return finalMeasuretCheckList;
    }

    @Override
    public Vo<FinalMeasuretCheck> searchfmCheckByOId(String searchValue, int page, int rows) {
        PageHelper.startPage(page,rows);

        FinalMeasuretCheckExample finalMeasuretCheckExample = new FinalMeasuretCheckExample();
        FinalMeasuretCheckExample.Criteria criteria = finalMeasuretCheckExample.createCriteria();
        criteria.andOrderIdLike("%" + searchValue + "%");
        List<FinalMeasuretCheck> finalMeasuretChecks = finalMeasuretCheckMapper.selectByExample(finalMeasuretCheckExample);/*使用逆向工程中的select方法*/

        PageInfo<FinalMeasuretCheck> pageInfo = new PageInfo<>(finalMeasuretChecks);

        Vo<FinalMeasuretCheck> finalMeasuretCheckList = new Vo<>(pageInfo.getTotal(),pageInfo.getList());
        return finalMeasuretCheckList;
    }
}
