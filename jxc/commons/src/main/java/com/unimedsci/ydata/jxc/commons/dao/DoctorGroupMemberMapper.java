package com.unimedsci.ydata.jxc.commons.dao;

import com.unimedsci.ydata.jxc.commons.datas.DoctorGroupMember;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorGroupMemberMapper {
    int deleteByPrimaryKey(Integer doctorGroupMemberId);

    int insert(DoctorGroupMember record);

    int insertSelective(DoctorGroupMember record);

    DoctorGroupMember selectByPrimaryKey(Integer doctorGroupMemberId);

    int updateByPrimaryKeySelective(DoctorGroupMember record);

    int updateByPrimaryKey(DoctorGroupMember record);
}