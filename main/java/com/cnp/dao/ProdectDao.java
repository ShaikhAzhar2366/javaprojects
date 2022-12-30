package com.cnp.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.cnp.model.Coupon;
import com.cnp.model.Product;
import com.connection.Connection;

public class ProdectDao {
	public void save(Product product) {
		java.sql.Connection connection = Connection.getConnection();
		Coupon coupon=new Coupon();
		try {
			PreparedStatement statement = connection.prepareStatement("insert into product(name,description,price,couponcode,) values(?,?,?,?)");
			statement.setString(1, product.getDescription());
			statement.setString(2, product.getName());
			statement.setBigDecimal(3, product.getPrice());
			statement.setString(4, product.getCouponcode());
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
