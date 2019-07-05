<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <jsp:include page="/WEB-INF/view/partial/head.jsp"></jsp:include>

            <script>
                var bscyrList = ${basicyearList};

                angular.module('ngapp', []).controller('PaymentController',
                        function ($scope) {
                            $scope.basicyearList = bscyrList;
                        });
        </script>
    </head>
    <body ng-app="ngapp" ng-controller="PaymentController">
    <div class="container-scroller">

        <jsp:include page="/WEB-INF/view/partial/topnav.jsp"></jsp:include>

            <div class="container-fluid page-body-wrapper">

            <jsp:include page="/WEB-INF/view/partial/sidebar.jsp"></jsp:include>

            <div class="main-panel">
                <div class="content-wrapper">
                    <div class="row d-flex justify-content-center">
                        <div class="col-md-6 grid-margin">
                            <div class="card">
                                <div class="card-body">
                                    Employee Name : <span class="text-primary">${sessionScope.singleEmp2pay.empname}</span> <br><br>
                                Designation : <span class="text-primary">${sessionScope.singleEmp2pay.jobtitlename}</span> <br><br>
                                Department : <span class="text-primary">${sessionScope.singleEmp2pay.departmentname}</span>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row d-flex justify-content-center">
                        <div class="col-md-6 grid-margin">
                            <div class="card">
                                <div class="card-body">
                                    <p class="card-title">Select Basic Year:</p>
                                    <form action="processBasicyear" method="post">
                                        <select class="form-control form-control-sm" ng-model="basicyear" ng-options="x.basicyearvalue for x in basicyearList" required="true">
                                            <option value="">-- Choose Year --</option>
                                        </select>
                                        <input type="hidden" value="{{basicyear.basicyearid}}" name="basicyear"> <br>
                                        <input type="submit" class="btn btn-primary btn-fw btn-block" value="Proceed to Payment">
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            <!-- content-wrapper ends -->

            <jsp:include page="/WEB-INF/view/partial/footer.jsp"></jsp:include>

            </div>
            <!-- main-panel ends -->
            </div>
            <!-- page-body-wrapper ends -->
        </div>
        <!-- container-scroller -->




        <jsp:include page="/WEB-INF/view/partial/jsinclude.jsp"></jsp:include>

        <!-- Plugin js for this page-->
        <script src="resources/theme/admin/vendors/chart.js/Chart.min.js"></script>
        <script src="resources/theme/admin/vendors/datatables.net/jquery.dataTables.js"></script>
        <script src="resources/theme/admin/vendors/datatables.net-bs4/dataTables.bootstrap4.js"></script>
        <!-- End plugin js for this page-->
        <!-- Custom js for this page-->
        <script src="resources/theme/admin/js/dashboard.js"></script>
        <script src="resources/theme/admin/js/data-table.js"></script>
        <script src="resources/theme/admin/js/jquery.dataTables.js"></script>
        <script src="resources/theme/admin/js/dataTables.bootstrap4.js"></script>
        <!-- End custom js for this page-->

    </body>
</html>
