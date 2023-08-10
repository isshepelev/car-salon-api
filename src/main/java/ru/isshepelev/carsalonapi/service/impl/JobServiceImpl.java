package ru.isshepelev.carsalonapi.service.impl;

import org.springframework.stereotype.Service;
import ru.isshepelev.carsalonapi.entity.job.DTO.JobDTO;
import ru.isshepelev.carsalonapi.entity.job.DTO.JobPaymentUpdateDTO;
import ru.isshepelev.carsalonapi.entity.job.Job;
import ru.isshepelev.carsalonapi.entity.user.User;
import ru.isshepelev.carsalonapi.repository.JobRepository;
import ru.isshepelev.carsalonapi.repository.UserRepository;
import ru.isshepelev.carsalonapi.service.JobService;

import java.math.BigDecimal;
import java.math.MathContext;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl implements JobService {

    private final JobRepository jobRepository;
    private final UserRepository userRepository;

    public JobServiceImpl(JobRepository jobRepository, UserRepository userRepository) {
        this.jobRepository = jobRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Job create(JobDTO jobDTO) {

        Optional<Job> existingJob = jobRepository.findByTitle(jobDTO.getTitle());
        if (existingJob.isPresent()) {
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
        if (jobOptional.isPresent()) {
            Job job = jobOptional.get();
            job.setPayment(jobPaymentUpdateDTO.getPayment());
            jobRepository.save(job);
        }
    }

    @Override
    public void startWork(String user_id) {
        Optional<User> userOptional = userRepository.findById(user_id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setStartTime(LocalDateTime.now());
            userRepository.save(user);
        } else throw new RuntimeException("user not found");
    }

    @Override
    public void stopWork(String user_id) {
        Optional<User> userOptional = userRepository.findById(user_id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();

            LocalDateTime endTime = LocalDateTime.now();
            long secondsDifference = Duration.between(user.getStartTime(), endTime).getSeconds();

            BigDecimal salaryPerSecond = user.getJob().getPayment().divide(BigDecimal.valueOf(3600), MathContext.DECIMAL32);

            BigDecimal pay = salaryPerSecond.multiply(BigDecimal.valueOf(secondsDifference));

            user.setStartTime(null);
            BigDecimal moneyUser = user.getWallet();
            user.setWallet(moneyUser.add(pay));

            userRepository.save(user);
        } else throw new RuntimeException("user not found");
    }
}
