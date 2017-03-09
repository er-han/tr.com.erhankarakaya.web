package tr.com.erhankarakaya.web.common.enums;

/**
 * Created by erhan.karakaya on 2/24/2017.
 */
public enum ResultEnum {
  SUCCESS, WARNING, ERROR, NA;

  public boolean isSuccess() {
    return this == ResultEnum.SUCCESS;
  }
}
