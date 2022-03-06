package cn.t18.est.utils;

import java.util.List;

/**
 * 分页查询类
 */
public class PageBean<T> {
    private int pagNo;   //当前页
    private int total;  //总数量
    private int totalPag;  //总页数
    private List<T> list;   //页面数据

    public void setPagSize(int pagSize) {
        this.pagSize = pagSize;
    }

    private int pagSize;    //当前页面显示的数据条数


    //封装属性
    public int getPagNo() {
        return pagNo;
    }

    //判断设置当期页面  当页面小于总页数时赋值给当前页  当当前页大于总页数时将总页数赋值给当前页
    public void setPagNo(int pagNo) {
        if(pagNo>0){
            this.pagNo = pagNo;
        }else if (this.pagNo>this.totalPag && this.totalPag!=0){
            this.pagNo = this.totalPag;
        }

    }

    public int getTotal() {
        return total;
    }
    //设置总条数  计算总页数   总页数=总条数 % 当前页面显示的数据条数
    public void setTotalCount(int total) {
        this.total = total;
        if (this.total > 0){
            this.totalPag = (this.total % this.pagSize)==0? this.total / this.pagSize : this.total / this.pagSize+1;
        }
    }

    public int getTotalPag() {
        return totalPag;
    }

    public void setTotalPag(int totalPag) {
        this.totalPag = totalPag;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public List<T> getList() {
        return list;
    }

    public int getPagSize() {
        return pagSize;
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "pagNo=" + pagNo +
                ", total=" + total +
                ", totalPag=" + totalPag +
                ", list=" + list +
                ", pagSize=" + pagSize +
                '}';
    }
}
