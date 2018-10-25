package net.tsystems.springframe.services.mappers;

import net.tsystems.springframe.database.RoadEntity;
import net.tsystems.springframe.services.objects.RoadEntitySO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RoadEntityMapper {
    RoadEntityMapper INSTANCE = Mappers.getMapper(RoadEntityMapper.class);
    RoadEntitySO roadEntityToDto(RoadEntity roadEntity);
}
