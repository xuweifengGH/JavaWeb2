package com.javaweb.web.dao.ds1;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.javaweb.mybatis.api.DaoForMySql;
import com.javaweb.web.po.Schedule;

@Mapper
public interface ScheduleDao extends DaoForMySql<Schedule> {
	
	public List<Schedule> getScheduleByDate(Map<String,String> map);
	
	public void deleteByScheduleDate(Map<String,String> map);
	
	public void scheduleSave(List<Schedule> list);
	
}