package com.unimedsci.ydata.jxz.commons.dao;

import com.unimedsci.ydata.jxz.commons.datas.Department;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentMapper {
    int deleteByPrimaryKey(Integer departmentId);

    int insert(Department record);

    int insertSelective(Department record);

    Department selectByPrimaryKey(Integer departmentId);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);
}