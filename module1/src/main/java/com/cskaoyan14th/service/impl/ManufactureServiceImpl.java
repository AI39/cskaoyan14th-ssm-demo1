package com.cskaoyan14th.service.impl;

import com.cskaoyan14th.bean.Manufacture;
import com.cskaoyan14th.bean.Technology;
import com.cskaoyan14th.bean.TechnologyExample;
import com.cskaoyan14th.mapper.ManufactureMapper;
import com.cskaoyan14th.mapper.TechnologyMapper;
import com.cskaoyan14th.service.ManufactureService;
import com.cskaoyan14th.vo.Vo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ManufactureServiceImpl implements ManufactureService {
    @Autowired
    ManufactureMapper manufactureMapper;
    @Autowired
    TechnologyMapper technologyMapper;

    @Override
    public List<Manufacture> multiSelectAll() {
        return manufactureMapper.multiSelectAll();
    }

    @Override
    public Manufacture multiSelectByManufactureSn(String id) {
        return manufactureMapper.multiSelectByManufactureSn(id);
    }

    @Override
    public Vo<Manufacture> getManufactureList(int page, int rows) {
        //设置要返回第几页以以及每页要显示的数据条数
        PageHelper.startPage(page, rows);
        //进行查询
        List<Manufacture> manufacture1 = manufactureMapper.multiSelectAll();
        //把查询结果封装成分页所需的列表
        PageInfo<Manufacture> pageInfo = new PageInfo<Manufacture>(manufacture1);
        //封装成前端所需的数据格式
        Vo<Manufacture> manufactureList = new Vo<Manufacture>(pageInfo.getTotal(), pageInfo.getList());
        return manufactureList;
    }

    @Override
    public int insert(Manufacture manufacture) {
        Manufacture resultManufacture = manufactureMapper.selectByPrimaryKey(manufacture.getManufactureSn());
        if (resultManufacture != null) {
            return -1;
        }
        return manufactureMapper.insert(manufacture);
    }

    @Override
    public int updateByPrimaryKeySelective(Manufacture manufacture) {
        return manufactureMapper.updateByPrimaryKeySelective(manufacture);
    }

    @Override
    public int deleteByIds(String[] ids) {
        return manufactureMapper.deleteByIds(ids);
    }

    @Override
    public Vo<Manufacture> searchManufactureListByManufactureSn(String searchValue, int page, int rows) {
        //设置要返回第几页以以及每页要显示的数据条数
        PageHelper.startPage(page, rows);
        //进行模糊查询
        List<Manufacture> workList1 = manufactureMapper.multiSelectByLikeManufactureSn(searchValue);
        //把查询结果封装成分页所需的列表
        PageInfo<Manufacture> pageInfo = new PageInfo<Manufacture>(workList1);
        //封装成前端所需的数据格式
        Vo<Manufacture> ManufactureList = new Vo<Manufacture>(pageInfo.getTotal(), pageInfo.getList());
        return ManufactureList;
    }

    @Override
    public Vo<Manufacture> searchManufactureListByManufactureOrderId(String searchValue, int page, int rows) {
        //设置要返回第几页以以及每页要显示的数据条数
        PageHelper.startPage(page, rows);
        //进行模糊查询
        List<Manufacture> workList1 = manufactureMapper.multiSelectByLikeManufactureOrderId(searchValue);
        //把查询结果封装成分页所需的列表
        PageInfo<Manufacture> pageInfo = new PageInfo<Manufacture>(workList1);
        //封装成前端所需的数据格式
        Vo<Manufacture> ManufactureList = new Vo<Manufacture>(pageInfo.getTotal(), pageInfo.getList());
        return ManufactureList;
    }

    @Override
    public Vo<Manufacture> searchManufactureListByManufactureTechnologyName(String searchValue, int page, int rows) {
        //先根据搜索条件设备名称先获得对应的设备列表（主要是为了设备列表里包含的产品id号）
        TechnologyExample technologyExample = new TechnologyExample();
        TechnologyExample.Criteria criteria = technologyExample.createCriteria();
        criteria.andTechnologyNameLike("%" + searchValue + "%");
        List<Technology> technologyList = technologyMapper.selectByExample(technologyExample);
        //System.out.println(technologyList);
        List<String> technologyIdList = new ArrayList<String>();
        for (Technology p : technologyList) {
            technologyIdList.add(p.getTechnologyId());
        }

        //再根据产品列表里包含的产品id号来查询对应的WorkList
        if (technologyIdList.size() > 0) {
            //设置要返回第几页以以及每页要显示的数据条数
            PageHelper.startPage(page, rows);
            //进行模糊查询
            List<Manufacture> workList1 = manufactureMapper.multiSelectByTechnologyIds(technologyIdList);
            //把查询结果封装成分页所需的列表
            PageInfo<Manufacture> pageInfo = new PageInfo<Manufacture>(workList1);
            //封装成前端所需的数据格式
            Vo<Manufacture> workList = new Vo<Manufacture>(pageInfo.getTotal(), pageInfo.getList());
            return workList;
        }
        return new Vo<Manufacture>(0, new ArrayList<Manufacture>());
    }
}
