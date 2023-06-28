package com.gev.backend;

import static org.mockito.Mockito.verify;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.gev.backend.io.repository.LabelRepository;
import com.gev.backend.service.LabelService;

@SpringBootTest
public class LabelServiceTest {

    @Mock
    private LabelRepository labelRepository;

    @InjectMocks
    private LabelService labelService;


}
