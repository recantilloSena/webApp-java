<%-- 
    Document   : verDatos
    Created on : 23/02/2021, 02:47:17 PM
    Author     : RICARDO
--%>

<%@page import="com.adsi.modelo.Cursos"%>
<%@page import="com.adsi.controlador.DataService"%>
<%@page import="com.adsi.modelo.Aprendices"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import = "java.util.Date" %>
<%@ page import = "java.text.SimpleDateFormat" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Recibir Datos del Formulario</title>
        <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    
    <!-- Custom fonts for this template -->
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/sb-admin-2.min.css" rel="stylesheet">

    <!-- Custom styles for this page -->
    <link href="vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">

    </head>
    <body>
        <h1>Procesando datos de Formularios</h1>
        <%
         String email, password, direccion,fecha;
         
         
         email = request.getParameter("email");
         password = request.getParameter("password");
         direccion = request.getParameter("direccion");
         fecha = request.getParameter("fecha");
         
          
         
        %>
        
        
        Recibí <b><%=email%></b>!
        <br>
        Recibí <b><%=password%></b>!
        <br>
        Recibí <b><%=direccion%></b>!
        <br>
        Recibí <b><%=fecha%></b>!
        
        
        
        <%
            DataService dataService = new DataService();
            
           // if (dataService.hayConexion()) {
            
              //Almacenar la conexión en una Variable de Session                            
              session.setAttribute("dataService",dataService); 
              
              //llamar a los métodos de mi CONTROLADOR
              List<Aprendices> lista   =   dataService.aprendicesService().findAllAprendices();
              List<Cursos> listaCursos =   dataService.cursosService().findAllCursos();
              
              Long total        = lista.stream().count();
              Long totalCursos  = listaCursos.stream().count();
              
              %>
              
              <div class="container">
                  
              <div class="card-body">
                  
              
              
                 <div> Tabla de Aprendices  </div>
                 <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>id</th>
                                            <th>Apellido1</th>
                                            <th>Apellido1</th>
                                            <th>Nombre</th>
                                            <th>Documento</th>
                                            <th>fk_Curso</th>
                                            <th>Jornada</th>
                                            <th>Sexo</th>
                                        </tr>
                                    </thead>
                                    
                                    <tbody>
                                        
                                       
                                      <%
                                        for(Aprendices item : lista )
                                        {
                                      %>  
                                        
                                        <tr>
                                            <td><%=item.getId_aprendices() %> </td>
                                            <td><%=item.getApellido1() %> </td>
                                            <td><%=item.getApellido2() %> </td>
                                            <td><%=item.getNombres() %> </td>
                                            <td><%=item.getDocumento() %> </td>
                                            <td><%=item.getFk_curso() %> </td>
                                            <td><%=item.getJornada() %> </td>
                                            <td><%=item.getSexo() %> </td>
                                        </tr>
                                    
                                        <%
                                         }
                                        %>
                                    
                                    </tbody>   
                                    
                                </table>    
                 
                 
                
                 
                 <%=total%>
                 <%=totalCursos%>
                  
              
              
                <% 
                    
                     
                 
           //  }
            
            
        
        %>
        </div>
        </div>
        <!-- INSERT EN UNA BASE DE DATOS 
        1. Conectarme a la base datos
        2. Ejecutar los comandos que deseo.
          Insert into datos values (email,password,direccion, fecha );
        
        
        -->
        
        
    <!-- Bootstrap core JavaScript-->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="js/sb-admin-2.min.js"></script>

    <!-- Page level plugins -->
    <script src="vendor/datatables/jquery.dataTables.min.js"></script>
    <script src="vendor/datatables/dataTables.bootstrap4.min.js"></script>

    <!-- Page level custom scripts -->
    <script src="js/demo/datatables-demo.js"></script>
        
        
        
        
        
    </body>
</html>
