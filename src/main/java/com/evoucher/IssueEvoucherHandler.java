package com.evoucher;

import org.springframework.stereotype.Component;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.evoucher.model.Evoucher;
import com.evoucher.model.RequestClass;
import com.evoucher.service.IssueEvoucherService;

import lombok.RequiredArgsConstructor;
@Component
@RequiredArgsConstructor
public class IssueEvoucherHandler implements RequestHandler<RequestClass, Evoucher>{
		public final IssueEvoucherService issueEvoucherService;

		@Override
		public Evoucher handleRequest(RequestClass input, Context context) {
			context.getLogger().log("issuing " + input + " voucher");
			return issueEvoucherService.issueEvoucher(input.getVoucher());
		}

}
