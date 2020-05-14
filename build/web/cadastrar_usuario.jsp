<%-- 
    Document   : cadastrar_usuario
    Created on : 31/10/2019, 21:26:55
    Author     : Willian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%if(request.getSession().getAttribute("usuario") != null){ %>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="msapplication-tap-highlight" content="no">
        <meta name="description" content="Materialize is a Material Design Admin Template,It's modern, responsive and based on Material Design by Google. ">
        <meta name="keywords" content="materialize, admin template, dashboard template, flat admin template, responsive admin template,">
        <title>Materialize - Dashboard</title>
        <!-- Favicons-->
        <link rel="icon" href="images/favicon/favicon-32x32.png" sizes="32x32">
        <!-- Favicons-->
        <link rel="apple-touch-icon-precomposed" href="images/favicon/apple-touch-icon-152x152.png">
        <!-- For iPhone -->
        <meta name="msapplication-TileColor" content="#00bcd4">
        <meta name="msapplication-TileImage" content="images/favicon/mstile-144x144.png">
        <!-- For Windows Phone -->
        <!-- CORE CSS-->
        <link href="css//materialize.css" type="text/css" rel="stylesheet">
        <link href="css//style.css" type="text/css" rel="stylesheet">
        <!-- Custome CSS-->
        <link href="css/custom/custom.css" type="text/css" rel="stylesheet">
        <!-- INCLUDED PLUGIN CSS ON THIS PAGE -->
        <link href="vendors/perfect-scrollbar/perfect-scrollbar.css" type="text/css" rel="stylesheet">
        <link href="vendors/flag-icon/css/flag-icon.min.css" type="text/css" rel="stylesheet">
    </head>
    <body>
        <!-- Start Page Loading -->
        <div id="loader-wrapper">
            <div id="loader"></div>
            <div class="loader-section section-left"></div>
            <div class="loader-section section-right"></div>
        </div>
        <!-- End Page Loading -->
        <!-- //////////////////////////////////////////////////////////////////////////// -->
        <!-- START HEADER -->
        <header id="header" class="page-topbar">
            <!-- start header nav-->
            <div class="navbar-fixed">
                <nav class="navbar-color gradient-45deg-purple-amber">
                    <div class="nav-wrapper">
                        <ul class="left">
                            <li>
                                <h1 class="logo-wrapper">
                                    <a href="index.jsp" class="brand-logo darken-1">
                                        <img src="images/logo/materialize-logo.png" alt="materialize logo">
                                        <span class="logo-text hide-on-med-and-down">Dashboard</span>
                                    </a>
                                </h1>
                            </li>
                        </ul>
                        <div class="header-search-wrapper hide-on-med-and-down">
                            <i class="material-icons">search</i>
                            <input type="text" name="Search" class="header-search-input z-depth-2" placeholder="Pesquisar" />
                        </div>
                        <ul class="right hide-on-med-and-down">
                            <li>
                                <a href="javascript:void(0);" class="waves-effect waves-block waves-light toggle-fullscreen">
                                    <i class="material-icons">settings_overscan</i>
                                </a>
                            </li>
                            <li>
                                <a href="javascript:void(0);" class="waves-effect waves-block waves-light profile-button" data-activates="profile-dropdown">
                                    <span class="avatar-status avatar-online">
                                        <img src="images/avatar/avatar-18.jpg" alt="avatar">
                                        <i></i>
                                    </span>
                                </a>
                            </li>
                        </ul>
                        <!-- profile-dropdown -->
                        <ul id="profile-dropdown" class="dropdown-content">
                            <li>
                                <a href="#" class="grey-text text-darken-1">
                                    <i class="material-icons">face</i> Perfil</a>
                            </li>
                            <li>
                                <a href="#" class="grey-text text-darken-1">
                                    <i class="material-icons">settings</i> Configurações</a>
                            </li>
                            <li>
                                <a href="#" class="grey-text text-darken-1">
                                    <i class="material-icons">live_help</i> Ajuda</a>
                            </li>
                            <li class="divider"></li>
                            <li>
                                <a href="login.jsp" class="grey-text text-darken-1">
                                    <i class="material-icons">keyboard_tab</i>Sair</a>
                            </li>
                        </ul>
                    </div>
                </nav>
            </div>
            <!-- end header nav-->
        </header>
        <!-- END HEADER -->
        <!-- //////////////////////////////////////////////////////////////////////////// -->
        <!-- START MAIN -->
        <div id="main">
            <!-- START WRAPPER -->
            <div class="wrapper">
                <!-- START LEFT SIDEBAR NAV-->
                <aside id="left-sidebar-nav">
                    <ul id="slide-out" class="side-nav fixed leftside-navigation">
                        <li class="user-details cyan darken-2">
                            <div class="row">
                                <div class="col col s4 m4 l4">
                                    <img src="images/avatar/avatar-18.jpg" alt="" class="circle responsive-img valign profile-image cyan">
                                </div>
                                <div class="col col s8 m8 l8">
                                    <ul id="profile-dropdown-nav" class="dropdown-content">
                                        <li>
                                            <a href="#" class="grey-text text-darken-1">
                                                <i class="material-icons">face</i> Perfil</a>
                                        </li>
                                        <li>
                                            <a href="#" class="grey-text text-darken-1">
                                                <i class="material-icons">settings</i> Configurações</a>
                                        </li>
                                        <li>
                                            <a href="#" class="grey-text text-darken-1">
                                                <i class="material-icons">live_help</i> Ajuda</a>
                                        </li>
                                        <li class="divider"></li>
                                        <li>
                                            <a href="#" class="grey-text text-darken-1">
                                                <i class="material-icons">keyboard_tab</i> Sair</a>
                                        </li>
                                    </ul>
                                    <a class="btn-flat dropdown-button waves-effect waves-light white-text profile-btn" href="#" data-activates="profile-dropdown-nav">All Might<i class="mdi-navigation-arrow-drop-down right"></i></a>
                                    <p class="user-roal">Administrador</p>
                                </div>
                            </div>
                        </li>
                        <li class="no-padding">
                            <ul class="collapsible" data-collapsible="accordion">
                                <li class="bold">
                                    <a href="#" class="waves-effect waves-cyan">
                                        <i class="material-icons">save</i>
                                        <span class="nav-text">Cadastrar</span>
                                    </a>
                                </li>
                                <li class="bold"><a class="waves-effect waves-cyan" href="cadastrar_usuario.jsp">Usuários</a></li>
                                <li class="divider"></li>
                                <li class="bold">
                                    <a href="#" class="waves-effect waves-cyan">
                                        <i class="material-icons">list</i>
                                        <span class="nav-text">Listar</span>
                                    </a>
                                </li>
                                <li class="bold"><a class="waves-effect waves-cyan" href="<%=request.getContextPath()%>/ListarUsuarioCTR">Usuários</a></li>
                                <li class="divider"></li>
                            </ul>
                        </li>
                    </ul>
                    <a href="#" data-activates="slide-out" class="sidebar-collapse btn-floating btn-medium waves-effect waves-light hide-on-large-only">
                        <i class="material-icons">menu</i>
                    </a>
                </aside>
                <!-- END LEFT SIDEBAR NAV-->
                <!-- //////////////////////////////////////////////////////////////////////////// -->
                <!-- START CONTENT -->
                <section id="content">
                    <!--start container-->

                    <!--breadcrumbs start-->
                    <div id="breadcrumbs-wrapper">
                        <!-- Search for small screen -->
                        <div class="header-search-wrapper grey lighten-2 hide-on-large-only">
                            <input type="text" name="Search" class="header-search-input z-depth-2" placeholder="Explore Materialize">
                        </div>
                        <div class="container">
                            <div class="row">
                                <div class="col s10 m6 l6">
                                    <h5 class="breadcrumbs-title">Cadastrar Cliente</h5>
                                    <ol class="breadcrumbs">
                                        <li><a href="index.jsp">Home</a>
                                        </li>
                                        <li><a href="#">Cadastrar</a>
                                        </li>
                                        <li class="active">Cliente</li>
                                    </ol>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="container">
                        <!-- Form with placeholder -->

                        <div class="card-panel col s12 m6 l6">
                            <h4 class="header2">Cadastrar Cliente</h4>
                            <div class="row">
                                <form class="col s12 m12 l6" action="<%=request.getContextPath()%>/CadastrarUsuarioCTR" method="POST">
                                    <div class="row">
                                        <div class="input-field col s12">
                                            <input placeholder="Digite o nome do cliente" class="validate" id="nome" required name="nomeUsuario" type="text">
                                            <label for="nome">Nome</label>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="input-field col s12">
                                            <input placeholder="teste@gmail.com" id="email" required name="emailUsuario" class="validate" type="email">
                                            <label for="email">Email</label>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="input-field col s12">
                                            <input placeholder="Senha" class="validate" required name="senhaUsuario" id="senha" type="password">
                                            <label for="senha">Senha</label>
                                        </div>
                                    </div>

                                    <div class="row">

                                        <div class="row">
                                            <div class="input-field col s12">
                                                <button class="btn waves-effect waves-light right" type="submit" name="action">Cadastrar
                                                    <i class="material-icons right">send</i>
                                                </button>
                                            </div>
                                            <%if (request.getAttribute("mensagem") != null) {%>
                                            <h4 class="center-align">Usuário cadastrado com sucesso!</h4>
                                            <%}%>
                                        </div>
                                    </div>
                                </form>

                            </div>
                        </div>
                    </div>
            </div>



            <!-- //////////////////////////////////////////////////////////////////////////// -->
        </div>
        <!--end container-->
    </section>
    <!-- END CONTENT -->
    <!-- START RIGHT SIDEBAR NAV-->
</div>
<!-- END WRAPPER -->
</div>
<!-- END MAIN -->
<!-- //////////////////////////////////////////////////////////////////////////// -->
<!-- START FOOTER -->
<footer class="page-footer gradient-45deg-light-blue-cyan">
    <div class="footer-copyright">
        <div class="container">
            <span>Copyright ©
                <script type="text/javascript">
                    document.write(new Date().getFullYear());
                </script> <a class="grey-text text-lighten-2" href="#" target="_blank">PIXINVENT</a> Todos os direitos reservados.</span>
            <span class="right hide-on-small-only"> Design e Desenvolvimento por <a class="grey-text text-lighten-2" href="#">PIXINVENT</a></span>
        </div>
    </div>
</footer>
<!-- END FOOTER -->
<!-- ================================================
Scripts
================================================ -->
<!-- jQuery Library -->
<script type="text/javascript" src="vendors/jquery-3.2.1.min.js"></script>
<!--materialize js-->
<script type="text/javascript" src="js/materialize.min.js"></script>
<!--scrollbar-->
<script type="text/javascript" src="vendors/perfect-scrollbar/perfect-scrollbar.min.js"></script>
<!--plugins.js - Some Specific JS codes for Plugin Settings-->
<script type="text/javascript" src="js/plugins.js"></script>
<!--custom-script.js - Add your own theme custom JS-->
<script type="text/javascript" src="js/custom-script.js"></script>
</body>
</html>
<%} else{
    request.getRequestDispatcher("login.jsp").forward(request, response);
}%>
