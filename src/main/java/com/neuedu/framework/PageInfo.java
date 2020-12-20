package com.neuedu.framework;

import java.util.List;

/**
 * Keafmd
 *
 * @ClassName: PageInfo
 * @Description:  分页信息封装
 * @author: 牛哄哄的柯南
 * @date: 2020-12-20 10:08
 */

public class PageInfo {


    private Integer pageNo; //查询第几页
    private Integer pageSize; //每页显示条数


    private Integer totalPage ;//总页数
    private Integer totalCount;// 总条数


    private List list;   //查询的数据


    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalPage() {

        return totalCount%pageSize==0?totalCount/pageSize  :  (totalCount/pageSize)+1;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }
}