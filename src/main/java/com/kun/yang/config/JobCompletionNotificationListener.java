package com.kun.yang.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.stereotype.Component;

/**
 * @author YangKun
 * @version 1.0
 * @date 2019/8/22 3:49 PM
 */
@Component
public class JobCompletionNotificationListener extends JobExecutionListenerSupport {

	private static final Logger log = LoggerFactory.getLogger(JobCompletionNotificationListener.class);

	//监听job是否处理成功，成功后执行自定义业务逻辑
	@Override
	public void afterJob(JobExecution jobExecution) {
		if(jobExecution.getStatus() == BatchStatus.COMPLETED) {
			log.info("!!! JOB FINISHED! Time to verify the results");
			System.out.println("执行参数："+jobExecution.getJobParameters()+"执行上下文："+jobExecution.getExecutionContext());
		}
	}
}
