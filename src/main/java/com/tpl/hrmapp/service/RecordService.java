package com.tpl.hrmapp.service;

import com.tpl.hrmapp.domain.Employee;
import com.tpl.hrmapp.domain.Record;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface RecordService {
    Record insertRecord(Record record);
    //根据departmentId分页查询Employee
    Page<Record> selectRecordByPage(String modifier, Pageable pageable);
}
