package com.cskaoyan14th.util;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class MyUtil {
    public static void sysPermissionList(HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        String substring = requestURI.substring(requestURI.lastIndexOf("/") + 1, requestURI.length());
        List<String> sysPermissionList = new ArrayList<>();
        sysPermissionList.add(substring + ":add");
        sysPermissionList.add(substring + ":edit");
        sysPermissionList.add(substring + ":delete");
        request.getSession().setAttribute("sysPermissionList", sysPermissionList);
    }
}
