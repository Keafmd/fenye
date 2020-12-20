package com.neuedu.controller;
import com.neuedu.entity.Disease;
import com.neuedu.service.DiseaseService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Keafmd
 *
 * @ClassName: DiseaseController
 * @Description:
 * @author: 牛哄哄的柯南
 * @date: 2020-12-20 09:39
 */

@WebServlet( name = "DiseaseController",urlPatterns = "/disease")
public class DiseaseController extends HttpServlet {

    DiseaseService diseaseService = new DiseaseService();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Disease> list = diseaseService.queryList();

        req.setAttribute("list",list);
        req.getRequestDispatcher("/WEB-INF/disease/disease_list.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
