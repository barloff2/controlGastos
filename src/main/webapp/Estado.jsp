<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
		<!DOCTYPE html>
		<html lang="">

		<head>
			<meta charset="utf-8">
			<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
			<title>Estado</title>
			<!-- Main Header and Footer -->
			<script type=module src=main.js></script>

			<!-- Bootstrap only -->
			<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
				integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N"
				crossorigin="anonymous">

			<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet"
				integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
				crossorigin="anonymous">
			<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
				integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
				crossorigin="anonymous"></script>

		</head>

		<body>
		<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
		<script src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"></script>
		<script src="https://cdn.datatables.net/fixedheader/3.1.6/js/dataTables.fixedHeader.min.js"></script> 
			<mn-header></mn-header>
			<header>
				<h1 style="padding: 60px; text-align: center">Estado de Cuenta</h1>
			</header>
			<main>
				<section>

					<nav class="navbar-expand-md bg-light ">
						<div class="container-fluid">
							<a class="navbar-brand"></a>
							<form class="d-flex" role="search" method="get" action="ServletEstado">
								<select name="tipo" class="form-select" required>
									<option selected>Gastos</option>
									<option>Ingresos</option>
								</select>
								<input class="form-control me-2" type="date" id="fecha" name="fecha"> <input id="nombre"
									class="form-control me-2" type="search" placeholder="nombre" aria-label="Search">
								<button id="buscar" class="btn btn-outline-success mr-1" type="submit">Search</button>
								<input class="btn btn-primary active ml-1" type="button" value="limpiar"
									onclick="limpiar()">

							</form>
						</div>
					</nav>

				</section>
				<div class="b-example-divider"></div>
				<section>
					<div class="container-fluid pb-3">
						<h3 align="center">Listado Movimientos</h3>
						<table id = "tabla" class="table">
							<thead>
								<tr>
									<th scope="col">Tipo</th>
									<th scope="col">Responsable</th>
									<th scope="col">Valor</th>
									<th scope="col">fecha</th>
									<th scope="col">Descripci&oacuten</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="movimiento" items="${listaI}">
									<tr>
										<td>
											<c:out value="${movimiento.tipo}"></c:out>
										</td>
										<td>
											<c:out value="${movimiento.responsable}"></c:out>
										</td>
										<td>
											<c:out value="${movimiento.ingreso}"></c:out>
										</td>
										<td>
											<c:out value="${movimiento.fecha}"></c:out>
										</td>
										<td>
											<c:out value="${movimiento.description}"></c:out>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
					</div>
				</section>
			</main>
			<script>
				document.getElementById("fecha").value = "";
				document.getElementById("nombre").value = "";
				
				$(document).ready(function(){
				    var table = $('#tabla').DataTable({
				       orderCellsTop: true,
				       fixedHeader: true 
				    });

				    //Creamos una fila en el head de la tabla y lo clonamos para cada columna
				    $('#tabla thead tr').clone(true).appendTo( '#tabla thead' );

				    $('#tabla thead tr:eq(1) th').each( function (i) {
				        var title = $(this).text(); //es el nombre de la columna
				        $(this).html( '<input type="text" placeholder="Search...'+title+'" />' );
				 
				        $( 'input', this ).on( 'keyup change', function () {
				            if ( table.column(i).search() !== this.value ) {
				                table
				                    .column(i)
				                    .search( this.value )
				                    .draw();
				            }
				        } );
				    } );   
				});
			</script>
			

			<div>
				<svg class="bi me-2" width="40" height="32" role="img" aria-label="Bootstrap">
				</svg>
			</div>
			<footer">
				<section class="">
					<div class="container p-4 pb-0">
						<section class="nav justify-content-center border-top">
							<a href="index.jsp" class="nav-link px-2 text-muted">Home</a>
						</section>
					</div>
					<div class="text-center p-3" style="background-color: rgba(0, 0, 0, 0.2);">
						© 2022 Copyright
					</div>
				</section>
				</footer>
		</body>

		</html>