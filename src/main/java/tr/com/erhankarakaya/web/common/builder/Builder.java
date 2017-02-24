package tr.com.erhankarakaya.web.common.builder;

/**
 * Created by erhan.karakaya on 2/24/2017.
 */
public interface Builder<T extends Buildable> {
  T build();
}
