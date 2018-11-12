package net.tsystems.springframe.services.mappers;

import net.tsystems.springframe.database.UserEntity;
import net.tsystems.springframe.services.objects.UserEntitySO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserEntityMapper {
    UserEntityMapper INSTANCE = Mappers.getMapper(UserEntityMapper.class);

    @Mapping(target="isEmployee", expression="java(net.tsystems.springframe.services.Utils.byteToBool(userEntity.getIsEmployee()))")
    UserEntitySO userEntityToDto(UserEntity userEntity);

    @Mapping(target="isEmployee", expression="java(net.tsystems.springframe.services.Utils.boolToByte(userEntitySO.getIsEmployee()))")
    UserEntity userDtoToEntity(UserEntitySO userEntitySO);
}
