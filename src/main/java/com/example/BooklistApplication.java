package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


// このクラスはSpringbootのアプリケーションクラスであることを宣言
@SpringBootApplication
public class BooklistApplication {

	public static void main(String[] args) {
		SpringApplication.run(BooklistApplication.class, args);
	}

	// http://localhost:8080/bookList
	// http://localhost:8080/list
	// で本のリストが開くはず
	// Sample1Application.javaのディレクトリ位置を動かしてもspringbootは動く

}
