package net.tsystems.springframe.services.mappers;

import net.tsystems.springframe.database.OrderexecutorEntity;
import net.tsystems.springframe.services.objects.OrderexecutorEntitySO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderexecutorEntityMapper {
    OrderexecutorEntityMapper INSTANCE = Mappers.getMapper(OrderexecutorEntityMapper.class);
    @Mappings({
            @Mapping(target = "orderIdOrder.closed", expression = "java(net.tsystems.springframe.services.Utils.byteToBool(orderEntity.getClosed()))"),
            @Mapping(target = "orderIdOrder.createDT", expression = "java(net.tsystems.springframe.services.Utils.datetimeToDate(orderEntity.getCreateDT()))"),
            @Mapping(target = "orderIdOrder.closeDT", expression = "java(net.tsystems.springframe.services.Utils.datetimeToDate(orderEntity.getCloseDT()))"),
    })
    OrderexecutorEntitySO orderexecutorEntityToDto(OrderexecutorEntity orderexecutorEntity);

    @Mappings({
            @Mapping(target="orderIdOrder.closed", expression="java(net.tsystems.springframe.services.Utils.boolToByte(orderEntitySO.getClosed()))"),
            @Mapping(target = "orderIdOrder.createDT", expression = "java(net.tsystems.springframe.services.Utils.dateToDatetime(orderEntitySO.getCreateDT()))"),
            @Mapping(target = "orderIdOrder.closeDT", expression = "java(net.tsystems.springframe.services.Utils.dateToDatetime(orderEntitySO.getCloseDT()))"),
    })
    OrderexecutorEntity orderexecutorDtoToEntity(OrderexecutorEntitySO orderexecutorEntitySO);
}
