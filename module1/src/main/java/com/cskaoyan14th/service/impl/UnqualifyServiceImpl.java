package com.cskaoyan14th.service.impl;

import com.cskaoyan14th.bean.*;

import com.cskaoyan14th.mapper.UnqualifyApplyMapper;

import com.cskaoyan14th.service.UnqualifyService;
import com.cskaoyan14th.vo.Vo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Yuechao Yang
 * @version 2019-06-26-17:12
 */
@Service
public class UnqualifyServiceImpl implements UnqualifyService {

    @Autowired
    UnqualifyApplyMapper unqualifyApplyMapper;

    @Override
    public Vo<UnqualifyApply> queryUnqualifyApplyLeftEmployeeAndProduct(int page, int rows) {
        PageHelper.startPage(page,rows);                                                                                /*这里是设置生成的page数和行数，由前端实现*/

        List<UnqualifyApply> unqualifyApplyList1 = unqualifyApplyMapper.queryUnqualifyApplyLeftEmployeeAndProduct();    /*调用底层的方法查询到三张表中的符合条件的合并成一个list*/

        PageInfo<UnqualifyApply> pageInfo = new PageInfo<>(unqualifyApplyList1);                                        /*根据生成到的list再生成一个pageInfo文件*/

                                                                                                                        //一个包含数目和当前页对象列表的封装对象，意思是把它封装成page对象
        Vo<UnqualifyApply> unqualifyApplyList = new Vo<>(pageInfo.getTotal(),pageInfo.getList());

        return unqualifyApplyList;
    }

    @Override
    public int unqualifyInsert(UnqualifyApply unqualifyApply) {
        int insert = unqualifyApplyMapper.insert(unqualifyApply);
        return insert;
    }

    @Override
    public int unqualifyUpdate(UnqualifyApply unqualifyApply) {
        int update = unqualifyApplyMapper.updateByPrimaryKey(unqualifyApply);
        System.out.println("插入后返回："+update);
        return update;
    }

    @Override
    public int deleteUnqualifyByIds(List<String> ids) {
        UnqualifyApplyExample unqualifyApplyExample = new UnqualifyApplyExample();
        UnqualifyApplyExample.Criteria criteria = unqualifyApplyExample.createCriteria();
        criteria.andUnqualifyApplyIdIn(ids);
        int delete = unqualifyApplyMapper.deleteByExample(unqualifyApplyExample);
        System.out.println(delete);
        return delete;
    }

    @Override
    public Vo<UnqualifyApply> searchUnqualifyByUnqualifyId(String searchValue, int page, int rows) {
        PageHelper.startPage(page,rows);

        UnqualifyApplyExample unqualifyApplyExample = new UnqualifyApplyExample();
        UnqualifyApplyExample.Criteria criteria = unqualifyApplyExample.createCriteria();
        criteria.andUnqualifyApplyIdLike("%" + searchValue + "%");
        List<UnqualifyApply> list = unqualifyApplyMapper.selectByExample(unqualifyApplyExample);                    /*使用逆向工程中的select方法*/

        PageInfo<UnqualifyApply> pageInfo = new PageInfo<>(list);

        Vo<UnqualifyApply> unqualifyApplyVo = new Vo<>(pageInfo.getTotal(),pageInfo.getList());
        return unqualifyApplyVo;
    }

    @Override
    public Vo<UnqualifyApply> searchUnqualifyByProductName(String searchValue, int page, int rows) {                /*该方法有问题，只能查非中文，而且只能查单表*/
        PageHelper.startPage(page,rows);

        UnqualifyApplyExample unqualifyApplyExample = new UnqualifyApplyExample();
        UnqualifyApplyExample.Criteria criteria = unqualifyApplyExample.createCriteria();
        criteria.andUnqualifyApplyIdLike("%" + searchValue + "%");
        List<UnqualifyApply> list = unqualifyApplyMapper.selectByExample(unqualifyApplyExample);

        PageInfo<UnqualifyApply> pageInfo = new PageInfo<>(list);

        Vo<UnqualifyApply> unqualifyApplyVo = new Vo<>(pageInfo.getTotal(),pageInfo.getList());
        return unqualifyApplyVo;
    }

}
