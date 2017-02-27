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


  @Autowired
  private PortfolioRepository portfolioRepository;

  @Autowired
  private PortfolioService portfolioService;

  @Test
  public void whenNoEntryFoundReturnEmptyResult() {
    List<Portfolio> portfolios = new ArrayList<>();
    Page<Portfolio> portfolioPage = new PageImpl<Portfolio>(portfolios);

    when(portfolioRepository.findAll(any(Pageable.class))).thenReturn(portfolioPage);

    CrudResult<PortfolioDto> crudResult = portfolioService.findAll(new PageRequest(1,10));

    assertEquals(0,crudResult.getReturnDtos().get().getTotalElements());
  }


}