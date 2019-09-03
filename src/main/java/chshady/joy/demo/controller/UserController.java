package chshady.joy.demo.controller;

import chshady.joy.demo.bean.User;
import chshady.joy.demo.configbean.Result;
import chshady.joy.demo.repository.UserRepository;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author 廖凡
 * @Date 2019/9/3 15:53
 */
@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/userList")
    public Result getUserList(){
       List<User> userList =  userRepository.findAll();
       return Result.ok(userList);
    }
}
