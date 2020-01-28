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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author manuel
 */
@Named(value = "sellBeans")
@SessionScoped
public class SellBeans implements Serializable {

    /**
     * Creates a new instance of SellBeans
     */
    
    private List<Products> sellList;
    private List<Products> warehouseProduct;
    private String codebar;
    private IProductService services;
    
    public SellBeans() {
        
        services = BeanHelper.getService();
        sellList = new ArrayList<Products>();
        codebar = "";
        warehouseProduct = services.listOfProducts();
        
    }

    public List<Products> getSellList() {
        return sellList;
    }

    public void setSellList(List<Products> sellList) {
        this.sellList = sellList;
    }

    public String getCodebar() {
        return codebar;
    }

    public void setCodebar(String codebar) {
        this.codebar = codebar;
    }

    public IProductService getServices() {
        return services;
    }

    public void setServices(IProductService services) {
        this.services = services;
    } 
    
    public void addProduct(){
      
      try{
          
        Products product = searchProduct();
        
        this.setCodebar("");

        if(product != null){

            sellList.add(product);

        }
      }catch(NullPointerException ex){

      }
      
    }
    
    public Products searchProduct(){
        
        Products productfound = null;
        
        for(Products product: warehouseProduct){
            if(product.getCodebarId().equals(codebar)){
                productfound = product;                
                break;
            }
        }
        
        warehouseProduct.add(productfound);
        
        return productfound; 
        
    }

    public List<Products> getWarehouseProduct() {
        return warehouseProduct;
    } 
    
    public double getTotal(){
    
        double total = 0;
        
        for(Products product: sellList)
            total += product.getProductPrice();
        
        return total;
    }
    
    
}
