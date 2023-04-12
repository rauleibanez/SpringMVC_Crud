/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import models.Conectar;
import models.Usuarios;
import models.usuarioValidar;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import java.sql.ResultSet;

/**
 *
 * @author RAUL IBANEZ
 */
@Controller
@RequestMapping("edit.htm")
public class editController {
    List datos;
    usuarioValidar UsuarioValidar;
    private JdbcTemplate jdbcTemplate;

    public editController() {
        this.UsuarioValidar = new usuarioValidar();
        Conectar con = new Conectar();
        this.jdbcTemplate = new JdbcTemplate(con.conectar());
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView form(HttpServletRequest request){
        ModelAndView mav = new ModelAndView();
        int id = Integer.parseInt(request.getParameter("id"));
        Usuarios datos= this.selectUsuario(id);
        mav.setViewName("edit");
        mav.addObject("usuarios", new Usuarios(id, datos.getNomusr(), datos.getApepatusr(), datos.getApematusr(), datos.getEmailusr(), datos.getTelusr()));
        return mav;
    }
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView form 
    (
        @ModelAttribute("usuarios") Usuarios u,
        BindingResult result,
        SessionStatus status,
        HttpServletRequest request
    )    
    {
         this.UsuarioValidar.validate(u, result); 
         if(result.hasErrors())
         {
            ModelAndView mav = new ModelAndView();
            int id= Integer.parseInt(request.getParameter("id"));
            Usuarios d = this.selectUsuario(id); 
            mav.setViewName("edit");
            mav.addObject("usuarios", new Usuarios(id, d.getNomusr(),d.getApepatusr(), d.getApematusr(), d.getEmailusr(), d.getTelusr()));
            return mav;
         }else
         {
         int id= Integer.parseInt(request.getParameter("id"));
         /*this.jdbcTemplate.update("UPDATE usuarios SET nomusr = ?, apepatusr = ?, apematusr = ?,  emailusr = ?, telusr = ? where idusr = ?",
          u.getNomusr(), u.getApepatusr(), u.getApematusr(), u.getEmailusr(), u.getTelusr(), id);*/
         this.jdbcTemplate.update("UPDATE usuarios SET nomusr = '"+ u.getNomusr() +"', apepatusr = '"+ u.getApepatusr() + "'  , apematusr = '" + u.getApematusr() + "' ,  emailusr = '" + u.getEmailusr() + "' , telusr = '" + u.getTelusr() + "'  where idusr = '" + id + "'");
          return new ModelAndView("redirect:/home.htm");        
         }
    
    }

    private Usuarios selectUsuario(int id) 
    {
        final Usuarios usuar = new Usuarios();
       
        String qry="SELECT * FROM usuarios WHERE idusr = '" + id + "'";
        
        return (Usuarios) jdbcTemplate.query
        (
                qry, new ResultSetExtractor<Usuarios>()
                
            {
            @Override    
            public Usuarios extractData(ResultSet rs)throws SQLException, DataAccessException{
                    if(rs.next())
                    {
                        usuar.setNomusr(rs.getString("nomusr"));
                        usuar.setApepatusr(rs.getString("apepatusr"));
                        usuar.setApematusr(rs.getString("apematusr"));
                        usuar.setEmailusr(rs.getString("emailusr"));
                        usuar.setTelusr(rs.getString("telusr"));
                    }
                
                    return usuar;
                }
    
            }
        );
    }
}
