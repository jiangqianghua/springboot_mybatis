package com.jqh.dao;

import com.jqh.entity.Area;

import java.util.List;

public interface AreaDao {

    List<Area> queryArea();

    Area queryAreaById(int areaId);

    int insertArea(Area area);

    int updateArea(Area area);

    int deleteAreaById(int areaId);
}
