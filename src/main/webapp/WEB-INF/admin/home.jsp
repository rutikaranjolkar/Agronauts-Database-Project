<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
				page="/WEB-INF/admin/leftNav.jsp"></jsp:include></td>
		<td>
			<table style="width: 100%;">
				<tr>
					<td><jsp:include page="/WEB-INF/admin/header.jsp"></jsp:include></td>
				</tr>
				<tr>
					<td style="vertical-align: top; padding: 20px;">
						<!-- Main Body starts here -->
						<table class="table table-hover">
							<tr>
								<td>Farmer name</td>
								<td>Date of request</td>
								<td>Address</td>
								<td>Area</td>
								<td>Location X1</td>
								<td>Location X2</td>
								<td>Location Y1</td>
								<td>Location Y2</td>
								<td>Location X3</td>
								<td>Location Y3</td>
								<td>Location X4</td>
								<td>Location Y4</td>

								<td>Action</td>
							</tr>
							<c:forEach items="${pendingRequests}" var="req">
								<tr>
									<td>${req.farmer.firstName}&nbsp;${req.farmer.lastName}</td>
									<td>${req.requestDate}</td>
									<td></td>
									<td>${req.area}</td>
									<td>${req.x1}</td>
									<td>${req.x2}</td>
									<td>${req.y1}</td>
									<td>${req.y2}</td>
									<td>${req.x3}</td>
									<td>${req.y3}</td>
									<td>${req.x4}</td>
									<td>${req.y4}</td>
									<td><script type="text/javascript">
									<!--
										function Warn1() {
											alert("Request approved!");
											document.write("Request approved!");
										}
									//-->
									</script> <a
										href="approveServiceRequest.html?decision=approve&id=${req.id}"
										class="btn btn-sm btn-success" role="button"
										onclick="Warn1();">Approve</a> <script type="text/javascript">
										<!--
											function Warn2() {
												alert("Request rejected!");
												document
														.write("Request rejected!");
											}
										//-->
										</script><a
										href="approveServiceRequest.html?decision=reject&id=${req.id}"
										class="btn btn-sm btn-danger" role="button" onclick="Warn2();">Reject</a></td>
								</tr>
							</c:forEach>
						</table> <!-- Main Body ends here -->
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
</html>