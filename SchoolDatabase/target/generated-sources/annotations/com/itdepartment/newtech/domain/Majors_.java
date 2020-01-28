package com.itdepartment.newtech.domain;

import com.itdepartment.newtech.domain.Students;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-11-17T10:10:59")
@StaticMetamodel(Majors.class)
public class Majors_ { 

    public static volatile SingularAttribute<Majors, Integer> majorID;
    public static volatile SingularAttribute<Majors, String> major;
    public static volatile CollectionAttribute<Majors, Students> studentsCollection;

}