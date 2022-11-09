package com.xdu.irent.dao;

import com.xdu.irent.pojo.House;

import java.util.List;

/**
 * @author zbq
 * @date 2022/10/25 13:20
 */
public interface HouseMapper {
    //查询所有房屋
    List<House> findAll();
    //添加房屋
    int addHouse(House house);
    //删除房屋
    void deleteHouseById(Long id);
    //修改房屋
    int updateHouse(House house);
}






