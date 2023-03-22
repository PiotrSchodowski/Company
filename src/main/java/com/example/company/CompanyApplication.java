package com.example.company;

import com.example.company.mapper.EmployeeDto;
import com.example.company.model.Employee;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CompanyApplication {

	public static void main(String[] args) {
		SpringApplication.run(CompanyApplication.class, args);
	}

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
