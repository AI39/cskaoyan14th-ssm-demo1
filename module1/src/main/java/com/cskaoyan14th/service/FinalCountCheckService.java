package com.cskaoyan14th.service;


import com.cskaoyan14th.bean.FinalCountCheck;
import com.cskaoyan14th.bean.FinalCountCheckVo;

import com.cskaoyan14th.vo.Vo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yuechao Yang
 * @version 2019-06-28-11:16
 */

public interface FinalCountCheckService {
    Vo<FinalCountCheck> queryFinalCountLeftEmployee(int page, int rows);

    int finalCountInsert(FinalCountCheck finalCountCheck);

    int finalCountUpdate(FinalCountCheck finalCountCheck);

    int deleteCountCheckByIds(List<String> list);

    int updateFinalCountNoteByFCId(FinalCountCheck finalCountCheck);

    Vo<FinalCountCheck> searchfcCheckByOId(String searchValue, int page, int rows);

    Vo<FinalCountCheck> searchfCCheckByFCId(String searchValue, int page, int rows);
}
