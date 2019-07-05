<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <jsp:include page="/WEB-INF/view/partial/head.jsp"></jsp:include>
            
        <script>
            var deptList = ${departmentList};
            //console.log(cat);
            angular.module('ngapp', []).controller('DepartmentController',
                function ($scope) {
                    $scope.departmentList = deptList;
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
                                            <p class="card-title">Add / Edit Departments</p>
                                            <br>
                                            <c:if test="${check}">
                                                <form:form modelAttribute="departmentMA" action="addingDepartment" method="post">
                                                    <label for="dn">Department Name</label>
                                                    <form:input type="text" path="departmentname" id="dn" class="form-control" placeholder="e.g. ICT, HR"></form:input>
                                                        <br><br>
                                                    <form:button type="submit" name="AddDepartment" class="btn btn-primary btn-fw btn-block">Add Department</form:button>
                                                </form:form>
                                            </c:if>
                                            <c:if test="${!check}">
                                                <form:form modelAttribute="departmentMA" action="addingDepartment" method="post">
                                                    <form:input type="text" path="departmentid" style="display:none"></form:input>
                                                        <label for="dn">Department Name</label>
                                                    <form:input type="text" id="dn" path="departmentname" class="form-control"></form:input>
                                                        <br><br>
                                                    <form:button id="editbuttons" type="submit" name="EditDepartment" class="btn btn-warning btn-fw btn-block">Edit Department</form:button>
                                                    <div class="text-center">
                                                        <br><a href="${pageContext.request.contextPath}/department" class="badge badge-light">Cancel Edit</a>
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
                                            <p class="card-title">Departments</p>
                                            <div class="table-responsive" ng-controller="DepartmentController">
                                                <table class="table">
                                                    <thead>
                                                        <tr>
                                                            <th>ID</th>
                                                            <th>Department Name</th>
                                                            <th>&nbsp;</th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                        <tr ng-repeat="department in departmentList">
                                                            <td>{{department.departmentid}}</td>
                                                            <td>{{department.departmentname}}</td>
                                                            <td class="text-right">
                                                                <a href="editdeptbutton?getdeptid={{department.departmentid}}" class="btn btn-sm">
                                                                    <i class="mdi mdi-pencil text-warning"></i>
                                                                </a>
                                                                <a href="removedept/{{department.departmentid}}" class="btn btn-sm">
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