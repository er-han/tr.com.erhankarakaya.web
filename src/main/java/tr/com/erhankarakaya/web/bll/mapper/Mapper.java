package tr.com.erhankarakaya.web.bll.mapper;

import tr.com.erhankarakaya.web.bll.dto.Dto;
import tr.com.erhankarakaya.web.dal.entity.Entity;

import java.util.List;

/**
 * Created by erhan.karakaya on 3/1/2017.
 */
public interface Mapper<EntityT extends Entity, DtoT extends Dto> extends ListMapper<EntityT, DtoT>{

  EntityT mapDtoToEntity(DtoT dtoT);

  List<EntityT> mapDtosToEntities(List<DtoT> dtoTs);
}
