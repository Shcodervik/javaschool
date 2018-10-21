package net.tsystems.springframe.services.mappers;

import net.tsystems.springframe.database.DriverEntity;
import net.tsystems.springframe.services.objects.DriverEntitySO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DriverEntityMapper {
    DriverEntityMapper INSTANCE = Mappers.getMapper(DriverEntityMapper.class);
    DriverEntitySO driverEntityToDto(DriverEntity driverEntity);
    DriverEntity driverDtoToEntity(DriverEntitySO driverEntitySO);
}
