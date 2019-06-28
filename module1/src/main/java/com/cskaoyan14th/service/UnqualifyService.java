package com.cskaoyan14th.service;



import com.cskaoyan14th.bean.UnqualifyApply;
import com.cskaoyan14th.vo.Vo;




/**
 * @author Yuechao Yang
 * @version 2019-06-26-17:11
 */
public interface UnqualifyService {

    Vo<UnqualifyApply> queryUnqualifyApplyLeftEmployeeAndProduct(int page, int rows);                               /*这里是用于多表查询，三张表*/



}
