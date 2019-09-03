package chshady.joy.demo.repository;

import chshady.joy.demo.bean.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

/**
 * @Author 廖凡
 * @Date 2019/8/20 16:49
 */
@Component
public interface Bookrepository extends ElasticsearchRepository<Book,Integer> {

}
