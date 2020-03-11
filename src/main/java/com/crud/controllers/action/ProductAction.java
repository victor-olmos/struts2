package com.crud.controllers.action;



import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.crud.entities.Product;
import com.crud.services.ProductService;
import com.opensymphony.xwork2.ActionSupport;

@Namespace("/product")
public class ProductAction extends ActionSupport {
	
	@Autowired
	private ProductService productService;
	
	private List<Product> products;
	
	
	
	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	@Action(value = "index", results = {
			@Result(name = SUCCESS, location = "/WEB-INF/views/product/index.jsp")
	})
	public String index() {
		this.products = this.productService.findAll();
		return SUCCESS;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

}
