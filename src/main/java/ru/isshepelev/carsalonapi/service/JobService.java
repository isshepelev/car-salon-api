package ru.isshepelev.carsalonapi.service;


import ru.isshepelev.carsalonapi.entity.job.DTO.JobDTO;
import ru.isshepelev.carsalonapi.entity.job.DTO.JobPaymentUpdateDTO;
import ru.isshepelev.carsalonapi.entity.job.Job;

import java.util.List;

public interface JobService {
    Job create(JobDTO jobDTO);

    List<Job> getWorkList();

    void delete(String jobId);

    void update(String jobId, JobPaymentUpdateDTO jobPaymentUpdateDTO);
    void startWork(String user_id);
    void stopWork(String user_id);
}
