package com.neuedu.entity;
import com.neuedu.util.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Keafmd
 *
 * @ClassName: Disease
 * @Description: Disease实体类
 * @author: 牛哄哄的柯南
 * @date: 2020-12-20 09:22
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Disease {

    private Integer id;


    @Column("disease_code")
    private String diseaseCode;

    @Column("disease_name")
    private String diseaseName;

    @Column("disease_icd")
    private String diseaseIcd;

    @Column("cate_id")
    private Integer cateId;

    private Date createtime;
    private String valid;

}