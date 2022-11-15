package com.xdu.irent.service;

import com.xdu.irent.pojo.House;
import com.xdu.irent.pojo.Renter;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zbq
 * @date 2022/11/10 15:03
 */
public interface RenterService {
    //根据用户名密码查询租客
    Renter findRenterByUsernameAndPassword(String username, String password);
    //增加租客
    int addRenter(Renter renter);
    //根据id删除租客
    void deleteRenterById(Long id);
    //修改租客信息
    int updateRenter(Renter renter);
    //获取所有未出租房屋
    List<House> getNotRentedHouse();

    List<House> searchHouse(@Param("text") String text);
}
