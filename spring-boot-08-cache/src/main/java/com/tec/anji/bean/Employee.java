package com.tec.anji.bean;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Employee {

    private int id;

    private String lastName;

    private String email;

    private int gender;

    private int dId;
}
