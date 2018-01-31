<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<table style="width: 100%;">
	<tr>
		<td width="200" style="vertical-align: top;"><jsp:include
				page="/WEB-INF/farmer/leftNav.jsp"></jsp:include></td>
		<td>
			<table style="width: 100%;">
				<tr>
					<td><jsp:include page="/WEB-INF/farmer/header.jsp"></jsp:include></td>
				</tr>
				<tr>
					<td style="vertical-align: top; padding: 20px;">
						<!-- Main Body starts here -->
						<form method="post" action="saveFarmerRequest.html">
							Farm address: <input name="farmAddress" /> <br /> Farm area: <input
								type="number" name="farmArea" min="0" step="0.01" /> <br />

							GPS X1: <input name="farmLocX1" step="0.01" /> <br /> GPS Y1: <input
								name="farmLocY1" step="0.01" /> <br /> GPS X2: <input
								name="farmLocX2" step="0.01" /> <br /> GPS Y2: <input
								name="farmLocY2" step="0.01" /> <br /> GPS X3: <input
								name="farmLocX3" step="0.01" /> <br /> GPS Y3: <input
								name="farmLocY3" step="0.01" /> <br /> GPS X4: <input
								name="farmLocX4" step="0.01" /> <br /> GPS Y4: <input
								name="farmLocY4" step="0.01" /> <br /> Crop Category: <br>
							<br> A. Summer: <br> <input type="checkbox"
								name="Scrop" value="Rice">Rice <input type="checkbox"
								name="Scrop" value="Cotton">Cotton <input
								type="checkbox" name="Scrop" value="Barley">Barley <input
								type="checkbox" name="Scrop" value="Soya">Soya <br>
							<br> B. Winter: <br> <input type="checkbox"
								name="Wcrop" value="Rice">Rice <input type="checkbox"
								name="Wcrop" value="Cotton">Cotton <input
								type="checkbox" name="Wcrop" value="Barley">Barley <input
								type="checkbox" name="Wcrop" value="Soya">Soya <br>
							<br> <input type="submit" />
						</form> <!-- Main Body ends here -->
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
</html>