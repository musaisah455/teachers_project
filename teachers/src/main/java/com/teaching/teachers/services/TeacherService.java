package com.teaching.teachers.services;

import com.teaching.teachers.dtos.TeacherRequestDTO;
import com.teaching.teachers.dtos.TeacherResponseDTO;
import com.teaching.teachers.entities.Teacher;
import com.teaching.teachers.mapper.TeacherMapper;
import com.teaching.teachers.repositories.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor   // Lombok: generates constructor for final fields
public class TeacherService {

    private final TeacherRepository teacherRepository;
    private final TeacherMapper teacherMapper;   // ← injected by Spring

    public List<TeacherResponseDTO> getAllTeachers() {
        return teacherMapper.toResponseList(teacherRepository.findAll());
    }

    public TeacherResponseDTO getTeacherById(Long id) {
        Teacher teacher = teacherRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Teacher not found with id: " + id));
        return teacherMapper.toResponseDTO(teacher);
    }

    public TeacherResponseDTO createTeacher(TeacherRequestDTO dto) {
        Teacher teacher = teacherMapper.toEntity(dto);
        Teacher saved = teacherRepository.save(teacher);
        return teacherMapper.toResponseDTO(saved);   // ← clean & readable
    }

    public TeacherResponseDTO updateTeacher(Long id, TeacherRequestDTO dto) {
        Teacher teacher = teacherRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Teacher not found with id: " + id));

        // Option 1: simple field-by-field (if you prefer control)
        // teacher.setFirstName(dto.getFirstName());
        // ...

        // Option 2: use MapStruct update method (recommended for larger entities)
        teacherMapper.updateEntityFromDto(dto, teacher);

        Teacher updated = teacherRepository.save(teacher);
        return teacherMapper.toResponseDTO(updated);
    }

    public void deleteTeacher(Long id) {
        if (!teacherRepository.existsById(id)) {
            throw new RuntimeException("Teacher not found with id: " + id);
        }
        teacherRepository.deleteById(id);
    }
}