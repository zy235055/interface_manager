package com.abchina.interfacemanager.entity;

public class SuccessMsg {
    boolean successStatus;
    String successMsg;

    public SuccessMsg(boolean successStatus, String successMsg) {
        this.successStatus = successStatus;
        this.successMsg = successMsg;
    }

    public boolean isSuccessStatus() {
        return successStatus;
    }

    public void setSuccessStatus(boolean successStatus) {
        this.successStatus = successStatus;
    }

    public String getSuccessMsg() {
        return successMsg;
    }

    public void setSuccessMsg(String successMsg) {
        this.successMsg = successMsg;
    }
}
