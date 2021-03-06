package tr.com.erhankarakaya.web.bll.mapper;

import tr.com.erhankarakaya.web.bll.dto.Dto;
import tr.com.erhankarakaya.web.dal.entity.Entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by erhan.karakaya on 3/1/2017.
 */
public abstract class BaseMapper<EntityT extends Entity, DtoT extends Dto> extends BaseListMapper<EntityT, DtoT> implements Mapper<EntityT, DtoT> {
  @Override
  public List<EntityT> mapDtosToEntities(List<DtoT> dtoTs) {
    List<EntityT> entityTs = new ArrayList<EntityT>();
    dtoTs.forEach(dtoT -> entityTs.add(mapDtoToEntity(dtoT)));
    return entityTs;
  }
}
