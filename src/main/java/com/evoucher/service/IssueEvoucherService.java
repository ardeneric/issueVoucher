package com.evoucher.service;

import java.time.LocalDateTime;
import java.util.Objects;

import org.springframework.stereotype.Service;

import com.evoucher.model.Evoucher;
import com.evoucher.model.Status;
import com.evoucher.repository.IssueEvoucherRepository;

@Service
public class IssueEvoucherService {
	IssueEvoucherRepository issueEvoucherRepository;
	
	public IssueEvoucherService(IssueEvoucherRepository issueEvoucherRepository) {
		super();
		this.issueEvoucherRepository = issueEvoucherRepository;
	}

	public Evoucher issueEvoucher(String voucherNumber) {
		Evoucher e = issueEvoucherRepository.findByVoucher(voucherNumber);
		if (Objects.nonNull(e)) {
			e.setStatus(String.valueOf(Status.USED.ordinal()));
			e.setModified(LocalDateTime.now());
			issueEvoucherRepository.save(e);
		}
		return e;
	}
}
