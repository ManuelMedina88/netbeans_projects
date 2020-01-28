/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itdepartment.newtech.dao;

import com.itdepartment.newtech.domain.ExamAnswerds;
import java.util.List;

/**
 *
 * @author manuel
 */
public interface IAnswerdDao {
    
    public List<ExamAnswerds> listOfAnswerds();
    
}
