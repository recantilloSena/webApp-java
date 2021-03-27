/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adsi.controlador;

import com.adsi.modelo.Aprendices;
import com.adsi.modelo.ConexionModelo;
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
public class AprendicesDAO {

    private final transient ConexionModelo conexion;
    
       AprendicesDAO(ConexionModelo conexionModelo) {
       this.conexion =  conexionModelo;
       
    }
    
    public  List<Aprendices>  listarAprendicesCursoUno(){
        // SELECT * FROM aprendices where fk_curso = 1;
        
        
        return null;
        
    }  
    
    public int  totalAprendices() throws SQLException{
        if (!conexion.hayConexion()) {
            throw new SQLException(" No existe conexion abierta ");
        }
        
        
        PreparedStatement pst = null;
        ResultSet rst = null;
        LinkedList lista = new LinkedList();
        int total=0;
        try {
            String query;
            query = "select count(*) as total from aprendices  ";                    //Definir la consulta
            pst = conexion.con.prepareStatement(query);                      //Prepararla
                  
            rst = pst.executeQuery();                                        //Ejecutarla 
            
            
            while (rst.next() ) {
               total = rst.getInt("total");     //Recorre el RS y llena una lista
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
        
        
        
        return total;
    }
    
    
    
    public List<Aprendices> listarAprendices_x_sexo( String psexo){
        //Select * from aprendices where sexo=:psexo ;
        
    
        return null;
    }
    
    
    
    public List<Aprendices> findAllAprendices( ) throws SQLException {
        
        //Select * from aprendices;        
        if (!conexion.hayConexion()) {
            throw new SQLException(" No existe conexion abierta ");
        }
        
        
        PreparedStatement pst = null;
        ResultSet rst = null;
        LinkedList lista = new LinkedList();
        try {
            String query;
            query = "select * from aprendices  ";                    //Definir la consulta
            pst = conexion.con.prepareStatement(query);                      //Prepararla
                  
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
      
    
    public Optional<Aprendices> findAprendizById( int idAprendiz) throws SQLException {
        
        //Select * from aprendices;        
        if (!conexion.hayConexion()) {
            throw new SQLException(" No existe conexion abierta ");
        }
        
        
        PreparedStatement pst = null;
        ResultSet rst = null;
        LinkedList lista = new LinkedList();
        try {
            String query;
            query = "select * from aprendices where id_aprendices = ?  ";                    //Definir la consulta
            pst.setInt(1, idAprendiz);
            pst = conexion.con.prepareStatement(query);                      //Prepararla
                  
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
        return lista.stream().findFirst();                            //Retorna la lista llena
    } 
    
    
    
    
}
