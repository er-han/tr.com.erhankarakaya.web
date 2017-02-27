package tr.com.erhankarakaya.web.dal.repository;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;
import tr.com.erhankarakaya.web.dal.entity.Portfolio;

/**
 * Created by erhan.karakaya on 2/23/2017.
 */
@Repository
public interface PortfolioRepository extends BaseRepository<Portfolio, Integer> {
}
