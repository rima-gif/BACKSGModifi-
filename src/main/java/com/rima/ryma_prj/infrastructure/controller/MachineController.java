package com.rima.ryma_prj.infrastructure.controller;

import com.rima.ryma_prj.application.service.MachineService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/machines")
public class MachineController {
    private final MachineService machineService;
    public MachineController(MachineService machineService){
        this.machineService=machineService;
    }
    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_SUPER_ADMIN')")
public
}
