package com.evoucher.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.evoucher.model.Evoucher;

@Repository
public interface IssueEvoucherRepository extends JpaRepository<Evoucher, Integer> {
	public Evoucher findByVoucher(String evoucher);
}
