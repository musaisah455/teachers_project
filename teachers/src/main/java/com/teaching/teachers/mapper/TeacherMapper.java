package com.teaching.teachers.mapper;

import com.teaching.teachers.dtos.TeacherRequestDTO;
import com.teaching.teachers.dtos.TeacherResponseDTO;
import com.teaching.teachers.entities.Teacher;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(
    componentModel = MappingConstants.ComponentModel.SPRING   // Makes it a Spring @Component → injectable
)
public interface TeacherMapper {

    // Request DTO → Entity (ignore id because it's generated)
    Teacher toEntity(TeacherRequestDTO dto);

    // Entity → Response DTO
    TeacherResponseDTO toResponseDTO(Teacher entity);

    // Bonus: list mapping (MapStruct handles collections automatically)
    List<TeacherResponseDTO> toResponseList(List<Teacher> entities);

    // Optional: update existing entity from DTO (useful for PUT)
    // By default ignores null values, but you can customize
    void updateEntityFromDto(TeacherRequestDTO dto, @MappingTarget Teacher entity);
}