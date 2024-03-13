package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

// restControllerであることの宣言　ざっくり、「APIであること宣言する」ぐらいの解釈でいいと思う。
// RESTAPIという単語を知ってると理解が早いが、知らなければ、調べるより、手を動かしたほうがいい。
@RestController
// URLに/usersecondと入力することで、このclassに結び付くよ、というおまじない
// http://localhost:8080/usersecond
@RequestMapping("/usersecond")
@CrossOrigin(origins = "*")

public class SampleController {
	@GetMapping("/sample")
	public String Hello() {
		return ("hellowwwwrold!");
	}
}
