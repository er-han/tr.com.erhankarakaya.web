package tr.com.erhankarakaya.web.dal.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by erhan.karakaya on 2/23/2017.
 */
@MappedSuperclass
public abstract class BaseEntity<IdT extends Serializable> implements Entity<IdT> {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idGenerator")
  @Column(name = "ID", columnDefinition = "INTEGER")
  protected IdT id;

  @Override
  public IdT getId() {
    return id;
  }

  @Override
  public void setId(IdT id) {
    this.id = id;
  }

}
