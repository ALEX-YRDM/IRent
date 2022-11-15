package com.xdu.irent.service;

import com.xdu.irent.pojo.House;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zbq
 * @date 2022/11/10 18:27
 */
public interface HouseService {
    //查询所有房屋
    List<House> findAll();
    //添加房屋
    int addHouse(House house);
    //删除房屋
    void deleteHouseById(Long id);
    //修改房屋
    int updateHouse(House house);

    void updateHouseState(@Param("id") Long id, @Param("state") int state);
}
