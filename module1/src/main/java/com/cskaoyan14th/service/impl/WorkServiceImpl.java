package com.cskaoyan14th.service.impl;

import com.cskaoyan14th.bean.*;
import com.cskaoyan14th.bean.Process;
import com.cskaoyan14th.mapper.*;
import com.cskaoyan14th.service.WorkService;
import com.cskaoyan14th.vo.Vo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WorkServiceImpl implements WorkService {
    @Autowired
    WorkMapper workMapper;
    @Autowired
    ProductMapper productMapper;
    @Autowired
    DeviceMapper deviceMapper;
    @Autowired
    ProcessMapper processMapper;

    @Override
    public List<Work> multiSelectAll() {
        return workMapper.multiSelectAll();
    }

    @Override
    public Work multiSelectByWorkId(String id) {
        return workMapper.multiSelectByWorkId(id);
    }

    @Override
    public Vo<Work> getWorkList(int page, int rows) {
        //设置要返回第几页以以及每页要显示的数据条数
        PageHelper.startPage(page, rows);
        //进行查询
        List<Work> workList1 = workMapper.multiSelectAll();
        //把查询结果封装成分页所需的列表
        PageInfo<Work> pageInfo = new PageInfo<Work>(workList1);
        //封装成前端所需的数据格式
        Vo<Work> workList = new Vo<Work>(pageInfo.getTotal(), pageInfo.getList());
        return workList;
    }

    @Override
    public int insert(Work work) {
        Work resultWork = workMapper.selectByPrimaryKey(work.getWorkId());
        if (resultWork != null) {
            return -1;
        }
        return workMapper.insert(work);
    }

    @Override
    public int updateByPrimaryKeySelective(Work work) {
        return workMapper.updateByPrimaryKeySelective(work);
    }

    @Override
    public int deleteByIds(String[] ids) {
        return workMapper.deleteByIds(ids);
    }

    @Override
    public Vo<Work> searchWorkListByWorkId(String searchValue, int page, int rows) {
        //设置要返回第几页以以及每页要显示的数据条数
        PageHelper.startPage(page, rows);
        //进行模糊查询
        List<Work> workList1 = workMapper.multiSelectByLikeWorkId(searchValue);
        //把查询结果封装成分页所需的列表
        PageInfo<Work> pageInfo = new PageInfo<Work>(workList1);
        //封装成前端所需的数据格式
        Vo<Work> workList = new Vo<Work>(pageInfo.getTotal(), pageInfo.getList());
        return workList;
    }

    @Override
    public Vo<Work> searchWorkListByWorkProduct(String searchValue, int page, int rows) {
        //先根据搜索条件产品名称先获得对应的产品列表（主要是为了产品列表里包含的产品id号）
        ProductExample productExample = new ProductExample();
        ProductExample.Criteria criteria = productExample.createCriteria();
        criteria.andProductNameLike("%" + searchValue + "%");
        List<Product> productList = productMapper.selectByExample(productExample);
        //System.out.println(productList);
        List<String> productIdList = new ArrayList<String>();
        for (Product p : productList) {
            productIdList.add(p.getProductId());
        }

        //再根据产品列表里包含的产品id号来查询对应的WorkList
        if (productIdList.size() > 0) {
            //设置要返回第几页以以及每页要显示的数据条数
            PageHelper.startPage(page, rows);
            //进行模糊查询
            List<Work> workList1 = workMapper.multiSelectByProductIds(productIdList);
            //把查询结果封装成分页所需的列表
            PageInfo<Work> pageInfo = new PageInfo<Work>(workList1);
            //封装成前端所需的数据格式
            Vo<Work> workList = new Vo<Work>(pageInfo.getTotal(), pageInfo.getList());
            return workList;
        }
        return new Vo<Work>(0, new ArrayList<Work>());
    }

    @Override
    public Vo<Work> searchWorkListByWorkDevice(String searchValue, int page, int rows) {
        //先根据搜索条件设备名称先获得对应的设备列表（主要是为了设备列表里包含的产品id号）
        DeviceExample deviceExample = new DeviceExample();
        DeviceExample.Criteria criteria = deviceExample.createCriteria();
        criteria.andDeviceNameLike("%" + searchValue + "%");
        List<Device> deviceList = deviceMapper.selectByExample(deviceExample);
        //System.out.println(deviceList);
        List<String> deviceIdList = new ArrayList<String>();
        for (Device d : deviceList) {
            deviceIdList.add(d.getDeviceId());
        }

        //再根据产品列表里包含的产品id号来查询对应的WorkList
        if (deviceIdList.size() > 0) {
            //设置要返回第几页以以及每页要显示的数据条数
            PageHelper.startPage(page, rows);
            //进行模糊查询
            List<Work> workList1 = workMapper.multiSelectByDeviceIds(deviceIdList);
            //把查询结果封装成分页所需的列表
            PageInfo<Work> pageInfo = new PageInfo<Work>(workList1);
            //封装成前端所需的数据格式
            Vo<Work> workList = new Vo<Work>(pageInfo.getTotal(), pageInfo.getList());
            return workList;
        }
        return new Vo<Work>(0, new ArrayList<Work>());
    }

    @Override
    public Vo<Work> searchWorkListByWorkProcess(String searchValue, int page, int rows) {
        //先根据搜索条件设备名称先获得对应的设备列表（主要是为了设备列表里包含的产品id号）
        ProcessExample processExample = new ProcessExample();
        ProcessExample.Criteria criteria = processExample.createCriteria();
        criteria.andProcessIdLike("%" + searchValue + "%");
        List<Process> processList = processMapper.selectByExample(processExample);
        //System.out.println(processList);
        List<String> processIdList = new ArrayList<String>();
        for (Process p : processList) {
            processIdList.add(p.getProcessId());
        }

        //再根据产品列表里包含的产品id号来查询对应的WorkList
        if (processIdList.size() > 0) {
            //设置要返回第几页以以及每页要显示的数据条数
            PageHelper.startPage(page, rows);
            //进行模糊查询
            List<Work> workList1 = workMapper.multiSelectByProcessIds(processIdList);
            //把查询结果封装成分页所需的列表
            PageInfo<Work> pageInfo = new PageInfo<Work>(workList1);
            //封装成前端所需的数据格式
            Vo<Work> workList = new Vo<Work>(pageInfo.getTotal(), pageInfo.getList());
            return workList;
        }
        return new Vo<Work>(0, new ArrayList<Work>());
    }


}
