package com.rima.ryma_prj.infrastructure.controller;

import com.rima.ryma_prj.application.service.RadioFrequenceService;
import com.rima.ryma_prj.domain.model.RadioFrequency;
import com.rima.ryma_prj.domain.repository.RadioFrequencyRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/radio-frequency")
public class RadioFrequencyController {
    private final RadioFrequenceService radioFrequenceService;

    public RadioFrequencyController(RadioFrequenceService radioFrequenceService) {
        this.radioFrequenceService = radioFrequenceService;
    }

    @GetMapping("/all")
    @PreAuthorize("hasAuthority('ROLE_SUPER_ADMIN')")
    public ResponseEntity<List<RadioFrequency>> getAllRadioFrequencies() {
        List<RadioFrequency> frequencies = radioFrequenceService.getAllRadioFrequencies();
        return ResponseEntity.ok(frequencies);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_SUPER_ADMIN')")
    public ResponseEntity<RadioFrequency> getRadioFrequencyById(@PathVariable Long id) {
        Optional<RadioFrequency> frequency = radioFrequenceService.getRadioFrequencyById(id);
        return frequency.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/Add")
    @PreAuthorize("hasAuthority('ROLE_SUPER_ADMIN')")
    public ResponseEntity<RadioFrequency> createRadioFrequency(@RequestBody RadioFrequency radioFrequency) {
        RadioFrequency savedFrequency = radioFrequencyService.createRadioFrequency(radioFrequency);
        return ResponseEntity.ok(savedFrequency);


    }
@PutMapping("/update/{id}")
@PreAuthorize("hasAuthority('ROLE_SUPER_ADMIN')")
public  ResponseEntity<RadioFrequency>updateRadioFrequency(@PathVariable Long id, @RequestBody RadioFrequency updatedRadioFrequency){
    Optional<RadioFrequency> updated = radioFrequencyService.updateRadioFrequency(id, updatedRadioFrequency);
    return updated.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());

}
@DeleteMapping("/delete/{id}")
@PreAuthorize("hasAuthority('ROLE_SUPER_ADMIN')")
public ResponseEntity<Void> deleteRadioFrequency(@PathVariable Long id){
        boolean deleted = radioFrequenceService.deleteRadioFrequency(id);
        return deleted ? ResponseEntity.noContent().build():ResponseEntity.notFound().build();
}

}
