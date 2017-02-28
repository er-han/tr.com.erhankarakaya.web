package tr.com.erhankarakaya.web.pl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by erhan.karakaya on 2/28/2017.
 */
@Controller
public class HomeController {

  @GetMapping({"/", "/index"})
  public String index() {
    return "index";
  }
}
