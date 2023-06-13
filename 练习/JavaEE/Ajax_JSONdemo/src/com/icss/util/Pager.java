package com.icss.util;

/**
 * Author: tyza66
 * Date: 2023/6/13 11:28
 * Github: https://github.com/tyza66
 **/

public class Pager {
    //    当前页
    private int currPage;
    //    起始位置
    private int start;
    //    页码
    private int pageNum;
    //    总共的记录数
    private int count;
    //    每页显示数目
    private int pageSize = 5;


    public Pager(int currPage,int count){
        this.currPage = currPage;

        this.start = (currPage - 1)*pageSize + 1;

        this.pageNum = (int)Math.ceil(count * 1.0 / pageSize);

        this.count = count;

    }

    public int getCurrPage() {
        return currPage;
    }

    public void setCurrPage(int currPage) {
        this.currPage = currPage;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

}
