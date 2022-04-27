package com.prac.boot3.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TransferService {
	@Autowired
	private Transfer transfer;

	
	public void go() {

		transfer.bus();

		transfer.subway();

		transfer.bus();

	}
}
