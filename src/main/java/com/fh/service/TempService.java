package com.fh.service;

import com.fh.bean.T_emp;
import com.fh.bean.vo.T_empvo;
import com.fh.uitl.PageBean;

import java.util.List;
import java.util.Map;

public interface TempService {
    T_emp queryTempByName(String name,Integer dape);

    List<Map<String,Object>> queryTempJob();

    List<Map<String,Object>> queryTempDept();

    void addTempList(T_emp temp);

    void queryTempList(PageBean<T_empvo> page);
}
