/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itdepartment.newtech.domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author manuel
 */
@Entity
@Table(name = "test_user_calification")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TestUserCalification.findAll", query = "SELECT t FROM TestUserCalification t"),
    @NamedQuery(name = "TestUserCalification.findByTestUserCalificationId", query = "SELECT t FROM TestUserCalification t WHERE t.testUserCalificationId = :testUserCalificationId"),
    @NamedQuery(name = "TestUserCalification.findByUserId", query = "SELECT t FROM TestUserCalification t WHERE t.userId = :userId"),
    @NamedQuery(name = "TestUserCalification.findByTestCalification", query = "SELECT t FROM TestUserCalification t WHERE t.testCalification = :testCalification")})
public class TestUserCalification implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "test_user_calification_id")
    private Integer testUserCalificationId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "user_id")
    private String userId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "test_calification")
    private String testCalification;

    public TestUserCalification() {
    }

    public TestUserCalification(Integer testUserCalificationId) {
        this.testUserCalificationId = testUserCalificationId;
    }

    public TestUserCalification(Integer testUserCalificationId, String userId, String testCalification) {
        this.testUserCalificationId = testUserCalificationId;
        this.userId = userId;
        this.testCalification = testCalification;
    }

    public Integer getTestUserCalificationId() {
        return testUserCalificationId;
    }

    public void setTestUserCalificationId(Integer testUserCalificationId) {
        this.testUserCalificationId = testUserCalificationId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTestCalification() {
        return testCalification;
    }

    public void setTestCalification(String testCalification) {
        this.testCalification = testCalification;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (testUserCalificationId != null ? testUserCalificationId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TestUserCalification)) {
            return false;
        }
        TestUserCalification other = (TestUserCalification) object;
        if ((this.testUserCalificationId == null && other.testUserCalificationId != null) || (this.testUserCalificationId != null && !this.testUserCalificationId.equals(other.testUserCalificationId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.itdepartment.newtech.domain.TestUserCalification[ testUserCalificationId=" + testUserCalificationId + " ]";
    }
    
}
