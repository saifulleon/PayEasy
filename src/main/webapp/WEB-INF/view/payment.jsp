<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <jsp:include page="/WEB-INF/view/partial/head.jsp"></jsp:include>

            <script>
                var BasicsalaryByEmployeeTemp = ${BasicsalaryByEmployeeGson};
                var paytList = ${paytypeList};
                
                <c:if test="${!acartavailempty}">
                    var aclList = ${acartavailgson};
                </c:if>
                <c:if test="${!acartempty}">
                    var acartgsonTemp = ${acartgson};
                </c:if>
                    
                <c:if test="${!dcartavailempty}">
                    var dclList = ${dcartavailgson};
                </c:if>
                <c:if test="${!dcartempty}">
                    var dcartgsonTemp = ${dcartgson};
                </c:if>

                angular.module('ngapp', []).controller('PaymentController',
                        function ($scope) {
                            $scope.BasicsalaryByEmployee = BasicsalaryByEmployeeTemp;
                            $scope.paytypeList = paytList;
                            
                            <c:if test="${!acartavailempty}">
                                $scope.acartavailgson = aclList;
                            </c:if>
                            <c:if test="${!acartempty}">
                                $scope.acartAddedItems = acartgsonTemp;
                                $scope.atoTakaPoisaKothayRakhi = function(){
                                    var total = 0;
                                    for(var i = 0; i < $scope.acartAddedItems.length; i++){
                                        var item = $scope.acartAddedItems[i];
                                        total += item.amount;
                                    }
                                    return total;
                                };
                            </c:if>
                                
                            <c:if test="${!dcartavailempty}">
                                $scope.dcartavailgson = dclList;
                            </c:if>
                            <c:if test="${!dcartempty}">
                                $scope.dcartAddedItems = dcartgsonTemp;
                                $scope.dontStealMyMoney = function(){
                                    var total = 0;
                                    for(var i = 0; i < $scope.dcartAddedItems.length; i++){
                                        var item = $scope.dcartAddedItems[i];
                                        total += item.amount;
                                    }
                                    return total;
                                };
                            </c:if>
                                
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
                            <div class="row">
                                <div class="col-md-12 grid-margin">
                                    <div class="mr-md-3 mr-xl-5">
                                        <h4>Apply Allowances &AMP; Deductions : </h4>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6 grid-margin stretch-card">
                                    <div class="card">
                                    <div class="card-body">
                                        <p class="card-title"><i class="mdi mdi-check"></i> Allowances</p>
                                        <div class="allowance-box">
                                            <p class="card-description bg-light">Added Allowances:</p>
                                            <c:if test="${acartempty}">
                                                <p class="card-description text-small text-center">No allowance added :( </p>
                                            </c:if>
                                            <c:if test="${!acartempty}">
                                                <table class="table table-sm table-borderless">
                                                    <tbody>
                                                        <tr ng-repeat="addedallowance in acartAddedItems">
                                                            <td>{{addedallowance.allowancehead}}</td>
                                                            <td>{{addedallowance.percent}}%</td>
                                                            <td style="background-color: rgba(113,192,22,0.2);">{{addedallowance.amount}} Tk.</td>
                                                            <td class="text-right">
                                                                <a href="deleteallowance4rmcart?getallowanceid={{addedallowance.allowancecalid}}" class="btn btn-sm">
                                                                    <i class="mdi mdi-minus-circle text-danger"></i>
                                                                </a>
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <td></td>
                                                            <td class="text-right">Total : </td>
                                                            <td  class="bg-success text-white">{{ atoTakaPoisaKothayRakhi() }} Tk.</td>
                                                            <td></td>
                                                        </tr>
                                                    </tbody>
                                                </table>
                                            </c:if>
                                            
                                            <br><br>
                                            
                                            <p class="card-description bg-light text-black">Available Allowances for ${sessionScope.singleEmp2pay.empname} :</p>
                                            <c:if test="${acartavailempty}">
                                                <p class="card-description text-small text-center">Sorry, no more allowance is available for ${sessionScope.singleEmp2pay.empname}</p>
                                            </c:if>
                                            <c:if test="${!acartavailempty}">
                                            <table class="table table-sm table-borderless">
                                                <tbody>
                                                    <tr ng-repeat="acartavail in acartavailgson">
                                                        <td>{{acartavail.allowancehead}}</td>
                                                        <td>{{acartavail.percent}}%</td>                                                        
                                                        <td>{{acartavail.amount}} Tk.</td>
                                                        <td class="text-right">
                                                            <a href="addallowance2cart?getallowanceid={{acartavail.allowancecalid}}" class="btn btn-sm">
                                                                <i class="mdi mdi-plus-circle text-success"></i>
                                                            </a>
                                                        </td>
                                                    </tr>
                                                </tbody>
                                            </table>
                                            </c:if>
                                        </div>
                                    </div>
                                </div>
                                </div>
                                <div class="col-md-6 grid-margin stretch-card">
                                    <div class="card">
                                    <div class="card-body">
                                        <p class="card-title"><i class="mdi mdi-content-cut"></i> Deductions</p>
                                        <div class="deduction-box">
                                            <p class="card-description bg-light">Added Deductions:</p>
                                            <c:if test="${dcartempty}">
                                                <p class="card-description text-small text-center">No deduction added :( </p>
                                            </c:if>
                                            <c:if test="${!dcartempty}">
                                                <table class="table table-sm table-borderless">
                                                    <tbody>
                                                        <tr ng-repeat="addeddeduction in dcartAddedItems">
                                                            <td>{{addeddeduction.deductionhead}}</td>
                                                            <td>{{addeddeduction.percent}}%</td>
                                                            <td style="background-color: rgba(255,71,71,0.2);">{{addeddeduction.amount}} Tk.</td>
                                                            <td class="text-right">
                                                                <a href="deletededuction4rmcart?getdeductionid={{addeddeduction.deductioncalid}}" class="btn btn-sm">
                                                                    <i class="mdi mdi-minus-circle text-danger"></i>
                                                                </a>
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <td></td>
                                                            <td class="text-right">Total : </td>
                                                            <td  class="bg-danger text-white">{{ dontStealMyMoney() }} Tk.</td>
                                                            <td></td>
                                                        </tr>
                                                    </tbody>
                                                </table>
                                            </c:if>
                                            
                                            <br><br>
                                            
                                            <p class="card-description bg-light text-black">Available Deductions for ${sessionScope.singleEmp2pay.empname} :</p>
                                            <c:if test="${dcartavailempty}">
                                                <p class="card-description text-small text-center">Sorry, no more deduction is available for ${sessionScope.singleEmp2pay.empname}</p>
                                            </c:if>
                                            <c:if test="${!dcartavailempty}">
                                            <table class="table table-sm table-borderless">
                                                <tbody>
                                                    <tr ng-repeat="dcartavail in dcartavailgson">
                                                        <td>{{dcartavail.deductionhead}}</td>
                                                        <td>{{dcartavail.percent}}%</td>                                                        
                                                        <td>{{dcartavail.amount}} Tk.</td>
                                                        <td class="text-right">
                                                            <a href="adddeduction2cart?getdeductionid={{dcartavail.deductioncalid}}" class="btn btn-sm">
                                                                <i class="mdi mdi-plus-circle text-success"></i>
                                                            </a>
                                                        </td>
                                                    </tr>
                                                </tbody>
                                            </table>
                                            </c:if>
                                        </div>
                                    </div>
                                </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-12 grid-margin">
                                    <div class="mr-md-3 mr-xl-5">
                                        <h4>Make Payment : </h4>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6  grid-margin">
                                    <div class="card">
                                        <div class="card-body">
                                            <p class="card-title">Payment</p>
                                            <form:form modelAttribute="paymentMA" action="processPayment" method="post">
                                                <label>Employee Name : <span class="text-primary">${sessionScope.singleEmp2pay.empname}</span></label>
                                                <form:hidden value="${sessionScope.singleEmp2pay.empname}" path="empname"></form:hidden>
                                                
                                                <br>
                                                
                                                <label>Job Title : <span class="text-primary">${sessionScope.singleEmp2pay.jobtitlename}</span></label>
                                                <form:hidden value="${sessionScope.singleEmp2pay.jobtitlename}" path="jobtitlename"></form:hidden>
                                                
                                                <br>
                                                
                                                <label>Basic Year : <span class="text-primary">${sessionScope.basicyear.basicyearvalue}</span></label>
                                                <form:hidden value="${sessionScope.basicyear.basicyearvalue}" path="basicyearvalue"></form:hidden>
                                                
                                                
                                                <br><br>
                                                
                                                <label>Paying Year :</label>
                                                <select class="form-control form-control-sm" ng-model="payingyear">
                                                    <option value="">-- Choose Year --</option>
                                                    <option value="2015">2015</option>
                                                    <option value="2016">2016</option>
                                                    <option value="2017">2017</option>
                                                    <option value="2018">2018</option>
                                                    <option value="2019">2019</option>
                                                    <option value="2020">2020</option>
                                                </select>
                                                <form:hidden value="{{payingyear}}" path="payingyear"></form:hidden>
                                                
                                                <br><br>
                                                
                                                <label>Paying Month :</label>
                                                <select class="form-control form-control-sm" ng-model="payingmonth">
                                                    <option value="">-- Choose Month --</option>
                                                    <option value="January">January</option>
                                                    <option value="February">February</option>
                                                    <option value="March">March</option>
                                                    <option value="April">April</option>
                                                    <option value="May">May</option>
                                                    <option value="June">June</option>
                                                    <option value="July">July</option>
                                                    <option value="August">August</option>
                                                    <option value="September">September</option>
                                                    <option value="October">October</option>
                                                    <option value="November">November</option>
                                                    <option value="December">December</option>
                                                </select>
                                                <form:hidden value="{{payingmonth}}" path="payingmonth"></form:hidden>
                                                
                                                <br>
                                                <label>Payment Type</label>
                                                <select class="form-control form-control-sm" ng-model="paytype" ng-options="x.paytypename for x in paytypeList" required="true">
                                                    <option value="">-- Choose Payment Type --</option>
                                                </select>
                                                <form:hidden value="{{paytype.paytypename}}" path="paytypename"></form:hidden>
                                                
                                                <br>
                                                
                                                <label>Bank Name</label>                        
                                                <form:input type="text" path="bankname" class="form-control form-control-sm" placeholder="Bank Name"></form:input>
                                                
                                                <br>
                                                
                                                <label>Check Number</label>                        
                                                <form:input type="text" path="checkno" class="form-control form-control-sm" placeholder="Check No"></form:input>
                                                
                                                <br>
                                                
                                                <table class="table table-borderless">
                                                    <tbody>
                                                        <tr>
                                                            <td class="text-right">Basic Salary</td>
                                                            <td class="text-right"><span class="text-success">{{BasicsalaryByEmployee.basicsalaryamount}}</span></td>
                                                        </tr>
                                                        <tr>
                                                            <td class="text-right">Total Allowance</td>
                                                            <td class="text-right"><span class="text-success">+ {{ atoTakaPoisaKothayRakhi() }}</span></td>
                                                        </tr>
                                                    </tbody>
                                                </table>
                                                <table class="table">
                                                    <tbody>
                                                        <tr>
                                                            <td class="text-right">Gross Salary</td>
                                                            <td class="text-right">{{ BasicsalaryByEmployee.basicsalaryamount + atoTakaPoisaKothayRakhi() }}</td>
                                                        </tr>
                                                    </tbody>
                                                </table>
                                                <table class="table table-borderless">
                                                    <tbody>
                                                        <tr>
                                                            <td class="text-right">Total Deduction</td>
                                                            <td class="text-right"><span class="text-danger">- {{ dontStealMyMoney() }}</span></td>
                                                        </tr>
                                                    </tbody>
                                                </table>
                                                <table class="table">
                                                    <tbody>
                                                        <tr>
                                                            <td class="text-right">Net Salary</td>
                                                            <td class="text-right bg-success"><span class="text-white display-4">Tk. {{ ( BasicsalaryByEmployee.basicsalaryamount + atoTakaPoisaKothayRakhi() ) - dontStealMyMoney() }}</span></td>
                                                        </tr>
                                                    </tbody>
                                                </table>
                                                
                                                
                                                <form:hidden value="{{BasicsalaryByEmployee.basicsalaryamount}}" path="basicsalaryamount"></form:hidden>
                                                
                                                <form:hidden value="{{ atoTakaPoisaKothayRakhi() }}" path="totalallowance"></form:hidden>
                                                
                                                <form:hidden value="{{ dontStealMyMoney() }}" path="totaldeduction"></form:hidden>

                                                <form:hidden value="{{ ( BasicsalaryByEmployee.basicsalaryamount + atoTakaPoisaKothayRakhi() ) - dontStealMyMoney() }}" path="netsalary"></form:hidden>
                                                
                                                <br><br>
                                                <form:button type="submit" class="btn btn-primary btn-fw btn-block">Pay</form:button>
                                            </form:form>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-6  grid-margin">
                                
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