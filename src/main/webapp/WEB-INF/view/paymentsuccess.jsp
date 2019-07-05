<!DOCTYPE html>
<html lang="en">
    <head>
        <jsp:include page="/WEB-INF/view/partial/head.jsp"></jsp:include>
            
            <script>
                var paymentgsonTemp = ${paymentgson};

                angular.module('ngapp', []).controller('SuccessController',
                    function ($scope) {
                        $scope.paymentgson = paymentgsonTemp;
                    });
            </script>
            
            <!-- plugin css for this page -->
            <link rel="stylesheet" href="resources/theme/admin/vendors/datatables.net-bs4/dataTables.bootstrap4.css">
            <!-- End plugin css for this page -->

            <!-- inject:css -->
            <link rel="stylesheet" href="resources/theme/admin/css/style.css">
            <!-- endinject -->
        </head>
        <body ng-app="ngapp" ng-controller="SuccessController">

            <div class="container-scroller">
                <div class="container-fluid page-body-wrapper full-page-wrapper">
                    <div class="content-wrapper d-flex align-items-center auth px-0">
                        <div class="row w-100 mx-0">
                            <div class="col-lg-4 mx-auto">
                                <div class="auth-form-light text-left py-5 px-4 px-sm-5 text-center">
                                    <div class="brand-logo">
                                        <img src="resources/images/received.png" alt="Received">
                                    </div>
                                    <h5>Payment Successful :)</h5>
                                    <br>
                                    <table class="table table-sm table-striped text-left">
                                        <tbody>
                                            <tr>
                                                <td>Payment ID :</td> <td>{{paymentgson.paymentid}}</td>
                                            </tr>
                                            <tr>
                                                <td>Employee Name :</td> <td>{{paymentgson.empname}}</td>
                                            </tr>
                                            <tr>
                                                <td>Paid for :</td> <td>{{paymentgson.payingmonth}}, {{paymentgson.payingyear}}</td>
                                            </tr>
                                            <tr>
                                                <td>Net Salary :</td> <td><span class="text-success">{{paymentgson.netsalary}}</span> Tk.</td>
                                            </tr>
                                        </tbody>
                                    </table>
                                    <br><br>
                                    <p class="text-black">
                                        <a href="reportPayslip" class="btn btn-block btn-primary btn-md font-weight-medium auth-form-btn" target="_blank">Print Payslip</a>
                                        <br> or <br>
                                        <br><a href="${pageContext.request.contextPath}/employee2pay" class="btn btn-sm btn-outline-secondary">Pay Next Employee</a>
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