package com.ximi.bean.scope;

import com.ximi.bean.scope.config.RequestConfig;
import com.ximi.bean.scope.controller.RequestScopeController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
public class RequestScopeDome {

	public static void main(String[] args) {
		SpringApplication.run(RequestScopeDome.class, args);
	}

}
