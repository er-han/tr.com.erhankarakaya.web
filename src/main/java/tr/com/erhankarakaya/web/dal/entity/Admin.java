package tr.com.erhankarakaya.web.dal.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Created by erhan.karakaya on 3/1/2017.
 */
@Entity
@Table(name = "ADMIN")
@SequenceGenerator(name = "idGenerator",
    sequenceName = "SEQ_ADMIN_ID",
    allocationSize = 1)
public class Admin extends BaseEntity<Integer>{
  @NotNull
  @Column(name = "USERNAME", columnDefinition = "NVARCHAR2(100)")
  private String username;
  @NotNull
  @Column(name = "PASSWORD", columnDefinition = "NVARCHAR2(100)")
  private String password;

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
