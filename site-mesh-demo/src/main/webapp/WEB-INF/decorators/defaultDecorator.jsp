<%@ include file="/WEB-INF/decorators/scriptloading.jsp"%>
<%@ include file="/WEB-INF/decorators/taglib.jsp"%>

<!DOCTYPE html>
<html>
<title><sitemesh:write property='title' /></title>
<sitemesh:write property='head' />
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
</head>
<body class="sb-nav-fixed">

	<%@ include file="/WEB-INF/decorators/header.jsp"%>
	<%@ include file="/WEB-INF/decorators/sidebar.jsp"%>
	<div id="layoutSidenav_content">
	<main id="main" class="main"> <sitemesh:write property='body' />
	</main>
	
	<footer class="py-4 bg-light mt-auto">
		<div class="container-fluid px-4">
			<div class="d-flex align-items-center justify-content-between small">
				<div class="text-muted">Copyright &copy; Your Website 2022</div>
				<div>
					<a href="#">Privacy Policy</a> &middot; <a href="#">Terms &amp;
						Conditions</a>
				</div>
			</div>
		</div>
	</footer>
	</div>

</body>
</html>