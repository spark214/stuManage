package com.toz.model;

/**
 * Created by Administrator on 2017/9/12.
 */
public class PageBean {
    private int page;
    private int rows;
    private int start;

    public PageBean(int page, int rows) {
        this.page = page;
        this.rows = rows;
    }

    public int getPage() {
        return this.page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getRows() {
        return this.rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getStart() {
        return (this.page - 1) * this.rows;
    }
}
