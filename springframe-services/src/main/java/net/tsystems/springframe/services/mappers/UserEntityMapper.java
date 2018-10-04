package net.tsystems.springframe.services.mappers;

import net.tsystems.springframe.database.UserEntity;
import net.tsystems.springframe.services.objects.UserEntitySO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserEntityMapper {
    UserEntityMapper INSTANCE = Mappers.getMapper(UserEntityMapper.class);

   // @Mapping(source="idUser", target="idUser")
    UserEntitySO userEntityToDto(UserEntity userEntity);
}
