package edu.students.settler.model.service.mapper;


public interface EntityMapper<E, D> {

    D mapToStudentDto(E entity);
}