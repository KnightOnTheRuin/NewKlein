package com.example.Klein.entity;

public class PageSendMessage {

    private int currentPage;

    private int pageSize;

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int PageSize) {
        this.pageSize = PageSize;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }
}
