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
                                    <h4>Payroll made Easy :)</h4>
                                    <h6 class="font-weight-light">Sign in to continue.</h6>
                                    <form class="pt-3" action="perform_login" method="post">
                                        <div class="form-group">
                                            <input type="email" class="form-control form-control-lg" id="inputEmail" placeholder="Email address" required="required" autofocus="autofocus" name="usename">
                                        </div>
                                        <div class="form-group">
                                            <input type="password" class="form-control form-control-lg" id="inputPassword" placeholder="Password" name="userpassword">
                                        </div>
                                        <div class="mt-3">
                                            <input type="submit" class="btn btn-block btn-primary btn-lg font-weight-medium auth-form-btn" value="SIGN IN">
                                        </div>
                                        <div class="my-2 d-flex justify-content-between align-items-center">
                                            <div class="form-check">
                                                <label class="form-check-label text-muted">
                                                    <input type="checkbox" class="form-check-input" value="remember-me">
                                                    Keep me signed in
                                                </label>
                                            </div>
                                            <a href="#" class="auth-link text-black">Forgot password?</a>
                                        </div>
                                        <div class="text-center mt-4 font-weight-light">
                                            Don't have an account? <a href="signup" class="text-primary">Create</a>
                                        </div>
                                    </form>
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