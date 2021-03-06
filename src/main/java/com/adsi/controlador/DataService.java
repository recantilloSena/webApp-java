/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adsi.controlador;

import com.adsi.modelo.ConexionModelo;
import java.io.IOException;
import java.sql.SQLException;

/**
 *
 * @author RICARDO
 */
public class DataService extends ConexionModelo{
    
    public ConexionModelo conexionModelo = new ConexionModelo();
    
    
    private AprendicesDAO aprendicesService;
    private CursosDAO cursosService;
    
    

    public DataService() throws SQLException, IOException {
        conexionModelo.conectar();
    }
    
    //MAapeo de DAO
    public AprendicesDAO aprendicesService(){
        aprendicesService = new AprendicesDAO(conexionModelo);
        return aprendicesService;
    }
    
    
    public CursosDAO cursosService(){
        cursosService = new CursosDAO(conexionModelo);
        return cursosService;
    }
    
}
