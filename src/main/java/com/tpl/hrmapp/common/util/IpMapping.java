package com.tpl.hrmapp.common.util;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class IpMapping {
    private String[] ipArray = {"10.122.4.66", "10.122.4.28", "10.122.4.80", "10.122.8.5", "10.122.3.11", "10.122.48.3", "10.122.3.91", "10.122.56.85", "10.122.16.15", "10.122.4.193", "10.122.3.34", "10.122.4.133", "10.122.40.5", "10.122.72.5", "10.122.4.101", "10.122.4.21", "10.122.4.33", "10.122.4.30", "10.122.64.85", "10.122.32.3", "10.122.4.104","10.122.4.103"};
    private Map<String, String> ipEmployeeMap = new HashMap<>();

    //判断操作人是否具备权限
    public boolean permissionVerif(String ipAddress) {
        boolean result = false;
        for (String str : ipArray) {
            if (ipAddress.equals(str)) {
                result = true;
                break;
            }
        }
        return result;
    }

    //判断操作人员是否在合理范围内操作
    public String limitOperation(String ipAddress) {
        insertMap();
        String deptName = ipEmployeeMap.get(ipAddress);
        return deptName;
    }

    public void insertMap() {
        ipEmployeeMap.put("10.122.4.66", "财务部");
        ipEmployeeMap.put("10.122.4.28", "运营服务部");
        ipEmployeeMap.put("10.122.4.80", "运营服务部");
        ipEmployeeMap.put("10.122.8.5", "顺德支公司");
        ipEmployeeMap.put("10.122.3.11", "教育培训部");
        ipEmployeeMap.put("10.122.48.3", "高明支公司");
        ipEmployeeMap.put("10.122.3.91", "禅城支公司");
        ipEmployeeMap.put("10.122.56.85", "勒流营销服务部");
        ipEmployeeMap.put("10.122.16.15", "顺德龙江支公司");
        ipEmployeeMap.put("10.122.4.193", "工会");
        ipEmployeeMap.put("10.122.3.34", "办公室");
        ipEmployeeMap.put("10.122.4.133", "合规部");
        ipEmployeeMap.put("10.122.40.5", "大沥营销服务部");
        ipEmployeeMap.put("10.122.72.5", "南海支公司");
        ipEmployeeMap.put("10.122.4.101", "综合开拓部");
        ipEmployeeMap.put("10.122.4.21", "个人业务部");
        ipEmployeeMap.put("10.122.4.33", "战略拓展部");
        ipEmployeeMap.put("10.122.4.30", "银保业务支援部");
        ipEmployeeMap.put("10.122.64.85", "均安支公司");
        ipEmployeeMap.put("10.122.32.3", "三水营销服务部");
        ipEmployeeMap.put("10.122.4.104", "银保业务发展部");
        ipEmployeeMap.put("10.122.4.103", "服务拓展部");
    }
}
