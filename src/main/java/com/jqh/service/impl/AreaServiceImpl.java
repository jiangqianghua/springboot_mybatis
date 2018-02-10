package com.jqh.service.impl;

import com.jqh.dao.AreaDao;
import com.jqh.entity.Area;
import com.jqh.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class AreaServiceImpl implements AreaService {
    @Autowired
    private AreaDao areaDao;

    @Override
    public List<Area> queryArea() {
        return areaDao.queryArea();
    }

    @Override
    public Area queryAreaById(int areaId) {
        return areaDao.queryAreaById(areaId);
    }

    /**
     * 事务回滚，到遇到RuntimeException异常回滚，默认不写就是到遇到RuntimeException
     * @param area
     * @return
     */
    @Transactional(rollbackFor = RuntimeException.class)
    //@Transactional
    @Override
    public boolean addArea(Area area) {
        if(area.getAreaName() != null && !"".equals(area.getAreaName())) {
            area.setCreateTime(new Date());
            area.setLastEditTime(new Date());

            try{
                int result = 0 ;
                result = areaDao.insertArea(area);
                if(result > 0)
                    return true;
                else
                    throw new RuntimeException("add area error");
            }catch (Exception e){
                throw new RuntimeException("add area error:"+e.getMessage());
            }
        }else{
            throw new RuntimeException("area name is null");
        }
    }

    @Transactional
    @Override
    public boolean modifyArea(Area area) {
        if(area.getAreaName() != null && !"".equals(area.getAreaName())) {
            area.setLastEditTime(new Date());
            try{
                int result = 0 ;
                result = areaDao.updateArea(area);
                if(result > 0)
                    return true;
                else
                    throw new RuntimeException("update area error");
            }catch (Exception e){
                throw new RuntimeException("update area error:"+e.getMessage());
            }
        }else{
            throw new RuntimeException("update name is null");
        }
    }

    @Transactional
    @Override
    public boolean deleteAreaById(int areaId) {
        try{
            int result = areaDao.deleteAreaById(areaId);
            if(result > 0)
                return true ;
            else
                throw new RuntimeException("delete area error");
        }catch (Exception  e){
            throw new RuntimeException("delete area error "+e.getMessage());
        }
    }
}
