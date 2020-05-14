<%-- 
    Document   : login.jsp
    Created on : 31/10/2019, 22:03:15
    Author     : Willian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
    <link href="css/custom/login.css" type="text/css" rel="stylesheet">
    <link href="css/custom/modal.css" type="text/css" rel="stylesheet">
    <!-- INCLUDED PLUGIN CSS ON THIS PAGE -->
    <link href="vendors/perfect-scrollbar/perfect-scrollbar.css" type="text/css" rel="stylesheet">
    <link href="vendors/flag-icon/css/flag-icon.min.css" type="text/css" rel="stylesheet">
    
    <title>Projeto MVC</title>
    </head>
    <body>
        <div id="login-page" class="row">
            <div class="col s12 z-depth-6 card-panel">
                <form action="<%=request.getContextPath()%>/LoginUsuarioCTR" method="POST" class="login-form">
                    <div class="row">
                    </div>
                    <div class="row">
                        <div class="input-field col s12">
                            <i class="material-icons prefix">mail_outline</i>
                            <input name="emailUsuario" required class="validate" id="email" type="email">
                            <label for="email" class="active" data-error="wrong" data-success="right">Email</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="input-field col s12">
                            <i class="material-icons prefix">lock_outline</i>
                            <input name="senhaUsuario" required id="password" type="password">
                            <label class="active" for="password">Senha</label>
                        </div>
                    </div>
           
                    <div class="row">
                        <div class="input-field col s12">
                            <input type="submit" value="Logar" class="btn waves-effect waves-light col s12">
                            
                        </div>
                    </div>
                    <div class="row">
                        <div class="input-field col s6 m6 l6">
                            <p class="margin medium-small"><a href="#">Registrar Agora!</a></p>
                        </div>
                        <div class="input-field col s6 m6 l6">
                            <p class="margin right-align medium-small"><a href="#">Esqueceu sua senha?</a></p>
                        </div>          
                    </div>

                </form>
                    <%if (request.getAttribute("mensagem") != null){%>
                    <h4 class="center-align">
                        <%=request.getAttribute("mensagem")%>
                    </h4>
                    <%}%>
            </div>
        </div> 
        
            <!-- Trigger/Open The Modal -->
<button id="myBtn">Open Modal</button>

<!-- The Modal -->
<div id="myModal" class="modal">

  <!-- Modal content -->
  <div class="modal-content">
    <span class="close">&times;</span>
    <p>Some text in the Modal..</p>
  </div>

</div>
              <script type="text/javascript" src="js/modal.js"></script>  
    </body>
</html>
