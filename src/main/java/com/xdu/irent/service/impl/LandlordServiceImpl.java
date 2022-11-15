package com.xdu.irent.service.impl;

import com.xdu.irent.dao.LandlordMapper;
import com.xdu.irent.pojo.House;
import com.xdu.irent.pojo.Landlord;
import com.xdu.irent.service.LandlordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zbq
 * @date 2022/11/10 18:41
 */
@Service
public class LandlordServiceImpl implements LandlordService {
    @Autowired
    private LandlordMapper landlordMapper;
    @Override
    public Landlord findLandlordByUsernameAndPassword(String username, String password) {
        return landlordMapper.findLandlordByUsernameAndPassword(username,password);
    }

    @Override
    public int addLandlord(Landlord landlord) {
        landlordMapper.addLandlord(landlord);
        return 0;
    }

    @Override
    public void deleteById(Long id) {
        landlordMapper.deleteById(id);
    }

    @Override
    public int updateLandlord(Landlord landlord) {
        landlordMapper.updateLandlord(landlord);
        return 0;
    }

    @Override
    public List<House> getHouseByLid(Long id) {
        return landlordMapper.getHouseByLid(id);
    }
}
