package com.prac.boot3.schedule;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.prac.boot3.board.BoardMapper;
import com.prac.boot3.board.BoardVO;
import com.prac.boot3.util.Pager;

@Component
public class TestSchedule {
	@Autowired
	private BoardMapper boardMapper;
	
	//@Scheduled(fixedRate = 1000,initialDelayString = "1000")// 1000-1초
	public void fixRateSchedule()throws Exception{
		Calendar calendar =Calendar.getInstance();
		System.out.println(calendar.getTime());
		Thread.sleep(2000);
	}
	//@Scheduled(fixedDelay = 1000,initialDelayString = "2000")// 1000-1초
	public void fixDelaySchedule()throws Exception{
		Calendar calendar =Calendar.getInstance();
		System.out.println(calendar.getTime());

	}
	
	//@Scheduled(cron = "50 * * * * *")
	public void cronSchedule()throws Exception{
		Calendar calendar =Calendar.getInstance();
		System.out.println(calendar.getTime());
		Pager pager = new Pager();
		pager.makeRow();
		List<BoardVO> ar = boardMapper.getList(pager);
		System.out.println(ar);
	}
}
