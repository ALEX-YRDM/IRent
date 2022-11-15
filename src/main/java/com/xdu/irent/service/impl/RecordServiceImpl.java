package com.xdu.irent.service.impl;

import com.xdu.irent.dao.RecordMapper;
import com.xdu.irent.pojo.Record;
import com.xdu.irent.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zbq
 * @date 2022/11/10 18:43
 */
@Service
public class RecordServiceImpl implements RecordService {
    @Autowired
    private RecordMapper recordMapper;
    @Override
    public int addRecord(Record record) {
        recordMapper.addRecord(record);
        return 0;
    }

    @Override
    public void deleteRecordById(Long id) {
        recordMapper.deleteRecordById(id);
    }
}
