package tr.com.erhankarakaya.web.bll.service;

import tr.com.erhankarakaya.web.bll.dto.AdminDto;

import java.util.Optional;

/**
 * Created by erhan.karakaya on 3/1/2017.
 */
public interface AdminService {
  AdminDto login(String name, String password);

  AdminDto findByName(String name);
}
