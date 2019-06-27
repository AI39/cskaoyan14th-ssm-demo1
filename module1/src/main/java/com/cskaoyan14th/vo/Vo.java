package com.cskaoyan14th.vo;

import java.util.List;

public class Vo<T> {
    long total;
    List<T> rows;

    @Override
    public String toString() {
        return "Vo{" +
                "total=" + total +
                ", rows=" + rows +
                '}';
    }

    public Vo(){}
    public Vo(long total, List<T> rows) {
        this.total = total;
        this.rows = rows;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
