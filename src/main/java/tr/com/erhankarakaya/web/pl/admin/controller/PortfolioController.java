package tr.com.erhankarakaya.web.pl.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tr.com.erhankarakaya.web.bll.dto.PortfolioDto;
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
  public String getListOfPortfolios(Model model) {
    CrudResult<PortfolioListDto> crudResult = portfolioService.findAllForList();
    if (crudResult.isSuccess()) {
      model.addAttribute("portfolios", crudResult.getReturnDtos().orElse(new ArrayList<>()));
    }

    return "/admin/portfolio-list";
  }


  @GetMapping("/portfolio/edit")
  public String getDetailOfPortfolio(@RequestParam(value = "id", required = false) Integer id, Model model) {
    CrudResult<PortfolioDto> crudResult = portfolioService.findById(id);

    PortfolioDto portfolioDto;
    if (crudResult.isSuccess() && crudResult.getReturnDto().isPresent()) {
      portfolioDto = crudResult.getReturnDto().get();
    } else {
      portfolioDto = new PortfolioDto.PortfolioDtoBuilder().build();
    }
    model.addAttribute("portfolio", portfolioDto );

    return "/admin/portfolio-edit";
  }
}
