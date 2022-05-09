package com.exampleSpringBoot.springBootFirstApiRest.mappers;

import com.exampleSpringBoot.springBootFirstApiRest.dto.UserDto;
import com.exampleSpringBoot.springBootFirstApiRest.model.User;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(source = "firstName", target = "firstName")
    @Mapping(source = "lastName", target = "lastName")
    @Mapping(source = "email", target = "email")
    UserDto modelToDto(User user);

    List<UserDto> modelsToDtos(List<User> users);

    @InheritInverseConfiguration
    User dtoToModel(UserDto userDto);

}
