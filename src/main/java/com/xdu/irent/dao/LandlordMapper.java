package com.xdu.irent.dao;

import com.xdu.irent.pojo.Landlord;

/**
 * @author zbq
 * @date 2022/10/25 13:16
 */
public interface LandlordMapper {
    //根据用户名和密码查询房东
    Landlord findLandlordByUsernameAndPassword(String username,String password);
    //新增用户名
    int addLandlord(Landlord landlord);
    //根据id删除用户
    void deleteById(int id);
    //修改房东信息
    int updateLandlord(Landlord landlord);
}
