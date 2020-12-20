package com.neuedu.dao;
import com.neuedu.entity.Disease;
import com.neuedu.util.JDBCUtil;

import java.util.List;

/**
 * Keafmd
 *
 * @ClassName: DiseaseDao
 * @Description: DiseaseDao
 * @author: 牛哄哄的柯南
 * @date: 2020-12-20 09:23
 */

public class DiseaseDao  {

    public List<Disease> selectList(String sql, Object... args) {
        return JDBCUtil.executeQuery(sql, Disease.class, args);
    }


    public Disease selectById(Integer id) {
        String sql = " select * from disease where id = ?";
        return JDBCUtil.getOne(sql, Disease.class, id);
    }


    public boolean update(Disease disease) {
        String sql = " UPDATE   disease SET disease_code = ? ,   disease_name = ?  ,   disease_icd = ? ,   cate_id = ?  ,   valid = ?     WHERE id = ?  ";
        return JDBCUtil.executeUpdate(sql,
                disease.getDiseaseCode(),
                disease.getDiseaseName(),
                disease.getDiseaseIcd(),
                disease.getCateId(),
                disease.getValid(),
                disease.getId()
        );
    }


    public boolean deleteById(Integer id) {
        String sql = " delete from disease where id = ?";
        return JDBCUtil.executeUpdate(sql,id);
    }


    public boolean batchDel(String sql, Object... parm) {
        return JDBCUtil.executeUpdate(sql,parm );
    }


    public boolean insert(Disease disease) {
        String sql = " INSERT INTO disease(  disease_code, disease_name,  disease_icd , cate_id)  values  (?,?,?,?) ";
        return JDBCUtil.executeUpdate(sql,
                disease.getDiseaseCode(),
                disease.getDiseaseName(),
                disease.getDiseaseIcd(),
                disease.getCateId()
        );
    }


    public long selectCount(String sql, Object... args) {
        return JDBCUtil.executeQueryCount(sql,args);
    }

}