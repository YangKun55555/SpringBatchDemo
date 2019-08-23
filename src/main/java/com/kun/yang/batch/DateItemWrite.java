package com.kun.yang.batch;

import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author YangKun
 * @version 1.0
 * @date 2019/8/22 7:59 PM
 * 自定义ItemWrite，模拟数据写操作
 */
@Component
public class DateItemWrite implements ItemWriter<String> {
	@Override
	public void write(List<? extends String> list) throws Exception {
		System.out.println("同步人员第三步：保存数据:"+list);
	}
}
