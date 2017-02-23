package tr.com.erhankarakaya.web.entity;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * Created by erhan.karakaya on 2/23/2017.
 */
@MappedSuperclass
public abstract class BaseIdEntity<IdT extends Serializable> extends BaseEntity implements IdEntity<IdT> {

  private IdT id;

  @Override
  public IdT getId() {
    return id;
  }

  @Override
  public void setId(IdT id) {
    this.id = id;
  }

}
