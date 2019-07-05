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
                                <div class="auth-form-light text-left py-5 px-4 px-sm-5 text-center">
                                    <div class="brand-logo">
                                        <img src="resources/images/logo/logo.png" alt="logo">
                                    </div>
                                    <h5>Payroll made Easy :)</h5>
                                    <br>
                                    <p class="text-primary">
                                        Welcome Buddy &hearts; <br>
                                        Only admin can enter into the site.
                                        <br><br>
                                    </p>
                                    <p class="text-black">
                                        <a href="login" class="btn btn-block btn-primary btn-lg font-weight-medium auth-form-btn">Login</a>
                                    </p>
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