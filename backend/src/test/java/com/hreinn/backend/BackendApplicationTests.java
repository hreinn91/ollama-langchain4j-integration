package com.hreinn.backend;

import com.hreinn.backend.domain.StreamingChatModel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BackendApplicationTests {

	@Autowired
	private StreamingChatModel chatModel;

	@Test
	void contextLoads() {
	}


	@Test
	void getMessage(){
		String response = chatModel.message("Hello what's the temperature climate at the office?");
		System.out.println(response);
	}

}
