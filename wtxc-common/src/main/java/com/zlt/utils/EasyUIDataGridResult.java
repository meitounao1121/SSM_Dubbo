package com.zlt.utils;

import java.io.Serializable;
import java.util.List;

public class EasyUIDataGridResult<T> implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = -2858175255201560613L;

    private long total;

    private List<T> rows;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public EasyUIDataGridResult(long total, List<T> rows) {
        this.total = total;
        this.rows = rows;
    }
}