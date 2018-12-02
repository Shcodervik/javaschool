package net.tsystems.springframe.services.mappers;

import net.tsystems.springframe.database.OrderEntity;
import net.tsystems.springframe.services.objects.OrderEntitySO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderEntityMapper {
    OrderEntityMapper INSTANCE = Mappers.getMapper(OrderEntityMapper.class);
    @Mappings({
            @Mapping(target = "closed", expression = "java(net.tsystems.springframe.services.Utils.byteToBool(orderEntity.getClosed()))"),
            @Mapping(target = "createDT", expression = "java(net.tsystems.springframe.services.Utils.datetimeToDate(orderEntity.getCreateDT()))"),
            @Mapping(target = "closeDT", expression = "java(net.tsystems.springframe.services.Utils.datetimeToDate(orderEntity.getCloseDT()))"),
    })
            OrderEntitySO orderEntityToDto(OrderEntity orderEntity);
    @Mappings({
            @Mapping(target = "closed", expression = "java(net.tsystems.springframe.services.Utils.boolToByte(orderEntitySO.getClosed()))"),
            @Mapping(target = "createDT", expression = "java(net.tsystems.springframe.services.Utils.dateToDatetime(orderEntitySO.getCreateDT()))"),
            @Mapping(target = "closeDT", expression = "java(net.tsystems.springframe.services.Utils.dateToDatetime(orderEntitySO.getCloseDT()))"),
    })
    OrderEntity orderDtoToEntity(OrderEntitySO orderEntitySO);
}
