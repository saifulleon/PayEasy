<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <jsp:include page="/WEB-INF/view/partial/head.jsp"></jsp:include>
            
        <script>
            var bscslList = ${basicsalaryList};
            var bscyrList = ${basicyearList};
            var jbttlList = ${jobtitleList};
            
            //set foreign key item into the combobox on edit page. jquery inclusion before this scrpit is required
            $(document).ready(function(){
                $('.selectBasicyear option:contains("${prevBasicyear}")').prop('selected', true);
                $('.selectJobtitle option:contains("${prevJobtitle}")').prop('selected', true);
            });
            
            angular.module('ngapp', []).controller('BasicsalaryController',
                function ($scope) {
                    $scope.basicsalaryList = bscslList;
                    $scope.basicyearList = bscyrList;
                    $scope.jobtitleList = jbttlList;
                });
        </script>
    </head>
    <body ng-app="ngapp" ng-controller="BasicsalaryController">
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
                                            <p class="card-title">Add / Edit Basic Salary</p>
                                            <br>
                                             <c:if test="${check}">
                                                <form:form commandName="basicsalaryMA" action="addingBasicsalary" method="post">
                                                    <label>Year</label>                        
                                                    <select class="form-control" ng-model="basicyear" ng-options="x.basicyearvalue as x.basicyearvalue for x in basicyearList" required="true">
                                                        <option value="">-- Choose Year --</option>
                                                    </select>
                                                    <form:hidden  class="form-control" value="{{basicyear}}" path="basicyearvalue"></form:hidden>
                                                    
                                                    <br>
                                                    
                                                    <label>Job Title</label>
                                                    <select class="form-control" ng-model="jobtitle" ng-options="x.jobtitlename as x.jobtitlename for x in jobtitleList" required="true">
                                                        <option value="">-- Choose Job Title --</option>
                                                    </select>
                                                    <form:hidden  class="form-control" value="{{jobtitle}}" path="jobtitlename"></form:hidden>
                                                    
                                                    <br>
                                                    
                                                    <label>Amount</label>
                                                    <form:input type="text" path="basicsalaryamount" class="form-control" Placeholder="amount"></form:input> <br>
                                                    
                                                    <br><br>
                                                    <form:button type="submit" name="AddBasicsalary" class="btn btn-primary btn-fw btn-block">Add Basicsalary</form:button>
                                                </form:form>
                                            </c:if>
                                            <c:if test="${!check}">
                                                <form:form commandName="basicsalaryMA" action="addingBasicsalary" method="post">
                                                    <form:input type="text" path="basicsalaryid" style="display:none"></form:input>
                                                    
                                                    <label>Year</label>                        
                                                    <form:select path="basicyearvalue" cssClass="form-control selectBasicyear" required="true">
                                                        <option value="">-- Choose Basic Year --</option>
                                                        <form:option ng-repeat="basicyear in basicyearList" value="{{basicyear.basicyearvalue}}">
                                                            {{basicyear.basicyearvalue}}
                                                        </form:option>
                                                    </form:select>
                                                    
                                                    <br>
                                                    
                                                    <label>Job Title</label>
                                                    <form:select path="jobtitlename" cssClass="form-control selectJobtitle" required="true">
                                                        <option value="">-- Choose Jobtitle --</option>
                                                        <form:option ng-repeat="jobtitle in jobtitleList" value="{{jobtitle.jobtitlename}}">
                                                            {{jobtitle.jobtitlename}}
                                                        </form:option>
                                                    </form:select>
                                                    
                                                    <br>
                                                    
                                                    <label>Amount</label>
                                                    <form:input type="text" path="basicsalaryamount" class="form-control" Placeholder="amount"></form:input> <br>
                                                    
                                                    <br><br>
                                                    <form:button type="submit" name="EditBasicsalary" class="btn btn-warning btn-fw btn-block">Edit Basic salary</form:button>
                                                    
                                                    <div class="text-center">
                                                        <br><a href="${pageContext.request.contextPath}/basicsalary" class="badge badge-light">Cancel Edit</a>
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
                                            <p class="card-title">Basic Salary</p>
                                            Show result for year:
                                            <select class="form-control form-control-sm col-md-4" ng-model="yearfilter" ng-options="x.basicyearvalue as x.basicyearvalue for x in basicyearList">
                                                <option value="">select year</option>
                                            </select>
                                            <div class="table-responsive">
                                                <table class="table">
                                                    <thead>
                                                        <tr>
                                                            <th>Year</th>
                                                            <th>Job Title</th>                                                            
                                                            <th>Basic Salary</th>
                                                            <th>&nbsp;</th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                        <tr ng-repeat="basicsalary in basicsalaryList | orderBy:'basicyearvalue' | filter : yearfilter">
                                                            <td>{{basicsalary.basicyearvalue}}</td>
                                                            <td>{{basicsalary.jobtitlename}}</td>                                                        
                                                            <td>{{basicsalary.basicsalaryamount}}</td>
                                                            <td class="text-right">
                                                                <a href="editbscslbutton?getbscslid={{basicsalary.basicsalaryid}}" class="btn btn-sm">
                                                                    <i class="mdi mdi-pencil text-warning"></i>
                                                                </a>
                                                                <a href="removebscsl/{{basicsalary.basicsalaryid}}" class="btn btn-sm">
                                                                    <i class="mdi mdi-delete text-danger"></i>
                                                                </a>
                                                            </td>
                                                        </tr>
                                                    </tbody>
                                                </table>
<!--                                                <table class="table">
                                                    <tbody>
                                                        <tr ng-repeat="basicyear in basicyearList">
                                                            <td>{{basicyear.basicyearid}}</td>
                                                            <td>{{basicyear.basicyearvalue}}</td>
                                                        </tr>
                                                    </tbody>
                                                </table>-->
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