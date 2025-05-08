package com.spring_web.test_web;

import com.spring_web.test_web.dtos.PageRequest;
import com.spring_web.test_web.services.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestWebApplication implements CommandLineRunner {

	@Autowired
	private PageService pageService;

	public static void main(String[] args) {
		SpringApplication.run(TestWebApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var req = PageRequest.builder()
				.title("Page Title")
				.userId(4L)
				.build();

		var res = this.pageService.readByTitle("User1 Page");
		System.out.println(res);


	}
}
