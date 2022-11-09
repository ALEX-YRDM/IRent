package com.xdu.irent.dao;

import com.xdu.irent.pojo.Record;

/**
 * @author zbq
 * @date 2022/11/7 22:29
 */
public interface RecordMapper {
    //增加一条交易记录
    int addRecord(Record record);
    //删除一条交易记录
    void deleteRecordById(Long id);

}
