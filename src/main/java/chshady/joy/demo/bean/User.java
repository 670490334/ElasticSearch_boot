package chshady.joy.demo.bean;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @Author 廖凡
 * @Date 2019/9/3 15:45
 */
@Entity
@Table(name = "user")
@Data
public class User {
    /**
     * 主键自增
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    private String name ;

    private String password;

    private String email;

    private int status;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "last_update_time")
    private Date lastUpdateTime;

    @Column(name = "last_login_time")
    private Date lastLoginTime;

    private String avatar;
}
