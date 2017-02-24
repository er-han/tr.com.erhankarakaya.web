package tr.com.erhankarakaya.web.dal.entity;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by erhan.karakaya on 2/23/2017.
 */
@Entity
@Table(name = "PORTFOLIO")
@SequenceGenerator(name = "idGenerator",
    sequenceName = "SEQ_PORTFOLIO_ID",
    allocationSize = 1)
public class Portfolio extends BaseEntity<Integer> {
  @NotNull
  @Size(max = 500)
  @Column(name = "TITLE", columnDefinition = "NVARCHAR2")
  private String title;
  @Column(name = "DESCRIPTION", columnDefinition = "NVARCHAR2")
  private String description;
  @Size(max = 200)
  @Column(name = "IMAGE_FILE_NAME", columnDefinition = "VARCHAR2")
  private String imageFileName;
  @NotNull
  @Column(name = "LANGUAGE_ID", columnDefinition = "INTEGER")
  private Integer languageId;
  @Column(name = "ORDERING_NUMBER", columnDefinition = "INTEGER")
  private Integer orderingNumber;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "LANGUAGE_ID")
  private Language language;

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getImageFileName() {
    return imageFileName;
  }

  public void setImageFileName(String imageFileName) {
    this.imageFileName = imageFileName;
  }

  public Integer getLanguageId() {
    return languageId;
  }

  public void setLanguageId(Integer languageId) {
    this.languageId = languageId;
  }

  public Integer getOrderingNumber() {
    return orderingNumber;
  }

  public void setOrderingNumber(Integer orderingNumber) {
    this.orderingNumber = orderingNumber;
  }
}
