<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <jsp:include page="/WEB-INF/view/partial/head.jsp"></jsp:include>
            
        <script>
            var empList = ${employeeList};
            var jbttlList = ${jobtitleList};
            var dptList = ${departmentList};
            var emptpList = ${emptypeList};
            
            //set foreign key item into the combobox on edit page. jquery inclusion before this scrpit is required
            $(document).ready(function(){
                $('.selectJobtitle option:contains("${prevJobtitle}")').prop('selected', true);
                $('.selectDepartment option:contains("${prevDepartment}")').prop('selected', true);
                $('.selectEmptype option:contains("${prevEmptype}")').prop('selected', true);
            });
            
            angular.module('ngapp', []).controller('EmployeeController',
                function ($scope) {
                    $scope.employeeList = empList;
                    $scope.jobtitleList = jbttlList;
                    $scope.departmentList = dptList;
                    $scope.emptypeList = emptpList;
                });
        </script>
    </head>
    <body ng-app="ngapp" ng-controller="EmployeeController">
        <div class="container-scroller">

            <jsp:include page="/WEB-INF/view/partial/topnav.jsp"></jsp:include>

                <div class="container-fluid page-body-wrapper">

                <jsp:include page="/WEB-INF/view/partial/sidebar.jsp"></jsp:include>

                    <div class="main-panel">
                        <div class="content-wrapper">
                            <div class="row">
                                <div class="col-md-3  grid-margin">
                                    <!-- left column -->
                                    <div class="card">
                                        <div class="card-body">
                                            <p class="card-title">Add / Edit Employee</p>
                                            <br>
                                            <c:if test="${check}">
                                                <form:form commandName="employeeMA" action="addingEmployee" method="post">

                                                    <label>Name</label>                        
                                                    <form:input type="text" path="empname" class="form-control form-control-sm" Placeholder="Name"></form:input>

                                                    <br>

                                                    <label>Job Title</label>
                                                    <form:select path="jobtitlename" cssClass="form-control form-control-sm" required="true">
                                                        <option value="">-- Choose Jobtitle --</option>
                                                        <form:option ng-repeat="jobtitle in jobtitleList" value="{{jobtitle.jobtitlename}}">
                                                            {{jobtitle.jobtitlename}}
                                                        </form:option>
                                                    </form:select>

                                                    <br>

                                                    <label>Department</label>
                                                    <select class="form-control form-control-sm" ng-model="department" ng-options="x.departmentname as x.departmentname for x in departmentList" required="true">
                                                        <option value="">-- Choose Department --</option>
                                                    </select>
                                                    <form:hidden value="{{department}}" path="departmentname"></form:hidden>

                                                    <br>

                                                    <label>Employee Type</label>
                                                    <select class="form-control form-control-sm" ng-model="emptypename" ng-options="x.emptypename as x.emptypename for x in emptypeList" required="true">
                                                        <option value="">-- Choose Department --</option>
                                                    </select>
                                                    <form:hidden value="{{emptypename}}" path="emptypename"></form:hidden>

                                                    <br>

                                                    <label>Phone</label>                        
                                                    <form:input type="text" path="phone" class="form-control form-control-sm" Placeholder="phone"></form:input>

                                                    <br>

                                                    <label>address</label>                        
                                                    <form:input type="text" path="address" class="form-control form-control-sm" Placeholder="address"></form:input>

                                                    <br>

                                                    <label>Email</label>                        
                                                    <form:input type="text" path="emailid" class="form-control form-control-sm" Placeholder="Email"></form:input>

                                                    <br><br>
                                                    <form:button type="submit" name="AddEmployee" class="btn btn-primary btn-fw btn-block">Add Employee</form:button>
                                                </form:form>
                                            </c:if>
                                            <c:if test="${!check}">
                                                <form:form commandName="employeeMA" action="addingEmployee" method="post">
                                                    
                                                    <form:input type="text" path="empid" style="display:none"></form:input>
                                                    
                                                    <label>Name</label>                        
                                                    <form:input type="text" path="empname" class="form-control form-control-sm" Placeholder="Name"></form:input>

                                                    <br>

                                                    <label>Job Title</label>
                                                    <form:select path="jobtitlename" cssClass="form-control form-control-sm selectJobtitle" required="true">
                                                        <option value="">-- Choose Jobtitle --</option>
                                                        <form:option ng-repeat="jobtitle in jobtitleList" value="{{jobtitle.jobtitlename}}">
                                                            {{jobtitle.jobtitlename}}
                                                        </form:option>
                                                    </form:select>

                                                    <br>

                                                    <label>Department</label>
                                                    <form:select path="departmentname" cssClass="form-control form-control-sm selectDepartment" required="true">
                                                        <option value="">-- Choose Department --</option>
                                                        <form:option ng-repeat="department in departmentList" value="{{department.departmentname}}">
                                                            {{department.departmentname}}
                                                        </form:option>
                                                    </form:select>

                                                    <br>

                                                    <label>Employee Type</label>
                                                    <form:select path="emptypename" cssClass="form-control form-control-sm selectEmptype" required="true">
                                                        <option value="">-- Employee Type --</option>
                                                        <form:option ng-repeat="emptype in emptypeList" value="{{emptype.emptypename}}">
                                                            {{emptype.emptypename}}
                                                        </form:option>
                                                    </form:select>

                                                    <br>

                                                    <label>Phone</label>                        
                                                    <form:input type="text" path="phone" class="form-control form-control-sm" Placeholder="phone"></form:input>

                                                    <br>

                                                    <label>address</label>                        
                                                    <form:input type="text" path="address" class="form-control form-control-sm" Placeholder="address"></form:input>

                                                    <br>

                                                    <label>Email</label>                        
                                                    <form:input type="text" path="emailid" class="form-control form-control-sm" Placeholder="Email"></form:input>

                                                    <br><br>
                                                    <form:button type="submit" name="EditEmployee" class="btn btn-warning btn-fw btn-block">Edit Employee</form:button>
                                                    
                                                    <div class="text-center">
                                                        <br><a href="${pageContext.request.contextPath}/employee" class="badge badge-light">Cancel Edit</a>
                                                    </div>
                                                </form:form>
                                            </c:if>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-9  grid-margin">
                                    <!-- right column -->
                                    <div class="card">
                                        <div class="card-body">
                                            <p class="card-title">Employee List</p>
                                            <div class="table-responsive">
                                                <table class="table table-striped">
                                                    <thead>
                                                        <tr>
                                                            <th>Name</th>                                                           
                                                            <th>Designation</th>
                                                            <th>Department</th>                                                            
                                                            <th>Type</th>
                                                            <th>Phone</th>
                                                            <th>Address</th>                                                            
                                                            <th>Email</th>
                                                            <th>&nbsp;</th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                        <tr ng-repeat="employee in employeeList">
                                                            <td>{{employee.empname}}</td>
                                                            <td>{{employee.jobtitlename}}</td>
                                                            <td>{{employee.departmentname}}</td>
                                                            <td>{{employee.emptypename}}</td>                                                        
                                                            <td>{{employee.phone}}</td>
                                                            <td>{{employee.address}}</td>
                                                            <td>{{employee.emailid}}</td>                                                        
                                                            <td class="text-right">
                                                                <a href="editempbutton?getempid={{employee.empid}}" class="btn btn-sm">
                                                                    <i class="mdi mdi-pencil text-warning"></i>
                                                                </a>
                                                                <a href="removeemp/{{employee.empid}}" class="btn btn-sm">
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