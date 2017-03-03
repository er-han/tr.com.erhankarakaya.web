package tr.com.erhankarakaya.web.bll.service;

import org.springframework.data.domain.Pageable;
import tr.com.erhankarakaya.web.bll.dto.PortfolioDto;
import tr.com.erhankarakaya.web.bll.dto.PortfolioListDto;
import tr.com.erhankarakaya.web.common.crudresult.CountResult;
import tr.com.erhankarakaya.web.common.crudresult.CrudResult;
import tr.com.erhankarakaya.web.common.enums.LanguageEnum;

import javax.transaction.Transactional;

/**
 * Created by erhan.karakaya on 2/24/2017.
 */
@Transactional
public interface PortfolioService {

  CrudResult<PortfolioDto> findAll();
  CrudResult<PortfolioDto> findAllByLanguageId(LanguageEnum languageEnum);
  CrudResult<PortfolioDto> insertOrUpdate(PortfolioDto portfolioDto);
  CountResult<PortfolioDto> countByLanguageId(LanguageEnum languageEnum);

  CrudResult<PortfolioListDto> findAllForList();

}
