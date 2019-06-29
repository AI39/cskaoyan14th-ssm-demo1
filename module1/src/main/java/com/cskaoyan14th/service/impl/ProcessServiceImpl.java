package com.cskaoyan14th.service.impl;

import com.cskaoyan14th.bean.Process;
import com.cskaoyan14th.mapper.ProcessMapper;
import com.cskaoyan14th.service.ProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcessServiceImpl implements ProcessService {
    @Autowired
    ProcessMapper processMapper;

    @Override
    public List<Process> getProcessList() {
        return processMapper.multiSelectProcessAll();
    }

    @Override
    public Process getProcessByProcessId(String id) {
        return processMapper.selectByPrimaryKey(id);
    }
}
