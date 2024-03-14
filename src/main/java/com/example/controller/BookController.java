//コントローラクラスの作成
// ユーザーからリクエストを受け取り、リクエストの内容に従ってサービスクラスを呼び出す
// サービスクラスから結果を受け取り、その結果をレスポンスとしてユーザーに返却する

package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.BookService;
import com.example.model.Book;

import ch.qos.logback.core.model.Model;

// import com.example.model.Book;
// import com.example.service.BookService;

// restControllerであることの宣言　ざっくり、「APIであること宣言する」ぐらいの解釈でいいと思う。
@RestController
// URLに/booklistと入力することで、このclassに結び付くよ、というおまじない
// http://localhost:8080/booklist/list
// @RequestMapping("/booklist")がない場合、GetMappingで以下に書いたように、http://localhost:8080/list に接続
// @RequestMapping("/booklist")
@CrossOrigin(origins = "*")

// serviceクラスであるBookService.javaから結果を受け取り、その結果をレスポンスとしてユーザーに返却する
public class BookController {
    @Autowired //BookServiceのインスタンスを保持
    BookService service;
    
    @GetMapping("/list")    //getというパスに、GETリクエストが飛んでくると、この中身（以下のbooklistメソッド）が動く
	public String bookList(Model model) {
        // serviceをつかって、本の一覧をDBから取得する
        List<Book> bookList = service.findAll();
        // modelに本の一覧を設定して、画面に渡す
        // model.addAttributeメソッドで画面に渡したいデータをModelオブジェクトに追加
        // 【構文】　model.addAttribute("属性名", 渡したいデータ);
        model.addAttribute("bookList", bookList);
        // bookList.htmlの表示
        return ("bookList");
	}
}