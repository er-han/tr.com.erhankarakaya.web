package tr.com.erhankarakaya.web.entity;

import java.io.Serializable;

/**
 * Created by erhan.karakaya on 2/23/2017.
 */
public interface IdEntity<IdT extends Serializable> extends Entity {
  IdT getId();
  void setId(IdT id);
}
