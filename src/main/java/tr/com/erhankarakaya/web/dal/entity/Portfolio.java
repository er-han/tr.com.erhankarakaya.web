package tr.com.erhankarakaya.web.dal.entity;

import tr.com.erhankarakaya.web.common.builder.Builder;
import tr.com.erhankarakaya.web.dal.repository.LanguageRepository;

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
  @Column(name = "IMAGE_FILE", columnDefinition = "BLOB(16M)")
  private byte[] imageFile;


  @Column(name = "ORDERING_NUMBER", columnDefinition = "INTEGER")
  private Integer orderingNumber;

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//  @JoinColumn(name = "LANGUAGE_ID", insertable = false, updatable = false)
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


  public byte[] getImageFile() {
    return imageFile;
  }

  public void setImageFile(byte[] imageFile) {
    this.imageFile = imageFile;
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


  @Override
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("[");
    stringBuilder.append("Id = " + getId());
    stringBuilder.append(", ");
    stringBuilder.append("Title = " + getTitle());
    stringBuilder.append(", ");
    stringBuilder.append("Description = " + getDescription());
    stringBuilder.append(", ");
    stringBuilder.append("Ordering Number = " + getOrderingNumber());
    stringBuilder.append("]");

    return stringBuilder.toString();
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

    public PortfolioBuilder imageFile(byte[] imageFile) {
      portfolio.setImageFile(imageFile);
      return this;
    }

    public PortfolioBuilder languageId(Integer languageId) {
      Language language = new Language();
      language.setId(languageId);
      portfolio.setLanguage(language);
      return this;
    }

    public PortfolioBuilder language(Language language) {
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
