package tr.com.erhankarakaya.web.pl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by erhan.karakaya on 2/28/2017.
 */
@Controller
public class HomeController {

  @RequestMapping({"/", "/index"})
  public String index() {
    return "index";
  }
}
