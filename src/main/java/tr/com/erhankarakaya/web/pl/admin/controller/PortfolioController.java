package tr.com.erhankarakaya.web.pl.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tr.com.erhankarakaya.web.bll.dto.PortfolioListDto;
import tr.com.erhankarakaya.web.bll.service.PortfolioService;
import tr.com.erhankarakaya.web.common.crudresult.CrudResult;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by erhan.karakaya on 3/3/2017.
 */
@Controller
public class PortfolioController extends BaseAdminController {

  @Autowired
  private PortfolioService portfolioService;

  @GetMapping("/portfolio/list")
  public String listPortfolios(Model model) {
    CrudResult<PortfolioListDto> crudResult = portfolioService.findAllForList();
    if (crudResult.isSuccess()) {
      model.addAttribute("portfolios", crudResult.getReturnDtos().orElse(new ArrayList<>()));
    }

    return "/admin/portfolio-list";
  }
}
