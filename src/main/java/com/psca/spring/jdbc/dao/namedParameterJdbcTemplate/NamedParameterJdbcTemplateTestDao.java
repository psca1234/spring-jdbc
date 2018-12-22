package com.psca.spring.jdbc.dao.namedParameterJdbcTemplate;

public interface NamedParameterJdbcTemplateTestDao {
	void updateCityInfoByCityId(String cityName,Integer id);
	void deleteCityInfoByCityId(Integer id);
}
