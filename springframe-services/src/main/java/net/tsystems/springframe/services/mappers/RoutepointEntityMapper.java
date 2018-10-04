package net.tsystems.springframe.services.mappers;

import net.tsystems.springframe.database.RoutepointEntity;
import net.tsystems.springframe.services.objects.RoutepointEntitySO;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

public interface RoutepointEntityMapper {
    RoutepointEntityMapper INSTANCE = Mappers.getMapper(RoutepointEntityMapper.class);
    RoutepointEntitySO routepointEntityToDto(RoutepointEntity routepointEntity);
}
