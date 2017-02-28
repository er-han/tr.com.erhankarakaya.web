package tr.com.erhankarakaya.web.bll.mapper;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import tr.com.erhankarakaya.web.bll.dto.PortfolioDto;
import tr.com.erhankarakaya.web.dal.entity.Portfolio;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by erhan.karakaya on 2/24/2017.
 */
public class PortfolioMapper {

  //region dto to entity
  public static PortfolioDto mapEntityToDto(Portfolio portfolio) {
    PortfolioDto.PortfolioDtoBuilder portfolioDtoBuilder = new PortfolioDto.PortfolioDtoBuilder();
    PortfolioDto portfolioDto = portfolioDtoBuilder.id(portfolio.getId())
        .languageId(portfolio.getLanguage().getId())
        .orderingNumber(portfolio.getOrderingNumber())
        .description(portfolio.getDescription())
        .imageFileName(portfolio.getDescription())
        .title(portfolio.getTitle())
        .build();

    return portfolioDto;
  }

  public static List<PortfolioDto> mapEntitiesToDtos(Iterable<Portfolio> entities) {
    List<PortfolioDto> dtos = new ArrayList<>();

    entities.forEach(portfolio -> dtos.add(mapEntityToDto(portfolio)));

    return dtos;
  }

  public static Page<PortfolioDto> mapPageEntityToPageDto(Page<Portfolio> portfolioPage, Pageable pageable) {
    List<PortfolioDto> dtos = mapEntitiesToDtos(portfolioPage.getContent());

    return new PageImpl<PortfolioDto>(dtos,pageable,portfolioPage.getTotalElements());
  }
  //endregion dto to entity

  //region entity to dto

  public static Portfolio mapDtoToEntity(PortfolioDto portfolioDto) {
    Portfolio.PortfolioBuilder portfolioBuilder = new Portfolio.PortfolioBuilder();
    Portfolio portfolio = portfolioBuilder.id(portfolioDto.getId())
        .description(portfolioDto.getDescription())
        .imageFileName(portfolioDto.getImageFileName())
        .languageId(portfolioDto.getLanguageId())
        .orderingNumber(portfolioDto.getOrderingNumber())
        .title(portfolioDto.getTitle())
        .build();

    return portfolio;
  }

  public static List<Portfolio> mapDtosToEntities(Iterable<PortfolioDto> dtos) {
    List<Portfolio> portfolios = new ArrayList<>();

    dtos.forEach(portfolioDto -> portfolios.add(mapDtoToEntity(portfolioDto)));

    return portfolios;
  }


  //endregion entity to dto

}
