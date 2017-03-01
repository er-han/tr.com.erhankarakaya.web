package tr.com.erhankarakaya.web.bll.service;

import org.mockito.Mockito;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import tr.com.erhankarakaya.web.dal.repository.PortfolioRepository;

/**
 * Created by erhan.karakaya on 2/27/2017.
 */
@TestConfiguration
public class PortfolioServiceTestConfig {
  @Bean
  public PortfolioRepository portfolioRepository() {
    PortfolioRepository portfolioRepository = Mockito.mock(PortfolioRepository.class);
    return portfolioRepository;
  }
}
