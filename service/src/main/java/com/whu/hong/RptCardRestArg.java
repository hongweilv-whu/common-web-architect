package com.whu.hong;


/**
 * Description:
 * Created by lvhw on 2017/1/9 11:14.
 */
public class RptCardRestArg {

    private int dataId; // 普通员工/共享员工/共享部门id

    private String dataName; // 普通员工/共享员工/共享部门名称

    private int dataType; // 1:下属员工；2:共享部门；3:共享员工

    private String beginTime; // yy-mm-dd hh:mm:ss

    private String endTime;

    private int ei;     // 企业Id

    private String ea;  // 企业账号

    private int userId; // 发起请求的userId

    public int getDataId() {
        return dataId;
    }

    public void setDataId(int dataId) {
        this.dataId = dataId;
    }

    public String getDataName() {
        return dataName;
    }

    public void setDataName(String dataName) {
        this.dataName = dataName;
    }

    public int getDataType() {
        return dataType;
    }

    public void setDataType(int dataType) {
        this.dataType = dataType;
    }

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public int getEi() {
        return ei;
    }

    public void setEi(int ei) {
        this.ei = ei;
    }

    public String getEa() {
        return ea;
    }

    public void setEa(String ea) {
        this.ea = ea;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
