package net.tsystems.springframe.services.mappers;

import net.tsystems.springframe.database.DriverworkinfoEntity;
import net.tsystems.springframe.services.objects.DriverworkinfoEntitySO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DriverworkinfoEntityMapper {
    DriverworkinfoEntityMapper INSTANCE = Mappers.getMapper(DriverworkinfoEntityMapper.class);
    DriverworkinfoEntitySO driverworkinfoEntityToDto(DriverworkinfoEntity drivervorkinfoEntity);
}
