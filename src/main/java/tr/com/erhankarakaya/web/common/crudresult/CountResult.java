package tr.com.erhankarakaya.web.common.crudresult;

/**
 * Created by erhan.karakaya on 3/1/2017.
 */
public class CountResult<T> extends CrudResult<T> {
  private long count;

  public long getCount() {
    return count;
  }

  public void setCount(long count) {
    this.count = count;
  }
}
