package com.psca.spring.jdbc.dao.namedParameterJdbcTemplate;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.psca.spring.domain.City;
@Repository
public class NamedParameterJdbcTemplateTestDaoImpl implements NamedParameterJdbcTemplateTestDao{
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	public void updateCityInfoByCityId(String cityName,Integer id) {
		// TODO Auto-generated method stub
		String sql  = "update city set countryCode = :countryCode where id =:id";
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("countryCode", cityName);
		param.put("id", id);
		namedParameterJdbcTemplate.update(sql, param);
	}

	public void deleteCityInfoByCityId(Integer id) {
		// TODO Auto-generated method stub
		
		String sql ="delete from city where id=:id";
		City city = new City();
		city.setId(id);
		SqlParameterSource param = new BeanPropertySqlParameterSource(city);
		namedParameterJdbcTemplate.update(sql, param);
		
	}
	

}
