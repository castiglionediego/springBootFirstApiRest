package com.exampleSpringBoot.springBootFirstApiRest.unit;

import com.exampleSpringBoot.springBootFirstApiRest.dto.UserDto;
import com.exampleSpringBoot.springBootFirstApiRest.mappers.UserMapper;
import com.exampleSpringBoot.springBootFirstApiRest.model.User;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class UserMappeTest {

    @Test
    void testMappingModelToDto() {

        User user = new User();
        user.setFirstName("Diego");
        user.setLastName("Castiglione");
        user.setEmail("diego@mail.com");

        UserDto userDto = UserMapper.INSTANCE.modelToDto(user);
        assertEquals("Diego", userDto.getFirstName());
        assertEquals("Castiglione", userDto.getLastName());
        assertEquals("diego@mail.com", userDto.getEmail());

    }

    @Test
    void testMappingDtoToModel() {

        UserDto userDto = new UserDto();
        userDto.setFirstName("Diego");
        userDto.setLastName("Castiglione");
        userDto.setEmail("diego@mail.com");

        User user = UserMapper.INSTANCE.dtoToModel(userDto);
        assertEquals("Diego", user.getFirstName());
        assertEquals("Castiglione", user.getLastName());
        assertEquals("diego@mail.com", user.getEmail());

    }

}
