package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

	@Autowired
	private KafkaTemplate<Object, Object> template;

	@PostMapping(path = "/send/foo/{what}")
	public String sendFoo(@PathVariable String what) {
		this.template.send("topic1", what);
		return "success!!\n";
	}

}
