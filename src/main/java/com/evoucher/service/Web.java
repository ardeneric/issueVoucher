package com.evoucher.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.evoucher.model.Evoucher;
import com.evoucher.repository.IssueEvoucherRepository;

@RestController
public class Web {
	IssueEvoucherService issueS;
	@Autowired
	IssueEvoucherRepository c;
	
	@GetMapping("/issue/{voucherNumber}")
	public Evoucher save(@PathVariable String voucherNumber){
		issueS = new IssueEvoucherService(c);
		return issueS.issueEvoucher(voucherNumber);
	}

}
