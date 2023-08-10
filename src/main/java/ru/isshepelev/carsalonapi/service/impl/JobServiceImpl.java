package ru.isshepelev.carsalonapi.service.impl;

import org.springframework.stereotype.Service;
import ru.isshepelev.carsalonapi.entity.job.DTO.JobDTO;
import ru.isshepelev.carsalonapi.entity.job.DTO.JobPaymentUpdateDTO;
import ru.isshepelev.carsalonapi.entity.job.Job;
import ru.isshepelev.carsalonapi.repository.JobRepository;
import ru.isshepelev.carsalonapi.service.JobService;

import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl implements JobService {

    private final JobRepository jobRepository;

    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public Job create(JobDTO jobDTO) {

        Optional<Job> existingJob = jobRepository.findByTitle(jobDTO.getTitle());
        if (existingJob.isPresent()){
            throw new RuntimeException("this work already exists");
        }

        Job job = new Job();
        job.setTitle(jobDTO.getTitle());
        job.setPayment(jobDTO.getPayment());
        return jobRepository.save(job);
    }

    @Override
    public List<Job> getWorkList() {
        return jobRepository.findAll();
    }

    @Override
    public void delete(String jobId) {
        jobRepository.deleteById(jobId);
    }

    @Override
    public void update(String jobId, JobPaymentUpdateDTO jobPaymentUpdateDTO) {
        Optional<Job> jobOptional = jobRepository.findById(jobId);
        if (jobOptional.isPresent()){
            Job job = jobOptional.get();
            job.setPayment(jobPaymentUpdateDTO.getPayment());
            jobRepository.save(job);
        }
    }
}
