<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <jsp:include page="/WEB-INF/view/partial/head.jsp"></jsp:include>

            <!-- plugin css for this page -->
            <link rel="stylesheet" href="resources/theme/admin/vendors/datatables.net-bs4/dataTables.bootstrap4.css">
            <!-- End plugin css for this page -->

            <!-- inject:css -->
            <link rel="stylesheet" href="resources/theme/admin/css/style.css">
            <!-- endinject -->
        </head>
        <body>

            <div class="container-scroller">
                <div class="container-fluid page-body-wrapper full-page-wrapper">
                    <div class="content-wrapper d-flex align-items-center auth px-0">
                        <div class="row w-100 mx-0">
                            <div class="col-lg-4 mx-auto">
                                <div class="auth-form-light text-left py-5 px-4 px-sm-5">
                                    <div class="brand-logo">
                                        <img src="resources/images/logo/logo.png" alt="logo">
                                    </div>
                                    <h5>Payroll made Easy :)</h5>
                                    <p class="text-danger">
                                        Sorry Buddy :( <br>
                                        User registration not available :D <br>
                                        Only admin can enter into the site.
                                        <br><br>
                                    </p>
                                    <p class="text-black">
                                        Already have an admin account? <a href="login" class="text-primary">Login</a>
                                    </p>
<!--                                    <h6 class="font-weight-light">Signing up is easy. It only takes a few steps</h6>-->
                                    <%--
                                    <form:form modelAttribute="urm" action="reguser" class="pt-3">
                                        <div class="form-group">
                                            <form:input type="text" class="form-control" placeholder="Username" id="name" autofocus="autofocus" aria-describedby="basic-addon1" path="username" required="true"></form:input>
                                        </div>
                                        <div class="form-group">
                                            <form:input type="password" class="form-control" id="pass" placeholder="New Password" aria-describedby="basic-addon1" path="password" required="true"></form:input>
                                        </div>
                                        <div class="form-group">
                                            <form:input type="text" class="form-control" id="phone" placeholder="Phone Number" aria-describedby="basic-addon1" path="phone" value="+88" required="true"></form:input>
                                        </div>
                                        <div class="form-group">
                                            <form:input type="email" class="form-control" placeholder="Email" id="inputEmail" aria-describedby="basic-addon1" path="emailid" required="true"></form:input>
                                        </div>
                                        
                                        <div class="mt-3">
                                            <button id="signupbutton" class="btn btn-block btn-primary btn-lg font-weight-medium auth-form-btn" type="submit">Sign Up</button>
                                        </div>
                                            
                                        <div class="text-center mt-4 font-weight-light">
                                            Already have an account? <a href="login" class="text-primary">Login</a>
                                        </div>
                                    </form:form>
                                    --%>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- content-wrapper ends -->
                </div>
                <!-- page-body-wrapper ends -->
            </div>


        <jsp:include page="/WEB-INF/view/partial/jsinclude.jsp"></jsp:include>

    </body>
</html>









<%--
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Shop - Sign Up</title>

        <!-- Bootstrap core CSS-->
        <link href="resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom fonts for this template-->
        <link href="resources/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

        <!-- Custom styles for this template-->
        <link href="resources/cssnew/sb-admin.css" rel="stylesheet">
        <link href="resources/img/logo.ico" rel="shortcut icon" />

    </head>
    <body class="bg-dark">



        <div class="container">
            <div class="card card-register mx-auto mt-5">
                <div class="card-header">Register an Account</div>
                <div class="card-body">
                    <form:form modelAttribute="urm" action="reguser">

                        <div class="form-group">
                            <div class="form-label-group">
                                <form:input type="text" class="form-control" placeholder="Username" id="name" autofocus="autofocus" aria-describedby="basic-addon1" path="username" required="true"></form:input>
                                    <label for="name">User Name</label>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="form-label-group">
                                <form:input type="password" class="form-control" id="pass"
                                            placeholder="New Password" aria-describedby="basic-addon1" path="password" required="true"></form:input>
                                    <label for="pass">Password</label>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="form-label-group">
                                <form:input type="text" class="form-control" id="phone"
                                            placeholder="Phone Number" aria-describedby="basic-addon1" path="phone" value="+88" required="true"></form:input>
                                    <label for="phone">Phone</label>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="form-label-group">
                                <form:input type="email" class="form-control" placeholder="Email" id="inputEmail" aria-describedby="basic-addon1" path="emailid" required="true"></form:input>
                                    <label for="inputEmail">Email address</label>
                                </div>
                            </div>
                            <button id="signupbutton" class="btn btn-primary btn-block" type="submit">Sign Up</button>
                            <button id="cancelbutton" class="btn btn-primary btn-block" type="Reset">Cancel</button>

                    </form:form>
                    <div class="text-center">
                        <a class="d-block small mt-3" href="login">Login Page</a>
                        <a class="d-block small" href="forgot-password.html">Forgot Password?</a>
                    </div>
                </div>
            </div>
        </div>
        <!-- Bootstrap core JavaScript-->
        <script src="resources/jquery/jquery.min.js"></script>
        <script src="resources/bootstrap/js/bootstrap.bundle.min.js"></script>

        <!-- Core plugin JavaScript-->
        <script src="resources/jquery-easing/jquery.easing.min.js"></script>
    </body>
</html>

--%>