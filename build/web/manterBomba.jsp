<%-- 
    Document   : manterBomba
    Created on : 28/09/2020, 19:53:27
    Author     : Igor-SSD
--%>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Bombas</title>
    </head>
    <body>
        <style>
            body {
                background-image: url('back.jpg');
            }
        </style>
        <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
            <a class="navbar-brand" href="index.jsp">Transport</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarsExampleDefault">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="dropdown01" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Cadastros</a>
                        <div class="dropdown-menu" aria-labelledby="dropdown01">
                            <a class="dropdown-item" href="PesquisaFuncionarioController">Funcionários</a>
                            <a class="dropdown-item" href="PesquisaGaragemController">Garagens</a>
                            <a class="dropdown-item" href="PesquisaTanqueController">Tanques</a>
                            <a class="dropdown-item" href="PesquisaBombaController">Bombas</a>
                            <a class="dropdown-item" href="PesquisaCarroController">Carros</a>
                            <a class="dropdown-item" href="PesquisaCombustivelController">Combustíveis</a>
                        </div>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" id="dropdown02" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Abastecimento</a>
                        <div class="dropdown-menu" aria-labelledby="dropdown02">
                            <a class="dropdown-item" href="ManterAbastecimentoController?acao=prepararOperacao&operacao=Incluir">Registrar Abastecimento</a>
                            <a class="dropdown-item" href="PesquisaAbastecimentoController">Visualizar Registros</a>
                        </div>    
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="dropdown01" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Relatórios</a>
                        <div class="dropdown-menu" aria-labelledby="dropdown01">
                            <a class="dropdown-item" href="relatoriosCadastrais.jsp">Cadastrais</a>
                        </div>
                    </li>
                </ul>
            </div>
        </nav>                
        <div class="jumbotron jumbotron-fluid">
            <div class="container"><br><br>
                <h1 class="display-10" align="center">Cadastro de Bombas</h1>
            </div>
        </div>
        <div class="form-group d-flex justify-content-center">       
            <form action="ManterBombaController?acao=confirmarOperacao&operacao=${operacao}" method="POST" name="frmManterBomba" class="needs-validation bg-light" novalidate>
                <div class="form-row">
                    <div class="col-md-2 mb-3">
                        <label for="validationCustom01">Código</label>
                        <input type="text" name="codigo" value="${bomba.codigo}" <c:if test="${operacao !='Incluir'}"> readonly</c:if> class="form-control" id="validationCustom01" required>
                    </div>
                    <div class="col-md-12 mb-3">
                        <label for="validationCustom04">Tanque</label>
                        <select name="tanque" class="custom-select" id="validationCustom04" required>
                            <option selected disabled value="0" <c:if test="${bomba.tanque.codigo == null}"> selected</c:if>>Selecione o Tanque</option>
                            <c:forEach items="${tanques}" var="tanque">
                                <option value="${tanque.codigo}"  <c:if test="${operacao =='Excluir'}"> disabled</c:if>
                                        <c:if test="${bomba.tanque.codigo == tanque.codigo}"> selected</c:if>>${tanque.descricao}
                                        </option>
                            </c:forEach>
                        </select>        
                        <div class="form-row">
                            <div class="col-md-12 mb-3">
                                <label for="validationCustom02">Descricao</label>
                                <input type="text" name="descricao" value="${bomba.descricao}" <c:if test="${operacao =='Excluir'}"> readonly</c:if> class="form-control" id="validationCustom02" required>
                            </div>
                        </div>    
                    </div>
                </div>
        </div>                        
        <div class="d-flex justify-content-center">
            <input type="submit" value="Processar" class="btn btn-dark col-md-1">
            <a href="PesquisaBombaController" value="Cancelar" class="btn btn-danger col-md-1">Cancelar</a>
        </div>
    </form>   

</body>
</html>
