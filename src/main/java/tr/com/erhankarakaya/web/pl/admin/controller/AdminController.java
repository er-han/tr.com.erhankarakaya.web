package tr.com.erhankarakaya.web.pl.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tr.com.erhankarakaya.web.bll.dto.PortfolioDto;
import tr.com.erhankarakaya.web.bll.service.PortfolioService;
import tr.com.erhankarakaya.web.common.crudresult.CountResult;
import tr.com.erhankarakaya.web.common.enums.LanguageEnum;

import java.security.Principal;

/**
 * Created by erhan.karakaya on 2/28/2017.
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

  @Autowired
  private PortfolioService portfolioService;


  @GetMapping({"", "/index"})
  public String index(Model model) {

    CountResult<PortfolioDto> countResult = portfolioService.countByLanguageId(LanguageEnum.getCurrentLanguage());
    long count = 0;
    if (countResult.isSuccess()) {
      count = countResult.getCount();
    }
    model.addAttribute("portfolioCount",count);
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
