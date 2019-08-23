package com.kun.yang.batch;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YangKun
 * @version 1.0
 * @date 2019/8/22 7:56 PM
 * 自定义ItemReader，模拟读取数据
 */
@Component
@StepScope
public class DataItemReader implements ItemReader<List> {
	@Value("#{jobParameters[date]}")
	private String param;
	private int count=0;
	@Override
	public List<Integer> read() throws Exception, UnexpectedInputException, ParseException,
			NonTransientResourceException {
		while (count<3){
			List<Integer> numbers =new ArrayList<>();
			numbers.add(1);
			numbers.add(2);
			numbers.add(3);
			numbers.add(4);
			numbers.add(5);
			System.out.println("同步人员第一步：读取人员数据: "+numbers);
			count++;
			return numbers;
		}
		return null;
	}
}
