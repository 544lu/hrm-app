package com.tpl.hrmapp.controller;

import com.tpl.hrmapp.domain.Record;
import com.tpl.hrmapp.presentation.FrontView;
import com.tpl.hrmapp.presentation.QueryEmployeeParam;
import com.tpl.hrmapp.service.RecordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class RecordController {

    Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RecordService recordService;

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "getRecord", method = RequestMethod.GET)
    @ResponseBody
    public FrontView<Record> getRecord(QueryEmployeeParam param, HttpServletRequest request) {
        String[] pros = {"id"};
        Pageable pageable = PageRequest.of(param.getPage() - 1, param.getRows(), Sort.Direction.DESC, pros);
        Page<Record> records;
        try {
            records = recordService.selectRecordByPage(request.getRemoteAddr(), pageable);
        } catch (Exception e) {
            log.error("在查询Record集合时出错");
            e.printStackTrace();
            return null;
        }
        if (records.getSize() == 0) {
            return null;
        }
        List<Record> recordList = records.toList();
        long total = records.getTotalElements();
        FrontView<Record> view = new FrontView<>(param.getPage(), recordList, total);
        return view;
    }
}
