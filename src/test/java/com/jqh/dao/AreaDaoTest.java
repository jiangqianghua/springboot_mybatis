package com.jqh.dao;

import com.jqh.entity.Area;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AreaDaoTest {

    @Autowired
    private AreaDao areaDao;
    @Test
    public void queryArea() {
        List<Area> areaDaos = areaDao.queryArea();
        assertEquals(2,areaDaos.size());
    }

    @Test
    public void queryAreaById() {
        Area area = areaDao.queryAreaById(1);
        assertEquals("江家村",area.getAreaName());
    }

    @Test
    public void insertArea() {

        Area area = new Area();
        area.setAreaName("杨家村");
        area.setPrority(3);
        int result = areaDao.insertArea(area);
        assertEquals(1,result);
    }

    @Test
    public void updateArea() {

        Area area = areaDao.queryAreaById(1);
        area.setAreaName("江家村update");
        area.setLastEditTime(new Date());
        int result = areaDao.updateArea(area);
        assertEquals(1,result);
    }

    @Test
    public void deleteAreaById() {
        int result = areaDao.deleteAreaById(3);
        assertEquals(1,result);
    }
}