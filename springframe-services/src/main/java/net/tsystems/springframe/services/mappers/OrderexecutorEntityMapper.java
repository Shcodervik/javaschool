package net.tsystems.springframe.services.mappers;

import net.tsystems.springframe.database.OrderexecutorEntity;
import net.tsystems.springframe.services.objects.OrderexecutorEntitySO;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

public interface OrderexecutorEntityMapper {
    OrderexecutorEntityMapper INSTANCE = Mappers.getMapper(OrderexecutorEntityMapper.class);
    OrderexecutorEntitySO orderexecutorEntityToDto(OrderexecutorEntity orderexecutorEntity);
}
