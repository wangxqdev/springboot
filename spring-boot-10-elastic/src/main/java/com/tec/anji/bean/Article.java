package com.tec.anji.bean;

import io.searchbox.annotations.JestId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Article implements Serializable {

    @JestId
    private Integer id;

    private String author;

    private String title;

    private String content;
}
