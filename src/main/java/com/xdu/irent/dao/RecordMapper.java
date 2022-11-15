package com.xdu.irent.dao;

import com.xdu.irent.pojo.Record;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author zbq
 * @date 2022/11/7 22:29
 */
@Mapper
@Repository
public interface RecordMapper {
    //增加一条交易记录
    int addRecord(Record record);
    //删除一条交易记录
    void deleteRecordById(@Param("id") Long id);

}
