package com.tpl.hrmapp.service.impl;

import com.tpl.hrmapp.domain.Employee;
import com.tpl.hrmapp.domain.Record;
import com.tpl.hrmapp.repository.RecordRepository;
import com.tpl.hrmapp.service.RecordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

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

    @Override
    public Page<Record> selectRecordByPage(String modifier, Pageable pageable) {
        return recordRepo.findAll(new Specification<Record>() {
            @Override
            public Predicate toPredicate(Root<Record> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

                Predicate idEqual = null;
                if (null != modifier) {
                    idEqual = cb.equal(root.<String>get("modifier"), modifier);
                }
                if (null != idEqual) query.where(idEqual);
                return idEqual;
            }
        }, pageable);
    }
}
