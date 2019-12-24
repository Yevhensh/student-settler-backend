package edu.students.settler.model.service.impl;

import edu.students.settler.model.entity.Dormitory;
import edu.students.settler.model.repository.DormitoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static java.util.Collections.emptyList;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class DormitoryServiceImplTest {

    @InjectMocks
    private DormitoryServiceImpl underTest;
    @Mock
    private DormitoryRepository dormitoryRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testFindAll() {
        when(dormitoryRepository.findAll()).thenReturn(emptyList());

        List<Dormitory> result = underTest.findAll();

        verify(dormitoryRepository).findAll();
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }
}