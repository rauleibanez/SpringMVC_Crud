/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
/**
 *
 * @author RAUL IBANEZ
 */
public class Conectar {
    public DriverManagerDataSource conectar(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/BIBLIO");
        dataSource.setUsername("postgres");
        dataSource.setPassword("");
        return dataSource;
    }

} 
