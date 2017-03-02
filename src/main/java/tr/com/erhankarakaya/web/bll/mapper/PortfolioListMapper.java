package tr.com.erhankarakaya.web.bll.mapper;

import tr.com.erhankarakaya.web.bll.dto.PortfolioListDto;
import tr.com.erhankarakaya.web.dal.entity.Portfolio;

/**
 * Created by erhan.karakaya on 3/2/2017.
 */
public class PortfolioListMapper extends BaseListMapper<Portfolio, PortfolioListDto> {
  @Override
  public PortfolioListDto mapEntityToDto(Portfolio portfolio) {
    PortfolioListDto.PortfolioListDtoBuilder portfolioListDtoBuilder = new PortfolioListDto.PortfolioListDtoBuilder();

    PortfolioListDto portfolioListDto = portfolioListDtoBuilder.id(portfolio.getId())
        .language(portfolio.getLanguage().getName())
        .orderingNumber(portfolio.getOrderingNumber())
        .title(portfolio.getTitle())
        .build();

    return portfolioListDto;
  }
}
