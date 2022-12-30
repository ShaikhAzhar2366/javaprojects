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
import com.cnp.dao.ProdectDao;
import com.cnp.model.Coupon;
import com.cnp.model.Product;
@WebServlet ("/products")
public class ProductController extends HttpServlet {
	CouponDao couponDao = new CouponDao();
	ProdectDao prodectDao = new ProdectDao();
	Product product = new Product();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String discription = req.getParameter("discription");
		String price = req.getParameter("price");
		String couponCode = req.getParameter("couponCode");
		Coupon coupon = couponDao.findByCode(couponCode);
		product.setDescription(discription);
		product.setName(name);
		product.setPrice(new BigDecimal(price).subtract(coupon.getDiscount()));
		prodectDao.save(product);
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.print("<b>Produc Created</b>");
		out.print("<br/><a href='/candpapp'>Home</a>");
	}

}
