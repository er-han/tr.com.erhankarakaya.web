package tr.com.erhankarakaya.web.bll.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tr.com.erhankarakaya.web.bll.dto.PortfolioDto;
import tr.com.erhankarakaya.web.common.crudresult.CrudResult;
import tr.com.erhankarakaya.web.common.enums.LanguageEnum;
import tr.com.erhankarakaya.web.dal.entity.Language;
import tr.com.erhankarakaya.web.dal.entity.Portfolio;
import tr.com.erhankarakaya.web.dal.repository.PortfolioRepository;

import javax.sound.sampled.Port;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


/**
 * Created by erhan.karakaya on 2/27/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PortfolioServiceTestConfig.class, PortfolioServiceImpl.class})
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
    when(portfolioRepository.findAll()).thenReturn(portfolios);

    CrudResult<PortfolioDto> crudResult = portfolioService.findAll();

    assertEquals(0, crudResult.getReturnDtos().get().size());
  }

  @Test
  public void whenOneEntryFound_ShouldReturnOneItemContainingList() {
    List<Portfolio> portfolios = new ArrayList<>();
    Portfolio portfolio1 = createPortfolio();
    portfolios.add(portfolio1);
    when(portfolioRepository.findAll()).thenReturn(portfolios);

    CrudResult<PortfolioDto> crudResult = portfolioService.findAll();

    verify(portfolioRepository, times(1)).findAll();
    assertEquals(1, crudResult.getReturnDtos().get().size());
  }

  @Test
  public void whenInsertingAValidEntry_ShouldReturnSuccessAndNewId() {
    Portfolio portfolio = createPortfolio();
    when(portfolioRepository.save(any(Portfolio.class))).thenReturn(portfolio);

    PortfolioDto portfolioDto = createPortfolioDtoForInsert();
    CrudResult<PortfolioDto> crudResult = portfolioService.insertOrUpdate(portfolioDto);

    verify(portfolioRepository, times(1)).save(any(Portfolio.class));
    assertTrue(crudResult.isSuccess());
    assertTrue(crudResult.getReturnDto().isPresent());
    assertEquals(ID,crudResult.getReturnDto().get().getId());
  }

  @Test
  public void whenNoEntryFoundById_ShouldReturnEmptyResult() {
    when(portfolioRepository.findOne(anyInt())).thenReturn(null);

    CrudResult<PortfolioDto> crudResult = portfolioService.findById(ID);

    verify(portfolioRepository, times(1)).findOne(anyInt());
    assertNotNull(crudResult);
    assertFalse(crudResult.isSuccess());
    assertFalse(crudResult.getReturnDto().isPresent());
  }


  private Portfolio createPortfolio() {
    Portfolio.PortfolioBuilder portfolioBuilder = new Portfolio.PortfolioBuilder();
    Portfolio portfolio = portfolioBuilder.id(ID)
        .title(TITLE)
        .description(DESCRIPTION)
        .imageFileName(IMAGE_FILE_NAME)
        .languageId(LANGUAGE.getId())
        .orderingNumber(ORDERING_NUMBER)
        .build();
    return portfolio;
  }

  private Portfolio createPortfolio(LanguageEnum languageEnum) {
    Portfolio.PortfolioBuilder portfolioBuilder = new Portfolio.PortfolioBuilder();
    Portfolio portfolio = portfolioBuilder.id(ID)
        .title(TITLE)
        .description(DESCRIPTION)
        .imageFileName(IMAGE_FILE_NAME)
        .languageId(languageEnum.getId())
        .orderingNumber(ORDERING_NUMBER)
        .build();
    return portfolio;
  }

  private PortfolioDto createPortfolioDtoForInsert() {
    PortfolioDto.PortfolioDtoBuilder portfolioBuilder = new PortfolioDto.PortfolioDtoBuilder();
    PortfolioDto portfolioDto = portfolioBuilder
        .title(TITLE)
        .description(DESCRIPTION)
        .imageFileName(IMAGE_FILE_NAME)
        .languageId(LANGUAGE.getId())
        .orderingNumber(ORDERING_NUMBER)
        .build();
    return portfolioDto;
  }

}