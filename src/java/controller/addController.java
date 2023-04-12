/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import models.Conectar;
import models.Usuarios;
import models.usuarioValidar;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
/*import static sun.net.www.http.KeepAliveCache.result;*/
/**
 *
 * @author RAUL IBANEZ
 */
@Controller
@RequestMapping("add.htm")
public class addController {
    usuarioValidar UsuarioValidar;
    private JdbcTemplate jdbcTemplate;

    public addController() {
        this.UsuarioValidar = new usuarioValidar();
        Conectar con = new Conectar();
        this.jdbcTemplate = new JdbcTemplate(con.conectar());
    }
    
    @RequestMapping(method=RequestMethod.GET)
    public ModelAndView form(){
        ModelAndView mav = new ModelAndView();     
        mav.setViewName("add");
        mav.addObject("usuarios", new Usuarios());
        return mav;
    }
    
    /*@RequestMapping(method = RequestMethod.POST)
    public ModelAndView form(Usuarios usuarios){
        String sql = "insert into usuarios (idusr, nomusr, apepatusr, apematusr, emailusr, telusr) values (?,?,?,?,?,?)";
        this.jdbcTemplate.update(sql, usuarios.getIdusr(), usuarios.getNomusr(), usuarios.getApepatusr(), usuarios.getApematusr(), usuarios.getEmailusr(), usuarios.getTelusr());
        return new ModelAndView("redirect:/home.htm");
    }*/
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView form (
            @ModelAttribute("usuarios") Usuarios u,
            BindingResult result,
            SessionStatus status)
    {
        this.UsuarioValidar.validate(u, result);
        if(result.hasErrors())
        {
            ModelAndView mav = new ModelAndView();
            mav.setViewName("add");
            mav.addObject("usuarios", new Usuarios());
            return mav;
        }else
        {
          this.jdbcTemplate.update("INSERT INTO usuarios (idusr, nomusr, apepatusr, apematusr, emailusr, telusr) VALUES (?,?,?,?,?,?)", 
                  u.getIdusr(), u.getNomusr(), u.getApepatusr(), u.getApematusr(), u.getEmailusr(), u.getTelusr());
          return new ModelAndView("redirect:/home.htm");
        }    
    }
    


    
}
