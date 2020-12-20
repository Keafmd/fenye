package com.neuedu.service;

import com.neuedu.dao.DiseaseDao;
import com.neuedu.entity.Disease;
import com.neuedu.framework.PageInfo;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class DiseaseServiceTest {
    DiseaseDao diseaseDao = new DiseaseDao();
    DiseaseService diseaseService = new DiseaseService();
    PageInfo pageInfo = new PageInfo();

    @Test
    public void queryList() {
        /*String sql = "select * from disease";
        List<Disease> list =  diseaseDao.selectList(sql);
        System.out.println(list);*/
        List<Disease> list = new ArrayList();
        list = diseaseService.queryList();
        for (Disease disease : list) {
            System.out.println(disease);
        }
        //System.out.println(diseaseService.queryList());
    }

    @Test
    public void queryListByPage() {
        PageInfo pageInfo = new PageInfo();
        pageInfo.setPageNo(2);
        pageInfo.setPageSize(100);

        pageInfo  = diseaseService.queryListByPage(pageInfo);


        System.out.println("当前页号:"+pageInfo.getPageNo());
        System.out.println("每页显示条数:"+pageInfo.getPageSize());
        System.out.println("总条数:"+pageInfo.getTotalCount());
        System.out.println("总页数:"+pageInfo.getTotalPage());

        for (Object o : pageInfo.getList()) {
            System.out.println(o);
        }
    }
}