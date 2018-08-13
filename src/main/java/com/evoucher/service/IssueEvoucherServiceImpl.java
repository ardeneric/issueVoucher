package com.evoucher.service;

import java.time.LocalDateTime;
import java.util.Objects;

import org.springframework.stereotype.Component;

import com.evoucher.model.Evoucher;
import com.evoucher.model.Status;
import com.evoucher.repository.IssueEvoucherRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class IssueEvoucherServiceImpl implements IssueEvoucherService {
	public final IssueEvoucherRepository issueEvoucherRepository;

	@Override
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
