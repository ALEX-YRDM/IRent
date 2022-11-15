package com.xdu.irent.dao;

import com.xdu.irent.pojo.House;
import com.xdu.irent.pojo.Landlord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zbq
 * @date 2022/10/25 13:16
 */
@Mapper
@Repository
public interface LandlordMapper {
    //根据用户名和密码查询房东
    Landlord findLandlordByUsernameAndPassword(@Param("username") String username,@Param("password") String password);
    //新增用户名
    int addLandlord(Landlord landlord);
    //根据id删除用户
    void deleteById(@Param("id") Long id);
    //修改房东信息
    int updateLandlord(Landlord landlord);

    //根据id查询用户
    Landlord getLandlord(@Param("id") Long id);

    List<House> getHouseByLid(@Param("lid") Long id);

}
