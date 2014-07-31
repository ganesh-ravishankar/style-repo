package com.style.product.service;

import java.util.List;

import com.style.exception.AppException;
import com.style.model.Branch;
import com.style.model.LabelValue;
import com.style.model.Partner;
import com.style.model.Product;
import com.style.model.ProductCategory;
import com.style.service.GenericManager;

/**
 * ProductManager Service Interface to handle communication between web and
 * persistence layer.
 * 
 * @author mathi
 */
public interface ProductManager extends GenericManager<Product, String> {

	/**
	 * get all products
	 * 
	 * @param start
	 * @param end
	 * @return
	 */
	List<Product> getAllProducts(int start, String[] brands, String[] categories)
			throws AppException;

	/**
	 * get all product categories
	 * 
	 * @return
	 */
	List<ProductCategory> getAllProductCategoriess() throws AppException;

	/**
	 * save partner
	 * 
	 * @param partner
	 * @return
	 */
	Partner savePartner(Partner partner) throws AppException;

	/**
	 * save branch
	 * 
	 * @param branch
	 * @return
	 */
	Branch saveBranch(Branch branch) throws AppException;

	/**
	 * save category
	 * 
	 * @param category
	 * @return
	 */
	ProductCategory saveCategory(ProductCategory category) throws AppException;

	/**
	 * save product
	 * 
	 * @param product
	 * @return
	 */
	Product saveProduct(Product product) throws AppException;

	/**
	 * 
	 * @param branchIds
	 * @return
	 */
	List<Branch> getBranches(String[] branchIds) throws AppException;

	/**
	 * Return all the product categories
	 * 
	 * @return
	 */
	List<LabelValue> getAllProductCategories() throws AppException;

	/**
	 * Return all the partners
	 * 
	 * @return
	 */
	List<LabelValue> getAllPartners() throws AppException;

	/**
	 * Returns all the branches
	 * 
	 * @return
	 */
	List<LabelValue> getAllBranches() throws AppException;

	/**
	 * Return all the product categories
	 * 
	 * @return
	 */
	List<ProductCategory> getProductCategories() throws AppException;

	/**
	 * Return all the partners
	 * 
	 * @return
	 */
	List<Partner> getPartners() throws AppException;

	/**
	 * Returns all the branches
	 * 
	 * @return
	 */
	List<Branch> getBranches() throws AppException;

}
