<%-- 
    Document   : ManagerProduct
    Created on : Dec 28, 2020, 5:19:02 PM
    Author     : trinh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Edit User</title>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link href="css/manager.css" rel="stylesheet" type="text/css"/>
         <link href="https://th.bing.com/th/id/OIP.WGyHTn_3yK52VkIhkRBarAHaEs?pid=ImgDet&rs=1" rel="icon"/>
        <style>
            img{
                width: 200px;
                height: 120px;
            }
        </style>
    <body>
        <div class="container">
            <div class="table-wrapper">
                <div class="table-title">
                    <div class="row">
                        <div class="col-sm-6">
                            <h2>Edit <b>User</b></h2>
                        </div>
                        <div class="col-sm-6">
                        </div>
                    </div>
                </div>
            </div>
            <div id="editEmployeeModal">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <form action="editUser" method="post">
                            <div class="modal-header">						
                                <h4 class="modal-title">Edit User</h4>
                              
                            </div>
                            <div class="modal-body">					
                                  
                                <div class="form-group">
                                    <label>User name</label>
                                    <input value="${listacc.user}" name="name" type="text" class="form-control" required readonly>
                                </div>
                                <div class="form-group">
                                    <label>Pass</label>
                                    <input value="${listacc.pass}" name="pass" type="text" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label>Email</label>
                                    <input value="${listacc.email}" name="email" type="text" class="form-control" required>
                                </div>                             
                                <div class="form-group">
                                    <label>Sell</label>
                                    <input value="${listacc.isSell}" name="sell" type="text" class="form-control" required>
                                </div>
                                
                            </div>
                            <div class="modal-footer">
                                <input type="submit" class="btn btn-success" value="Edit">
                            </div>
                        </form>
                    </div>
                </div>
            </div>
 <a href="manageruser"><button style="margin-bottom: 30px" type="button" class="btn btn-primary">Back </button>   </a> 
        </div>


        <script src="js/manager.js" type="text/javascript"></script>
    </body>
</html>