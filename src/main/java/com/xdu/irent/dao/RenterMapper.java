package com.xdu.irent.dao;

import com.xdu.irent.pojo.Renter;

/**
 * @author zbq
 * @date 2022/10/25 13:15
 */
public interface RenterMapper {
    //根据用户名密码查询租客
    Renter findRenterByUsernameAndPassword(String username,String password);
    //增加租客
    int addRenter(Renter renter);
    //根据id删除租客
    void deleteRenterById(int id);
    //修改租客信息
    int updateRenter(Renter renter);


}
