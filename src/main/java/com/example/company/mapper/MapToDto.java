package com.example.company.mapper;

import com.example.company.model.Employee;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class MapToDto {

    @Bean
    public ModelMapper getModelMapper(){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addMappings(new PropertyMap<Employee, EmployeeDto>(){
            @Override
            protected void configure(){
                map().setName(source.getName());
                map().setSurname(source.getSurname());
                map().setCity(source.getAddress().getCity());
                map().setPosition(source.getSensitiveData().getPosition());
            }
        });

        return modelMapper;
    }
}
