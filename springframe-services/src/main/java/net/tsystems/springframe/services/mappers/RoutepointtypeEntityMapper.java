package net.tsystems.springframe.services.mappers;

import net.tsystems.springframe.database.RoutepointtypeEntity;
import net.tsystems.springframe.services.objects.RoutepointtypeEntitySO;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

public interface RoutepointtypeEntityMapper {
    RoutepointtypeEntityMapper INSTANCE = Mappers.getMapper(RoutepointtypeEntityMapper.class);
    RoutepointtypeEntitySO routepointtypeEntityToDto(RoutepointtypeEntity routepointtypeEntity);
}
