package com.evoucher.Handler;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.evoucher.model.Evoucher;
import com.evoucher.model.RequestClass;
import com.evoucher.service.IssueEvoucherService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class IssueEvoucherHandler implements RequestHandler<RequestClass, Evoucher>{
	
	private final IssueEvoucherService issueEvoucherService;

	@Override
	public Evoucher handleRequest(RequestClass input, Context context) {
		context.getLogger().log("issuing " + input + " voucher");
		return issueEvoucherService.issueEvoucher(input.getVoucher());
	}

}
