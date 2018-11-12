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
            @Mapping(target = "createDt", expression = "java(net.tsystems.springframe.services.Utils.datetimeToDate(orderEntity.getCreateDt()))"),
            @Mapping(target = "closeDt", expression = "java(net.tsystems.springframe.services.Utils.datetimeToDate(orderEntity.getCloseDt()))"),
    })
            OrderEntitySO orderEntityToDto(OrderEntity orderEntity);
    @Mappings({
            @Mapping(target = "closed", expression = "java(net.tsystems.springframe.services.Utils.boolToByte(orderEntitySO.getClosed()))"),
            @Mapping(target = "createDt", expression = "java(net.tsystems.springframe.services.Utils.dateToDatetime(orderEntitySO.getCreateDt()))"),
            @Mapping(target = "closeDt", expression = "java(net.tsystems.springframe.services.Utils.dateToDatetime(orderEntitySO.getCloseDt()))"),
    })
    OrderEntity orderDtoToEntity(OrderEntitySO orderEntitySO);
}
