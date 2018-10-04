package net.tsystems.springframe.services.mappers;

import net.tsystems.springframe.database.TruckEntityPK;
import net.tsystems.springframe.services.objects.TruckEntityPKSO;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

public interface TruckEntityPKMapper {
    TruckEntityPKMapper INSTANCE = Mappers.getMapper(TruckEntityPKMapper.class);
    TruckEntityPKSO truckEntityPKToDto(TruckEntityPK truckEntityPK);
}
