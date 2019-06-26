package com.cskaoyan14th.util;

import java.util.ArrayList;
import java.util.List;

public class ToolbarButtons {
    private List<String> sysPermissionList;
    private String name;

    public ToolbarButtons(String name) {
        if ("".equals(name) || name == null){
            throw new IllegalArgumentException("name=" + name);
        }
        this.name = name;
        String add = name.toLowerCase() + ":add";
        String edit = name.toLowerCase() + ":edit";
        String delete = name.toLowerCase() + ":delete";
        sysPermissionList = new ArrayList<>();
        sysPermissionList.add(add);
        sysPermissionList.add(edit);
        sysPermissionList.add(delete);
    }

    public List<String> getSysPermissionList() {
        return sysPermissionList;
    }
}
