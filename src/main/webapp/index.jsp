<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="">

	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<title>Registrar Ingresos</title>
		<!-- Main Header and Footer -->
		<script type=module src=main.js></script>
	
		<!-- Bootstrap only -->
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
			integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
		<!-- Bootstrap icons -->
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet"
			integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
			integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
			crossorigin="anonymous"></script>
	
	</head>

<body>
	<!-- Javascript Header-->
	<mn-header></mn-header>
	<!-- Bootstrap only -->
	<main class="html">
		<div class="d-flex flex-wrap align-items-center justify-content-center justify-content-xlg-start">
			<ul class="nav col-12 col-lg-auto my-2 justify-content-center my-md-0 text-small">
				<!-- Botón Estado -->
				<li>
					<button class="btn btn-outline-secondary mr-2">
						<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
							class="bi bi-bar-chart-fill" viewBox="0 0 16 16">
							<path
								d="M1 11a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1v3a1 1 0 0 1-1 1H2a1 1 0 0 1-1-1v-3zm5-4a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1v7a1 1 0 0 1-1 1H7a1 1 0 0 1-1-1V7zm5-5a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1v12a1 1 0 0 1-1 1h-2a1 1 0 0 1-1-1V2z" />
						</svg>
						<a href="ServletEstado" class="nav-link text-blue" style="text-decoration:none"> <svg
								class="bi d-block mx-auto mb-1" width="20" height="15">
								<use xlink:href="#home"></use>
							</svg> &nbspEstado&nbsp
						</a>
					</button>
				</li>
				<!-- Botón Estado -->
				<li>
					<button class="btn btn-outline-secondary mr-2">
						<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
							class="bi bi-node-plus-fill" viewBox="0 0 16 16">
							<path
								d="M11 13a5 5 0 1 0-4.975-5.5H4A1.5 1.5 0 0 0 2.5 6h-1A1.5 1.5 0 0 0 0 7.5v1A1.5 1.5 0 0 0 1.5 10h1A1.5 1.5 0 0 0 4 8.5h2.025A5 5 0 0 0 11 13zm.5-7.5v2h2a.5.5 0 0 1 0 1h-2v2a.5.5 0 0 1-1 0v-2h-2a.5.5 0 0 1 0-1h2v-2a.5.5 0 0 1 1 0z" />
						</svg>
						<a href="Ingresos.html" class="nav-link text-blue" style="text-decoration:none"> <svg
								class="bi d-block mx-auto mb-1" width="20" height="15">
								<use xlink:href="#speedometer2"></use>
							</svg> Ingresos
						</a>
					</button>
				</li>
				<!-- Botón Gastos -->
				<li>
					<button class="btn btn-outline-secondary">
						<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
							class="bi bi-node-minus-fill" viewBox="0 0 16 16">
							<path fill-rule="evenodd"
								d="M16 8a5 5 0 0 1-9.975.5H4A1.5 1.5 0 0 1 2.5 10h-1A1.5 1.5 0 0 1 0 8.5v-1A1.5 1.5 0 0 1 1.5 6h1A1.5 1.5 0 0 1 4 7.5h2.025A5 5 0 0 1 16 8zm-2 0a.5.5 0 0 0-.5-.5h-5a.5.5 0 0 0 0 1h5A.5.5 0 0 0 14 8z" />
						</svg>
						<a href="Gastos.html" class="nav-link text-blue" style="text-decoration:none"> <svg
								class="bi d-block mx-auto mb-1" width="20" height="15">
								<use xlink:href="#table"></use>
							</svg>&nbspGastos&nbsp
						</a>
					</button>
				</li>
			</ul>
		</div>
	</main>
<!-- JavaScript footer -->
	<mn-footer></mn-footer>
</body>
</html>