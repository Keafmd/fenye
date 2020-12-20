package com.neuedu.service;
import com.neuedu.dao.DiseaseDao;
import com.neuedu.entity.Disease;
import com.neuedu.framework.PageInfo;


import java.util.List;

/**
 * Keafmd
 *
 * @ClassName: DiseaseService
 * @Description:
 * @author: 牛哄哄的柯南
 * @date: 2020-12-20 09:37
 */

public class DiseaseService {

    private DiseaseDao diseaseDao = new DiseaseDao();

    /**
     * 查询集合，不分页
     * @return
     */

    public List<Disease> queryList() {
        String sql = " select * from disease ";
        List<Disease> list =  diseaseDao.selectList(sql);
        return list;
    }

    /**
     * 查询集合，分页
     * @return
     */

    /*public List<Disease> queryListByPage(Integer pageNo,Integer pageCount) {

        String sql = " select * from disease  limit ?  , ?  ";

        int start = (pageNo-1) * pageCount ;
        List<Disease> list =  diseaseDao.selectList(sql,start,pageCount);


        return list;

    }*/
    public PageInfo  queryListByPage(PageInfo pageInfo) {

        String sql = " select * from disease  limit ?  , ?  ";

        int start = (pageInfo.getPageNo()-1) * pageInfo.getPageSize();
        List<Disease> list =  diseaseDao.selectList(sql,start,pageInfo.getPageSize());


        String sql2 = "  select count(1) from disease   ";
        long count =  diseaseDao.selectCount(sql2);



        pageInfo.setList(list);
        pageInfo.setTotalCount((int) count);

        return pageInfo;

    }




    public Disease queryById(Integer id) {
        return diseaseDao.selectById(id);
    }


    public boolean edit(Disease disease) {
        return diseaseDao.update(disease);
    }


    public boolean deleteById(Integer id) {
        return diseaseDao.deleteById(id);
    }


    public boolean save(Disease disease) {
        return diseaseDao.insert(disease);
    }


    public boolean batchdel(String[] ids) throws Exception {

        //物理删除 ， delete  from  disease where id i ???????


        if(ids == null){
            throw new Exception("批量删除 id 不能为空");
        }
        StringBuffer sql = new StringBuffer(" delete  from  disease where id in (  ");

        for (String id : ids) {
            sql.append("?,");
        }

        //移除最后的 ，
        sql.deleteCharAt(sql.length()-1);

        sql.append(" ) ");
        //逻辑删除  update disease set valid = 0 where id  = ?????

        System.out.println("sql: "+sql.toString());

        return diseaseDao.batchDel(sql.toString(),ids);

    }
}