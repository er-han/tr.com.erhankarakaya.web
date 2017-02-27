package tr.com.erhankarakaya.web.bll.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import tr.com.erhankarakaya.web.bll.dto.PortfolioDto;
import tr.com.erhankarakaya.web.bll.mapper.PortfolioMapper;
import tr.com.erhankarakaya.web.common.crudresult.CrudResult;
import tr.com.erhankarakaya.web.common.enums.ResultEnum;
import tr.com.erhankarakaya.web.dal.entity.Portfolio;
import tr.com.erhankarakaya.web.dal.repository.PortfolioRepository;

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

  @Override
  public CrudResult<PortfolioDto> findAll(Pageable pageable) {
    Assert.notNull(messageSource);
    Page<Portfolio> portfolioPage = portfolioRepository.findAll(pageable);

    Page<PortfolioDto> portfolioDtoPage = PortfolioMapper.mapPageEntityToPageDto(portfolioPage, pageable);

    CrudResult<PortfolioDto> crudResult = new CrudResult<>();
    //crudResult.setMessage(messageSource.getMessage("crudresult.success", null, new Locale("tr")));
    crudResult.setReturnDtos(portfolioDtoPage);
    crudResult.setResult(ResultEnum.SUCCESS);

    return crudResult;
  }

  @Override
  public CrudResult<PortfolioDto> insertOrUpdate(PortfolioDto portfolioDto) {
    Portfolio portfolio = PortfolioMapper.mapDtoToEntity(portfolioDto);

    CrudResult<PortfolioDto> crudResult = new CrudResult<>();

    try {
      portfolio = portfolioRepository.save(portfolio);
      crudResult.setResult(ResultEnum.SUCCESS);
      crudResult.setReturnDto(PortfolioMapper.mapEntityToDto(portfolio));
    } catch (Exception e) {
      crudResult.setResult(ResultEnum.ERROR);
    }

    return crudResult;
  }
}
