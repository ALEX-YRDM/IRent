package com.xdu.irent.service.impl;

import com.xdu.irent.dao.RenterMapper;
import com.xdu.irent.pojo.House;
import com.xdu.irent.pojo.Renter;
import com.xdu.irent.service.RenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zbq
 * @date 2022/11/10 15:03
 */
@Service
public class RenterServiceImpl implements RenterService {
    @Autowired
    private RenterMapper renterMapper;
    @Override
    public Renter findRenterByUsernameAndPassword(String username, String password) {
        return renterMapper.findRenterByUsernameAndPassword(username,password);
    }

    @Override
    public int addRenter(Renter renter) {
        renterMapper.addRenter(renter);
        return 0;
    }

    @Override
    public void deleteRenterById(Long id) {
        renterMapper.deleteRenterById(id);
    }

    @Override
    public int updateRenter(Renter renter) {
        renterMapper.updateRenter(renter);
        return 0;
    }

    @Override
    public List<House> getNotRentedHouse() {
        return renterMapper.getNotRentedHouse();
    }

    @Override
    public List<House> searchHouse(String text) {
        return renterMapper.searchHouse(text);
    }
}
