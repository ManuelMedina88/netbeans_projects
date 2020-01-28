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
@Table(name = "exam_answerds")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ExamAnswerds.findAll", query = "SELECT e FROM ExamAnswerds e"),
    @NamedQuery(name = "ExamAnswerds.findByAnswerdId", query = "SELECT e FROM ExamAnswerds e WHERE e.answerdId = :answerdId"),
    @NamedQuery(name = "ExamAnswerds.findByAnswer", query = "SELECT e FROM ExamAnswerds e WHERE e.answer = :answer")})
public class ExamAnswerds implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "answerd_id")
    private Integer answerdId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 90)
    @Column(name = "answer")
    private String answer;

    public ExamAnswerds() {
    }

    public ExamAnswerds(Integer answerdId) {
        this.answerdId = answerdId;
    }

    public ExamAnswerds(Integer answerdId, String answer) {
        this.answerdId = answerdId;
        this.answer = answer;
    }

    public Integer getAnswerdId() {
        return answerdId;
    }

    public void setAnswerdId(Integer answerdId) {
        this.answerdId = answerdId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (answerdId != null ? answerdId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ExamAnswerds)) {
            return false;
        }
        ExamAnswerds other = (ExamAnswerds) object;
        if ((this.answerdId == null && other.answerdId != null) || (this.answerdId != null && !this.answerdId.equals(other.answerdId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.itdepartment.newtech.domain.ExamAnswerds[ answerdId=" + answerdId + " ]";
    }
    
}
