package tr.com.erhankarakaya.web.bll.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import tr.com.erhankarakaya.web.bll.dto.PortfolioDto;
import tr.com.erhankarakaya.web.bll.dto.PortfolioListDto;
import tr.com.erhankarakaya.web.bll.mapper.PortfolioListMapper;
import tr.com.erhankarakaya.web.bll.mapper.PortfolioMapper;
import tr.com.erhankarakaya.web.common.crudresult.CountResult;
import tr.com.erhankarakaya.web.common.crudresult.CrudResult;
import tr.com.erhankarakaya.web.common.enums.LanguageEnum;
import tr.com.erhankarakaya.web.common.enums.ResultEnum;
import tr.com.erhankarakaya.web.dal.entity.Portfolio;
import tr.com.erhankarakaya.web.dal.repository.PortfolioRepository;

import java.util.List;
import java.util.Locale;


/**
 * Created by erhan.karakaya on 2/27/2017.
 */
@Service
public class PortfolioServiceImpl implements PortfolioService {

  @Autowired
  protected MessageSource messageSource;

  @Autowired
  private PortfolioRepository portfolioRepository;

  private PortfolioMapper portfolioMapper;

  public PortfolioServiceImpl() {
    portfolioMapper = new PortfolioMapper();
  }

  @Override
  public CrudResult<PortfolioDto> findAll() {
    List<Portfolio> portfolios = portfolioRepository.findAll();

    List<PortfolioDto> portfolioDtos = portfolioMapper.mapEntitiesToDtos(portfolios);

    CrudResult<PortfolioDto> crudResult = new CrudResult<>();
    //crudResult.setMessage(messageSource.getMessage("crudresult.success", null, new Locale("tr")));
    crudResult.setReturnDtos(portfolioDtos);
    crudResult.setResult(ResultEnum.SUCCESS);

    return crudResult;
  }

  @Override
  public CrudResult<PortfolioDto> findAllByLanguageId(LanguageEnum languageEnum) {
    List<Portfolio> portfolios = portfolioRepository.findAllByLanguageId(languageEnum.getId());

    List<PortfolioDto> portfolioDtos = portfolioMapper.mapEntitiesToDtos(portfolios);

    CrudResult<PortfolioDto> crudResult = new CrudResult<>();
    //crudResult.setMessage(messageSource.getMessage("crudresult.success", null, new Locale("tr")));
    crudResult.setReturnDtos(portfolioDtos);
    crudResult.setResult(ResultEnum.SUCCESS);

    return crudResult;
  }


  @Override
  public CrudResult<PortfolioDto> insertOrUpdate(PortfolioDto portfolioDto) {
    Portfolio portfolio = portfolioMapper.mapDtoToEntity(portfolioDto);

    CrudResult<PortfolioDto> crudResult = new CrudResult<>();

    try {
      portfolio = portfolioRepository.save(portfolio);
      crudResult.setResult(ResultEnum.SUCCESS);
      crudResult.setReturnDto(portfolioMapper.mapEntityToDto(portfolio));
    } catch (Exception e) {
      crudResult.setResult(ResultEnum.ERROR);
    }

    return crudResult;
  }

  @Override
  public CountResult<PortfolioDto> countByLanguageId(LanguageEnum languageEnum) {
    CountResult<PortfolioDto> countResult = new CountResult<>();
    try {
      long count = portfolioRepository.countByLanguageId(languageEnum.getId());
      countResult.setCount(count);
      countResult.setResult(ResultEnum.SUCCESS);
    } catch (Exception e) {
      countResult.setResult(ResultEnum.ERROR);
    }
    return countResult;
  }

  @Override
  public CrudResult<PortfolioListDto> findAllForList() {
    CrudResult<PortfolioListDto> crudResult = new CrudResult<>();
    try {
      List<Portfolio> portfolios = portfolioRepository.findAll();
      PortfolioListMapper portfolioListMapper = new PortfolioListMapper();
      List<PortfolioListDto> portfolioListDtos = portfolioListMapper.mapEntitiesToDtos(portfolios);
      crudResult.setReturnDtos(portfolioListDtos);
      crudResult.setResult(ResultEnum.SUCCESS);
    } catch (Exception e) {
      crudResult.setResult(ResultEnum.WARNING);
    }
    return crudResult;
  }
}
