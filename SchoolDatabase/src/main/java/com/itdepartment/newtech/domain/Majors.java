/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itdepartment.newtech.domain;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author manuel
 */
@Entity
@Table(name = "Majors")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Majors.findAll", query = "SELECT m FROM Majors m"),
    @NamedQuery(name = "Majors.findByMajorID", query = "SELECT m FROM Majors m WHERE m.majorID = :majorID"),
    @NamedQuery(name = "Majors.findByMajor", query = "SELECT m FROM Majors m WHERE m.major = :major")})
public class Majors implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "MajorID")
    private Integer majorID;
    @Size(max = 20)
    @Column(name = "Major")
    private String major;
    @OneToMany(mappedBy = "studMajor")
    private Collection<Students> studentsCollection;

    public Majors() {
    }

    public Majors(Integer majorID) {
        this.majorID = majorID;
    }

    public Integer getMajorID() {
        return majorID;
    }

    public void setMajorID(Integer majorID) {
        this.majorID = majorID;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    @XmlTransient
    public Collection<Students> getStudentsCollection() {
        return studentsCollection;
    }

    public void setStudentsCollection(Collection<Students> studentsCollection) {
        this.studentsCollection = studentsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (majorID != null ? majorID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Majors)) {
            return false;
        }
        Majors other = (Majors) object;
        if ((this.majorID == null && other.majorID != null) || (this.majorID != null && !this.majorID.equals(other.majorID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.itdepartment.newtech.domain.Majors[ majorID=" + majorID + " ]";
    }
    
}
