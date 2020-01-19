package com.tpl.hrmapp.presentation;

public class HandleInfo {
    private String result;
    private String message;

    public HandleInfo(String result,String mes){
        this.result=result;
        this.message=mes;
    }
    public String getResult() {
        return result;
    }


    public void setResult(String result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
