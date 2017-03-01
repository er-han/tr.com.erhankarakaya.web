package tr.com.erhankarakaya.web.bll.service;

import org.mockito.Mockito;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import tr.com.erhankarakaya.web.dal.repository.AdminRepository;

/**
 * Created by erhan.karakaya on 3/1/2017.
 */
@TestConfiguration
public class AdminServiceTestConfig {
  @Bean
  public AdminRepository adminRepository() {
    return Mockito.mock(AdminRepository.class);
  }
}
