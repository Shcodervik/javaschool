package net.tsystems.springframe.services.mappers;

import net.tsystems.springframe.database.RoadEntity;
import net.tsystems.springframe.services.objects.RoadEntitySO;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

public interface RoadEntityMapper {
    RoadEntityMapper INSTANCE = Mappers.getMapper(RoadEntityMapper.class);
    RoadEntitySO roadEntityToDto(RoadEntity roadEntity);
}
