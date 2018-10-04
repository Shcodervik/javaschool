package net.tsystems.springframe.services.mappers;

import net.tsystems.springframe.database.TruckEntity;
import net.tsystems.springframe.services.objects.TruckEntitySO;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

public interface TruckEntityMapper {
    TruckEntityMapper INSTANCE = Mappers.getMapper(TruckEntityMapper.class);
    TruckEntitySO truckEntityToDto(TruckEntity truckEntity);
}
