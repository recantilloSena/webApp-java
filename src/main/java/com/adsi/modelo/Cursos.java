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
public class Cursos {
    
    private int idCurso;
    private String nombreCurso;

    public Cursos() {
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }
    
    public static Cursos load(ResultSet rs)throws SQLException{
        Cursos curso= new Cursos();
        
        curso.setIdCurso(rs.getInt(1));
        curso.setNombreCurso(rs.getString(2));
        
        
                       
        return curso;
    }
    
}
