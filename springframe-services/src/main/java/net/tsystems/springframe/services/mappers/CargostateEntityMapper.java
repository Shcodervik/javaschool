package net.tsystems.springframe.services.mappers;

import net.tsystems.springframe.database.CargostateEntity;
import net.tsystems.springframe.services.objects.CargostateEntitySO;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

public interface CargostateEntityMapper {
    CargostateEntityMapper INSTANCE = Mappers.getMapper(CargostateEntityMapper.class);
    CargostateEntitySO cargostateEntityToDto(CargostateEntity cargostateEntity);
}
