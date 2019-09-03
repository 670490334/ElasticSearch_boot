package chshady.joy.demo;

import chshady.joy.demo.bean.Book;
import chshady.joy.demo.repository.Bookrepository;
import com.alibaba.fastjson.JSON;
import org.checkerframework.checker.units.qual.A;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    private static final String INDEX_NAME = "book"; //定义索引
    private static final String INDEX_TYPE = "goods";//定义类型
    @Autowired
    ElasticsearchTemplate template ;
    @Test
    public void contextLoads() {
        List<Book> list = new ArrayList<>();
        int i = 1;
        for (int a = 0 ; a <30;a++){
            Book book = new Book();
            book.setId(a);
            book.setBookPrice(new BigDecimal(a*100));
            book.setBookName("海贼王"+0+0+i++);
            list.add(book);
        }
        if(!template.indexExists(INDEX_NAME)){
            template.createIndex(INDEX_NAME);
        }
        template.putMapping(Book.class);
        List<IndexQuery> indexQueries = new ArrayList<>();
        for (Book b:list){
            IndexQuery indexQuery = new IndexQuery();
            indexQuery.setId(b.getId().toString());
            indexQuery.setIndexName(INDEX_NAME);
            indexQuery.setType(INDEX_TYPE);
            indexQuery.setSource(JSON.toJSONString(b));
            indexQueries.add(indexQuery);
        }
        //批量提交
        template.bulkIndex(indexQueries);
    }

}
