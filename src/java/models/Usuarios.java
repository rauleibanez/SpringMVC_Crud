/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author RAUL IBANEZ
 */
public class Usuarios {
    private int idusr;
    private String nomusr;
    private String apepatusr;
    private String apematusr;
    private String emailusr;
    private String telusr;

    public Usuarios() {
    }

    public Usuarios(int idusr, String nomusr, String apepatusr, String apematusr, String emailusr, String telusr) {
        this.idusr = idusr;
        this.nomusr = nomusr;
        this.apepatusr = apepatusr;
        this.apematusr = apematusr;
        this.emailusr = emailusr;
        this.telusr = telusr;
    }

    public Usuarios(String nomusr, String apepatusr, String apematusr, String emailusr, String telusr) {
        this.nomusr = nomusr;
        this.apepatusr = apepatusr;
        this.apematusr = apematusr;
        this.emailusr = emailusr;
        this.telusr = telusr;
    }

    public int getIdusr() {
        return idusr;
    }

    public String getNomusr() {
        return nomusr;
    }

    public String getApepatusr() {
        return apepatusr;
    }

    public String getApematusr() {
        return apematusr;
    }

    public String getEmailusr() {
        return emailusr;
    }

    public String getTelusr() {
        return telusr;
    }

    public void setIdusr(int idusr) {
        this.idusr = idusr;
    }

    public void setNomusr(String nomusr) {
        this.nomusr = nomusr;
    }

    public void setApepatusr(String apepatusr) {
        this.apepatusr = apepatusr;
    }

    public void setApematusr(String apematusr) {
        this.apematusr = apematusr;
    }

    public void setEmailusr(String emailusr) {
        this.emailusr = emailusr;
    }

    public void setTelusr(String telusr) {
        this.telusr = telusr;
    }
    
    
}
