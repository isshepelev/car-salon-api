package ru.isshepelev.carsalonapi.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.isshepelev.carsalonapi.entity.user.JobEnum;
import ru.isshepelev.carsalonapi.service.JobService;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/job")
public class JobController {
    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping()
    public List<JobEnum> ListJob(){
        return Arrays.asList(JobEnum.values());
    }
}
