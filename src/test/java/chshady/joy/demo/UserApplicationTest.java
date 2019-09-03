package chshady.joy.demo;

import chshady.joy.demo.bean.User;
import chshady.joy.demo.repository.UserRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Author 廖凡
 * @Date 2019/9/3 15:59
 */
public class UserApplicationTest extends DemoApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void test1(){
        List<User> userList =  userRepository.findAll();
        for (User user: userList
             ) {
            System.out.println(user);
        }
    }
}
