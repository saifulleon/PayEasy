<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <jsp:include page="/WEB-INF/view/partial/head.jsp"></jsp:include>
            
        <script>
            var aclList = ${allowancecalList};
            var allowList = ${allowanceList};
            var basicslList = ${basicsalaryList};
            <c:if test="${!check}">
                var singleAclJsontemp = ${singleAclJson};
            </c:if>
                
            angular.module('ngapp', []).controller('AllowancecalController',
                function ($scope) {
                    $scope.allowancecalList = aclList;
                    $scope.allowanceList = allowList;
                    $scope.basicsalaryList = basicslList;
                    <c:if test="${!check}">
                        $scope.singleAclJson = singleAclJsontemp;
                    </c:if>
                });
        </script>
    </head>
    <body ng-app="ngapp" ng-controller="AllowancecalController">
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
                                            <p class="card-title">Allowance Rate:</p>
                                            <br>
                                            <c:if test="${check}">
                                                <form:form commandName="allowancecalMA" action="addingAllowancecal" method="post">
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
                                                    
                                                    <label>Allowance for:</label>
                                                    <select class="form-control form-control-sm" ng-model="allowanceSelected" ng-options="x.allowancehead for x in allowanceList" required="true">
                                                        <option value="">-- Choose Allowance --</option>
                                                    </select>
                                                    <form:hidden value="{{allowanceSelected.allowancehead}}" path="allowancehead"></form:hidden>
                                                    
                                                    <br>

                                                    <label>Percent ( % ) :</label>
                                                    <form:input ng-model="percentSelected" type="text" path="percent" class="form-control form-control-sm"></form:input>

                                                    <br>
                                                    
                                                    <label ng-show="percentSelected">
                                                        Calculated <span class="text-primary">{{allowanceSelected.allowancehead}}</span> allowance : 
                                                        <span class="text-success">{{payscaleSelected.basicsalaryamount * (percentSelected / 100)}}</span> Tk
                                                        <br><br>
                                                    </label>
                                                    <form:hidden value="{{payscaleSelected.basicsalaryamount * (percentSelected / 100)}}" path="amount"></form:hidden>
                                                    
                                                    <form:button type="submit" name="AddAllowancecal" class="btn btn-primary btn-fw btn-block">Add Allowance</form:button>
                                                </form:form>
                                            </c:if>
                                                    
                                            <c:if test="${!check}">
                                                <form:form commandName="allowancecalMA" action="addingAllowancecal" method="post">
                                                    <form:hidden path="allowancecalid"></form:hidden>
                                                
                                                    <label>Basic Year : <span class="text-primary">{{singleAclJson.basicyearvalue}}</span></label> <br><br>
                                                    <label>Job Title : <span class="text-primary">{{singleAclJson.jobtitlename}}</span></label> <br><br>
                                                    <label>Basic Salary : <span class="text-success">{{singleAclJson.basicsalaryamount}}</span></label> <br>
                                                    
                                                    <form:hidden value="{{singleAclJson.basicyearvalue}}" path="basicyearvalue"></form:hidden>
                                                    <form:hidden value="{{singleAclJson.jobtitlename}}" path="jobtitlename"></form:hidden>
                                                    <form:hidden value="{{singleAclJson.basicsalaryamount}}" path="basicsalaryamount"></form:hidden>
                                                    
                                                    <br>
                                                
                                                    <label>Allowance for : <span class="text-primary">{{singleAclJson.allowancehead}}</span></label> <br>
                                                    <form:hidden value="{{singleAclJson.allowancehead}}" path="allowancehead"></form:hidden>
                                                
                                                    <br>

                                                    <label>Percent ( % ) :</label>
                                                    <form:input ng-model="percentSelected" type="text" path="percent" class="form-control form-control-sm"></form:input>

                                                    <br>
                                                
                                                    <label ng-show="percentSelected">
                                                        Calculated <span class="text-primary">{{singleAclJson.allowancehead}}</span> allowance : 
                                                        <span class="text-success">{{singleAclJson.basicsalaryamount * (percentSelected / 100)}}</span> Tk
                                                        <br><br>
                                                    </label>
                                                    <form:hidden value="{{singleAclJson.basicsalaryamount * (percentSelected / 100)}}" path="amount"></form:hidden>
                                                
                                                    <form:button type="submit" name="EditAllowancecal" class="btn btn-warning btn-fw btn-block">Edit Allowance</form:button>
                                                    <div class="text-center">
                                                        <br><a href="${pageContext.request.contextPath}/allowancecal" class="badge badge-light">Cancel Edit</a>
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
                                            <p class="card-title">Allowances</p>
                                            Show result for year:
                                            <select class="form-control form-control-sm col-md-4" ng-model="yearfilter" ng-options="x.basicyearvalue as x.basicyearvalue for x in allowancecalList">
                                                <option value="">select year</option>
                                            </select>
                                            <div class="table-responsive">
                                                <table class="table">
                                                    <thead>
                                                        <tr>
                                                            <th>Year</th>
                                                            <th>Job Title</th>
                                                            <th>Basic Salary</th>
                                                            <th>Allowance</th>
                                                            <th>Percent</th>
                                                            <th>Amount</th>
                                                            <th>&nbsp;</th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                        <tr ng-repeat="allowancecal in allowancecalList | orderBy:'basicyearvalue' | filter : yearfilter">
                                                            <td>{{allowancecal.basicyearvalue}}</td>
                                                            <td>{{allowancecal.jobtitlename}}</td>                                                        
                                                            <td>{{allowancecal.basicsalaryamount}}</td>
                                                            <td>{{allowancecal.allowancehead}}</td>
                                                            <td>{{allowancecal.percent}}%</td>                                                        
                                                            <td>{{allowancecal.amount}}</td>
                                                            <td class="text-right">
                                                                <a href="editaclbutton?getaclid={{allowancecal.allowancecalid}}" class="btn btn-sm">
                                                                    <i class="mdi mdi-pencil text-warning"></i>
                                                                </a>
                                                                <a href="removeacl/{{allowancecal.allowancecalid}}" class="btn btn-sm">
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