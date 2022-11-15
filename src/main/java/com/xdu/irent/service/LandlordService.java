package com.xdu.irent.service;

import com.xdu.irent.pojo.House;
import com.xdu.irent.pojo.Landlord;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zbq
 * @date 2022/11/10 18:27
 */

public interface LandlordService {
    //根据用户名和密码查询房东
    Landlord findLandlordByUsernameAndPassword(String username, String password);
    //新增用户名
    int addLandlord(Landlord landlord);
    //根据id删除用户
    void deleteById(Long id);
    //修改房东信息
    int updateLandlord(Landlord landlord);

    List<House> getHouseByLid(@Param("lid") Long id);
}
