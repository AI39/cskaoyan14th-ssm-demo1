package com.cskaoyan14th.service;

import com.cskaoyan14th.bean.*;
import com.cskaoyan14th.bean.Process;
import com.cskaoyan14th.bean.TechnologyRequirement;
import com.cskaoyan14th.vo.Vo;

import java.util.List;

public interface TechnologyService {
    // 一、工艺管理
    Vo<Technology> getTechnologyVo(int page, int rows);

    boolean technologyIsExists(String technologyId);

    int insertTechnology(Technology technology);

    int updateTechnology(Technology technology);

    int deleteTechnology(String[] ids);

    Vo<Technology> selectTechnologyById(String id, int page, int rows);

    Vo<Technology> selectTechnologyByName(String id, int page, int rows);

    // 二、工艺要求
    Vo<TechnologyRequirementShow> getTechnologyRequirementVoShow(int page, int rows);

    List<Technology> getAllTechnology();

    boolean technologyRequirementIsExists(String technologyRequirementId);

    int insertTechnologyRequirement(TechnologyRequirement technologyRequirement);

    int updateTechnologyRequirement(TechnologyRequirement technologyRequirement);

    int deleteTechnologyRequirement(String[] ids);

    Vo<TechnologyRequirement> selectTechnologyRequirementById(String id, int page, int rows);

    Vo<TechnologyRequirement> selectTechnologyRequirementByName(String searchValue, int page, int rows);

    Technology getTechnologyById(String technologyId);

    int updateRequirementTechnologyRequirement(TechnologyRequirement technologyRequirement);

    // 三、工艺计划

    Vo<TechnologyPlan> getTechonologyPlanVo(int page, int rows);

    boolean technologyPlanIsExists(String technologyPlanId);

    int insertTechnologyPlan(TechnologyPlan technologyPlan);

    int updateTechnologyPlan(TechnologyPlan technologyPlan);

    int deleteTechnologyPlan(String[] ids);

    Vo<TechnologyPlan> selectTechnologyPlanById(String id, int page, int rows);

    /*Vo<TechnologyPlan> selectTechnologyPlanByName(String id, int page, int rows);*/

    // 四、工序管理

    Vo<Process> getProcessVo(int page, int rows);

    boolean ProcessIsExists(String processId);

    int insertProcess(Process process);

    int updateProcess(Process process);

    int deleteProcess(String[] ids);

    Vo<Process> selectProcessById(String id, int page, int rows);

    List<Technology> getAllTechnologyData();

    List<TechnologyPlan> getAllTechnologyPlanData();

    TechnologyPlan getTechnologyPlan(String technologyId);

    List<Process> selectProcessByPlanId(String id, int page, int rows);

    Vo<TechnologyPlan> selectTechnologyPlanBy(String searchValue, int page, int rows);



}