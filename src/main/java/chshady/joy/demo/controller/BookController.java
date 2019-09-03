package chshady.joy.demo.controller;

import chshady.joy.demo.bean.Book;
import chshady.joy.demo.repository.Bookrepository;
import com.google.common.collect.Lists;
import org.elasticsearch.index.query.QueryStringQueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

import java.util.List;

/**
 * @Author 廖凡
 * @Date 2019/8/20 16:51
 */
@RestController
public class BookController {
    @Autowired
    private Bookrepository bookrepository;

    @GetMapping("/save")
    public String save(){
        Book book = new Book();
        book.setBookName("西游记");
        book.setBookPrice(new BigDecimal(48.9));
        book.setId(001);
        //保存
        bookrepository.save(book);
        return "success";
    }
    @GetMapping("/delete")
    public String delete(){
        //通过id删除
        bookrepository.deleteById(001);
        return "success";
    }

    @GetMapping("/search")
    public List<Book> search( @PageableDefault(page = 1,value = 10) Pageable pageable){
        Iterable<Book> list = bookrepository.findAll();
        List<Book> bookList = Lists.newArrayList(list);
        return bookList;
    }
    @GetMapping("/query")
    public List<Book> queryString(@RequestParam("queryString") String queryString){
        QueryStringQueryBuilder queryStringQueryBuilder = new QueryStringQueryBuilder(queryString);
        Iterable<Book> list = bookrepository.search(queryStringQueryBuilder);
        return Lists.newArrayList(list);
    }



}
