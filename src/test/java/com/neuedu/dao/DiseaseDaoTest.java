package com.neuedu.dao;

import com.neuedu.entity.Disease;
import org.junit.Test;

import static org.junit.Assert.*;

public class DiseaseDaoTest {

    DiseaseDao diseaseDao =new DiseaseDao();

    @Test
    public void selectList() {
    }

    @Test
    public void insert() {


        for (int i = 100; i < 300; i++) {
            Disease disease = new Disease();
            disease.setDiseaseCode("GDXHL"+i);
            disease.setDiseaseName("古典型霍乱"+i);
            disease.setDiseaseIcd("A00.051"+i);
            disease.setCateId(1);
            diseaseDao.insert(disease);
        }


    }
}