//コントローラクラスの作成
// ユーザーからリクエストを受け取り、リクエストの内容に従ってサービスクラスを呼び出す
// サービスクラスから結果を受け取り、その結果をレスポンスとしてユーザーに返却する

package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.model.Book;
import com.example.service.BookService;

@Controller //controllerであることを宣言
public class BookController {
	
    @Autowired //BookServiceのインスタンスを保持
    BookService service;
	
    @GetMapping("/book-list") // /book-listにリクエストが来た時にbookListメソッドを実行する
    public String bookList(Model model) {
		
        // serviceクラスを使って、本の一覧をDBから取得する？？？？
        List<Book> bookList = service.findAll();
        // modelに本の一覧を設定して、画面に渡す
        model.addAttribute("bookList", bookList);
        // bookList.htmlの表示
        return "bookList";
    }
}
