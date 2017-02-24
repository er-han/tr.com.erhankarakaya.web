package tr.com.erhankarakaya.web.common.enums;

/**
 * Created by erhan.karakaya on 2/24/2017.
 */
public enum LanguageEnum {
  TR(1), EN(2);

  private Integer id;

  LanguageEnum(Integer id) {
    this.id = id;
  }

  public Integer getId() {
    return id;
  }
}
