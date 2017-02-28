package tr.com.erhankarakaya.web.config;

import nz.net.ultraq.thymeleaf.LayoutDialect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.spring4.SpringTemplateEngine;

/**
 * Created by erhan.karakaya on 2/28/2017.
 */
@Configuration
public class ThymeleafConfig {

  @Bean
  public SpringTemplateEngine templateEngine() {
    SpringTemplateEngine templateEngine = new SpringTemplateEngine();
    templateEngine.addDialect(new LayoutDialect());
    return templateEngine;
  }
}
