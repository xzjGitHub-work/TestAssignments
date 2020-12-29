package com.xuzhaoju.service;

import com.xuzhaoju.dao.EmployeeDao;
import com.xuzhaoju.dao.EmployeeDao;
import com.xuzhaoju.model.EmployeeModel;
import com.xuzhaoju.model.EmployeeModel;

import java.sql.SQLException;
import java.util.List;

/**
 * java类作用描述
 *
 * @author xuzhaoju
 * @createDate 2020/12/23 14:59
 */
public class EmployeeService {
    public List<EmployeeModel> queryAll(EmployeeModel model){
        try {
            return new EmployeeDao().queryAll(model);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int update(EmployeeModel s) {
        EmployeeDao sDao = new EmployeeDao();
        try {
            sDao.update(s);
            return 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return 1001;
        }
    }

    public int delete(String id) {
        EmployeeDao sDao =new EmployeeDao();
        try {
            sDao.detele(id);
            return 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return 1001;
        }
    }

    public int insert(EmployeeModel s) {
        EmployeeDao sDao =new EmployeeDao();
        try {
            sDao.add(s);
            return 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return 1001;
        }
    }
}
