package com.fh.controller;

import com.fh.bean.T_emp;
import com.fh.bean.vo.T_empvo;
import com.fh.service.TempService;
import com.fh.uitl.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class TempController {
   @Autowired
    private TempService tempService;

   @RequestMapping("queryTempByName")
   public Map queryTempByName(String name,Integer dape){
       Map map=new HashMap();
       T_emp temp=tempService.queryTempByName(name,dape);
       if(temp==null){
           map.put("code",200);
           map.put("message","可以添加");
       }else {
           map.put("code",201);
           map.put("message","该部门下已有名字");
       }
       return map;
   }

   @RequestMapping("queryTempJob")
   public List<Map<String,Object>> queryTempJob(){
       List<Map<String,Object>> list=tempService.queryTempJob();
       return list;
   }
   @RequestMapping("queryTempDept")
   public List<Map<String,Object>> queryTempDept(){
       List<Map<String,Object>> list=tempService.queryTempDept();
       return list;
   }

   @RequestMapping("addTempList")
   public T_emp addTempList(T_emp temp){
       tempService.addTempList(temp);
       return temp;
   }

   @RequestMapping("queryTempList")
   public PageBean<T_empvo> queryTempList(PageBean<T_empvo> page){
       tempService.queryTempList(page);
       return page;
   }
}
