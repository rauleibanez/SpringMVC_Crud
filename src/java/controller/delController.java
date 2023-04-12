/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import models.Conectar;
import org.springframework.jdbc.core.JdbcTemplate;
import javax.servlet.http.HttpServletRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;



/**
 *
 * @author RAUL IBANEZ
 */
public class delController {
    private JdbcTemplate jdbcTemplate;
    
    public delController(){
        Conectar con = new Conectar();
        this.jdbcTemplate=new JdbcTemplate(con.conectar()); 
    }
    @RequestMapping("del.htm")
    public ModelAndView form(HttpServletRequest request)
    {
        ModelAndView mav = new ModelAndView();
        int id= Integer.parseInt(request.getParameter("id"));
        this.jdbcTemplate.update("DELETE FROM usuarios WHERE idusr = '" + id + "'");
        return new ModelAndView("redirect:/home.htm");      
    }
}
