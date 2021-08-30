<%-- 
    Document   : index
    Created on : 14/09/2020, 21:54:28
    Author     : Igor-SSD
--%>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Transport</title>
    </head>

    <body>
        <style>
            body {
                background-image: url('back.jpg');
                background-size: cover;
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
                            <a class="dropdown-item" href="#">Another action</a>
                            <a class="dropdown-item" href="#">Something else here</a>
                        </div>
                    </li>
                </ul>
            </div>
        </nav><br><br><br><br><br><br><br><br><br><Br><br><br>  
        <div class="card-group card text-center bg-transparent">
            <div class="row bg-transparent">
                <div class="col-sm-3 mb-3 bg-transparent">
                    <div class="card bg-dark">
                        <div class="card-body bg-light">
                            <h5 class="card-title">Funcionários</h5>
                            <p class="card-text">Acessar o Cadastro de Funcionários.</p>
                            <a href="PesquisaFuncionarioController" class="btn btn-dark">Clique Aqui</a>
                        </div>
                    </div>
                </div><br><br>
                <div class="col-sm-3 bg-transparent">
                    <div class="card bg-dark">
                        <div class="card-body bg-light">
                            <h5 class="card-title">Garagens</h5>
                            <p class="card-text">Acessar o Cadastro de Garagens.</p>
                            <a href="PesquisaGaragemController" class="btn btn-dark">Clique Aqui</a>
                        </div>
                    </div>
                </div>
                <div class="col-sm-3 bg-transparent">
                    <div class="card bg-dark">
                        <div class="card-body bg-light">
                            <h5 class="card-title">Tanques</h5>
                            <p class="card-text">Acessar o Cadastro de Tanques.</p>
                            <a href="PesquisaTanqueController" class="btn btn-dark">Clique Aqui</a>
                        </div>
                    </div>
                </div>
                <div class="col-sm-3 bg-transparent">
                    <div class="card bg-dark">
                        <div class="card-body bg-light">
                            <h5 class="card-title">Bombas</h5>
                            <p class="card-text">Acessar o Cadastro de Bombas.</p>
                            <a href="PesquisaBombaController" class="btn btn-dark">Clique Aqui</a>
                        </div>
                    </div>
                </div>
                <div class="col-sm-3 bg-transparent">
                    <div class="card bg-dark">
                        <div class="card-body bg-light" >
                            <h5 class="card-title">Carros</h5>
                            <p class="card-text">Acessar o Cadastro de Carros.</p>
                            <a href="PesquisaCarroController" class="btn btn-dark">Clique Aqui</a>
                        </div>
                    </div>
                </div>
                <div class="col-sm-3 bg-transparent">
                    <div class="card bg-dark">
                        <div class="card-body bg-light">
                            <h5 class="card-title">Combustíveis</h5>
                            <p class="card-text">Acessar o Cadastro de Combustíveis.</p>
                            <a href="PesquisaCombustivelController" class="btn btn-dark">Clique Aqui</a>
                        </div>
                    </div>
                </div>
                <div class="col-sm-3 bg-transparent">
                    <div class="card bg-dark">
                        <div class="card-body bg-light">
                            <h5 class="card-title">Abastecimentos</h5>
                            <p class="card-text">Registrar de Abastecimentos.</p>
                            <a href="ManterAbastecimentoController?acao=prepararOperacao&operacao=Incluir" class="btn btn-dark">Clique Aqui</a>
                        </div>
                    </div>
                </div><br><br>
                <div class="col-sm-3 bg-transparent">
                    <div class="card bg-dark">
                        <div class="card-body bg-light">
                            <h5 class="card-title">Relatórios</h5>
                            <p class="card-text">Emissão de Relatórios.</p>
                            <a href="relatoriosCadastrais.jsp" class="btn btn-dark">Clique Aqui</a>
                        </div>
                    </div>
                </div><br><br>  
            </div>
        </div>
    </body>
</html>
