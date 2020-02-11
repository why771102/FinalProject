package com.t.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.paypal.api.payments.PayerInfo;
import com.paypal.api.payments.Payment;
import com.paypal.api.payments.ShippingAddress;
import com.paypal.api.payments.Transaction;
import com.paypal.base.rest.PayPalRESTException;
import com.t.model.OrderDetail;
import com.t.model.PaypalBean;
import com.t.service.PaymentServices2;


@Controller
public class PaypalController2 {
	
	@RequestMapping("/paypal")
	public String toPaypal() {
		return "t/checkout";
	}
	
	//金額和產品名稱寫這裡
	//subtotal 和 total要長一樣
	@RequestMapping(value = "/authorize_payment2", method = RequestMethod.POST)
	public void toPaypal(PaypalBean pb,HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String product = ("76影城線上商城");
		String subtotal = request.getParameter("total");
		String shipping = "0";
		String tax = "0";
		String total = request.getParameter("total");
		
		OrderDetail orderDetail = new OrderDetail(product, subtotal, shipping, tax, total);

		try {
			PaymentServices2 paymentServices = new PaymentServices2();
			String approvalLink = paymentServices.authorizePayment(orderDetail);

			response.sendRedirect(approvalLink);
			
		} catch (PayPalRESTException ex) {
			request.setAttribute("errorMessage", ex.getMessage());
			ex.printStackTrace();
			request.getRequestDispatcher("WEB-INF/views/t/error.jsp").forward(request, response);
		}	
		
	}
	
	@RequestMapping("/review_payment2")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String paymentId = request.getParameter("paymentId");
		String payerId = request.getParameter("PayerID");
		
		try {
			PaymentServices2 paymentServices = new PaymentServices2();
			Payment payment = paymentServices.getPaymentDetails(paymentId);
			
			PayerInfo payerInfo = payment.getPayer().getPayerInfo();
			Transaction transaction = payment.getTransactions().get(0);
			ShippingAddress shippingAddress = transaction.getItemList().getShippingAddress();
			
			request.setAttribute("payer", payerInfo);
			request.setAttribute("transaction", transaction);
			request.setAttribute("shippingAddress", shippingAddress);
			
			String url = "WEB-INF/views/t/review2.jsp?paymentId=" + paymentId + "&PayerID=" + payerId;
			
			request.getRequestDispatcher(url).forward(request, response);
			
		} catch (PayPalRESTException ex) {
			request.setAttribute("errorMessage", ex.getMessage());
			ex.printStackTrace();
			request.getRequestDispatcher("WEB-INF/views/t/error.jsp").forward(request, response);
		}	
		
	}
	
	@RequestMapping("/execute_payment2")
	protected String doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String paymentId = request.getParameter("paymentId");
		String payerId = request.getParameter("PayerID");

		try {
			PaymentServices2 paymentServices = new PaymentServices2();
			Payment payment = paymentServices.executePayment(paymentId, payerId);
			
			PayerInfo payerInfo = payment.getPayer().getPayerInfo();
			Transaction transaction = payment.getTransactions().get(0);
			
			request.setAttribute("payer", payerInfo);
			request.setAttribute("transaction", transaction);			

			return "redirect:/orderconfirmOK";
					
		} catch (PayPalRESTException ex) {
			request.setAttribute("errorMessage", ex.getMessage());
			ex.printStackTrace();
			return "redirect:/movieIndex";
		}
	}
	
}
