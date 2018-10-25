package net.tsystems.springframe.services.mappers;

import net.tsystems.springframe.database.CargoEntity;
import net.tsystems.springframe.services.objects.CargoEntitySO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CargoEntityMapper {
    CargoEntityMapper INSTANCE = Mappers.getMapper(CargoEntityMapper.class);
    CargoEntitySO cargoEntityToDto(CargoEntity cargoEntity);
    CargoEntity cargoDtoToEntity(CargoEntitySO cargoEntitySO);
}
