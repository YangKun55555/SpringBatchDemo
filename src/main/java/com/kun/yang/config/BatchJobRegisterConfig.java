package com.kun.yang.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author YangKun
 * @version 1.0
 * @date 2019/8/22 3:35 PM
 */
@Configuration
@EnableBatchProcessing
public class BatchJobRegisterConfig {
	@Autowired
	public JobBuilderFactory jobBuilderFactory;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;

	//注册job
	@Bean
	public Job importUserJob(JobCompletionNotificationListener listener, Step step1) {
		return jobBuilderFactory.get("syncJob")
				.incrementer(new RunIdIncrementer())
				.listener(listener)
				.flow(step1)
				.end()
				.build();
	}

	//注册step
	//chunk=3，则执行三次reader和三次processor之后执行一次write，331
	@Bean
	public Step step1(ItemReader reader,ItemProcessor processor,ItemWriter writer){
		return stepBuilderFactory.get("step1")
				.chunk(3)
				.reader(reader)
				.processor(processor)
				.writer(writer)
				.build();
	}
}
