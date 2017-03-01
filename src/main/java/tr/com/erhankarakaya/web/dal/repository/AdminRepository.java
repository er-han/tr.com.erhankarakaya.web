package tr.com.erhankarakaya.web.dal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tr.com.erhankarakaya.web.dal.entity.Admin;

/**
 * Created by erhan.karakaya on 3/1/2017.
 */
@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {
  Admin findByUsernameAndPassword(String name, String password);

  Admin findByUsername(String name);
}
