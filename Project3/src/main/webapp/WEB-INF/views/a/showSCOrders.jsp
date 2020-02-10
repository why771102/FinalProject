<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>76影城</title>
<style>
div.shop_details, div.order_history {
    border: 2px solid rgb(227, 231, 220);
}
.VH_padding3 {
    padding: 3vh;
}
.wrapList {
    display: flex;
    flex-flow: column nowrap;
    justify-content: flex-start;
    align-items: flex-start;
    width: 100%;
    /* height: 100%; */
    box-sizing: border-box;
    padding: 0% 1% 1% 1%;
}

</style>
</head>
<body>
	<div class="login-inner">
		<h2>訂單內容</h2>
		<div class="login-form">
			<div class="shop_details wrapList VH_padding3">
				<div class="end_gray_border wrapRowStart">
					<p class="text">Order Date</p>
					<p class="text">Order Date</p>
				</div>

				<div class=" wrapList end_gray_border  ">
					<div class="shop_products wrapRowBtw">
						<div class="wrapRowStart width60">
							<div id="prodimage">
								<img src="img/order_v2.png" alt="">
							</div>
							<div id="prod_des">polka dot cat crop t-shirt: navy</div>
						</div>
						<div class="wrapRowStart shopping_detail">
							<div class=" VH_RL_padding4 " id="prod_quantity ">X 1</div>
							<div id="prod_price">NT$369</div>
						</div>


					</div>
					<div class="shop_products wrapRowBtw">
						<div class="wrapRowStart width60">
							<div id="prodimage">
								<img src="img/order_v2.png" alt="">
							</div>
							<div id="prod_des">polka dot cat crop t-shirt: natural</div>
						</div>
						<div class="wrapRowStart shopping_detail">
							<div class=" VH_RL_padding4 " id="prod_quantity ">X 1</div>
							<div id="prod_price">NT$369</div>
						</div>
					</div>
					<div class="shop_products wrapRowBtw">
						<div class="wrapRowStart width60">
							<div id="prodimage">
								<img src="img/order_v2.png" alt="">
							</div>
							<div id="prod_des">polka dot cat crop t-shirt: pink</div>
						</div>
						<div class="wrapRowStart shopping_detail">
							<div class=" VH_RL_padding4 " id="prod_quantity ">X 1</div>
							<div id="prod_price">NT$369</div>
						</div>
					</div>
					<div class="shop_products wrapRowBtw">
						<div class="wrapRowStart width60">
							<div id="prodimage">
								<img src="img/order_v2.png" alt="">
							</div>
							<div id="prod_des">polka dot cat crop t-shirt: white</div>
						</div>
						<div class="wrapRowStart shopping_detail">
							<div class=" VH_RL_padding4 " id="prod_quantity ">X 1</div>
							<div id="prod_price">NT$369</div>
						</div>
					</div>
				</div>
			</div>
			
		</div>
	</div>
</body>
</html>