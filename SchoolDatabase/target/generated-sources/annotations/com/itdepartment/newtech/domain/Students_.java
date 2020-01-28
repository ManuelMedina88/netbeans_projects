package com.itdepartment.newtech.domain;

import com.itdepartment.newtech.domain.Majors;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-11-17T10:10:59")
@StaticMetamodel(Students.class)
public class Students_ { 

    public static volatile SingularAttribute<Students, String> studPhoneNumber;
    public static volatile SingularAttribute<Students, String> studLastName;
    public static volatile SingularAttribute<Students, String> studFirstName;
    public static volatile SingularAttribute<Students, Majors> studMajor;
    public static volatile SingularAttribute<Students, String> studState;
    public static volatile SingularAttribute<Students, Integer> studentID;
    public static volatile SingularAttribute<Students, String> studGender;
    public static volatile SingularAttribute<Students, String> studStreetAddress;
    public static volatile SingularAttribute<Students, String> studAreaCode;
    public static volatile SingularAttribute<Students, String> studCity;
    public static volatile SingularAttribute<Students, String> studZipCode;
    public static volatile SingularAttribute<Students, Date> studBirthDate;
    public static volatile SingularAttribute<Students, String> studMaritalStatus;

}