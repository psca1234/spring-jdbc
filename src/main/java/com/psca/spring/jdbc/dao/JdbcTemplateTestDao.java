package com.psca.spring.jdbc.dao;

import java.util.List;

import com.psca.spring.domain.City;

public interface JdbcTemplateTestDao {
	void saveOne(Object[] args);
	void batchSave(List<Object[]> argsList);
	Integer showAllInfoCounts();
	List<City> showAllInfos();
}
