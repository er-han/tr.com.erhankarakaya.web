package tr.com.erhankarakaya.web.pl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tr.com.erhankarakaya.web.bll.dto.PortfolioDto;
import tr.com.erhankarakaya.web.bll.service.PortfolioService;
import tr.com.erhankarakaya.web.common.crudresult.CrudResult;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by erhan.karakaya on 2/28/2017.
 */
@Controller
public class HomeController {

  @Autowired
  private PortfolioService portfolioService;

  @RequestMapping({"/", "/index"})
  public String index(Model model) {

    CrudResult<PortfolioDto> crudResult = portfolioService.findAll();

    List<PortfolioDto> portfolioDtos = crudResult.getReturnDtos().orElse(new ArrayList<>());

    model.addAttribute("portfolios", portfolioDtos);
    return "index";
  }
}
