package tr.com.erhankarakaya.web.dal.entity;

import java.io.Serializable;

/**
 * Created by erhan.karakaya on 2/23/2017.
 */
public interface Entity<IdT extends Serializable> {
  IdT getId();
  void setId(IdT id);
}