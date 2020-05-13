package com.abchina.interfacemanager.entity;

public class PageInfo {

    private int currentPage;
    private int pageSize;
    private int totalPageSize;
    private long totalElementNum;

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalPageSize() {
        return totalPageSize;
    }

    public void setTotalPageSize(int totalPageSize) {
        this.totalPageSize = totalPageSize;
    }

    public long getTotalElementNum() {
        return totalElementNum;
    }

    public void setTotalElementNum(long totalElementNum) {
        this.totalElementNum = totalElementNum;
    }
}
