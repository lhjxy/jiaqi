package com.fh.bean.vo;

import java.util.Date;

public class T_empvo {
    private Integer id;// 员工id
    private String name;
    private Integer jobid;// 岗位id
    private double salary;// 工资
    private Date entrytime;// 入职时间
    private Integer leaderid;// 领导id
    private Integer deptid;// 部门id
    private String lingname;
    private String jobname;
    private String deptname;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getJobid() {
        return jobid;
    }

    public void setJobid(Integer jobid) {
        this.jobid = jobid;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Date getEntrytime() {
        return entrytime;
    }

    public void setEntrytime(Date entrytime) {
        this.entrytime = entrytime;
    }

    public Integer getLeaderid() {
        return leaderid;
    }

    public void setLeaderid(Integer leaderid) {
        this.leaderid = leaderid;
    }

    public Integer getDeptid() {
        return deptid;
    }

    public void setDeptid(Integer deptid) {
        this.deptid = deptid;
    }

    public String getLingname() {
        return lingname;
    }

    public void setLingname(String lingname) {
        this.lingname = lingname;
    }

    public String getJobname() {
        return jobname;
    }

    public void setJobname(String jobname) {
        this.jobname = jobname;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }
}
