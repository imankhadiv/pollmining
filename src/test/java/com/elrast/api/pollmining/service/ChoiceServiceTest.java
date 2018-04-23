package com.elrast.api.pollmining.service;

import com.elrast.api.pollmining.domain.Choice;
import com.elrast.api.pollmining.repository.ChoiceRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ChoiceServiceTest {

    @InjectMocks
    ChoiceService choiceService;

    @Mock
    ChoiceRepository choiceRepository;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldCreateChoices() {

        List<Choice> options = Arrays.asList(new Choice("option1"), new Choice("option2"), new Choice("option3"));
        when(choiceRepository.findAll()).thenReturn(null);
        when(choiceRepository.saveAll(options)).thenReturn(options);

        List<String> list = Arrays.asList("option1", "option2", "option3");
        List<Choice> choices = choiceService.createChoices(list);

        Assert.assertEquals(options, choices);
        verify(choiceRepository).saveAll(options);

    }

}
