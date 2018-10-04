package net.tsystems.springframe.services.mappers;

import net.tsystems.springframe.database.DriverworkinfoEntityPK;
import net.tsystems.springframe.services.objects.DriverworkinfoEntityPKSO;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

public interface DriverworkinfoEntityPKMapper {
    DriverworkinfoEntityPKMapper INSTANCE = Mappers.getMapper(DriverworkinfoEntityPKMapper.class);
    DriverworkinfoEntityPKSO driverworkinfoEntityPKToDto(DriverworkinfoEntityPK driverworkinfoEntityPK);
}
