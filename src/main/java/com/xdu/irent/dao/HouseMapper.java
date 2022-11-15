package com.xdu.irent.dao;

import com.xdu.irent.pojo.House;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zbq
 * @date 2022/10/25 13:20
 */
@Mapper
@Repository
public interface HouseMapper {
    //查询所有房屋
    List<House> findAll();
    //添加房屋
    int addHouse(House house);
    //删除房屋
    void deleteHouseById(@Param("id") Long id);
    //修改房屋
    int updateHouse(House house);

    void updateHouseState(@Param("id") Long id,@Param("state") int state);
}






