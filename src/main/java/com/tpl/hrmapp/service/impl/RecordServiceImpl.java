package com.tpl.hrmapp.service.impl;

import com.tpl.hrmapp.domain.Record;
import com.tpl.hrmapp.repository.RecordRepository;
import com.tpl.hrmapp.service.RecordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecordServiceImpl implements RecordService {
    Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RecordRepository recordRepo;

    @Override
    public Record insertRecord(Record record) {
        Record re = null;
        try {
            re = recordRepo.save(record);
        } catch (Exception e) {
            log.error("添加Record时出错");
            e.printStackTrace();
        }
        return re;
    }
}
