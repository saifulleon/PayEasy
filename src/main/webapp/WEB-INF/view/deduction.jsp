<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <jsp:include page="/WEB-INF/view/partial/head.jsp"></jsp:include>
            
        <script>
            var deducList = ${deductionList};
            //console.log(cat);
            angular.module('ngapp', []).controller('DeductionController',
                function ($scope) {
                    $scope.deductionList = deducList;
                });
        </script>
    </head>
    <body ng-app="ngapp">
        <div class="container-scroller">

            <jsp:include page="/WEB-INF/view/partial/topnav.jsp"></jsp:include>

                <div class="container-fluid page-body-wrapper">

                <jsp:include page="/WEB-INF/view/partial/sidebar.jsp"></jsp:include>

                    <div class="main-panel">
                        <div class="content-wrapper">
                            <div class="row">
                                <div class="col-md-5  grid-margin">
                                    <!-- left column -->
                                    <div class="card">
                                        <div class="card-body">
                                            <p class="card-title">Add / Edit Deduction</p>
                                            <br>
                                            <c:if test="${check}">
                                                <form:form modelAttribute="deductionMA" action="addingDeduction" method="post">
                                                    <label for="dn">Deduction Name</label>
                                                    <form:input type="text" path="deductionhead" id="dn" class="form-control" placeholder="Deduction"></form:input>
                                                        <br><br>
                                                    <form:button type="submit" name="AddDeduction" class="btn btn-primary btn-fw btn-block">Add Deduction</form:button>
                                                </form:form>
                                            </c:if>
                                            <c:if test="${!check}">
                                                <form:form modelAttribute="deductionMA" action="addingDeduction" method="post">
                                                    <form:input type="text" path="deductionid" style="display:none"></form:input>
                                                        <label for="dn">Deduction Name</label>
                                                    <form:input type="text" id="dn" path="deductionhead" class="form-control"></form:input>
                                                        <br><br>
                                                    <form:button id="editbuttons" type="submit" name="EditDeduction" class="btn btn-warning btn-fw btn-block">Edit Deduction</form:button>
                                                    <div class="text-center">
                                                        <br><a href="${pageContext.request.contextPath}/deduction" class="badge badge-light">Cancel Edit</a>
                                                    </div>
                                                </form:form>
                                            </c:if>          
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-7  grid-margin">
                                    <!-- right column -->
                                    <div class="card">
                                        <div class="card-body">
                                            <p class="card-title">Deductions</p>
                                            <div class="table-responsive" ng-controller="DeductionController">
                                                <table class="table">
                                                    <thead>
                                                        <tr>
                                                            <th>Deduction ID</th>
                                                            <th>Deduction Name</th>
                                                            <th>&nbsp;</th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                        <tr ng-repeat="deduction in deductionList">
                                                            <td>{{deduction.deductionid}}</td>
                                                            <td>{{deduction.deductionhead}}</td>
                                                            <td class="text-right">
                                                                <a href="editdeducbutton?getdeducid={{deduction.deductionid}}" class="btn btn-sm">
                                                                    <i class="mdi mdi-pencil text-warning"></i>
                                                                </a>
                                                                <a href="removededuc/{{deduction.deductionid}}" class="btn btn-sm">
                                                                    <i class="mdi mdi-delete text-danger"></i>
                                                                </a>
                                                            </td>
                                                        </tr>
                                                    </tbody>
                                                </table>
                                            </div>                                        
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