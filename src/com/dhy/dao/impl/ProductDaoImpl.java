package com.dhy.dao.impl;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.dhy.dao.ProductDao;
import com.dhy.domain.Product;
import com.dhy.utils.DataSourceUtils;
import com.sun.org.apache.bcel.internal.generic.NEW;

public class ProductDaoImpl implements ProductDao{

	/**
	 * 查询最新商品
	 */
	@Override
	public List<Product> findNew() throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql="select * from product order by pdate limit 9";
		return qr.query(sql, new BeanListHandler<>(Product.class));
	}
 
	/**
	 * 查询热门商品
	 */
	@Override
	public List<Product> findHot() throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql="select * from product where is_hot = 1 order by pdate limit 9";
		return qr.query(sql, new BeanListHandler<>(Product.class));
	}

	/**
	 * 通过商品id 获取商品
	 */
	@Override
	public Product getByPid(String pid) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql="select * from product where pid = ? limit 1";
		return qr.query(sql, new BeanHandler<>(Product.class),pid);
	}

	/**
	 * 查询当前页需要展示的数据
	 */
	@Override
	public List<Product> findByPage(int currPage, int pageSize, String cid) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql="select * from product where cid = ? limit ?,?";
		return qr.query(sql, new BeanListHandler<>(Product.class ), cid,(currPage-1)*pageSize,pageSize);
	}

	/**
	 * 查询当前类别总条数
	 */
	@Override
	public int getTotalCount(String cid) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select count(*) from product where cid = ?";
		return ((Long)qr.query(sql, new ScalarHandler(),cid)).intValue();
	}

}