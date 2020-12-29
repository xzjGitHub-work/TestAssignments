package com.xuzhaoju.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xuzhaoju.model.EmployeeModel;
import com.xuzhaoju.model.EmployeeModel;
import com.xuzhaoju.util.EmptyUtils;
import com.xuzhaoju.util.JdbcUtil;

public class EmployeeDao {

    public void add(EmployeeModel s) throws SQLException {
        //获取连接
        Connection conn = JdbcUtil.getConnection();
        //准备sql
        String sql="insert into employee (name,age,gender,postion,department) VALUES(?,?,?,?,?);";
        //获取PreparedStatement
        PreparedStatement ps=conn.prepareStatement(sql);
        //填充占位符
        ps.setString(1, s.getName());
		ps.setString(2, s.getAge());
        ps.setString(3, s.getGender());
        ps.setString(4, s.getPostion());
        ps.setString(5, s.getDepartment());
        //执行sql
        ps.executeUpdate();
        //关闭连接
        JdbcUtil.release(conn);
    }

    public void detele(String id) throws SQLException {
        //获取连接
        Connection conn = JdbcUtil.getConnection();
        //准备sql
        String sql="delete from employee where id = ?";
        //获取PreparedStatement
        PreparedStatement ps=conn.prepareStatement(sql);
        //填充占位符
        ps.setString(1, id);
        //执行sql
        ps.executeUpdate();
        //关闭连接
        JdbcUtil.release(conn);
    }

    public void update(EmployeeModel s) throws SQLException {
        Connection conn = JdbcUtil.getConnection();
        String sql="UPDATE employee SET `name`= ? ,age= ? ,gender = ?,postion = ?, department = ? WHERE id = ?; ";
        PreparedStatement ps=conn.prepareStatement(sql);
        ps.setString(1, s.getName());
        ps.setString(2, s.getAge());
        ps.setString(3, s.getGender());
        ps.setString(4, s.getPostion());
        ps.setString(5, s.getDepartment());
        ps.setString(6, s.getId());
        ps.executeUpdate();
        JdbcUtil.release(conn);
    }

    public List<EmployeeModel> queryAll(EmployeeModel model) throws SQLException{
        List<EmployeeModel> stus=new ArrayList<>();
        //获取连接
        Connection conn = JdbcUtil.getConnection();
        //准备sql
        StringBuilder sql = new StringBuilder("select id,name,age ,gender,postion,department  from employee");
        if (!EmptyUtils.isAnyoneEmpty(model)){
            if (!EmptyUtils.isEmpty(model.getName())){
                sql.append(" AND Name LIKE '%"+model.getName()+"%'");

            }
        }
        //获取PreparedStatement
        PreparedStatement ps=conn.prepareStatement(sql);
        //执行sql
        ResultSet rs = ps.executeQuery();
        while(rs.next()) {
            EmployeeModel s=new EmployeeModel();
            s.setId(rs.getString(1));
            s.setName(rs.getString(2));
            s.setAge(rs.getString(3));
			s.setGender(rs.getString(4));
            s.setPostion(rs.getString(5));
            s.setDepartment(rs.getString(6));
            stus.add(s);
        }
        //关闭连接
        JdbcUtil.release(conn);
        return stus;
    }
}
