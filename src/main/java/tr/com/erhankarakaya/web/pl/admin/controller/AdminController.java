package tr.com.erhankarakaya.web.pl.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by erhan.karakaya on 2/28/2017.
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

  @GetMapping({"", "/index"})
  public String index() {
    return "admin/index";
  }


  @GetMapping("/login")
  public String login() {
    return "admin/login";
  }

}
