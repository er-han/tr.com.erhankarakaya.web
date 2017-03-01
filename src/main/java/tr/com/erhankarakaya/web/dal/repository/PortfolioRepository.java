package tr.com.erhankarakaya.web.dal.repository;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;
import tr.com.erhankarakaya.web.dal.entity.Portfolio;

import java.util.List;

/**
 * Created by erhan.karakaya on 2/23/2017.
 */
@Repository
public interface PortfolioRepository extends BaseRepository<Portfolio, Integer> {
  List<Portfolio> findAllByLanguageId(Integer languageId);
  long countByLanguageId(Integer languageId);
}
