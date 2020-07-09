package com.tec.anji.repository;

import com.tec.anji.bean.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface BookRepository extends ElasticsearchRepository<Book, Integer> {

    List<Book> findBooksByNameLike(String name);
}
