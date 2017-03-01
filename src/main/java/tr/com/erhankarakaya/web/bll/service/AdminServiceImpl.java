package tr.com.erhankarakaya.web.bll.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import tr.com.erhankarakaya.web.bll.dto.AdminDto;
import tr.com.erhankarakaya.web.dal.entity.Admin;
import tr.com.erhankarakaya.web.dal.repository.AdminRepository;

/**
 * Created by erhan.karakaya on 3/1/2017.
 */
@Service
public class AdminServiceImpl implements AdminService, UserDetailsService {
  private static final Logger LOGGER = LoggerFactory.getLogger(AdminServiceImpl.class);

  @Autowired
  private AdminRepository adminRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    AdminDto adminDto = this.findByName(username);

    if (adminDto == null) {
      LOGGER.error("-------------Username: " + username + " not found");
      throw new UsernameNotFoundException("Username: " + username + " not found");
    }
    LOGGER.info("-------------Username: " + username + " found");
    return adminDto;
  }

  @Override
  public AdminDto login(String name, String password) {
    Admin admin = adminRepository.findByUsernameAndPassword(name, password);

    AdminDto adminDto = null;
    if (admin != null) {

      AdminDto.AdminDtoBuilder adminDtoBuilder = new AdminDto.AdminDtoBuilder();

      adminDto = adminDtoBuilder.id(admin.getId())
          .username(admin.getUsername())
          .password(admin.getPassword())
          .build();
    }
    return adminDto;
  }

  @Override
  public AdminDto findByName(String name) {
    Admin admin = adminRepository.findByUsername(name);

    AdminDto adminDto = null;
    if (admin != null) {

      AdminDto.AdminDtoBuilder adminDtoBuilder = new AdminDto.AdminDtoBuilder();

      adminDto = adminDtoBuilder.id(admin.getId())
          .username(admin.getUsername())
          .password(admin.getPassword())
          .build();
    }
    return adminDto;
  }
}
