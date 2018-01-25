package com.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2018-01-24T10:11:17")
@StaticMetamodel(Data.class)
public class Data_ { 

    public static volatile SingularAttribute<Data, Long> id;
    public static volatile SingularAttribute<Data, Date> dateOfBirth;
    public static volatile SingularAttribute<Data, Integer> religionCode;
    public static volatile SingularAttribute<Data, String> placeOfBirth;
    public static volatile SingularAttribute<Data, Integer> educationCode;
    public static volatile SingularAttribute<Data, String> maritalstatus;
    public static volatile SingularAttribute<Data, String> currentAddress;
    public static volatile SingularAttribute<Data, String> name;
    public static volatile SingularAttribute<Data, Double> gpa;
    public static volatile SingularAttribute<Data, String> gender;
    public static volatile SingularAttribute<Data, Integer> programCode;
    public static volatile SingularAttribute<Data, String> expectedSalary;

}