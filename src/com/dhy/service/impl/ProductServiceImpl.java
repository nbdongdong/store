package com.dhy.service.impl;

import java.util.List;

import com.dhy.dao.ProductDao;
import com.dhy.dao.impl.ProductDaoImpl;
import com.dhy.domain.PageBean;
import com.dhy.domain.Product;
import com.dhy.service.ProductService;

public class ProductServiceImpl implements ProductService{

	/**
	 * 查询最新商品
	 */
	@Override
	public List<Product> findNew() throws Exception {
		ProductDao pDao=new ProductDaoImpl();
		return pDao.findNew();
	}

	/**
	 * 查询热门
	 */
	@Override
	public List<Product> findHot() throws Exception {
		ProductDao pDao=new ProductDaoImpl();
		return pDao.findHot();
	}

	/**
	 * 查询单个商品详情
	 */
	@Override
	public Product getByPid(String pid) throws Exception {
		ProductDao pDao=new ProductDaoImpl();
		return pDao.getByPid(pid);
	}

	/**
	 * 按类别分页查询商品
	 */
	@Override
	public PageBean<Product> findByPage(int currPage, int pageSize, String cid) throws Exception {
		ProductDao pDao=new ProductDaoImpl();
		//当前页数据
		List<Product> list=pDao.findByPage(currPage,pageSize,cid); 
		
		//总条数
		int totalCount=pDao.getTotalCount(cid);
		
		return new PageBean<>(list, currPage, pageSize, totalCount);
	}

}
