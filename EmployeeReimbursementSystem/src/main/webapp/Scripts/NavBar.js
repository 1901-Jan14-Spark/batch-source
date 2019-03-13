const addNavBar = () => {
	let navBarDiv = document.getElementById("EmployeeNavBar");
	navBarDiv.innerHTML = 
		`<div class="container">
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
			<a class="navbar-brand" href="home">ERS</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarNav" aria-controls="navbarNav"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav">
					<li class="nav-item active"><a class="nav-link"
						href="home">Home</a></li>
					<li class="nav-item"><a class="nav-link"
						href="requests">View Requests</a></li>
					<li class="nav-item"><a class="nav-link"
						href="profile">View Profile</a></li>
					<li class="nav-item"><a class="nav-link"
						href="profile">Update Profile</a></li>
					<li class="nav-item"><a class="nav-link"
						href="logout">Logout</a></li>
				</ul>
			</div>
		</nav>
	</div>`;
}

addNavBar();