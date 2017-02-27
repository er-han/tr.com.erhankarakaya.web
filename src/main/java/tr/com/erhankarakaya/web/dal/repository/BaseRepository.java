package tr.com.erhankarakaya.web.dal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import tr.com.erhankarakaya.web.dal.entity.Entity;

import java.io.Serializable;

/**
 * Created by erhan.karakaya on 2/23/2017.
 */
@NoRepositoryBean
public interface BaseRepository<T extends Entity<IdT>, IdT extends Serializable> extends JpaRepository<T, IdT> {
}
