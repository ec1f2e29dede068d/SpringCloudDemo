package com.c.w.four;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import java.util.Scanner;

/**
 * @author C
 */
@SpringBootApplication
@EnableEurekaClient
public class LoadBalanceProviderApplication {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String port = scanner.nextLine();
		new SpringApplicationBuilder(LoadBalanceProviderApplication.class).properties("server.port=" + port).run(args);
	}

}
