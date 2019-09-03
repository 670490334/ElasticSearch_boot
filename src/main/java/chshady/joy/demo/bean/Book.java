package chshady.joy.demo.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.math.BigDecimal;

/**
 * @Author 廖凡
 * @Date 2019/8/20 16:39
 */
@Data
//indexName索引名称 可以理解为数据库名 必须为小写 不然会报org.elasticsearch.indices.InvalidIndexNameException异常
//type类型 可以理解为表名
@Document(indexName = "book",type = "goods")
public class Book {

    @Id
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("bookName")
    private String bookName;
    @JsonProperty("bookPrice")
    private BigDecimal bookPrice;

}
