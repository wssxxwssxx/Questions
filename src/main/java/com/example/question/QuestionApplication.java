package com.example.question;

//import com.example.question.chat.ChatServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.io.IOException;


@SpringBootApplication
public class QuestionApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(QuestionApplication.class, args);
		///new ChatServer(12345).run();
	}

}
