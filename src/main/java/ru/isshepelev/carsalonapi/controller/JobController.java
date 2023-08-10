package ru.isshepelev.carsalonapi.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.isshepelev.carsalonapi.entity.job.DTO.JobDTO;
import ru.isshepelev.carsalonapi.entity.job.DTO.JobPaymentUpdateDTO;
import ru.isshepelev.carsalonapi.entity.job.Job;
import ru.isshepelev.carsalonapi.service.JobService;

import java.util.List;

@RestController
@RequestMapping("/job")
public class JobController {
    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }


    @GetMapping()
    public ResponseEntity<List<Job>> workList(){
        return ResponseEntity.ok(jobService.getWorkList());
    }

    @PostMapping("/create")
    public ResponseEntity<Job> createJob(@RequestBody JobDTO jobDTO){
        return ResponseEntity.ok(jobService.create(jobDTO));
    }
    @DeleteMapping("/delete/{jobId}")
    public ResponseEntity<Void> deleteJob(@PathVariable String jobId){
        jobService.delete(jobId);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/update/{jobId}")
    public ResponseEntity<Void> updateJob(@PathVariable String jobId,
                                          @RequestBody JobPaymentUpdateDTO jobPaymentUpdateDTO){
        jobService.update(jobId,jobPaymentUpdateDTO);
        return ResponseEntity.noContent().build();
    }
}
