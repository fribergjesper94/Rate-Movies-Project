package com.example.almgroupproject;

import com.example.almgroupproject.models.Director;
import com.example.almgroupproject.repositories.DirectorRepository;
import com.example.almgroupproject.service.DirectorService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DirectorServiceTest {

    @Mock
    DirectorRepository mockRepository;

    @Test
    void saveDirectorTest() {
        Director director1 = new Director(1, "Pål", "Pålsson", "Man");
        DirectorService service = new DirectorService(mockRepository);

        assertEquals(service.save(director1), "Director saved");
        when(mockRepository.findDirectorByFirstNameAndLastName(director1.getFirstName(), director1.getLastName())).thenReturn(director1);
        assertEquals(service.save(director1), "Director already exists");
    }

    @Test
    void getAllDirectorsTest() {
        Director director1 = new Director(1, "Pål", "Pålsson", "Man");
        Director director2 = new Director(2, "Agda", "Braun", "Kvinna");
        Director director3 = new Director(3, "Jason", "Vorhees", "Annat");
        DirectorService service = new DirectorService(mockRepository);
        List<Director> completeDirectorList = new ArrayList<>();
        completeDirectorList.add(director1);
        completeDirectorList.add(director2);
        completeDirectorList.add(director3);

        when(mockRepository.findAll()).thenReturn(completeDirectorList);
        assertEquals(service.getAllDirectors(), Arrays.asList(director1, director2, director3));
    }
}
