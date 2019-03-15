const sideBar = document.getElementById("sidebar");

sideBar.innerHTML = 
	`
	<li class="nav-item active"><a class="nav-link"
		href="employeehome"> <i class="fas fa-fw fa-tachometer-alt"></i>
			<span>Dashboard</span>
	</a></li>
	<li class="nav-item"><a class="nav-link" href="employeeprofile">
			<i class="fa fa-user"></i> <span>Profile</span>
	</a></li>
	<li class="nav-item"><a class="nav-link" href="logout"> <i
			class="fas fa-sign-out-alt"></i> <span>Logout</span></a></li>`