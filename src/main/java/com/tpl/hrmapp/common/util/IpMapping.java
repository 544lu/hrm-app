package com.tpl.hrmapp.common.util;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class IpMapping {
    private String[] ipArray = {"10.122.4.67", "10.122.4.28"};
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
        String deptName = ipEmployeeMap.get(ipAddress);
        return deptName;
    }

    public void insertMap() {
        ipEmployeeMap.put("10.122.4.67", "何达林");
        ipEmployeeMap.put("10.122.4.28", "谢定华");
    }
}
