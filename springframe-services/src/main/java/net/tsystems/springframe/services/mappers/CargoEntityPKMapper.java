package net.tsystems.springframe.services.mappers;

import net.tsystems.springframe.database.CargoEntityPK;
import net.tsystems.springframe.services.objects.CargoEntityPKSO;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

public interface CargoEntityPKMapper {
    CargoEntityPKMapper INSTANCE = Mappers.getMapper(CargoEntityPKMapper.class);
    CargoEntityPKSO cargoEntityPKToDto(CargoEntityPK cargoEntityPK);

}
