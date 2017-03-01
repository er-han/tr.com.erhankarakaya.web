package tr.com.erhankarakaya.web.bll.dto;

import tr.com.erhankarakaya.web.common.builder.Builder;

/**
 * Created by erhan.karakaya on 3/1/2017.
 */
public class AdminDto extends BaseDto {

  private Integer id;
  private String username;
  private String password;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public static class AdminDtoBuilder implements Builder<AdminDto> {

    private AdminDto adminDto;

    public AdminDtoBuilder() {
      adminDto = new AdminDto();
    }

    public AdminDtoBuilder id(Integer id) {
      this.adminDto.id = id;
      return this;
    }

    public AdminDtoBuilder username(String username) {
      this.adminDto.username = username;
      return this;
    }

    public AdminDtoBuilder password(String password) {
      this.adminDto.password = password;
      return this;
    }

    @Override
    public AdminDto build() {
      return adminDto;
    }
  }
}
