/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itdepartment.newtech.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author manuel
 */
@Entity
@Table(name = "Students")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Students.findAll", query = "SELECT s FROM Students s"),
    @NamedQuery(name = "Students.findByStudentID", query = "SELECT s FROM Students s WHERE s.studentID = :studentID"),
    @NamedQuery(name = "Students.findByStudFirstName", query = "SELECT s FROM Students s WHERE s.studFirstName = :studFirstName"),
    @NamedQuery(name = "Students.findByStudLastName", query = "SELECT s FROM Students s WHERE s.studLastName = :studLastName"),
    @NamedQuery(name = "Students.findByStudStreetAddress", query = "SELECT s FROM Students s WHERE s.studStreetAddress = :studStreetAddress"),
    @NamedQuery(name = "Students.findByStudCity", query = "SELECT s FROM Students s WHERE s.studCity = :studCity"),
    @NamedQuery(name = "Students.findByStudState", query = "SELECT s FROM Students s WHERE s.studState = :studState"),
    @NamedQuery(name = "Students.findByStudZipCode", query = "SELECT s FROM Students s WHERE s.studZipCode = :studZipCode"),
    @NamedQuery(name = "Students.findByStudAreaCode", query = "SELECT s FROM Students s WHERE s.studAreaCode = :studAreaCode"),
    @NamedQuery(name = "Students.findByStudPhoneNumber", query = "SELECT s FROM Students s WHERE s.studPhoneNumber = :studPhoneNumber"),
    @NamedQuery(name = "Students.findByStudBirthDate", query = "SELECT s FROM Students s WHERE s.studBirthDate = :studBirthDate"),
    @NamedQuery(name = "Students.findByStudGender", query = "SELECT s FROM Students s WHERE s.studGender = :studGender"),
    @NamedQuery(name = "Students.findByStudMaritalStatus", query = "SELECT s FROM Students s WHERE s.studMaritalStatus = :studMaritalStatus")})
public class Students implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "StudentID")
    private Integer studentID;
    @Size(max = 25)
    @Column(name = "StudFirstName")
    private String studFirstName;
    @Size(max = 25)
    @Column(name = "StudLastName")
    private String studLastName;
    @Size(max = 50)
    @Column(name = "StudStreetAddress")
    private String studStreetAddress;
    @Size(max = 30)
    @Column(name = "StudCity")
    private String studCity;
    @Size(max = 2)
    @Column(name = "StudState")
    private String studState;
    @Size(max = 5)
    @Column(name = "StudZipCode")
    private String studZipCode;
    @Size(max = 5)
    @Column(name = "StudAreaCode")
    private String studAreaCode;
    @Size(max = 8)
    @Column(name = "StudPhoneNumber")
    private String studPhoneNumber;
    @Column(name = "StudBirthDate")
    @Temporal(TemporalType.DATE)
    private Date studBirthDate;
    @Size(max = 1)
    @Column(name = "StudGender")
    private String studGender;
    @Size(max = 1)
    @Column(name = "StudMaritalStatus")
    private String studMaritalStatus;
    @JoinColumn(name = "StudMajor", referencedColumnName = "MajorID")
    @ManyToOne
    private Majors studMajor;

    public Students() {
    }

    public Students(Integer studentID) {
        this.studentID = studentID;
    }

    public Integer getStudentID() {
        return studentID;
    }

    public void setStudentID(Integer studentID) {
        this.studentID = studentID;
    }

    public String getStudFirstName() {
        return studFirstName;
    }

    public void setStudFirstName(String studFirstName) {
        this.studFirstName = studFirstName;
    }

    public String getStudLastName() {
        return studLastName;
    }

    public void setStudLastName(String studLastName) {
        this.studLastName = studLastName;
    }

    public String getStudStreetAddress() {
        return studStreetAddress;
    }

    public void setStudStreetAddress(String studStreetAddress) {
        this.studStreetAddress = studStreetAddress;
    }

    public String getStudCity() {
        return studCity;
    }

    public void setStudCity(String studCity) {
        this.studCity = studCity;
    }

    public String getStudState() {
        return studState;
    }

    public void setStudState(String studState) {
        this.studState = studState;
    }

    public String getStudZipCode() {
        return studZipCode;
    }

    public void setStudZipCode(String studZipCode) {
        this.studZipCode = studZipCode;
    }

    public String getStudAreaCode() {
        return studAreaCode;
    }

    public void setStudAreaCode(String studAreaCode) {
        this.studAreaCode = studAreaCode;
    }

    public String getStudPhoneNumber() {
        return studPhoneNumber;
    }

    public void setStudPhoneNumber(String studPhoneNumber) {
        this.studPhoneNumber = studPhoneNumber;
    }

    public Date getStudBirthDate() {
        return studBirthDate;
    }

    public void setStudBirthDate(Date studBirthDate) {
        this.studBirthDate = studBirthDate;
    }

    public String getStudGender() {
        return studGender;
    }

    public void setStudGender(String studGender) {
        this.studGender = studGender;
    }

    public String getStudMaritalStatus() {
        return studMaritalStatus;
    }

    public void setStudMaritalStatus(String studMaritalStatus) {
        this.studMaritalStatus = studMaritalStatus;
    }

    public Majors getStudMajor() {
        return studMajor;
    }

    public void setStudMajor(Majors studMajor) {
        this.studMajor = studMajor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (studentID != null ? studentID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Students)) {
            return false;
        }
        Students other = (Students) object;
        if ((this.studentID == null && other.studentID != null) || (this.studentID != null && !this.studentID.equals(other.studentID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.itdepartment.newtech.domain.Students[ studentID=" + studentID + " ]";
    }
    
}
