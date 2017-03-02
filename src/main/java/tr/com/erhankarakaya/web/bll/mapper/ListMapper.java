package tr.com.erhankarakaya.web.bll.mapper;

import tr.com.erhankarakaya.web.bll.dto.Dto;
import tr.com.erhankarakaya.web.dal.entity.Entity;

import java.util.List;

/**
 * Created by erhan.karakaya on 3/2/2017.
 */
public interface ListMapper<EntityT extends Entity, DtoT extends Dto> {
  DtoT mapEntityToDto(EntityT entityT);

  List<DtoT> mapEntitiesToDtos(List<EntityT> entityTs);

}
