package tr.com.erhankarakaya.web.dal.entity;

import tr.com.erhankarakaya.web.common.builder.Builder;

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
  @Column(name = "DESCRIPTION", columnDefinition = "NCLOB")
  private String description;
  @Size(max = 200)
  @Column(name = "IMAGE_FILE_NAME", columnDefinition = "VARCHAR2")
  private String imageFileName;

  @Column(name = "ORDERING_NUMBER", columnDefinition = "INTEGER")
  private Integer orderingNumber;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "LANGUAGE_ID", insertable = false, updatable = false)
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

  public Language getLanguage() {
    return language;
  }

  public void setLanguage(Language language) {
    this.language = language;
  }

  public Integer getOrderingNumber() {
    return orderingNumber;
  }

  public void setOrderingNumber(Integer orderingNumber) {
    this.orderingNumber = orderingNumber;
  }

  public static class PortfolioBuilder implements Builder<Portfolio> {
    private Portfolio portfolio;

    public PortfolioBuilder() {
      portfolio = new Portfolio();
    }

    public PortfolioBuilder id(Integer id) {
      portfolio.setId(id);
      return this;
    }

    public PortfolioBuilder title(String title) {
      portfolio.setTitle(title);
      return this;
    }

    public PortfolioBuilder description(String description) {
      portfolio.setDescription(description);
      return this;
    }

    public PortfolioBuilder imageFileName(String imageFileName) {
      portfolio.setImageFileName(imageFileName);
      return this;
    }

    public PortfolioBuilder languageId(Integer languageId) {
      Language language = new Language();
      language.setId(languageId);
      portfolio.setLanguage(language);
      return this;
    }

    public PortfolioBuilder orderingNumber(Integer orderingNumber) {
      portfolio.setOrderingNumber(orderingNumber);
      return this;
    }

    @Override
    public Portfolio build() {
      return portfolio;
    }
  }

}
