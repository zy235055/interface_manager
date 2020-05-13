package com.abchina.interfacemanager.entity;

public class InterfaceInfoQuery {
    private String interfaceSysQuery;
    private String callInterfaceSysQuery;
    private String iSmartQuery;
    private String id;
    private Integer currentPage;
    private Integer pageSize;

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getInterfaceSysQuery() {
        return interfaceSysQuery;
    }

    public void setInterfaceSysQuery(String interfaceSysQuery) {
        this.interfaceSysQuery = interfaceSysQuery;
    }

    public String getCallInterfaceSysQuery() {
        return callInterfaceSysQuery;
    }

    public void setCallInterfaceSysQuery(String callInterfaceSysQuery) {
        this.callInterfaceSysQuery = callInterfaceSysQuery;
    }

    public String getiSmartQuery() {
        return iSmartQuery;
    }

    public void setiSmartQuery(String iSmartQuery) {
        this.iSmartQuery = iSmartQuery;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
