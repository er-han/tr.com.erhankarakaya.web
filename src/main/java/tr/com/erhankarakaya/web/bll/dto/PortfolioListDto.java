package tr.com.erhankarakaya.web.bll.dto;

import tr.com.erhankarakaya.web.common.builder.Builder;

/**
 * Created by erhan.karakaya on 3/2/2017.
 */
public class PortfolioListDto extends BaseDto {
  private Integer id;
  private String title;
  private String language;
  private Integer orderingNumber;

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

  public String getLanguage() {
    return language;
  }

  public void setLanguage(String language) {
    this.language = language;
  }

  public Integer getOrderingNumber() {
    return orderingNumber;
  }

  public void setOrderingNumber(Integer orderingNumber) {
    this.orderingNumber = orderingNumber;
  }

  public static class PortfolioListDtoBuilder implements Builder<PortfolioListDto> {

    private PortfolioListDto portfolioListDto;

    public PortfolioListDtoBuilder() {
      portfolioListDto = new PortfolioListDto();
    }

    public PortfolioListDtoBuilder id(Integer id) {
      this.portfolioListDto.setId(id);
      return this;
    }

    public PortfolioListDtoBuilder title(String title) {
      this.portfolioListDto.setTitle(title);
      return this;
    }

    public PortfolioListDtoBuilder language(String language) {
      this.portfolioListDto.setLanguage(language);
      return this;
    }

    public PortfolioListDtoBuilder orderingNumber(Integer orderingNumber) {
      this.portfolioListDto.orderingNumber = orderingNumber;
      return this;
    }

    @Override
    public PortfolioListDto build() {
      return portfolioListDto;
    }
  }
}
