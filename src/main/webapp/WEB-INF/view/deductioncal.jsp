<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <jsp:include page="/WEB-INF/view/partial/head.jsp"></jsp:include>
            
        <script>
            var dclList = ${deductioncalList};
            var deducList = ${deductionList};
            var basicslList = ${basicsalaryList};
            <c:if test="${!check}">
                var singleDclJsontemp = ${singleDclJson};
            </c:if>
                
            angular.module('ngapp', []).controller('DeductioncalController',
                function ($scope) {
                    $scope.deductioncalList = dclList;
                    $scope.deductionList = deducList;
                    $scope.basicsalaryList = basicslList;
                    <c:if test="${!check}">
                        $scope.singleDclJson = singleDclJsontemp;
                    </c:if>
                });
        </script>
    </head>
    <body ng-app="ngapp" ng-controller="DeductioncalController">
        <div class="container-scroller">

            <jsp:include page="/WEB-INF/view/partial/topnav.jsp"></jsp:include>

                <div class="container-fluid page-body-wrapper">

                <jsp:include page="/WEB-INF/view/partial/sidebar.jsp"></jsp:include>

                    <div class="main-panel">
                        <div class="content-wrapper">
                            <div class="row">
                                <div class="col-md-4  grid-margin">
                                    <!-- left column -->
                                    <div class="card">
                                        <div class="card-body">
                                            <p class="card-title">Deduction Rate:</p>
                                            <br>
                                            <c:if test="${check}">
                                                <form:form commandName="deductioncalMA" action="addingDeductioncal" method="post">
                                                    <label>Basic Year / Jobtitle :</label>
                                                    <select class="form-control form-control-sm" ng-model="payscaleSelected" ng-options="x.basicyearvalue + ' - ' + x.jobtitlename for x in basicsalaryList" required="true">
                                                        <option value="">-- Choose Year --</option>
                                                    </select>
                                                    <form:hidden value="{{payscaleSelected.jobtitlename}}" path="jobtitlename"></form:hidden>
                                                    <form:hidden value="{{payscaleSelected.basicsalaryamount}}" path="basicsalaryamount"></form:hidden>
                                                    <form:hidden value="{{payscaleSelected.basicyearvalue}}" path="basicyearvalue"></form:hidden>
                                                    
                                                    <br>
                                                    <label>
                                                        Basic Salary : 
                                                        <span ng-hide="payscaleSelected" class="text-gray">N/A</span> 
                                                        <span class="text-success">{{payscaleSelected.basicsalaryamount}}</span>
                                                    </label>
                                                    <br><br>
                                                    
                                                    <label>Deduction for:</label>
                                                    <select class="form-control form-control-sm" ng-model="deductionSelected" ng-options="x.deductionhead for x in deductionList" required="true">
                                                        <option value="">-- Choose Deduction --</option>
                                                    </select>
                                                    <form:hidden value="{{deductionSelected.deductionhead}}" path="deductionhead"></form:hidden>
                                                    
                                                    <br>

                                                    <label>Percent ( % ) :</label>
                                                    <form:input ng-model="percentSelected" type="text" path="percent" class="form-control form-control-sm"></form:input>

                                                    <br>
                                                    
                                                    <label ng-show="percentSelected">
                                                        Calculated <span class="text-primary">{{deductionSelected.deductionhead}}</span> deduction : 
                                                        <span class="text-success">{{payscaleSelected.basicsalaryamount * (percentSelected / 100)}}</span> Tk
                                                        <br><br>
                                                    </label>
                                                    <form:hidden value="{{payscaleSelected.basicsalaryamount * (percentSelected / 100)}}" path="amount"></form:hidden>
                                                    
                                                    <form:button type="submit" name="AddDeductioncal" class="btn btn-primary btn-fw btn-block">Add Deduction</form:button>
                                                </form:form>
                                            </c:if>
                                                    
                                            <c:if test="${!check}">
                                                <form:form commandName="deductioncalMA" action="addingDeductioncal" method="post">
                                                    <form:hidden path="deductioncalid"></form:hidden>
                                                
                                                    <label>Basic Year : <span class="text-primary">{{singleDclJson.basicyearvalue}}</span></label> <br><br>
                                                    <label>Job Title : <span class="text-primary">{{singleDclJson.jobtitlename}}</span></label> <br><br>
                                                    <label>Basic Salary : <span class="text-success">{{singleDclJson.basicsalaryamount}}</span></label> <br>
                                                    
                                                    <form:hidden value="{{singleDclJson.basicyearvalue}}" path="basicyearvalue"></form:hidden>
                                                    <form:hidden value="{{singleDclJson.jobtitlename}}" path="jobtitlename"></form:hidden>
                                                    <form:hidden value="{{singleDclJson.basicsalaryamount}}" path="basicsalaryamount"></form:hidden>
                                                    
                                                    <br>
                                                
                                                    <label>Deduction for : <span class="text-primary">{{singleDclJson.deductionhead}}</span></label> <br>
                                                    <form:hidden value="{{singleDclJson.deductionhead}}" path="deductionhead"></form:hidden>
                                                
                                                    <br>

                                                    <label>Percent ( % ) :</label>
                                                    <form:input ng-model="percentSelected" type="text" path="percent" class="form-control form-control-sm"></form:input>

                                                    <br>
                                                
                                                    <label ng-show="percentSelected">
                                                        Calculated <span class="text-primary">{{singleDclJson.deductionhead}}</span> deduction : 
                                                        <span class="text-success">{{singleDclJson.basicsalaryamount * (percentSelected / 100)}}</span> Tk
                                                        <br><br>
                                                    </label>
                                                    <form:hidden value="{{singleDclJson.basicsalaryamount * (percentSelected / 100)}}" path="amount"></form:hidden>
                                                
                                                    <form:button type="submit" name="EditDeductioncal" class="btn btn-warning btn-fw btn-block">Edit Deduction</form:button>
                                                    <div class="text-center">
                                                        <br><a href="${pageContext.request.contextPath}/deductioncal" class="badge badge-light">Cancel Edit</a>
                                                    </div>
                                                </form:form>
                                            </c:if> 
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-8  grid-margin">
                                    <!-- right column -->
                                    <div class="card">
                                        <div class="card-body">
                                            <p class="card-title">Deductions</p>
                                            Show result for year:
                                            <select class="form-control form-control-sm col-md-4" ng-model="yearfilter" ng-options="x.basicyearvalue as x.basicyearvalue for x in deductioncalList">
                                                <option value="">select year</option>
                                            </select>
                                            <div class="table-responsive">
                                                <table class="table">
                                                    <thead>
                                                        <tr>
                                                            <th>Year</th>
                                                            <th>Job Title</th>
                                                            <th>Basic Salary</th>
                                                            <th>Deduction</th>
                                                            <th>Percent</th>
                                                            <th>Amount</th>
                                                            <th>&nbsp;</th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                        <tr ng-repeat="deductioncal in deductioncalList | orderBy:'basicyearvalue' | filter : yearfilter">
                                                            <td>{{deductioncal.basicyearvalue}}</td>
                                                            <td>{{deductioncal.jobtitlename}}</td>                                                        
                                                            <td>{{deductioncal.basicsalaryamount}}</td>
                                                            <td>{{deductioncal.deductionhead}}</td>
                                                            <td>{{deductioncal.percent}}%</td>                                                        
                                                            <td>{{deductioncal.amount}}</td>
                                                            <td class="text-right">
                                                                <a href="editdclbutton?getdclid={{deductioncal.deductioncalid}}" class="btn btn-sm">
                                                                    <i class="mdi mdi-pencil text-warning"></i>
                                                                </a>
                                                                <a href="removedcl/{{deductioncal.deductioncalid}}" class="btn btn-sm">
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