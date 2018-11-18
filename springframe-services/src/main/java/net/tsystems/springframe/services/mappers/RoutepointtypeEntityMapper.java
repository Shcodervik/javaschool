package net.tsystems.springframe.services.mappers;

import net.tsystems.springframe.database.RoutepointtypeEntity;
import net.tsystems.springframe.services.objects.RoutepointtypeEntitySO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RoutepointtypeEntityMapper {
    RoutepointtypeEntityMapper INSTANCE = Mappers.getMapper(RoutepointtypeEntityMapper.class);
    RoutepointtypeEntitySO routepointtypeEntityToDto(RoutepointtypeEntity routepointtypeEntity);
    RoutepointtypeEntity routepointtypeDtoToEntity(RoutepointtypeEntitySO routepointtypeEntitySO);
}
