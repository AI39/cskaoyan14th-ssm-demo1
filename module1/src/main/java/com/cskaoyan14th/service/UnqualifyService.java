package com.cskaoyan14th.service;



import com.cskaoyan14th.bean.DeviceType;
import com.cskaoyan14th.bean.UnqualifyApply;
import com.cskaoyan14th.vo.Vo;

import java.util.List;


/**
 * @author Yuechao Yang
 * @version 2019-06-26-17:11
 */
public interface UnqualifyService {

    Vo<UnqualifyApply> queryUnqualifyApplyLeftEmployeeAndProduct(int page, int rows);                               /*这里是用于多表查询，三张表*/

    int unqualifyInsert(UnqualifyApply unqualifyApply);                                                             /*增*/

    int unqualifyUpdate(UnqualifyApply unqualifyApply);                                                             /*改*/

    int deleteUnqualifyByIds(List<String> ids);                                                                         /*删，因为要实现多选删除，所以要用String数组实现ids*/

    Vo<UnqualifyApply> searchUnqualifyByUnqualifyId(String searchValue, int page, int rows);                        /*根据id查询*/

    Vo<UnqualifyApply> searchUnqualifyByProductName(String searchValue, int page, int rows);                        /*根据name查询*/

    int updateUnqualifyNoteByUnqualifyId(UnqualifyApply unqualifyApply);

}
