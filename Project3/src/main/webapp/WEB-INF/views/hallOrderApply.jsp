<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"
	integrity="sha256-ZosEbRLbNQzLpnKIkEdrPv7lOy9C27hHQ+Xp8a4MxAQ="
	crossorigin="anonymous"></script>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<!-- stylesheets -->
<link rel="stylesheet" href="../css/bootstrap.min.css">
<link rel="stylesheet" href="../css/font-awesome.min.css">
<link rel="stylesheet" href="../css/flexslider.css">
<link rel="stylesheet" href="../css/style.css">
<link rel="stylesheet" href="../css/responsive.css">

<title>包廳申請</title>

</head>
<body>
	<header>
		<jsp:include page="a/header.jsp">
			<jsp:param name="a" value="1" />
		</jsp:include>
	</header>
	<section class="login-block">
		<div class="container">
			<div class="login-inner">
				<h2>包廳申請</h2>
				<div class="login-form">
					<table>

						<form:form method='POST' modelAttribute="hallOrderBean"
							enctype="multipart/form-data">

							<fieldset>

								<tr>
									<td>租借日期:</td>
									<td><form:input id="date" path="orderDate" type='date' /></td>
								</tr>

								<tr>
									<td>租借起始時間:</td>
									<td><form:select id="startTime" path="startTime">
											<form:option value="-1">請選擇</form:option>
											<form:option value="09:00">09:00</form:option>
											<form:option value="10:00">10:00</form:option>
											<form:option value="11:00">11:00</form:option>
											<form:option value="12:00">12:00</form:option>
											<form:option value="13:00">13:00</form:option>
											<form:option value="14:00">14:00</form:option>
											<form:option value="15:00">15:00</form:option>
											<form:option value="16:00">16:00</form:option>
											<form:option value="17:00">17:00</form:option>
											<form:option value="18:00">18:00</form:option>
											<form:option value="19:00" id="start1">19:00</form:option>
											<form:option value="20:00">20:00</form:option>
											<form:option value="21:00">21:00</form:option>
											<form:option value="22:00">22:00</form:option>
											<form:option value="23:00">23:00</form:option>
										</form:select></td>
								</tr>
								<tr>
									<td>租借結束時間:</td>
									<td><form:select id="endTime" path="endTime">
											<form:option value="-1">請選擇</form:option>
											<form:option value="09:00">09:00</form:option>
											<form:option value="10:00">10:00</form:option>
											<form:option value="11:00">11:00</form:option>
											<form:option value="12:00">12:00</form:option>
											<form:option value="13:00">13:00</form:option>
											<form:option value="14:00">14:00</form:option>
											<form:option value="15:00">15:00</form:option>
											<form:option value="16:00">16:00</form:option>
											<form:option value="17:00">17:00</form:option>
											<form:option value="18:00">18:00</form:option>
											<form:option value="19:00">19:00</form:option>
											<form:option value="20:00">20:00</form:option>
											<form:option value="21:00" id="end1">21:00</form:option>
											<form:option value="22:00">22:00</form:option>
											<form:option value="23:00">23:00</form:option>
										</form:select></td>
								</tr>
								<tr>
									<td>選擇影廳:</td>
									<td><form:select path="hallID" id="hallID">
											<form:option value="-1">
									請選擇
								</form:option>
											<form:options items="${hallList}" />
										</form:select></td>
								</tr>
								<tr>
									<td>包廳總時數:</td>
									<td><form:input id="orderHours" path="orderHours"
											type='text' readonly="true" /></td>
								</tr>
								<tr>
									<td>包廳目的:</td>
									<td><form:select id="hallPurpose" path="hallPurpose">
											<form:option value="-1">請選擇</form:option>
											<form:option value="求婚">求婚</form:option>
											<form:option value="企業包場">企業包場</form:option>
											<form:option value="片商活動" id="purpose">片商活動</form:option>
											<form:option value="其他">其他</form:option>
										</form:select></td>
								</tr>
								<tr>
									<td>原因詳述:</td>
									<td><form:textarea cols="30" rows="5"
											id="hallPurposeDetail" path="hallPurposeDetail"
											type='textarea'></form:textarea></td>
								</tr>
								<tr>
									<td>預估包廳總金額:</td>
									<td><form:input id="hallSubtotal" path="hallSubtotal"
											type='text' readonly="true" /></td>
								</tr>
								<tr>
									<td>連絡人:</td>
									<td><form:input id="contactPerson" path="contactPerson"
											type='text' /></td>
								</tr>
								<tr>
									<td>連絡電話:</td>
									<td><form:input id="mobile" path="mobile" type='text' /></td>
								</tr>
								<tr>
									<td>電子郵件:</td>
									<td><form:input id="mail" path="mail" type='text' /></td>
								</tr>
								<tr>
									<td><form:input id="hallOrderStatusNo"
											path="hallOrderStatusNo" value="0" type='hidden' /></td>
								</tr>
								<tr>
									<td><form:input id="payStatusNo" path="payStatusNo"
											value="0" type='hidden' /></td>
								</tr>
								<tr>
									<td colspan="2"><input type='submit' value="送出申請"
										class="inlog-btn" /></td>
									<%-- 									<td><a href="<c:url value='/'/>" class="inlog-btn" >回首頁</a></td> --%>
								</tr>
							</fieldset>
						</form:form>
						<tr>
							<td colspan="2"><input type='button' value="回首頁"
								onclick="javascript:location.href='<c:url value='/'/>'"
								class="inlog-btn" /></td>
						</tr>
						<tr>
							<td colspan="2"><input type='button' id="sumit2"
								value="一鍵輸入" class="inlog-btn" /></td>
						</tr>
					</table>
				</div>
			</div>
		</div>
	</section>
	<!-- footer -->
	<footer>

		<jsp:include page="a/footer.jsp">
			<jsp:param name="a" value="1" />
		</jsp:include>

	</footer>

	<!-- footer -->
	<script>
		var s;
		var e;
		var h;

		$("#startTime").change(function() {
			s = $("#startTime").val().substring(0, 2);
			$("#endTime").change(function() {
				e = $("#endTime").val().substring(0, 2);
				$("#hallID").change(function() {
					h = $("#hallID").val();
					if (s != null && e != null && h != null) {
						var s2 = parseInt(s);
						var e2 = parseInt(e);
						var hours = e2 - s2;
						var price;
						if (h == "A" || h == "B" || h == "C" || h == "D") {
							price = parseInt("80000");
						} else {
							price = parseInt("40000");
						}
						var st = (hours) * price;
						if (hours <= 0) {
							alert("時間輸入有誤!請重新輸入");
							$("#orderHours").val("時間輸入有誤");
							$("#hallSubtotal").val("0");
						} else {
							$("#orderHours").val(hours);
							$("#hallSubtotal").val(st);
						}
					}
				});
				if (s != null && e != null && h != null) {
					var s2 = parseInt(s);
					var e2 = parseInt(e);
					var hours = e2 - s2;
					var price;
					if (h == "A" || h == "B" || h == "C" || h == "D") {
						price = parseInt("80000");
					} else {
						price = parseInt("40000");
					}
					var st = (hours) * price;
					if (hours <= 0) {
						alert("時間輸入有誤!請重新輸入");
						$("#orderHours").val("時間輸入有誤");
						$("#hallSubtotal").val("0");
					} else {
						$("#orderHours").val(hours);
						$("#hallSubtotal").val(st);
					}
				}
			});
			if (s != null && e != null && h != null) {
				var s2 = parseInt(s);
				var e2 = parseInt(e);
				var hours = e2 - s2;
				var price;
				if (h == "A" || h == "B" || h == "C" || h == "D") {
					price = parseInt("80000");
				} else {
					price = parseInt("40000");
				}
				var st = (hours) * price;
				if (hours <= 0) {
					alert("時間輸入有誤!請重新輸入");
					$("#orderHours").val("時間輸入有誤");
					$("#hallSubtotal").val("0");
				} else {
					$("#orderHours").val(hours);
					$("#hallSubtotal").val(st);
				}
			}

		});
		
		$("#sumit2").click(function(){
			$("#date").val("2020-03-09");
			$("#purpose").prop("selected", true);
			$("#hallPurposeDetail").val("我們是XXX公司，想租借貴戲院影廳來舉辦新國片演員見面會");
			$("#contactPerson").val("溫努比");
			$("#mobile").val("0918362789");
			$("#mail").val("p29296848@gmail.com");
			
			
// 			$("#start1").prop("selected", true);
// 			$("#end1").prop("selected", true);
// 			$("#purpose").prop("selected", true);
			
			
// 			$("#female").prop("checked", true);
// 			$("#uID").val("B123456789");
// 			$("#birth").val("1990-02-02");
// 			$("#mobile").val("0918362789");
// 			$("#email").val("allyli1234@gmail.com");
// 			$("#address").val("台北市大安區復興南路一段390號15樓");
		});
	</script>
</body>
</html>
