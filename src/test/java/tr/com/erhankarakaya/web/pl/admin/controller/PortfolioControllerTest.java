package tr.com.erhankarakaya.web.pl.admin.controller;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.View;
import tr.com.erhankarakaya.web.bll.dto.PortfolioDto;
import tr.com.erhankarakaya.web.bll.dto.PortfolioListDto;
import tr.com.erhankarakaya.web.bll.service.PortfolioService;
import tr.com.erhankarakaya.web.common.crudresult.CrudResult;
import tr.com.erhankarakaya.web.common.enums.ResultEnum;
import tr.com.erhankarakaya.web.dal.entity.Portfolio;


import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
/**
 * Created by erhan.karakaya on 3/8/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class PortfolioControllerTest {

  @InjectMocks
  private PortfolioController portfolioController;

  @Mock
  PortfolioService portfolioService;

  @Mock
  View mockView;

  MockMvc mockMvc;

  @Before
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);
    mockMvc = standaloneSetup(portfolioController)
        .setSingleView(mockView)
        .build();
  }


  @Test
  public void testPortfolioList() throws Exception{
    List<PortfolioListDto> portfolioDtos = new ArrayList<>();
    PortfolioListDto portfolioListDto = new PortfolioListDto();
    portfolioDtos.add(portfolioListDto);
    CrudResult<PortfolioListDto> crudResult = new CrudResult<>();
    crudResult.setResult(ResultEnum.SUCCESS);
    crudResult.setReturnDtos(portfolioDtos);
    when(portfolioService.findAllForList()).thenReturn(crudResult);

    mockMvc.perform(get("/admin/portfolio/list"))
        .andExpect(status().isOk())
        .andExpect(view().name("/admin/portfolio-list"))
        .andExpect(model().attribute("portfolios",portfolioDtos));
  }

}