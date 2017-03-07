package tr.com.erhankarakaya.web.bll.mapper;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.util.Assert;
import tr.com.erhankarakaya.web.bll.dto.PortfolioDto;
import tr.com.erhankarakaya.web.dal.entity.Portfolio;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by erhan.karakaya on 2/24/2017.
 */
public class PortfolioMapper extends BaseMapper<Portfolio, PortfolioDto> {

  //region dto to entity
  public PortfolioDto mapEntityToDto(Portfolio portfolio) {
    Assert.notNull(portfolio);
    PortfolioDto.PortfolioDtoBuilder portfolioDtoBuilder = new PortfolioDto.PortfolioDtoBuilder();
    PortfolioDto portfolioDto = portfolioDtoBuilder.id(portfolio.getId())
        .languageId(portfolio.getLanguage().getId())
        .orderingNumber(portfolio.getOrderingNumber())
        .description(portfolio.getDescription())
        .imageFile(portfolio.getImageFile())
        .title(portfolio.getTitle())
        .build();

    return portfolioDto;
  }

  //endregion dto to entity

  //region entity to dto

  public Portfolio mapDtoToEntity(PortfolioDto portfolioDto) {
    Portfolio.PortfolioBuilder portfolioBuilder = new Portfolio.PortfolioBuilder();
    Portfolio portfolio = portfolioBuilder.id(portfolioDto.getId())
        .description(portfolioDto.getDescription())
        .imageFile(portfolioDto.getimageFile())
        .languageId(portfolioDto.getLanguageId())
        .orderingNumber(portfolioDto.getOrderingNumber())
        .title(portfolioDto.getTitle())
        .build();

    return portfolio;
  }

  //endregion entity to dto

}
