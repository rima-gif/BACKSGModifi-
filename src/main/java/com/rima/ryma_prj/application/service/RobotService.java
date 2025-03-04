package com.rima.ryma_prj.application.service;

import com.rima.ryma_prj.domain.model.Robot;
import com.rima.ryma_prj.domain.repository.RobotRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class RobotService {

    private final RobotRepository robotRepository;


    public RobotService(RobotRepository robotRepository) {

        this.robotRepository = robotRepository;
    }

    public List<Robot> getAllRobots() {
       return robotRepository.findAll();
    }

    public Optional<Robot> getRobotById(Long id) {

        return robotRepository.findById(id);
    }


    public Robot updateRobot(Long id, Robot robotDetails) {
        return robotRepository.findById(id).map(robot -> {
            robot.setName(robotDetails.getName());
            robot.setStatus(robotDetails.getStatus());
            return robotRepository.save(robot);
        }).orElseThrow(() -> new RuntimeException("Robot non trouvé"));
    }


    public Robot addRobot(Robot robot) {
        return robotRepository.save(robot);
    }

    public void deleteRobot(Long id) {
        robotRepository.deleteById(id);


    }
}
