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
  public static PortfolioDto mapEntityToDto(Portfolio portfolio) {
    PortfolioDto.PortfolioDtoBuilder portfolioDtoBuilder = new PortfolioDto.PortfolioDtoBuilder();
    PortfolioDto portfolioDto = portfolioDtoBuilder.id(portfolio.getId())
        .languageId(portfolio.getLanguageId())
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
}
