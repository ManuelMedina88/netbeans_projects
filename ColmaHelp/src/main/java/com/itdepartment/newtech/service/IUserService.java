/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itdepartment.newtech.service;

import com.itdepartment.newtech.domain.Users;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author manuel
 */
@Remote
public interface IUserService {    
    
    public List<Users> listOfUsers();
    
}
