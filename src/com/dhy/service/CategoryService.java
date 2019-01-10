package com.dhy.service;

import java.util.List;

import com.dhy.domain.Category;

public interface CategoryService {

	List<Category> findAll() throws Exception;

}
