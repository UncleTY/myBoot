package com.ty.bb.bean;

import java.io.Serializable;
import java.util.List;

public class Page<E extends Serializable> implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<E> rows;
    private long total;
    private String positionStr;

    public Page() {
    }

    public Page(List<E> rows, long total) {
        this.rows = rows;
        this.total = total;
    }

    private Page(List<E> rows, long total, String positionStr) {
        this(rows, total);
        this.positionStr = positionStr;
    }

    public Page(List<E> rows) {
        this.rows = rows;
        if (rows instanceof com.github.pagehelper.Page) {
            this.total = ((com.github.pagehelper.Page) rows).getTotal();
        } else {
            this.total = (long) rows.size();
        }

    }

    private Page(List<E> rows, String positionStr) {
        this(rows);
        this.positionStr = positionStr;
    }

    public static <T extends Serializable> Page<T> of(List<T> rows) {
        return new Page(rows);
    }

    public static <T extends Serializable> Page<T> of(List<T> rows, String positionStr) {
        return new Page(rows, positionStr);
    }

    public static <T extends Serializable> Page<T> of(List<T> rows, long total, String positionStr) {
        return new Page(rows, total, positionStr);
    }

    public List<E> getRows() {
        return this.rows;
    }

    public long getTotal() {
        return this.total;
    }

    public String getPositionStr() {
        return this.positionStr;
    }

    public void setRows(List<E> rows) {
        this.rows = rows;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public void setPositionStr(String positionStr) {
        this.positionStr = positionStr;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof Page)) {
            return false;
        } else {
            Page<?> other = (Page) o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label39:
                {
                    Object this$rows = this.getRows();
                    Object other$rows = other.getRows();
                    if (this$rows == null) {
                        if (other$rows == null) {
                            break label39;
                        }
                    } else if (this$rows.equals(other$rows)) {
                        break label39;
                    }

                    return false;
                }

                if (this.getTotal() != other.getTotal()) {
                    return false;
                } else {
                    Object this$positionStr = this.getPositionStr();
                    Object other$positionStr = other.getPositionStr();
                    if (this$positionStr == null) {
                        if (other$positionStr != null) {
                            return false;
                        }
                    } else if (!this$positionStr.equals(other$positionStr)) {
                        return false;
                    }

                    return true;
                }
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof Page;
    }

    /*public int hashCode() {
        int PRIME = true;
        int result = 1;
        Object $rows = this.getRows();
        int result = result * 59 + ($rows == null ? 43 : $rows.hashCode());
        long $total = this.getTotal();
        result = result * 59 + (int)($total >>> 32 ^ $total);
        Object $positionStr = this.getPositionStr();
        result = result * 59 + ($positionStr == null ? 43 : $positionStr.hashCode());
        return result;
    }*/

    public String toString() {
        return "Page(rows=" + this.getRows() + ", total=" + this.getTotal() + ", positionStr=" + this.getPositionStr() + ")";
    }
}
