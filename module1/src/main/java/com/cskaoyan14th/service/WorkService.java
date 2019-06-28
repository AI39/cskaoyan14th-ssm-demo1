package com.cskaoyan14th.service;

import com.cskaoyan14th.bean.Work;
import com.cskaoyan14th.vo.Vo;

public interface WorkService {
    Vo<Work> getWorkList(int page, int rows);

    int insert(Work work);

    int updateByPrimaryKeySelective(Work work);

    int deleteByIds(String[] ids);

    Vo<Work> searchWorkListByWorkId(String searchValue, int page, int rows);

    Vo<Work> searchWorkListByWorkProduct(String searchValue, int page, int rows);

    Vo<Work> searchWorkListByWorkDevice(String searchValue, int page, int rows);

    Vo<Work> searchWorkListByWorkProcess(String searchValue, int page, int rows);

}
