package ru.isshepelev.carsalonapi.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.isshepelev.carsalonapi.entity.job.DTO.JobDTO;
import ru.isshepelev.carsalonapi.entity.job.DTO.JobPaymentUpdateDTO;
import ru.isshepelev.carsalonapi.entity.job.Job;
import ru.isshepelev.carsalonapi.entity.user.User;
import ru.isshepelev.carsalonapi.service.JobService;
import ru.isshepelev.carsalonapi.service.UserService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/job")
public class JobController {
    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }


    @GetMapping()
    public ResponseEntity<List<Job>> workList() {
        return ResponseEntity.ok(jobService.getWorkList());
    }

    @PostMapping("/create")
    public ResponseEntity<Job> createJob(@Valid @RequestBody JobDTO jobDTO) {
        return ResponseEntity.ok(jobService.create(jobDTO));
    }

    @DeleteMapping("/delete/{jobId}")
    public ResponseEntity<String> deleteJob(@PathVariable String jobId) {
        jobService.delete(jobId);
        return ResponseEntity.ok("successfully");
    }

    @PutMapping("/update/{jobId}")
    public ResponseEntity<String> updateJob(@PathVariable String jobId,
                                          @RequestBody @Valid JobPaymentUpdateDTO jobPaymentUpdateDTO) {
        jobService.update(jobId, jobPaymentUpdateDTO);
        return ResponseEntity.ok("successfully");
    }

    @PostMapping("/start-work/{user_id}")
    public ResponseEntity<String> startWork(@PathVariable String user_id){
        jobService.startWork(user_id);
        return ResponseEntity.ok("user successfully logged in");
    }
    @PostMapping("/stop-work/{user_id}")
    public ResponseEntity<String> stopWork(@PathVariable String user_id){
        jobService.stopWork(user_id);
        return ResponseEntity.ok("the user has successfully completed the work");
    }
}
