package com.cnp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cnp.model.Coupon;
import com.cnp.util.ConnectionUtil;

public class CouponDao {
	public void save(Coupon coupon) {
		
		Connection connection=com.connection.Connection.getConnection();
		try {
			PreparedStatement statement = connection.prepareStatement("insert into coupon(code,discount,expdate) values(?,?,?)");
			statement.setString(1, coupon.getCode());
			statement.setBigDecimal(2, coupon.getDiscount());
			statement.setString(3, coupon.getExpDate());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public Coupon findByCode(String code) {
		Coupon coupon = new Coupon();
		Connection connection = com.connection.Connection.getConnection();
		try {
			PreparedStatement statement = connection.prepareStatement("select * from coupon where code=?");
			statement.setString(1, code);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				coupon.setCode(resultSet.getString(2));
				coupon.setDiscount(resultSet.getBigDecimal(3));
				coupon.setExpDate(resultSet.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return coupon;


}}



















