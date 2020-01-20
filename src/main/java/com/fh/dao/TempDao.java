package com.fh.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fh.bean.T_emp;
import com.fh.bean.vo.T_empvo;
import com.fh.uitl.PageBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface TempDao extends BaseMapper<T_emp> {
    T_emp queryTempByName(@Param("name") String name,@Param("dape") Integer dape);

    List<Map<String,Object>> queryTempJob();

    List<Map<String,Object>> queryTempDept();

    long queryCount();

    List<T_empvo> queryBookList(@Param("page") PageBean<T_empvo> page);
}
