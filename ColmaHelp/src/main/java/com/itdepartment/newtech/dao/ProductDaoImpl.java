/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itdepartment.newtech.dao;

import com.itdepartment.newtech.domain.Products;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author manuel
 */
@Stateless
public class ProductDaoImpl implements IProductDao{
    
    @PersistenceContext(name  = "com.itdepartment.newtech_ColmaHelp_war_1.0PU")
    EntityManager em;
    
    @Override
    public List<Products> listOfProducts(){
            return em.createNamedQuery("Products.findAll").getResultList();       
    }

    @Override
    public void registerProduct(Products product) {
        em.persist(product);
    }

    @Override
    public void updateProduct(Products product) {
        em.merge(product);
    }

    @Override
    public void deleteProduct(Products product) {
        System.out.println("Pase aqui ahora1");
        Products foundProduct = em.find(Products.class, product.getProductId());
        em.remove(foundProduct);
    }

    @Override
    public Products searchProduct(Products product) {
        return em.find(Products.class, product.getProductId());
    }       
    
}
