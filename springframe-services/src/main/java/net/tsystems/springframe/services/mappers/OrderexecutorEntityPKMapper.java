package net.tsystems.springframe.services.mappers;

import net.tsystems.springframe.database.OrderexecutorEntityPK;
import net.tsystems.springframe.services.objects.OrderexecutorEntityPKSO;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

public interface OrderexecutorEntityPKMapper {
    OrderexecutorEntityPKMapper INSTANCE = Mappers.getMapper(OrderexecutorEntityPKMapper.class);
    OrderexecutorEntityPKSO orderexecutorEntityPKToDto(OrderexecutorEntityPK orderexecutorEntityPK);
}
