package tr.com.erhankarakaya.web.common.crudresult;

import org.springframework.data.domain.Page;
import tr.com.erhankarakaya.web.bll.dto.Dto;
import tr.com.erhankarakaya.web.common.enums.ResultEnum;
import tr.com.erhankarakaya.web.dal.entity.Entity;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

/**
 * Created by erhan.karakaya on 2/24/2017.
 */
public class CrudResult<T> {
  private ResultEnum result;
  private Optional<T> returnDto;
  private Optional<List<T>> returnDtos;
  private String message;

  public ResultEnum getResult() {
    return result;
  }

  public void setResult(ResultEnum result) {
    this.result = result;
  }

  public Optional<T> getReturnDto() {
    if (returnDto==null) {
      returnDto = Optional.empty();
    }
    return returnDto;
  }

  public void setReturnDto(T returnDto) {
    this.returnDto = Optional.of(returnDto);
  }

  public void setReturnDto(Optional<T> returnDto) {
    this.returnDto = returnDto;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public boolean isSuccess() {
    return getResult().isSuccess();
  }

  public Optional<List<T>> getReturnDtos() {
    return returnDtos;
  }

  public void setReturnDtos(List<T> returnPageDtos) {
    this.returnDtos = Optional.of(returnPageDtos);
  }

}
