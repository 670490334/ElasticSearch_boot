package chshady.joy.demo.repository;

import chshady.joy.demo.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author 廖凡
 * @Date 2019/9/3 15:52
 */
public interface UserRepository extends JpaRepository<User,Long> {
}
