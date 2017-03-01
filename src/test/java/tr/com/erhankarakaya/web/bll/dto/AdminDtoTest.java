package tr.com.erhankarakaya.web.bll.dto;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by erhan.karakaya on 3/1/2017.
 */

public class AdminDtoTest {

  private static final Integer ID = 1;
  private static final String USERNAME = "USERNAME";
  private static final String PASSWORD = "PASSWORD";

  @Test
  public void builderSetsAllFieldsCorrect() {
    AdminDto.AdminDtoBuilder adminDtoBuilder = new AdminDto.AdminDtoBuilder();
    AdminDto adminDto = adminDtoBuilder.id(ID)
        .username(USERNAME)
        .password(PASSWORD)
        .build();

    assertNotNull(adminDto);
    assertEquals(ID, adminDto.getId());
    assertEquals(USERNAME, adminDto.getUsername());
    assertEquals(PASSWORD, adminDto.getPassword());
  }
}