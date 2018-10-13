package net.tsystems.springframe.services.mappers;

import net.tsystems.springframe.database.TruckstateEntity;
import net.tsystems.springframe.services.objects.TruckstateEntitySO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TruckstateEntityMapper {
    TruckstateEntityMapper INSTANCE = Mappers.getMapper(TruckstateEntityMapper.class);
    TruckstateEntitySO truckstateEntityToDto(TruckstateEntity truckstateEntity);
}
