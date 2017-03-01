package tr.com.erhankarakaya.web.pl.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

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
  public String login(Principal user) {
    if (user != null) {
      return "redirect:/admin/index";
    }
    return "admin/login";
  }

}
