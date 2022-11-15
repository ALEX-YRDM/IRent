package com.xdu.irent.service;

import com.xdu.irent.pojo.Record;
import org.springframework.stereotype.Service;

/**
 * @author zbq
 * @date 2022/11/10 18:28
 */

public interface RecordService {
    //增加一条交易记录
    int addRecord(Record record);
    //删除一条交易记录
    void deleteRecordById(Long id);

}
