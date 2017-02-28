package tr.com.erhankarakaya.web.common.enums;

import org.springframework.context.i18n.LocaleContextHolder;

import java.util.Locale;

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

  public static LanguageEnum getLanguageByLocale(Locale locale) {
    switch (locale.getLanguage().toLowerCase()) {
      case "en":
        return EN;
      case "tr":
      default:
        return TR;
    }
  }

  public static LanguageEnum getCurrentLanguage() {
    Locale locale = LocaleContextHolder.getLocale();
    return getLanguageByLocale(locale);
  }
}
