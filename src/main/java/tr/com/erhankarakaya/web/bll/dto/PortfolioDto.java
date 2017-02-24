package tr.com.erhankarakaya.web.bll.dto;

import tr.com.erhankarakaya.web.common.builder.Builder;
import tr.com.erhankarakaya.web.common.enums.LanguageEnum;

/**
 * Created by erhan.karakaya on 2/24/2017.
 */
public class PortfolioDto extends BaseDto {

  //region constructors
  private PortfolioDto() {

  }
  //endregion constructors

  //region fields
  private Integer id;
  private String title;
  private String description;
  private String imageFileName;
  private Integer orderingNumber;
  private Integer languageId;
  //endregion fields

  //region getters-setters
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

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

  public Integer getOrderingNumber() {
    return orderingNumber;
  }

  public void setOrderingNumber(Integer orderingNumber) {
    this.orderingNumber = orderingNumber;
  }

  public Integer getLanguageId() {
    return languageId;
  }

  public void setLanguageId(Integer languageId) {
    this.languageId = languageId;
  }

  //endregion getters-setters

  //region builder

  public static class PortfolioDtoBuilder implements Builder<PortfolioDto> {

    private PortfolioDto portfolioDto;

    public PortfolioDtoBuilder(){
      portfolioDto = new PortfolioDto();
    }

    public PortfolioDtoBuilder id(Integer id) {
      portfolioDto.setId(id);
      return this;
    }

    public PortfolioDtoBuilder title(String title) {
      portfolioDto.setTitle(title);
      return this;
    }

    public PortfolioDtoBuilder description(String description) {
      portfolioDto.setDescription(description);
      return this;
    }

    public PortfolioDtoBuilder imageFileName(String imageFileName) {
      portfolioDto.setImageFileName(imageFileName);
      return this;
    }

    public PortfolioDtoBuilder orderingNumber(Integer orderinNumber) {
      portfolioDto.setOrderingNumber(orderinNumber);
      return this;
    }

    public PortfolioDtoBuilder languageId(Integer languageId) {
      portfolioDto.setLanguageId(languageId);
      return this;
    }

    public PortfolioDtoBuilder languageId(LanguageEnum languageEnum) {
      this.languageId(languageEnum.getId());
      return this;
    }


    @Override
    public PortfolioDto build() {
      return portfolioDto;
    }

  }
  //endregion
}
