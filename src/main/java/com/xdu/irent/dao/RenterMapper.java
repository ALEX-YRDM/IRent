package com.xdu.irent.dao;

import com.xdu.irent.pojo.House;
import com.xdu.irent.pojo.Renter;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zbq
 * @date 2022/10/25 13:15
 */
@Mapper
@Repository
public interface RenterMapper {
    //根据用户名密码查询租客
    Renter findRenterByUsernameAndPassword(@Param("username") String username,@Param("password") String password);
    //增加租客
    int addRenter(Renter renter);
    //根据id删除租客
    void deleteRenterById(@Param("id") Long id);
    //修改租客信息
    int updateRenter(Renter renter);

    List<House> getNotRentedHouse();

    List<House> searchHouse(@Param("text") String text);
}
