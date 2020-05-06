package com.tec.anji.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tbl_user")
@Data
@ToString
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "last_name")
    private String lastName;

    @Column
    private String email;
}
