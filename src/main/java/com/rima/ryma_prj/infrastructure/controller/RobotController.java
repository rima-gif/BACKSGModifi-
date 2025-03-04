package com.rima.ryma_prj.infrastructure.controller;

import com.rima.ryma_prj.application.service.RobotService;
import com.rima.ryma_prj.domain.model.Robot;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/robots")

public class RobotController {
    private final RobotService robotService;

    public RobotController(RobotService robotService) {
        this.robotService = robotService;
    }

    @PostMapping("/add")
    @PreAuthorize("hasAnyAuthority ('ROLE_SUPER_ADMIN')")
    public Robot addRobot(@RequestBody Robot robot) {
        return robotService.addRobot(robot);
    }

}










