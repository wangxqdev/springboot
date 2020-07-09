package com.tec.anji.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "atguigu", type = "book")
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Book {

    private Integer id;

    private String name;

    private String author;
}
