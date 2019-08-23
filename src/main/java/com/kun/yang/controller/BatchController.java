package com.kun.yang.controller;

import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author YangKun
 * @version 1.0
 * @date 2019/8/22 7:14 PM
 */
@RestController
@RequestMapping("/batch")
public class BatchController {
	@Autowired
	private JobLauncher jobLauncher;

	@Autowired
	private Job job;

	@GetMapping("/execute")
	public void executeJob() throws JobParametersInvalidException, JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException {
		JobParametersBuilder jobParametersBuilder=new JobParametersBuilder();
		jobParametersBuilder.addString("date",String.valueOf(System.currentTimeMillis()));
		jobLauncher.run(job,jobParametersBuilder.toJobParameters());
	}
}
