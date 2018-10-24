package net.tsystems.springframe.services.mappers;

import net.tsystems.springframe.database.CargostateEntity;
import net.tsystems.springframe.services.objects.CargostateEntitySO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CargostateEntityMapper {
    CargostateEntityMapper INSTANCE = Mappers.getMapper(CargostateEntityMapper.class);
    CargostateEntitySO cargostateEntityToDto(CargostateEntity cargostateEntity);
    CargostateEntity cargostateDtoToEntity(CargostateEntitySO cargostateEntitySO);
}
