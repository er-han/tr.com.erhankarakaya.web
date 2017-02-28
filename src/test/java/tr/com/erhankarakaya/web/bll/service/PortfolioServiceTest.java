package tr.com.erhankarakaya.web.bll.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tr.com.erhankarakaya.web.bll.dto.PortfolioDto;
import tr.com.erhankarakaya.web.common.crudresult.CrudResult;
import tr.com.erhankarakaya.web.common.enums.LanguageEnum;
import tr.com.erhankarakaya.web.dal.entity.Portfolio;
import tr.com.erhankarakaya.web.dal.repository.PortfolioRepository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Pageable;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;


/**
 * Created by erhan.karakaya on 2/27/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PortfolioTestConfig.class, PortfolioServiceImpl.class})
public class PortfolioServiceTest {

  private static final Integer ID = 20;
  private static final String TITLE = "PORTFOLIO 1";
  private static final String DESCRIPTION = "Lorem Ipsum Portfolio Description.";
  private static final String IMAGE_FILE_NAME = "portfolio1.jpg";
  private static final LanguageEnum LANGUAGE = LanguageEnum.TR;
  private static final Integer ORDERING_NUMBER = 1;

  @Autowired
  private PortfolioRepository portfolioRepository;

  @Autowired
  private PortfolioService portfolioService;

  @Test
  public void whenNoEntryFound_ShouldReturnEmptyResult() {
    List<Portfolio> portfolios = new ArrayList<>();
    Page<Portfolio> portfolioPage = new PageImpl<Portfolio>(portfolios);

    when(portfolioRepository.findAll(any(Pageable.class))).thenReturn(portfolioPage);

    CrudResult<PortfolioDto> crudResult = portfolioService.findAll(new PageRequest(0, 10));

    assertEquals(0, crudResult.getReturnDtos().get().getTotalElements());
  }

  @Test
  public void whenOneEntryFound_ShouldReturnOneItemContainingList() {
    List<Portfolio> portfolios = new ArrayList<>();
    Portfolio.PortfolioBuilder portfolioBuilder = new Portfolio.PortfolioBuilder();
    Portfolio portfolio1 = portfolioBuilder.id(ID)
        .title(TITLE)
        .description(DESCRIPTION)
        .imageFileName(IMAGE_FILE_NAME)
        .languageId(LANGUAGE.getId())
        .orderingNumber(ORDERING_NUMBER)
        .build();
    portfolios.add(portfolio1);
    Page<Portfolio> portfolioPage = new PageImpl<Portfolio>(portfolios);

    when(portfolioRepository.findAll(any(Pageable.class))).thenReturn(portfolioPage);

    CrudResult<PortfolioDto> crudResult = portfolioService.findAll(new PageRequest(0, 10));

    assertEquals(1, crudResult.getReturnDtos().get().getTotalElements());
  }

}