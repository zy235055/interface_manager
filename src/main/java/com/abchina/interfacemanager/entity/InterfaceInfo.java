package com.abchina.interfacemanager.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tbl_interfaceInfo")
public class InterfaceInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    //接口所在系统名称 中文
    @Column
    private String interfaceSystemName;
    @Column
    private String interfaceSystemNameEN; //接口所在系统名称 英文
    @Column
    private String interfaceServiceName; // 接口业务名称
    @Column
    private String interfaceServiceDes; // 接口业务描述
    @Column
    private String interfaceServiceDept; // 接口业务所属部门
    @Column
    private String interfaceServiceGroup; // 接口业务所属组
    @Column
    private String interfaceServiceLinkmanName; // 接口业务联系人名称
    @Column
    private String interfaceServiceLinkmanPhone; // 接口业务联系人电话
    @Column
    private String interfaceCallAddress; // 接口访问地址
    @Column
    private String interfaceMethodName; // 接口方法名称
    @Column
    private String interfaceHasParameters; // 接口方法是否需要参数
    @Column(length = 2000)
    private String interfaceParameters; // 接口方法参数
    @Column
    private String interfaceHasReturnedValue; // 接口是否有返回值
    @Column(length = 2000)
    private String interfaceReturnedValue; // 接口返回值
    @Column
    private String callInterfaceSystemName; // 调用接口的系统名称 中文
    @Column
    private String callInterfaceSystemNameEN; //  调用接口的系统名称 英文
    @Column
    private String callInterfaceType; // 调用接口方式
    @Column
    private String callInterfaceFrequency; // 调用接口频率
    @Column
    private String callInterfaceDept; // 调用接口部门
    @Column
    private String callInterfaceGroup; // 调用接口组
    @Column
    private String callInterfaceLinkmanName; // 调用接口联系人
    @Column
    private String callInterfaceLinkmanPhone; // 调用接口联系电话
    @Column
    private String interfaceIsCheckInIsmart; // 是否纳入ismart
    @Column
    private String interfaceHasWhiteList; // 是否有白名单
    @Column
    private String interfaceComment; // 接口备注
    @Column
    private String dataEntryEmp;
    @Column
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date dataEntryTime;
    @Column
    private String dataEntryUpdateEmp;
    @Column
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date dataEntryUpdateTime;
    @Column
    private String deleteFlag;
    @Column
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date deleteTime;
    @Column
    private String deleteEmp;

    public String getDeleteEmp() {
        return deleteEmp;
    }

    public void setDeleteEmp(String deleteEmp) {
        this.deleteEmp = deleteEmp;
    }

    public Date getDeleteTime() {
        return deleteTime;
    }

    public void setDeleteTime(Date deleteTime) {
        this.deleteTime = deleteTime;
    }

    public String getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public String getDataEntryUpdateEmp() {
        return dataEntryUpdateEmp;
    }

    public void setDataEntryUpdateEmp(String dataEntryUpdateEmp) {
        this.dataEntryUpdateEmp = dataEntryUpdateEmp;
    }

    public Date getDataEntryUpdateTime() {
        return dataEntryUpdateTime;
    }

    public void setDataEntryUpdateTime(Date dataEntryUpdateTime) {
        this.dataEntryUpdateTime = dataEntryUpdateTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInterfaceSystemName() {
        return interfaceSystemName;
    }

    public void setInterfaceSystemName(String interfaceSystemName) {
        this.interfaceSystemName = interfaceSystemName;
    }

    public String getInterfaceSystemNameEN() {
        return interfaceSystemNameEN;
    }

    public void setInterfaceSystemNameEN(String interfaceSystemNameEN) {
        this.interfaceSystemNameEN = interfaceSystemNameEN;
    }

    public String getInterfaceServiceName() {
        return interfaceServiceName;
    }

    public void setInterfaceServiceName(String interfaceServiceName) {
        this.interfaceServiceName = interfaceServiceName;
    }

    public String getInterfaceServiceDes() {
        return interfaceServiceDes;
    }

    public void setInterfaceServiceDes(String interfaceServiceDes) {
        this.interfaceServiceDes = interfaceServiceDes;
    }

    public String getInterfaceServiceDept() {
        return interfaceServiceDept;
    }

    public void setInterfaceServiceDept(String interfaceServiceDept) {
        this.interfaceServiceDept = interfaceServiceDept;
    }

    public String getInterfaceServiceGroup() {
        return interfaceServiceGroup;
    }

    public void setInterfaceServiceGroup(String interfaceServiceGroup) {
        this.interfaceServiceGroup = interfaceServiceGroup;
    }

    public String getInterfaceServiceLinkmanName() {
        return interfaceServiceLinkmanName;
    }

    public void setInterfaceServiceLinkmanName(String interfaceServiceLinkmanName) {
        this.interfaceServiceLinkmanName = interfaceServiceLinkmanName;
    }

    public String getInterfaceServiceLinkmanPhone() {
        return interfaceServiceLinkmanPhone;
    }

    public void setInterfaceServiceLinkmanPhone(String interfaceServiceLinkmanPhone) {
        this.interfaceServiceLinkmanPhone = interfaceServiceLinkmanPhone;
    }

    public String getInterfaceCallAddress() {
        return interfaceCallAddress;
    }

    public void setInterfaceCallAddress(String interfaceCallAddress) {
        this.interfaceCallAddress = interfaceCallAddress;
    }

    public String getInterfaceMethodName() {
        return interfaceMethodName;
    }

    public void setInterfaceMethodName(String interfaceMethodName) {
        this.interfaceMethodName = interfaceMethodName;
    }

    public String getInterfaceHasParameters() {
        return interfaceHasParameters;
    }

    public void setInterfaceHasParameters(String interfaceHasParameters) {
        this.interfaceHasParameters = interfaceHasParameters;
    }

    public String getInterfaceParameters() {
        return interfaceParameters;
    }

    public void setInterfaceParameters(String interfaceParameters) {
        this.interfaceParameters = interfaceParameters;
    }

    public String getInterfaceHasReturnedValue() {
        return interfaceHasReturnedValue;
    }

    public void setInterfaceHasReturnedValue(String interfaceHasReturnedValue) {
        this.interfaceHasReturnedValue = interfaceHasReturnedValue;
    }

    public String getInterfaceReturnedValue() {
        return interfaceReturnedValue;
    }

    public void setInterfaceReturnedValue(String interfaceReturnedValue) {
        this.interfaceReturnedValue = interfaceReturnedValue;
    }

    public String getCallInterfaceSystemName() {
        return callInterfaceSystemName;
    }

    public void setCallInterfaceSystemName(String callInterfaceSystemName) {
        this.callInterfaceSystemName = callInterfaceSystemName;
    }

    public String getCallInterfaceSystemNameEN() {
        return callInterfaceSystemNameEN;
    }

    public void setCallInterfaceSystemNameEN(String callInterfaceSystemNameEN) {
        this.callInterfaceSystemNameEN = callInterfaceSystemNameEN;
    }

    public String getCallInterfaceType() {
        return callInterfaceType;
    }

    public void setCallInterfaceType(String callInterfaceType) {
        this.callInterfaceType = callInterfaceType;
    }

    public String getCallInterfaceFrequency() {
        return callInterfaceFrequency;
    }

    public void setCallInterfaceFrequency(String callInterfaceFrequency) {
        this.callInterfaceFrequency = callInterfaceFrequency;
    }

    public String getCallInterfaceDept() {
        return callInterfaceDept;
    }

    public void setCallInterfaceDept(String callInterfaceDept) {
        this.callInterfaceDept = callInterfaceDept;
    }

    public String getCallInterfaceGroup() {
        return callInterfaceGroup;
    }

    public void setCallInterfaceGroup(String callInterfaceGroup) {
        this.callInterfaceGroup = callInterfaceGroup;
    }

    public String getCallInterfaceLinkmanName() {
        return callInterfaceLinkmanName;
    }

    public void setCallInterfaceLinkmanName(String callInterfaceLinkmanName) {
        this.callInterfaceLinkmanName = callInterfaceLinkmanName;
    }

    public String getCallInterfaceLinkmanPhone() {
        return callInterfaceLinkmanPhone;
    }

    public void setCallInterfaceLinkmanPhone(String callInterfaceLinkmanPhone) {
        this.callInterfaceLinkmanPhone = callInterfaceLinkmanPhone;
    }

    public String getInterfaceIsCheckInIsmart() {
        return interfaceIsCheckInIsmart;
    }

    public void setInterfaceIsCheckInIsmart(String interfaceIsCheckInIsmart) {
        this.interfaceIsCheckInIsmart = interfaceIsCheckInIsmart;
    }

    public String getInterfaceHasWhiteList() {
        return interfaceHasWhiteList;
    }

    public void setInterfaceHasWhiteList(String interfaceHasWhiteList) {
        this.interfaceHasWhiteList = interfaceHasWhiteList;
    }

    public String getInterfaceComment() {
        return interfaceComment;
    }

    public void setInterfaceComment(String interfaceComment) {
        this.interfaceComment = interfaceComment;
    }

    public String getDataEntryEmp() {
        return dataEntryEmp;
    }

    public void setDataEntryEmp(String dataEntryEmp) {
        this.dataEntryEmp = dataEntryEmp;
    }

    public Date getDataEntryTime() {
        return dataEntryTime;
    }

    public void setDataEntryTime(Date dataEntryTime) {
        this.dataEntryTime = dataEntryTime;
    }
}
