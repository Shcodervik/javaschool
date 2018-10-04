package net.tsystems.springframe.services.mappers;

import net.tsystems.springframe.database.CityEntity;
import net.tsystems.springframe.services.objects.CityEntitySO;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

public interface CityEntityMapper {
    CityEntityMapper INSTANCE = Mappers.getMapper(CityEntityMapper.class);
    CityEntitySO cityEntityToDto(CityEntity cityEntity);
}
