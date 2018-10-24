package net.tsystems.springframe.services.mappers;

import net.tsystems.springframe.database.DriverstateEntity;
import net.tsystems.springframe.services.objects.DriverstateEntitySO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DriverstateEntityMapper {
    DriverstateEntityMapper INSTANCE = Mappers.getMapper(DriverstateEntityMapper.class);
    DriverstateEntitySO driverstateEntityToDto(DriverstateEntity driverstateEntity);
}
