package com.tec.anji.bean;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class Employee implements Serializable {

    private int id;

    private String lastName;

    private String email;

    private int gender;

    private int dId;
}
