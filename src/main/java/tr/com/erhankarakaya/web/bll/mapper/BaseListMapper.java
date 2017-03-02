package tr.com.erhankarakaya.web.bll.mapper;

import tr.com.erhankarakaya.web.bll.dto.Dto;
import tr.com.erhankarakaya.web.dal.entity.Entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by erhan.karakaya on 3/2/2017.
 */
public abstract class BaseListMapper<EntityT extends Entity, DtoT extends Dto> implements ListMapper<EntityT, DtoT> {

  @Override
  public List<DtoT> mapEntitiesToDtos(List<EntityT> entityTs) {
    List<DtoT> dtos = new ArrayList<DtoT>();
    entityTs.forEach(entityT -> dtos.add(mapEntityToDto(entityT)));
    return dtos;
  }
}
