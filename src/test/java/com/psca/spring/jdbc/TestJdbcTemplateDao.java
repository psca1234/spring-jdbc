package com.psca.spring.jdbc;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.psca.spring.domain.City;
import com.psca.spring.jdbc.dao.JdbcTemplateTestDao;
import com.psca.spring.jdbc.dao.namedParameterJdbcTemplate.NamedParameterJdbcTemplateTestDao;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class TestJdbcTemplateDao {
	@Autowired
	private JdbcTemplateTestDao jdbcTemplateTestDao;
	@Autowired
	private NamedParameterJdbcTemplateTestDao named;
	@Test
	public void test() {
		fail("Not yet implemented");
	}
	@Test
	public void testAddCity() {
		jdbcTemplateTestDao.saveOne(new Object[] {"haerbin","AFG","heilongjiang","10086"});
	}
	@Test
	public void testAddCityBatch() {
		List<Object[]> argsList= new ArrayList<Object[]>();
		Object[] argObject1 = new Object[] {"jilin","AFG","jilin","10042"};
		Object[] argObject2 = new Object[] {"daqin","AFG","heilongjiang","10085"};
		Object[] argObject3 = new Object[] {"changchun","AFG","jilin","10043"};
		Object[] argObject4 = new Object[] {"jiamusi","AFG","heilongjiang","10084"};
		Object[] argObject5 = new Object[] {"qiqihaer","AFG","heilongjiang","10083"};
		argsList.add(argObject1);
		argsList.add(argObject2);
		argsList.add(argObject3);
		argsList.add(argObject4);
		argsList.add(argObject5);
		jdbcTemplateTestDao.batchSave(argsList);
	}
	@Test
	public void testGetAllCityInfoCount() {
		Integer result = jdbcTemplateTestDao.showAllInfoCounts();
		System.out.println(result);
	}
	@Test
	public void testGetAllCityInfos() {
		List<City> cityList = jdbcTemplateTestDao.showAllInfos();
		System.out.println(cityList.size());
		for(City city : cityList) {
			System.out.println(city);
		}
	}
	@Test
	public void testUpdateCityInfoByNamedParameterJdbcTemplate() {
		String countryCode="CHN";
		Integer id = 4082;
		named.updateCityInfoByCityId(countryCode, id);
	}
	@Test
	public void testDeleteCityInfoByCityIdAndUseSqlParameterSource() {
		Integer id = 4086;
		named.deleteCityInfoByCityId(id);
	}
}
