package com.evoucher.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.evoucher.model.Evoucher;

public interface IssueEvoucherRepository extends JpaRepository<Evoucher, Integer> {
	public Evoucher findByVoucher(String evoucher);
}
