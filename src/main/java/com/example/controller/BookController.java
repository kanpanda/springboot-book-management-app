//コントローラクラスの作成
// ユーザーからリクエストを受け取り、リクエストの内容に従ってサービスクラスを呼び出す
// サービスクラスから結果を受け取り、その結果をレスポンスとしてユーザーに返却する

package com.example.controller;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

// import com.example.model.Book;
// import com.example.service.BookService;

// restControllerであることの宣言　ざっくり、「APIであること宣言する」ぐらいの解釈でいいと思う。
@RestController
// URLに/booklistと入力することで、このclassに結び付くよ、というおまじない
// http://localhost:8080/booklist/list
@RequestMapping("/booklist")
@CrossOrigin(origins = "*")

public class BookController {
    @GetMapping("/list")
	public String Hello() {
		return ("hellowwwwrold!これはブックリストコントローラだwasa");
	}
}