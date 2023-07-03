package com.gev.backend;

import com.gev.backend.io.repository.LabelRepository;
import com.gev.backend.service.LabelService;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LabelServiceTest {
    
    @Mock
    private LabelRepository labelRepository;
    
    @InjectMocks
    private LabelService labelService;
    
    
}
