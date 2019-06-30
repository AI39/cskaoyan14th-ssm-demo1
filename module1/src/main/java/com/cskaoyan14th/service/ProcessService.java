package com.cskaoyan14th.service;

import com.cskaoyan14th.bean.Process;

import java.util.List;

public interface ProcessService {
    List<Process> getProcessList();

    Process getProcessByProcessId(String id);
}
