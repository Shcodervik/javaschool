package net.tsystems.springframe.services.mappers;

import net.tsystems.springframe.database.DriverstateEntity;
import net.tsystems.springframe.services.objects.DriverstateEntitySO;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

public interface DriverstateEntityMapper {
    DriverstateEntityMapper INSTANCE = Mappers.getMapper(DriverstateEntityMapper.class);
    DriverstateEntitySO driverstateEntityToDto(DriverstateEntity driverstateEntity);
}
