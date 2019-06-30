package com.cskaoyan14th.service.impl;

import com.cskaoyan14th.bean.*;
import com.cskaoyan14th.bean.Process;
import com.cskaoyan14th.mapper.ProcessMapper;
import com.cskaoyan14th.mapper.TechnologyMapper;
import com.cskaoyan14th.mapper.TechnologyPlanMapper;
import com.cskaoyan14th.mapper.TechnologyRequirementMapper;
import com.cskaoyan14th.service.TechnologyService;
import com.cskaoyan14th.vo.ResponseVo;
import com.cskaoyan14th.vo.Vo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sun.corba.se.impl.interceptors.PICurrent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class TechnologyServiceImpl implements TechnologyService {
    @Autowired
    TechnologyMapper technologyMapper;
    @Autowired
    TechnologyRequirementMapper technologyRequirementMapper;
    @Autowired
    TechnologyPlanMapper technologyPlanMapper;
    @Autowired
    ProcessMapper processMapper;

    @Override
    public Vo<Technology> getTechnologyVo(int page, int rows) {
        PageHelper.startPage(page,rows);

        TechnologyExample technologyExample = new TechnologyExample();
        TechnologyExample.Criteria criteria = technologyExample.createCriteria();
        criteria.andTechnologyIdIsNotNull();
        List<Technology> list = technologyMapper.selectByExample(technologyExample);
        PageInfo<Technology> pageInfo = new PageInfo<>(list);
        Vo<Technology> technologyVo = new Vo<>(pageInfo.getTotal(), pageInfo.getList());

        return technologyVo;
    }

    @Override
    public boolean technologyIsExists(String technologyId) {
        TechnologyExample technologyExample = new TechnologyExample();
        TechnologyExample.Criteria criteria = technologyExample.createCriteria();
        criteria.andTechnologyIdEqualTo(technologyId);
        List<Technology> list = technologyMapper.selectByExample(technologyExample);
        if(list!=null&&list.size()!=0){
            return true;
        }
        return false;
    }

    @Override
    public int insertTechnology(Technology technology) {
        int insert = technologyMapper.insert(technology);
        return insert;
    }

    @Override
    public int updateTechnology(Technology technology) {
        int i = technologyMapper.updateByPrimaryKey(technology);
        return i;
    }

    @Override
    public int deleteTechnology(String[] ids) {
        int i=0;
        for (String id:ids
        ) {
            i = technologyMapper.deleteByPrimaryKey(id);
        }
        return i;
    }

    @Override
    public Vo<Technology> selectTechnologyById(String id, int page, int rows) {
        PageHelper.startPage(page,rows);

        TechnologyExample technologyExample = new TechnologyExample();
        TechnologyExample.Criteria criteria = technologyExample.createCriteria();
        criteria.andTechnologyIdLike("%" +id + "%");
        List<Technology> list = technologyMapper.selectByExample(technologyExample);

        PageInfo<Technology> pageInfo = new PageInfo<>(list);
        Vo<Technology> technologyVo = new Vo<>(pageInfo.getTotal(), pageInfo.getList());
        return technologyVo;
    }

    @Override
    public Vo<Technology> selectTechnologyByName(String type, int page, int rows) {
        PageHelper.startPage(page,rows);

        TechnologyExample technologyExample = new TechnologyExample();
        TechnologyExample.Criteria criteria = technologyExample.createCriteria();
        criteria.andTechnologyNameLike("%"+type+"%");
        List<Technology> list = technologyMapper.selectByExample(technologyExample);

        PageInfo<Technology> pageInfo = new PageInfo<>(list);
        Vo<Technology> technologyVo= new Vo<>(pageInfo.getTotal(),pageInfo.getList());
        return technologyVo;

    }

    @Override
    public Vo<TechnologyRequirementShow> getTechnologyRequirementVoShow(int page, int rows) {
        PageHelper.startPage(page, rows);
       List<TechnologyRequirementShow> list =  technologyRequirementMapper.selectTechnologyRequirementShow();

        PageInfo<TechnologyRequirementShow> pageInfo = new PageInfo<>(list);
        Vo<TechnologyRequirementShow> requirementVo = new Vo<>(pageInfo.getTotal(), pageInfo.getList());

        return requirementVo;
    }

    @Override
    public List<Technology> getAllTechnology() {
        TechnologyExample technologyExample = new TechnologyExample();
        TechnologyExample.Criteria criteria = technologyExample.createCriteria();
        criteria.andTechnologyIdIsNotNull();
        List<Technology> list = technologyMapper.selectByExample(technologyExample);
        return list;
    }

    @Override
    public boolean technologyRequirementIsExists(String technologyRequirementId) {
        TechnologyRequirementExample technologyRequirementExample = new TechnologyRequirementExample();
        TechnologyRequirementExample.Criteria criteria = technologyRequirementExample.createCriteria();
        criteria.andTechnologyRequirementIdEqualTo(technologyRequirementId);
        List<TechnologyRequirement> list = technologyRequirementMapper.selectByExample(technologyRequirementExample);

        if(list!=null&&list.size()!=0){
            return true;
        }
        return false;
       }

    @Override
    public int insertTechnologyRequirement(TechnologyRequirement technologyRequirement) {
        int insert = technologyRequirementMapper.insert(technologyRequirement);
        return insert;
    }

    @Override
    public int updateTechnologyRequirement(TechnologyRequirement technologyRequirement) {
        int i = technologyRequirementMapper.updateByPrimaryKey(technologyRequirement);
        return i;
    }

    @Override
    public int deleteTechnologyRequirement(String[] ids) {
        int i = 0;
        for (String id:ids){
            i = technologyRequirementMapper.deleteByPrimaryKey(id);
        }
        return i;
    }

    @Override
    public Vo<TechnologyRequirement> selectTechnologyRequirementById(String id, int page, int rows) {
        PageHelper.startPage(page,rows);

        TechnologyRequirementExample technologyRequirementExample = new TechnologyRequirementExample();
        TechnologyRequirementExample.Criteria criteria = technologyRequirementExample.createCriteria();
        criteria.andTechnologyRequirementIdLike("%" + id + "%");
        List<TechnologyRequirement> list = technologyRequirementMapper.selectByExample(technologyRequirementExample);

        PageInfo<TechnologyRequirement> pageInfo = new PageInfo<>(list);
        Vo<TechnologyRequirement> technologyRequirementVo = new Vo<>(pageInfo.getTotal(), pageInfo.getList());

        return technologyRequirementVo;
    }

    @Override
    public Vo<TechnologyRequirement> selectTechnologyRequirementByName(String searchValue, int page, int rows) {

        PageHelper.startPage(page,rows);

        List<TechnologyRequirement> list = technologyRequirementMapper.selectTechnologyRequorementByName("%" + searchValue + "%");
        PageInfo<TechnologyRequirement> pageInfo = new PageInfo<>(list);
        Vo<TechnologyRequirement> technologyRequirementVo = new Vo<>(pageInfo.getTotal(), pageInfo.getList());

        return technologyRequirementVo;

    }

    @Override
    public Technology getTechnologyById(String technologyId) {
        Technology technology = technologyMapper.selectByPrimaryKey(technologyId);
        return technology;
    }

    @Override
    public int updateRequirementTechnologyRequirement(TechnologyRequirement technologyRequirement) {
        int i = technologyRequirementMapper.updateByPrimaryKeySelective(technologyRequirement);
        return i;
    }

    // 三、工艺计划
    @Override
    public Vo<TechnologyPlan> getTechonologyPlanVo(int page, int rows) {
        PageHelper.startPage(page, rows);
        List<TechnologyPlan> list = technologyPlanMapper.selectAllTechnologyPlan();
        PageInfo<TechnologyPlan> pageInfo = new PageInfo<>(list);
        Vo<TechnologyPlan> technologyPlanVo = new Vo<>(pageInfo.getTotal(), pageInfo.getList());
        return technologyPlanVo;
    }

    @Override
    public boolean technologyPlanIsExists(String technologyPlanId) {
        TechnologyPlanExample technologyPlanExample = new TechnologyPlanExample();
        TechnologyPlanExample.Criteria criteria = technologyPlanExample.createCriteria();
        criteria.andTechnologyPlanIdEqualTo(technologyPlanId);
        List<TechnologyPlan> list = technologyPlanMapper.selectByExample(technologyPlanExample);
        if(list!=null&&list.size()!=0){
            return true;
        }
        return false;
    }

    @Override
    public int insertTechnologyPlan(TechnologyPlan technologyPlan) {
        int insert = technologyPlanMapper.insert(technologyPlan);
        return insert;
    }

    @Override
    public int updateTechnologyPlan(TechnologyPlan technologyPlan) {
        int i = technologyPlanMapper.updateByPrimaryKey(technologyPlan);
        return i;
    }

    @Override
    public int deleteTechnologyPlan(String[] ids) {
        int i=0;
        for ( String id:ids)
        {
            i = technologyPlanMapper.deleteByPrimaryKey(id);
        }
        return i;
    }

    @Override
    public Vo<TechnologyPlan> selectTechnologyPlanById(String id, int page, int rows) {
        PageHelper.startPage(page,rows);

        TechnologyPlanExample technologyPlanExample = new TechnologyPlanExample();
        TechnologyPlanExample.Criteria criteria = technologyPlanExample.createCriteria();
        criteria.andTechnologyPlanIdLike("%" + id + "%");
        List<TechnologyPlan> list = technologyPlanMapper.selectByExample(technologyPlanExample);

        PageInfo<TechnologyPlan> pageInfo = new PageInfo<>(list);
        Vo<TechnologyPlan> technologyPlanVo = new Vo<>(pageInfo.getTotal(), pageInfo.getList());

        return technologyPlanVo;
    }
    // 四、工序管理

    @Override
    public Vo<Process> getProcessVo(int page, int rows) {
        PageHelper.startPage(page,rows);

        ProcessExample processExample = new ProcessExample();
        ProcessExample.Criteria criteria = processExample.createCriteria();
        criteria.andProcessIdIsNotNull();
        List<Process> list = processMapper.selectByExample(processExample);
        PageInfo<Process> pageInfo = new PageInfo<>(list);
        Vo<Process> processVo = new Vo<>(pageInfo.getTotal(), pageInfo.getList());

        return processVo;
    }

    @Override
    public boolean ProcessIsExists(String processId) {
        ProcessExample processExample = new ProcessExample();
        ProcessExample.Criteria criteria = processExample.createCriteria();
        criteria.andProcessIdEqualTo(processId);
        List<Process> list = processMapper.selectByExample(processExample);
        if(list!=null&&list.size()!=0){
            return true;
        }
        return false;
    }

    @Override
    public int insertProcess(Process process) {
        int insert = processMapper.insert(process);
        return insert;
    }

    @Override
    public int updateProcess(Process process) {
        int i = processMapper.updateByPrimaryKey(process);
        return i;
    }

    @Override
    public int deleteProcess(String[] ids) {
        int i=0;
        for(String id:ids){
             i = processMapper.deleteByPrimaryKey(id);
        }
        return i;
    }

    //用id查
    @Override
    public Vo<Process> selectProcessById(String id, int page, int rows) {
        PageHelper.startPage(page,rows);
        ProcessExample processExample = new ProcessExample();
        ProcessExample.Criteria criteria = processExample.createCriteria();
        criteria.andProcessIdLike("%" + id + "%");
        List<Process> list = processMapper.selectByExample(processExample);

        PageInfo<Process> pageInfo = new PageInfo<>(list);
        Vo<Process> processVo = new Vo<>(pageInfo.getTotal(), pageInfo.getList());

        return processVo;
    }

    @Override
    public List<Technology> getAllTechnologyData() {
        TechnologyExample technologyExample = new TechnologyExample();
        TechnologyExample.Criteria criteria = technologyExample.createCriteria();
        criteria.andTechnologyIdIsNotNull();
        List<Technology> technologyList = technologyMapper.selectByExample(technologyExample);
        return technologyList;
    }

    @Override
    public List<TechnologyPlan> getAllTechnologyPlanData() {
        TechnologyPlanExample technologyPlanExample = new TechnologyPlanExample();
        TechnologyPlanExample.Criteria criteria = technologyPlanExample.createCriteria();
        criteria.andTechnologyPlanIdIsNotNull();
        List<TechnologyPlan> planList = technologyPlanMapper.selectByExample(technologyPlanExample);
        return planList;
    }

    @Override
    public TechnologyPlan getTechnologyPlan(String technologyId) {
        TechnologyPlan technologyPlan = technologyPlanMapper.selectByPrimaryKey(technologyId);
        return technologyPlan;
    }

    @Override
    public List<Process> selectProcessByPlanId(String id, int page, int rows) {
        ProcessExample processExample = new ProcessExample();
        ProcessExample.Criteria criteria = processExample.createCriteria();
        criteria.andTechnologyPlanIdLike("%" +id + "%");
        List<Process> process = processMapper.selectByExample(processExample);
        return process;
    }

    @Override
    public Vo<TechnologyPlan> selectTechnologyPlanBy(String searchValue, int page, int rows) {
        PageHelper.startPage(page,rows);

        List<TechnologyPlan> list = technologyPlanMapper.selectTechnologyPlanByName("%"+searchValue+"%");

        PageInfo<TechnologyPlan> pageInfo = new PageInfo<>(list);
        Vo<TechnologyPlan> technologyVo = new Vo<>(pageInfo.getTotal(), pageInfo.getList());
        return technologyVo;
    }

    //用于name查
    /*@Override
    public Vo<TechnologyPlan> selectTechnologyPlanByName(String id, int page, int rows) {
        PageHelper.startPage(page,rows);

        List<TechnologyPlan> list = technologyPlanMapper.selectTechnologyPlanByName("%" +  + "%");
        PageInfo<TechnologyPlan> pageInfo = new PageInfo<>(list);
        Vo<TechnologyPlan> technologyPlanVo = new Vo<>(pageInfo.getTotal(), pageInfo.getList());

        return technologyPlanVo;


        return null;
    }*/

}


