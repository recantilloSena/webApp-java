/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adsi.modelo;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author RICARDO
 */
public class Aprendices {
    
    private int id_aprendices;
    private String apellido1 ;
    private String apellido2 ; 
    private String nombres ; 
    private String documento ; 
    private int fk_curso ;
    private String  jornada ; 
    private String sexo ;

    public Aprendices() {
    }

    public int getId_aprendices() {
        return id_aprendices;
    }

    public void setId_aprendices(int id_aprendices) {
        this.id_aprendices = id_aprendices;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public int getFk_curso() {
        return fk_curso;
    }

    public void setFk_curso(int fk_curso) {
        this.fk_curso = fk_curso;
    }

    public String getJornada() {
        return jornada;
    }

    public void setJornada(String jornada) {
        this.jornada = jornada;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    
    
    
    public static Aprendices load(ResultSet rs)throws SQLException{
        Aprendices aprendiz= new Aprendices();
        
        aprendiz.setId_aprendices(rs.getInt(1));
        aprendiz.setApellido1(rs.getString(2));
        aprendiz.setApellido2(rs.getString(3));
        aprendiz.setNombres(rs.getString(4));
        aprendiz.setDocumento(rs.getString(5));
        aprendiz.setFk_curso(rs.getInt(6));  
        aprendiz.setJornada(rs.getString(7));
        aprendiz.setSexo(rs.getString(8));
        
                       
        return aprendiz;
    }
    
    
    
    
    
    
}
