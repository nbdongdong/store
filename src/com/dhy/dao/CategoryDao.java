package com.dhy.dao;

import java.util.List;

import com.dhy.domain.Category;

public interface CategoryDao {

	List<Category> findAll() throws Exception;

}
