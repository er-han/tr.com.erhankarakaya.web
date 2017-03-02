package tr.com.erhankarakaya.web.bll.dto;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by erhan.karakaya on 3/2/2017.
 */
public class PortfolioListDtoTest {

  private static final Integer ID = 1;
  private static final String TITLE = "PORTFOLIO 1";
  private static final String LANGUAGE = "tr";
  private static final Integer ORDERING_NUMBER = 3;

  @Test
  public void builderSetsAllFieldsCorrect() {
    PortfolioListDto.PortfolioListDtoBuilder portfolioListDtoBuilder = new PortfolioListDto.PortfolioListDtoBuilder();
    PortfolioListDto portfolioListDto = portfolioListDtoBuilder.id(ID)
        .title(TITLE)
        .orderingNumber(ORDERING_NUMBER)
        .language(LANGUAGE)
        .build();

    assertNotNull(portfolioListDto);
    assertEquals(ID, portfolioListDto.getId());
    assertEquals(TITLE, portfolioListDto.getTitle());
    assertEquals(LANGUAGE, portfolioListDto.getLanguage());
    assertEquals(ORDERING_NUMBER, portfolioListDto.getOrderingNumber());
  }
}