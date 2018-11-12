package net.tsystems.springframe.services.mappers;

import net.tsystems.springframe.database.OrderexecutorEntity;
import net.tsystems.springframe.services.objects.OrderexecutorEntitySO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderexecutorEntityMapper {
    OrderexecutorEntityMapper INSTANCE = Mappers.getMapper(OrderexecutorEntityMapper.class);
    @Mapping(target="orderIdOrder.closed", expression="java(net.tsystems.springframe.services.Utils.byteToBool(orderEntity.getClosed()))")
    OrderexecutorEntitySO orderexecutorEntityToDto(OrderexecutorEntity orderexecutorEntity);

    @Mapping(target="orderIdOrder.closed", expression="java(net.tsystems.springframe.services.Utils.boolToByte(orderEntitySO.getClosed()))")
    OrderexecutorEntity orderexecutorDtoToEntity(OrderexecutorEntitySO orderexecutorEntitySO);
}
