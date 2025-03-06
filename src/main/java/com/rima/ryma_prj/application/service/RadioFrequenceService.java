package com.rima.ryma_prj.application.service;

import com.rima.ryma_prj.domain.model.RadioFrequency;
import com.rima.ryma_prj.domain.repository.RadioFrequencyRepository;

import java.util.List;
import java.util.Optional;

public class RadioFrequenceService {
    private final RadioFrequencyRepository radioFrequencyRepository;

    private RadioFrequenceService(RadioFrequencyRepository radioFrequencyRepository){
        this.radioFrequencyRepository = radioFrequencyRepository;

    }
    public List<RadioFrequency> getAllRadioFrequencies(){
        return radioFrequencyRepository.findAll();
    }
    public Optional<RadioFrequency> getRadioFrequencyById(Long id){
        return radioFrequencyRepository.findById(id);
    }
    public  RadioFrequency createRadioFrequency(RadioFrequency radioFrequency){
        return radioFrequencyRepository.save(radioFrequency);
    }
    public Optional<RadioFrequency> updateRadioFrequency(Long id, RadioFrequency updatedRadioFrequency) {
        return radioFrequencyRepository.findById(id).map(existing -> {
            existing.setUID(updatedRadioFrequency.getUID());
            return radioFrequencyRepository.save(existing);
        });
    }
    public boolean deleteRadioFrequency(Long id){
        if (radioFrequencyRepository.existsById(id)){
            radioFrequencyRepository.deleteById(id);
            return true;

        }
        return false;
    }

}
