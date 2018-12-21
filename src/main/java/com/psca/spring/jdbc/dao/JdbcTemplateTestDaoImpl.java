package com.psca.spring.jdbc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.psca.spring.domain.City;

@Repository
public class JdbcTemplateTestDaoImpl implements JdbcTemplateTestDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void saveOne(Object[] args) {
		// TODO Auto-generated method stub
		String sql = "insert into city(name,countryCode,district,population) values (?,?,?,?)";
		jdbcTemplate.update(sql, args);
	}

	public void batchSave(List<Object[]> argsList) {
		// TODO Auto-generated method stub
		String sql = "insert into city(name,countryCode,district,population) values (?,?,?,?)";
		jdbcTemplate.batchUpdate(sql, argsList);
	}

	public Integer showAllInfoCounts() {
		// TODO Auto-generated method stub
		String sql = "select count(*) from city";
		Integer result = jdbcTemplate.queryForObject(sql, Integer.class);
		return result;
	}

	public List<City> showAllInfos() {
		// TODO Auto-generated method stub
		String sql ="select id,name,countryCode,district,population from city";
		RowMapper<City> cityMapper = new BeanPropertyRowMapper<City>(City.class);
		return jdbcTemplate.query(sql, cityMapper);
	}

}
