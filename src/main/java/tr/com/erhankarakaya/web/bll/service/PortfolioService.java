package tr.com.erhankarakaya.web.bll.service;

import org.springframework.data.domain.Pageable;
import tr.com.erhankarakaya.web.bll.dto.PortfolioDto;
import tr.com.erhankarakaya.web.common.crudresult.CrudResult;

import javax.transaction.Transactional;

/**
 * Created by erhan.karakaya on 2/24/2017.
 */
@Transactional
public interface PortfolioService {

  CrudResult<PortfolioDto> findAll();

  CrudResult<PortfolioDto> insertOrUpdate(PortfolioDto portfolioDto);
}
