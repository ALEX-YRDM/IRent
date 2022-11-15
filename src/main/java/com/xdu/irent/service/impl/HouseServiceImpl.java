package com.xdu.irent.service.impl;

import com.xdu.irent.dao.HouseMapper;
import com.xdu.irent.pojo.House;
import com.xdu.irent.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zbq
 * @date 2022/11/10 18:38
 */
@Service
public class HouseServiceImpl implements HouseService {
    @Autowired
    private HouseMapper houseMapper;
    @Override
    public List<House> findAll() {
        return houseMapper.findAll();
    }

    @Override
    public int addHouse(House house) {
        houseMapper.addHouse(house);
        return 0;
    }

    @Override
    public void deleteHouseById(Long id) {
        houseMapper.deleteHouseById(id);
    }

    @Override
    public int updateHouse(House house) {
        houseMapper.updateHouse(house);
        return 0;
    }

    @Override
    public void updateHouseState(Long id, int state) {
        houseMapper.updateHouseState(id,state);
    }
}
