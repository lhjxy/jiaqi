package com.fh.service.impl;

import com.fh.bean.T_emp;
import com.fh.bean.vo.T_empvo;
import com.fh.dao.TempDao;
import com.fh.service.TempService;
import com.fh.uitl.PageBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class TempServiceImpl implements TempService {
    @Resource
    private TempDao tempDao;

    @Override
    public T_emp queryTempByName(String name,Integer dape) {
        return tempDao.queryTempByName(name,dape);
    }

    @Override
    public List<Map<String, Object>> queryTempJob() {
        return tempDao.queryTempJob();
    }

    @Override
    public List<Map<String, Object>> queryTempDept() {
        return tempDao.queryTempDept();
    }

    @Override
    public void addTempList(T_emp temp) {
        tempDao.insert(temp);
    }

    @Override
    public void queryTempList(PageBean<T_empvo> page) {
        long count=tempDao.queryCount();
        page.setRecordsFiltered(count);
        page.setRecordsTotal(count);
        List<T_empvo> list=tempDao.queryBookList(page);
        page.setData(list);
    }
}
