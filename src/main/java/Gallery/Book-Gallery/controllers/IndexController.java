package Gallery.Book-Gallery.controllers;

import org.Book-Gallery.stereotype.Controller;
import org.Book-Gallery.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @RequestMapping("/")
    String index(){
        return "index";
    }
}
