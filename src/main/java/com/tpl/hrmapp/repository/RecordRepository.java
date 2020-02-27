package com.tpl.hrmapp.repository;

import com.tpl.hrmapp.domain.Record;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecordRepository extends JpaRepository<Record, Integer> {
}
