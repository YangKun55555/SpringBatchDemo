package com.kun.yang.batch;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author YangKun
 * @version 1.0
 * @date 2019/8/22 7:59 PM
 * 自定义ItemProcessor，模拟数据处理
 */

@Component
public class DataItemProcessor implements ItemProcessor<List,List> {
	@Override
	public List process(List list) throws Exception {
		list.add(6);
		list.add(7);
		list.add(8);
		System.out.println("同步人员第二步：处理人员数据:"+list);
		return list;
	}
}
