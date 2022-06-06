<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <html>

        <head>
            <title>London Underground Ticket System</title>
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        </head>

        <body>

            <header>
                <nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
                    <div>
                        <a href="https://www.javaguides.net" class="navbar-brand"> London Underground Ticket System </a>
                    </div>

                    <ul class="navbar-nav">
                        <li><a  href="<%=request.getContextPath()%>/ConfigServelet" class="nav-link">HOME PAGE</a></li>
                        <li><a  href="<%=request.getContextPath()%>/gateview" class="nav-link">GATE</a></li>
                    </ul>
                </nav>
            </header>
            <br>

            <div class="row">
                <!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

                <div class="container" >
                <div class="h-100 row align-items-center">
  <div class="col">
     <h3 class="text-center">YOUR ARE</h3>
      <img src="gate.jpg" alt="Ticket COunter" style="width:569px;height:426px;">
                  
					    <div class="col-sm">
					  <h6 style="color:red;width: 50%">${result}</h6>
							  </div>
							</div>
                </div>
            </div>
            </div>
        </body>

</html>