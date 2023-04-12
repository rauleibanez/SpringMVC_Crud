<%-- 
    Document   : home
    Created on : 4/04/2023, 12:20:03 p. m.
    Author     : RAUL IBANEZ
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ejemplo de JDBC con Spring MVC</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script> 
    </head>
    <body>
        <div class="container-fluid bg-primary text-white text-center">
            <p class="display-5">Ejemplo de CRUD con JDBCTemplates (Spring MVC) & Postgres SQL</p>      
        </div>
        <div class="row">
            <p>
                <a href="<c:url value="add.htm"/>" class="btn btn-success">Agregar</a>
            </p>
        </div>
        <div class="container-fluid text-center">
            <div class="row">    
                <p>
                <table class="table table-bordered table-striped table-hover">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>NOMBRE</th>
                            <th>APELLIDO 1</th>
                            <th>APELLIDO 2</th>
                            <th>CORREO</th>
                            <th>TELEFONO</th>
                            <th>OPCIONES</th>
                        </tr>
                        
                    </thead>
                    <tbody>
                        <c:forEach items="${datos}" var="dato">
                            <tr>
                                <td><c:out value="${dato.idusr}" /></td>
                                <td><c:out value="${dato.nomusr}" /></td>
                                <td><c:out value="${dato.apepatusr}" /></td>
                                <td><c:out value="${dato.apematusr}" /></td>
                                <td><c:out value="${dato.emailusr}" /></td>
                                <td><c:out value="${dato.telusr}" /></td>
                                <td>
                                    <a href="<c:url value="edit.htm?id=${dato.idusr}"/>" class="btn btn-primary">Editar</a>
                                    <a href="<c:url value="del.htm?id=${dato.idusr}"/>" class="btn btn-danger">Eliminar</a>
                                </td>
                            </tr>                            
                        </c:forEach>
                    </tbody>
                </table>
                </p>
            </div>
        </div>
    </body>
</html>
