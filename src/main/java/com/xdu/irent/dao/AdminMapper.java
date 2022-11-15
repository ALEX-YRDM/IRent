package com.xdu.irent.dao;

import com.xdu.irent.pojo.House;
import com.xdu.irent.pojo.Landlord;
import com.xdu.irent.pojo.Record;
import com.xdu.irent.pojo.Renter;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zbq
 * @date 2022/11/14 16:23
 */

@Mapper
@Repository
public interface AdminMapper {
    List<Renter> getAllRenter();

    List<Landlord> getAllLandlord();

    List<House> getAllHouse();

    List<Record> getAllRecord();
}
