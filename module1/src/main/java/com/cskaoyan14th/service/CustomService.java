package com.cskaoyan14th.service;

import com.cskaoyan14th.bean.Custom;

import java.util.List;

public interface CustomService {

    List<Custom> queryCustoms();
    Custom queryCustomById(String id);
}
