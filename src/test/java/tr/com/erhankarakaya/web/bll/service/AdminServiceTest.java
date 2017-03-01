package tr.com.erhankarakaya.web.bll.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tr.com.erhankarakaya.web.bll.dto.AdminDto;
import tr.com.erhankarakaya.web.dal.entity.Admin;
import tr.com.erhankarakaya.web.dal.repository.AdminRepository;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

/**
 * Created by erhan.karakaya on 3/1/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AdminServiceTestConfig.class, AdminServiceImpl.class})
public class AdminServiceTest {

  private static final Integer ID = 1;
  private static final String USERNAME = "ADMIN";
  private static final String PASSWORD = "PASSWORD";

  @Autowired
  private AdminRepository adminRepository;

  @Autowired
  private AdminService adminService;

  @Test
  public void shouldLoadUserByUsername() {

    Admin.AdminBuilder adminBuilder = new Admin.AdminBuilder();
    Admin admin = adminBuilder.id(ID)
        .username(USERNAME)
        .password(PASSWORD)
        .build();

    when(adminRepository.findByUsername(USERNAME)).thenReturn(admin);

    AdminDto adminDto = adminService.findByName(USERNAME);

    assertNotNull(adminDto);
    assertEquals(ID, adminDto.getId());
    assertEquals(USERNAME, adminDto.getUsername());
    assertEquals(PASSWORD, admin.getPassword());
  }
}