package tr.com.erhankarakaya.web.bll.mapper;

import tr.com.erhankarakaya.web.bll.dto.AdminDto;
import tr.com.erhankarakaya.web.dal.entity.Admin;

/**
 * Created by erhan.karakaya on 3/1/2017.
 */
public class AdminMapper extends BaseMapper<Admin, AdminDto> {

  @Override
  public AdminDto mapEntityToDto(Admin admin) {
    AdminDto.AdminDtoBuilder adminDtoBuilder = new AdminDto.AdminDtoBuilder();

    AdminDto adminDto = adminDtoBuilder.id(admin.getId())
        .username(admin.getUsername())
        .password(admin.getPassword())
        .build();

    return adminDto;
  }

  @Override
  public Admin mapDtoToEntity(AdminDto adminDto) {
    Admin.AdminBuilder adminBuilder = new Admin.AdminBuilder();

    Admin admin = adminBuilder.id(adminDto.getId())
        .username(adminDto.getUsername())
        .password(adminDto.getPassword())
        .build();

    return admin;
  }
}
