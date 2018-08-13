package com.evoucher;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.evoucher.model.Evoucher;
import com.evoucher.model.RequestClass;

import me.ccampo.spring.aws.lambda.SpringRequestHandler;

public class MainHandler extends SpringRequestHandler<RequestClass, Evoucher> {
	private static final ApplicationContext context =
            new AnnotationConfigApplicationContext(IssueEvoucherApplication.class);

	@Override
	public ApplicationContext getApplicationContext() {
		return context;
	}

}
