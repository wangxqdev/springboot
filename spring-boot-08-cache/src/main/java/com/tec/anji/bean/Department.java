package com.tec.anji.bean;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class Department implements Serializable {

    private int id;

    private String departmentName;
}
