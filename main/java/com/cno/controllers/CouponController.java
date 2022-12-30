package com.cno.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cnp.dao.CouponDao;
import com.cnp.model.Coupon;

@WebServlet("/Coupons")
public class CouponController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CouponDao dao = new CouponDao();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");
		if (action.equals("create")) {
			createCoupon(request, response);
		} else if (action.equals("find")) {
			String coupon = request.getParameter("couponCode");
			Coupon coupon1 = dao.findByCode(coupon);
			if (coupon1 != null) {
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				out.print("<br>find is success</br>");
				out.print("<br>find is success</br> "+coupon1);
				
			}

		}

	}

	private void createCoupon(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String couponCode = request.getParameter("couponCode");
		String discount = request.getParameter("discount");
		String expiryDate = request.getParameter("expiryDate");
		Coupon coupon = new Coupon();
		coupon.setCode(couponCode);
		coupon.setDiscount(new BigDecimal(discount));
		coupon.setExpDate(expiryDate);
		dao.save(coupon);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<b>Coupon Created!!</b>");
		out.print("<br/><a href=''>Home</a>");
	}
}