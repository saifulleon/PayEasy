<nav class="sidebar sidebar-offcanvas" id="sidebar">
    <ul class="nav">
        <li class="nav-item">
            <a class="nav-link" href="${pageContext.request.contextPath}/dashboard">
                <i class="mdi mdi-apps menu-icon"></i>
                <span class="menu-title">Dashboard</span>
            </a>
        </li>
        <li class="nav-item">
            <a class="nav-link" data-toggle="collapse" href="#employee" aria-expanded="false" aria-controls="employee">
                <i class="mdi mdi-account-multiple menu-icon"></i>
                <span class="menu-title">Employee</span>
                <i class="menu-arrow"></i>
            </a>
            <div class="collapse" id="employee">
                <ul class="nav flex-column sub-menu">
                    <li class="nav-item"> <a class="nav-link" href="${pageContext.request.contextPath}/employee">Employee List</a></li>
                    
                </ul>
            </div>
        </li>
        <li class="nav-item">
            <a class="nav-link" data-toggle="collapse" href="#allowance" aria-expanded="false" aria-controls="allowance">
                <i class="mdi mdi-delta menu-icon"></i>
                <span class="menu-title">Allowance</span>
                <i class="menu-arrow"></i>
            </a>
            <div class="collapse" id="allowance">
                <ul class="nav flex-column sub-menu">
                    <li class="nav-item"> <a class="nav-link" href="${pageContext.request.contextPath}/allowance">Allowance List</a></li>
                    <li class="nav-item"> <a class="nav-link" href="${pageContext.request.contextPath}/allowancecal">Allowance Rate</a></li>
                </ul>
            </div>
        </li>
        <li class="nav-item">
            <a class="nav-link" data-toggle="collapse" href="#deduction" aria-expanded="false" aria-controls="deduction">
                <i class="mdi mdi-details menu-icon"></i>
                <span class="menu-title">Deduction</span>
                <i class="menu-arrow"></i>
            </a>
            <div class="collapse" id="deduction">
                <ul class="nav flex-column sub-menu">
                    <li class="nav-item"> <a class="nav-link" href="${pageContext.request.contextPath}/deduction">Deduction List</a></li>
                    <li class="nav-item"> <a class="nav-link" href="${pageContext.request.contextPath}/deductioncal">Deduction Rate</a></li>
                </ul>
            </div>
        </li>
        <li class="nav-item">
            <a class="nav-link" data-toggle="collapse" href="#payment" aria-expanded="false" aria-controls="payment">
                <i class="mdi mdi-cash-multiple menu-icon"></i>
                <span class="menu-title">Payment</span>
                <i class="menu-arrow"></i>
            </a>
            <div class="collapse" id="payment">
                <ul class="nav flex-column sub-menu">
                    <li class="nav-item"> <a class="nav-link" href="${pageContext.request.contextPath}/basicsalary">Set Basic Salary</a></li>
                    <li class="nav-item"> <a class="nav-link" href="${pageContext.request.contextPath}/employee2pay">Employees to Pay</a></li>
                </ul>
            </div>
        </li>
        <li class="nav-item">
            <a class="nav-link" data-toggle="collapse" href="#report" aria-expanded="false" aria-controls="report">
                <i class="mdi mdi-chart-line menu-icon"></i>
                <span class="menu-title">Report</span>
                <i class="menu-arrow"></i>
            </a>
            <div class="collapse" id="report">
                <ul class="nav flex-column sub-menu">
                    <li class="nav-item"> <a class="nav-link" href="${pageContext.request.contextPath}/reportSingleEmp" target="_blank">Employee Search</a></li>
                </ul>
            </div>
        </li>
        <li class="nav-item">
            <a class="nav-link" data-toggle="collapse" href="#settings" aria-expanded="false" aria-controls="settings">
                <i class="mdi mdi-settings menu-icon"></i>
                <span class="menu-title">Settings</span>
                <i class="menu-arrow"></i>
            </a>
            <div class="collapse" id="settings">
                <ul class="nav flex-column sub-menu">
                    <li class="nav-item"> <a class="nav-link" href="${pageContext.request.contextPath}/department">Departments</a></li>
                    <li class="nav-item"> <a class="nav-link" href="${pageContext.request.contextPath}/emptype">Employee Types</a></li>
                    <li class="nav-item"> <a class="nav-link" href="${pageContext.request.contextPath}/jobtitle">Job Titles</a></li>
                    <li class="nav-item"> <a class="nav-link" href="${pageContext.request.contextPath}/paytype">Payment Types</a></li>
                    <li class="nav-item"> <a class="nav-link" href="${pageContext.request.contextPath}/basicyear">Basic Years</a></li>
                </ul>
            </div>
        </li>
    </ul>
</nav>
