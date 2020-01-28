/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itdepartment.newtech.service;

import com.itdepartment.newtech.dao.IProductDao;
import com.itdepartment.newtech.domain.Products;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author manuel
 */
@Stateless
public class ProductServiceImpl implements IProductService{
    
    @Inject
    private IProductDao dao;
    
    @Override
     public List<Products> listOfProducts(){
         return dao.listOfProducts();
     }

    @Override
    public void registerProduct(Products product) {
        dao.registerProduct(product);
    }

    @Override
    public void updateProduct(Products product) {
        dao.updateProduct(product);
    }

    @Override
    public void deleteProduct(Products product) {
        System.out.println("Pase aqui ahora2");
        dao.deleteProduct(product);
    }

    @Override
    public Products searchProduct(Products product) {
        return dao.searchProduct(product);
    }
    
}
