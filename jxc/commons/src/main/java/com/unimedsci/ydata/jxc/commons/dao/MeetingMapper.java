package com.unimedsci.ydata.jxc.commons.dao;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.unimedsci.ydata.jxc.commons.datas.Meeting;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface MeetingMapper {
    int deleteByPrimaryKey(Integer meetingId);

    int insert(Meeting record);

    int insertSelective(Meeting record);

    Meeting selectByPrimaryKey(Integer meetingId);

    int updateByPrimaryKeySelective(Meeting record);

    int updateByPrimaryKeyWithBLOBs(Meeting record);

    int updateByPrimaryKey(Meeting record);

    List<Meeting> queryMeetingList(PageBounds pageBounds,
                                   @Param(value = "meetingTitle") String meetingTitle,
                                   @Param(value = "beginTime") Date beginTime,
                                   @Param(value = "endTime") Date endTime,
                                   @Param(value = "regionId") Integer regionId,
                                   @Param(value = "meetingId") Integer meetingId);
}