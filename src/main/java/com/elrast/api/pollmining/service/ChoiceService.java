package com.elrast.api.pollmining.service;

import com.elrast.api.pollmining.domain.Choice;
import com.elrast.api.pollmining.repository.ChoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChoiceService {

    @Autowired
    ChoiceRepository choiceRepository;

    public List<Choice> createChoices(List<String> options) {
        return choiceRepository.saveAll(convertDtosToChoices(options));
    }

    private List<Choice> convertDtosToChoices(List<String> optionDescriptions) {
        return optionDescriptions.stream().map(Choice::new).collect(Collectors.toList());
    }

}
