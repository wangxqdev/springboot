package com.tec.anji;

import com.tec.anji.bean.Article;
import com.tec.anji.bean.Book;
import com.tec.anji.repository.BookRepository;
import io.searchbox.client.JestClient;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ElasticMainApplicationTest {

    @Autowired
    private JestClient jestClient;

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void testIndexUsingJest() {
        Article article = new Article(1, "zhangsan", "很精彩", "Hello World");
        Index index = new Index.Builder(article).index("atguigu").type("news").build();
        try {
            jestClient.execute(index);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSearchUsingJest() {
        String query = "{\n" +
                "    \"query\" : {\n" +
                "        \"match_phrase\" : {\n" +
                "            \"content\" : \"hello\"\n" +
                "        }\n" +
                "    },\n" +
                "    \"highlight\": {\n" +
                "        \"fields\" : {\n" +
                "            \"content\" : {}\n" +
                "        }\n" +
                "    }\n" +
                "}";
        Search search = new Search.Builder(query).build();
        try {
            SearchResult result = jestClient.execute(search);
            System.out.println(result.getJsonString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testIndexUsingSpringData() {
        Book book = new Book(1, "西游记", "吴承恩");
        bookRepository.index(book);
    }

    @Test
    public void testSearchUsingSpringData() {
        List<Book> books = bookRepository.findBooksByNameLike("游");
        System.out.println(books.toString());
    }
}
