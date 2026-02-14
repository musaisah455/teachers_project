package com.teaching.teachers.service;

import com.teaching.teachers.dtos.TeacherRequestDTO;
import com.teaching.teachers.dtos.TeacherResponseDTO;
import com.teaching.teachers.entities.Teacher;
import com.teaching.teachers.repositories.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeacherService {

    private final TeacherRepository teacherRepository;

    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public List<TeacherResponseDTO> getAllTeachers() {
        return teacherRepository.findAll().stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    public TeacherResponseDTO getTeacherById(Long id) {
        Teacher teacher = teacherRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Teacher not found with id: " + id));
        return toResponseDTO(teacher);
    }

    public TeacherResponseDTO createTeacher(TeacherRequestDTO dto) {
        Teacher teacher = toEntity(dto);
        Teacher saved = teacherRepository.save(teacher);
        return toResponseDTO(saved);
    }

    public TeacherResponseDTO updateTeacher(Long id, TeacherRequestDTO dto) {
        Teacher teacher = teacherRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Teacher not found with id: " + id));

        // Update only allowed fields
        teacher.setFirstName(dto.getFirstName());
        teacher.setLastName(dto.getLastName());
        teacher.setAddress(dto.getAddress());
        teacher.setSchool(dto.getSchool());

        Teacher updated = teacherRepository.save(teacher);
        return toResponseDTO(updated);
    }

    public void deleteTeacher(Long id) {
        if (!teacherRepository.existsById(id)) {
            throw new RuntimeException("Teacher not found with id: " + id);
        }
        teacherRepository.deleteById(id);
    }

    // Simple manual mapping (you can later replace with MapStruct)
    private Teacher toEntity(TeacherRequestDTO dto) {
        return Teacher.builder()
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .address(dto.getAddress())
                .school(dto.getSchool())
                .build();
    }

    private TeacherResponseDTO toResponseDTO(Teacher teacher) {
        return new TeacherResponseDTO(
                teacher.getId(),
                teacher.getFirstName(),
                teacher.getLastName(),
                teacher.getAddress(),
                teacher.getSchool()
        );
    }
}