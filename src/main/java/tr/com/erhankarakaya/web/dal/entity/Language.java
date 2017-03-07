package tr.com.erhankarakaya.web.dal.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by erhan.karakaya on 2/23/2017.
 */
@Entity
@Table(name = "LANGUAGE")
@SequenceGenerator(name = "idGenerator",
    sequenceName = "SEQ_LANGUAGE_ID",
    allocationSize = 1)
public class Language extends BaseEntity<Integer> {

  @NotNull
  @Size(max = 50)
  @Column(name = "NAME", columnDefinition = "NVARCHAR2")
  private String name;
  @NotNull
  @Size(max = 2)
  @Column(name = "CODE", columnDefinition = "VARCHAR2")
  private String code;
  @NotNull
  @Size(max = 5)
  @Column(name = "LOCALE", columnDefinition = "VARCHAR2")
  private String locale;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getLocale() {
    return locale;
  }

  public void setLocale(String locale) {
    this.locale = locale;
  }


  @Override
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("[");
    stringBuilder.append("Id = " + getId());
    stringBuilder.append(", ");
    stringBuilder.append("Name = " + getName());
    stringBuilder.append(", ");
    stringBuilder.append("Code = " + getCode());
    stringBuilder.append(", ");
    stringBuilder.append("locale = " + getLocale());
    stringBuilder.append("]");

    return stringBuilder.toString();
  }

}
