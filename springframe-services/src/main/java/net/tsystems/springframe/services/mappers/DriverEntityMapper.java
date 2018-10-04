package net.tsystems.springframe.services.mappers;

import net.tsystems.springframe.database.DriverEntity;
import net.tsystems.springframe.services.objects.DriverEntitySO;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

public interface DriverEntityMapper {
    DriverEntityMapper INSTANCE = Mappers.getMapper(DriverEntityMapper.class);
    DriverEntitySO cargoEntityToDto(DriverEntity driverEntity);
}
