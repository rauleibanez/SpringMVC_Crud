/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.List;
import models.Conectar;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author RAUL IBANEZ
 */

public class HomeController {
    private JdbcTemplate jdbcTemplate;
    public HomeController(){
        Conectar con = new Conectar();
        this.jdbcTemplate= new JdbcTemplate(con.conectar());
    }
    
    @RequestMapping("home.htm")
    public ModelAndView home(){
        ModelAndView mav = new ModelAndView();
        String sql = "SELECT * FROM usuarios";
        List datos=this.jdbcTemplate.queryForList(sql);
        mav.addObject("datos",datos);
        mav.setViewName("home");
        return mav;
    }
    
}
