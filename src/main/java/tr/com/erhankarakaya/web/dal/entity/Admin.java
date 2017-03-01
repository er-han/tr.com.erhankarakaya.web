package tr.com.erhankarakaya.web.dal.entity;

import tr.com.erhankarakaya.web.common.builder.Builder;

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

  public static class AdminBuilder implements Builder<Admin> {

    private Admin admin;

    public AdminBuilder() {
      admin = new Admin();
    }

    public AdminBuilder id(Integer id) {
      this.admin.setId(id);
      return this;
    }

    public AdminBuilder username(String username) {
      this.admin.setUsername(username);
      return this;
    }

    public AdminBuilder password(String password) {
      this.admin.setPassword(password);
      return this;
    }

    @Override
    public Admin build() {
      return admin;
    }
  }
}
