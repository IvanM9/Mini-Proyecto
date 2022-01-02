<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="UTF-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta http-equiv="Content-Type" content="text/html">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<title>Registro</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
		integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous" />

</head>

<body>
	<div class="container">
		<div class="row align-items-stretch justify-content-center">
			<div class="col-9 p-2 mt-3 rounded-end col-md-5">
				<div class="card-header text-center mb-4">
					<h1 class="text-align">Registro</h1>
				</div>
				<form action="UsuarioController" method="post">
					<div class="form-group">
						<label for="nombres">Nombres</label>
						<input type="text" id="nombres" class="form-control" name="nombres" />
					</div>
					<div class="form-group">
						<label for="appelidos">Apellidos</label>
						<input type="text" id="apellidos" class="form-control" name="apellidos"/>
					</div>
					<div class="form-group">
						<label for="fechanacimiento">Fecha de nacimiento</label>
						<input type="date" id="fechanacimiento" class="form-control" name="fechanacimiento">
					</div>
					<div class="form-group">
						<label for="correo">Correo Electronico</label>
						<input type="email" class="form-control" id="correo" aria-describedby="emailHelp" name="correo"/>
					</div>
					<div class="form-group">
						<label for="contraseña">Contraseña</label>
						<input type="password" class="form-control" id="contraseña" name="password"/>
						<small id="emailHelp" class="form-text text-muted">Nunca
							comparta su contraseña con nadie.</small>
					</div>
					<div class="form-group">
						<label for="InputPassword1">Ingrese nuevamente la
							contraseña</label>
						<input type="password" class="form-control" id="InputPassword2"  />
					</div>
					<button id="registrar" type="submit" class="btn btn-primary" name="boton" value="registrar">registrar</button>
				</form>
			</div>
		</div>
	</div>
	<br>
	<script src="js/jquery-3.6.0.js"></script>
</body>
