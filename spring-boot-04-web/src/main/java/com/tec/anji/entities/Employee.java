package com.tec.anji.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Employee {

	private Integer id;

    private String lastName;

    private String email;

    private Integer gender;

    private Department department;

    private Date birth;
}
