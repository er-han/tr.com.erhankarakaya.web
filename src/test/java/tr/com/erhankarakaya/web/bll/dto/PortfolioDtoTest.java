package tr.com.erhankarakaya.web.bll.dto;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tr.com.erhankarakaya.web.common.enums.LanguageEnum;

/**
 * Created by erhan.karakaya on 2/24/2017.
 */

public class PortfolioDtoTest {

  @Test
  public void builderSetsAllFieldsCorrect() {
    PortfolioDto.PortfolioDtoBuilder portfolioDtoBuilder = new PortfolioDto.PortfolioDtoBuilder();
    Integer id = 1, orderingNumber = 1;
    String title = "title", description = "description";
    byte[] imageFile = new byte[]{};
    LanguageEnum languageEnum = LanguageEnum.TR;

    PortfolioDto portfolioDto = portfolioDtoBuilder.id(1)
        .title(title)
        .imageFile(imageFile)
        .description(description)
        .orderingNumber(orderingNumber)
        .languageId(languageEnum.getId())
        .build();


    assertEquals(id, portfolioDto.getId());
    assertEquals(orderingNumber, portfolioDto.getOrderingNumber());
    assertEquals(title, portfolioDto.getTitle());
    assertEquals(description, portfolioDto.getDescription());
    assertEquals(imageFile, portfolioDto.getimageFile());
    assertEquals(languageEnum.getId(), portfolioDto.getId());
  }

}