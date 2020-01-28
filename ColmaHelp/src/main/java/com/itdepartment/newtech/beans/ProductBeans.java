/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itdepartment.newtech.beans;

import com.itdepartment.newtech.domain.Products;
import com.itdepartment.newtech.helper.BeanHelper;
import com.itdepartment.newtech.service.IProductService;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

/**
 *
 * @author manuel
 */
@Named(value = "productBeans")
@SessionScoped
public class ProductBeans implements Serializable {

    private List<Products> list;
    private int productId;
    private String codebar_id;
    private String product_name;
    private double product_price;
    private int product_quantity;
    private String product_description;
    private String product_provider;
    private String provider_phone_number;
    private final IProductService services;

    /**
     * Creates a new instance of ProductBeans
     */
    public ProductBeans() {
        
        services = BeanHelper.getService();
        list = services.listOfProducts();

    }

    public List<Products> getList() {
        return list;
    }

    public void setList(List<Products> list) {
        this.list = list;
    }

    public String getCodebar_id() {
        return codebar_id;
    }

    public void setCodebar_id(String codebar_id) {
        this.codebar_id = codebar_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public double getProduct_price() {
        return product_price;
    }

    public void setProduct_price(double product_price) {
        this.product_price = product_price;
    }

    public int getProduct_quantity() {
        return product_quantity;
    }

    public void setProduct_quantity(int product_quantity) {
        this.product_quantity = product_quantity;
    }

    public String getProduct_description() {
        return product_description;
    }

    public void setProduct_description(String product_description) {
        this.product_description = product_description;
    }

    public String getProduct_provider() {
        return product_provider;
    }

    public void setProduct_provider(String product_provider) {
        this.product_provider = product_provider;
    }

    public String getProvider_phone_number() {
        return provider_phone_number;
    }

    public void setProvider_phone_number(String provider_phone_number) {
        this.provider_phone_number = provider_phone_number;
    }

    public String deleteProduct(int id) {

        System.out.println("Manuel : Erased");

        System.out.println(id);

        Products product = null;

        for (Products products : list) {
            if (products.getProductId() == id) {
                product = products;
            }
        }

        services.deleteProduct(product);

        updateList();

        return "warehouse.xhtml";
    }

    public String registerProduct() {

        return "register_product.xhtml";
    }

    public void updateList() {

        list = services.listOfProducts();

    }

    public void clearFields() {

        productId = 0;
        codebar_id = "";
        product_name = "";
        product_price = 0.0;
        product_quantity = 0;
        product_description = "";
        product_provider = "";
        provider_phone_number = "";

    }
    
    public void registerProductForm(){
    
        Products product;
        product = new Products(codebar_id, product_name, product_price, product_quantity, product_description, product_provider, provider_phone_number);
        
        services.registerProduct(product);
        
        clearFields();        
        
    }
    
    public String getProductDetails(Products product){
        
        Products productUnit = services.searchProduct(product);
        fillFields(productUnit);
        return "details.xhtml";
    }
    
    public void fillFields(Products product){
        
        productId = product.getProductId();
        codebar_id = product.getCodebarId();
        product_name = product.getProductName();
        product_price = product.getProductPrice();
        product_quantity = product.getProductQuantity();
        product_description = product.getProductDescription();
        product_provider = product.getProductProvider();
        provider_phone_number = product.getProviderPhoneNumber();
        
    }
    
    public String goBack(){
    
        clearFields();
        return "warehouse.xhtml";
    }
    
    public String updateProduct(Products product){
    
        Products productUnit = services.searchProduct(product);
        fillFields(productUnit);        
        return "edit_product.xhtml";
    }
    
    public String updateProductForm(){
        
       Products product = new Products(codebar_id, product_name, product_price, product_quantity, product_description, product_provider, provider_phone_number);
       product.setProductId(productId);
       services.updateProduct(product);
       clearFields();
       
       return "warehouse.xhtml";
    
    }
    
    public String currencyFormat(double money){
        
        NumberFormat format = NumberFormat.getCurrencyInstance(Locale.US);
        String currency = format.format(money);
        
        System.out.println(currency);
        
        return currency;
    }

}
