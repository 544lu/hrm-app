package com.tpl.hrmapp.repository;

import com.tpl.hrmapp.domain.Record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface RecordRepository extends JpaRepository<Record, Integer>, JpaSpecificationExecutor<Record> {
}
