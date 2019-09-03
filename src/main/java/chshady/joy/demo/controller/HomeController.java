package chshady.joy.demo.controller;

import chshady.joy.demo.bean.Book;
import chshady.joy.demo.repository.Bookrepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @Author 廖凡
 * @Date 2019/8/21 15:51
 */
@Controller
public class HomeController {
    @Autowired
    private Bookrepository bookrepository;
    @GetMapping("/myindex")
    public String index(Model model){
        model.addAttribute("name","Joy");
        model.addAttribute("myname","廖");
        List<Book> list = Lists.newArrayList(bookrepository.findAll());
        model.addAttribute("book",list);
        return "index";
    }
}
