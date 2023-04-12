<%-- 
    Document   : add
    Created on : 5/04/2023, 9:54:30 p. m.
    Author     : RAUL IBANEZ
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script> 
        <title>Formulario de Nuevos Usuarios</title>
    </head>
    <body>
        <div class="container-fluid bg-primary text-white text-center">
            <p class="display-5">Agregar Usuarios</p>
        </div>
        <div>
            <ul>
                <li><a href="<c:url value="/home.htm"/>">Listado de Usuarios</a></li>
            </ul>
        </div>
 
        <div class="text-center">
            <div class="row">
                <div class="col-4"></div>
                <div class="col-4">
                    <div class="card">
                        <div class="card-header bg-seconday">
                            <p>Datos de la Persona</p>
                        </div>
                        <div class="card-body">
                            <form:form method="POST" commandName="usuarios" >
                                <form:errors path="*" element="div" cssClass="alert alert-danger" />
                                <p>
                                <form:label path="idusr">ID</form:label>
                                <form:input path="idusr" cssClass="form-control"/>                                
                                <form:errors path="idusr"/>
                                </p>
                                <p>
                                <form:label path="nomusr">Nombre</form:label>
                                <form:input path="nomusr" cssClass="form-control"/>
                                <form:errors path="nomusr"/>
                                </p> 
                                <p>
                                <form:label path="apepatusr">Apellido Paterno</form:label>
                                <form:input path="apepatusr" cssClass="form-control"/>
                                <form:errors path="apepatusr"/>                              
                                </p>    
                                <p>
                                <form:label path="apematusr">Apellido Materno</form:label>
                                <form:input path="apematusr" cssClass="form-control"/>
                                <form:errors path="apematusr"/>                              
                                </p>    
                                <p>
                                <form:label path="emailusr">Correo</form:label>
                                <form:input path="emailusr" cssClass="form-control"/>
                                <form:errors path="emailusr"/>                              
                                </p>
                                <p>
                                <form:label path="telusr">Telefono</form:label>
                                <form:input path="telusr" cssClass="form-control"/>
                                <form:errors path="telusr"/>                              
                                </p>
                                
                            <hr>
                            <input type="submit" value="Enviar" class="form-control btn-primary">                                
                            </form:form>                                    
                        </div>
                <div class="col-4"></div>    
                </div>
            </div>
        </div> 
    </body>
</html>
