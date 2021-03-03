/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adsi.controlador;

import com.adsi.modelo.Aprendices;
import com.adsi.modelo.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author RICARDO
 */
public class Controlador extends Conexion{
    
    public  List<Aprendices>  listarAprendicesCursoUno(){
        // SELECT * FROM aprendices where fk_curso = 1;
        
        
        return null;
        
    }  
    
    public int  totalAprendices(){
        //Select Count(*) from aprendices;
        
        
        return 0;
    }
    
    
    
    public List<Aprendices> listarAprendices_x_sexo( String psexo){
        //Select * from aprendices where sexo=:psexo ;
        
    
        return null;
    }
    
    
    
    public List<Aprendices> findAllAprendices( ) throws SQLException {
        
        //Select * from aprendices;        
        if (!hayConexion()) {
            throw new SQLException(" No existe conexion abierta ");
        }
        
        
        PreparedStatement pst = null;
        ResultSet rst = null;
        LinkedList lista = new LinkedList();
        try {
            String query;
            query = "select * from aprendices  ";                    //Definir la consulta
            pst = con.prepareStatement(query);                      //Prepararla
                  
            rst = pst.executeQuery();                               //Ejecutarla 
            
            
            while (rst.next()) {
                lista.add(Aprendices.load(rst));     //Recorre el RS y llena una lista
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
      
    
    
    
    
    
}
