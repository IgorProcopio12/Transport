<%-- 
    Document   : manterFuncionario
    Created on : 23/09/2020, 22:09:48
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
        <title>Cadastrar Funcionário</title>
    </head>

    <body>
        <style>
            body {
                background-image: url('back.jpg');
            }
        </style>
        <div style="background-image: url('back.jpg');"></div>
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
                <h1 class="display-10" align="center">Cadastro de Funcionários</h1>
            </div>
        </div>
        <div class="form-group d-flex justify-content-center">       
            <form action="ManterFuncionarioController?acao=confirmarOperacao&operacao=${operacao}" method="POST" name="frmManterFuncionario" class="needs-validation bg-light" novalidate>
                <div class="form-row">
                    <div class="col-md-2 mb-3">
                        <label for="validationCustom01">Código</label>
                        <input type="text" name="idFuncionario" value="${funcionario.idFuncionario}" <c:if test="${operacao !='Incluir'}"> readonly</c:if> class="form-control" id="validationCustom01" required>
                    </div>
                    <div class="col-md-7 mb-3">
                        <label for="validationCustom02">Nome</label>
                        <input type="text" name="nome" value="${funcionario.nome}" <c:if test="${operacao =='Excluir'}"> readonly</c:if> class="form-control" id="validationCustom02" required>
                    </div>
                </div>
                <div class="form-row">
                    <div class="col-md-4 mb-3">
                        <label for="validationCustom03">CPF</label>
                        <input type="text" name="cpf" value="${funcionario.cpf}" <c:if test="${operacao =='Excluir'}"> readonly</c:if> class="form-control" id="validationCustom03" required>
                    </div>
                    <div class="col-md-4 mb-3">
                        <label for="validationCustom04">RG</label>
                        <input type="text" name="rg" value="${funcionario.rg}" <c:if test="${operacao =='Excluir'}"> readonly</c:if> class="form-control" id="validationCustom04" required>
                    </div>
                </div>       
                <div class="form-row">
                    <div class="col-md-4 mb-3">
                        <label for="validationCustom05">CEP</label>
                        <input type="text" name="cep" value="${funcionario.cep}" <c:if test="${operacao =='Excluir'}"> readonly</c:if> class="form-control" id="validationCustom05" required>
                    </div>
                    <div class="col-md-4 mb-3">
                        <label for="validationCustom06">RUA</label>
                        <input type="text" name="rua" value="${funcionario.rua}" <c:if test="${operacao =='Excluir'}"> readonly</c:if> class="form-control" id="validationCustom06" required>
                    </div>
                    <div class="col-md-2 mb-3">
                        <label for="validationCustom07">Número</label>
                        <input type="text" name="numero" value="${funcionario.numero}" <c:if test="${operacao =='Excluir'}"> readonly</c:if> class="form-control" id="validationCustom07" required>
                    </div>
                    <div class="col-md-2 mb-3">
                        <label for="validationCustom08">Complemento</label>
                        <input type="text" name="complemento" value="${funcionario.complemento}" <c:if test="${operacao =='Excluir'}"> readonly</c:if> class="form-control" id="validationCustom08" required>
                    </div>
                </div>
                <div class="form-row">
                    <div class="col-md-4 mb-3">
                        <label for="validationCustom09">Bairro</label>
                        <input type="text" name="bairro" value="${funcionario.bairro}" <c:if test="${operacao =='Excluir'}"> readonly</c:if> class="form-control" id="validationCustom09" required>
                    </div>

                    <div class="col-md-4 mb-3">
                        <label for="validationCustom10">Cidade</label>
                        <input type="text" name="cidade" value="${funcionario.cidade}" <c:if test="${operacao =='Excluir'}"> readonly</c:if> class="form-control" id="validationCustom10" required>
                    </div>
                    <div class="col-md-2 mb-3">
                        <label for="validationCustom11">UF</label>
                        <input type="text" name="estado" value="${funcionario.estado}" <c:if test="${operacao =='Excluir'}"> readonly</c:if> class="form-control" id="validationCustom11" required>
                    </div>  
                </div>
                <div class="form-row">
                    <div class="col-md-3 mb-3">
                        <label for="validationCustom12">Telefone 1</label>
                        <input type="text" name="telefone1" value="${funcionario.telefone}" <c:if test="${operacao =='Excluir'}"> readonly</c:if> class="form-control" id="validationCustom12" required>
                    </div>

                    <div class="col-md-3 mb-3">
                        <label for="validationCustom13">Telefone 2</label>
                        <input type="text" name="telefone2" value="${funcionario.telefone2}" <c:if test="${operacao =='Excluir'}"> readonly</c:if> class="form-control" id="validationCustom13">
                    </div>
                    <div class="col-md-6 mb-3">
                        <label for="validationCustom14">E-mail</label>
                        <input type="text" name="email" value="${funcionario.email}" <c:if test="${operacao =='Excluir'}"> readonly</c:if> class="form-control" id="validationCustom14" required>
                    </div>  
                </div>
        </div> 
        <div class="d-flex justify-content-center">
            <input type="submit" value="Processar" class="btn btn-dark col-md-1">
            <a href="PesquisaFuncionarioController" value="Cancelar" class="btn btn-danger col-md-1">Cancelar</a>
        </div>
    </form>

</body>  
</html>
