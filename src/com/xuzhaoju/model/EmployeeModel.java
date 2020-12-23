package com.xuzhaoju.model;

/**
 * java类作用描述
 *
 * @author xuzhaoju
 * @createDate 2020/12/23 14:59
 */
public class EmployeeModel {
    //id
    private String id;
    //姓名
    private String name;
    //年龄
    private String age;
    //性别
    private String gender;
    //职位
    private String postion;
    //部门
    private String department;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPostion() {
        return postion;
    }

    public void setPostion(String postion) {
        this.postion = postion;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public EmployeeModel(String name, String age, String gender, String postion, String department) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.postion = postion;
        this.department = department;
    }
    public EmployeeModel() {
    }
}
