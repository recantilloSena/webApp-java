/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adsi.controlador;

import com.adsi.modelo.ConexionModelo;
import com.adsi.modelo.Cursos;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author RICARDO
 */
public class CursosDAO extends ConexionModelo{

    private final transient ConexionModelo conexion;
       
    CursosDAO(ConexionModelo conexionModelo) {
        this.conexion =  conexionModelo;
    }
    
    
    public List<Cursos> findAllCursos( ) throws SQLException {
        
                
        if (!conexion.hayConexion()) {
            throw new SQLException(" No existe conexion abierta ");
        }
        
        
        PreparedStatement pst = null;
        ResultSet rst = null;
        LinkedList lista = new LinkedList();
        try {
            String query;
            query = "select * from cursos  ";                    //Definir la consulta
            pst = conexion.con.prepareStatement(query);                      //Prepararla
                  
            rst = pst.executeQuery();                               //Ejecutarla 
            
            
            while (rst.next()) {
                lista.add(Cursos.load(rst));                         //Recorre el RS y llena una lista
            }
            System.out.println("El Query " + query );
            
        }  finally {
            if (pst != null) {
                pst.close();
                pst = null;
            }
            if (rst != null) {
                rst.close();
                rst = null;
            }
        }
        return lista;                            //Retorna la lista llena
    }
    
    public Optional<Cursos> findCursoById( int idCurso) throws SQLException {
        
        //Select * from aprendices;        
        if (!hayConexion()) {
            throw new SQLException(" No existe conexion abierta ");
        }
        
        
        PreparedStatement pst = null;
        ResultSet rst = null;
        LinkedList lista = new LinkedList();
        try {
            String query;
            query = "select * from cursos where id_curso = ?  ";                    //Definir la consulta
            
            pst.setInt(1, idCurso);
            pst = conexion.con.prepareStatement(query);                      //Prepararla
                  
            rst = pst.executeQuery();                               //Ejecutarla 
            
            
            while (rst.next()) {
                lista.add(Cursos.load(rst));                         //Recorre el RS y llena una lista
            }
            System.out.println("El Query " + query );
            
        }  finally {
            if (pst != null) {
                pst.close();
                pst = null;
            }
            if (rst != null) {
                rst.close();
                rst = null;
            }
        }
        return lista.stream().findFirst();                            //Retorna la lista llena
    }  
}
