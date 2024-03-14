//コントローラクラスの作成
// ユーザーからリクエストを受け取り、リクエストの内容に従ってサービスクラスを呼び出す
// サービスクラスから結果を受け取り、その結果をレスポンスとしてユーザーに返却する
package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import com.example.form.BookForm;
import com.example.model.Book;
import com.example.service.BookService;

import org.springframework.web.bind.annotation.CrossOrigin;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.ResponseBody;

// restControllerであることの宣言　ざっくり、「APIであること宣言する」ぐらいの解釈でいいと思う。
// restControllerとcontrollerの違い！
@Controller
// URLに/booklistと入力することで、このclassに結び付くよ、というおまじない
// http://localhost:8080/booklist/list
// @RequestMapping("/booklist")がない場合、GetMappingで以下に書いたように、http://localhost:8080/list に接続
// @RequestMapping("/booklist")
@CrossOrigin(origins = "*")

// serviceクラスであるBookService.javaから結果を受け取り、その結果をレスポンスとしてユーザーに返却する
public class BookController {
    @Autowired //BookServiceのインスタンスを保持
    BookService service;
    

    /**------------------------------------------
    ------------------------------------------
     * 「bookList」メソッド・・・「http://localhost:8080/book-list」にアクセスがあったときのメソッド。本の情報をデータベースから取得して、画面に表示する。
    ------------------------------------------
     ------------------------------------------*/
    @GetMapping("/book-list")    //getというパスに、GETリクエストが飛んでくると、この中身（以下のbooklistメソッド）が動く
    // 引数にModel modelを設定する
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


    /**------------------------------------------
    ------------------------------------------
     * 「createBook」メソッド・・・「http://localhost:8080/book-create」にGetメソッドでアクセスがあったときのメソッド。本の新規登録画面を画面に表示する。
     ------------------------------------------
     ------------------------------------------*/
    /**
     * 新規登録画面を表示
     * @param model
     * @return 新規登録画面
     */
    @GetMapping("/book-create")
    public String createBook(Model model) {

        model.addAttribute("bookForm", new BookForm());
        return "add";
    }



    /**------------------------------------------
    ------------------------------------------
     * 「saveBook」メソッド・・・「http://localhost:8080/book-create」にPostメソッドでアクセスがあったときのメソッド。画面で入力された情報をデータベースに登録する。登録完了後は一覧画面にリダイレクトする。
    ------------------------------------------ 
     ------------------------------------------*/
     /**
     * データベースに本を登録する
     * @param bookForm
     * @param model
     * @return
     */
    @PostMapping("/book-create")
    public String saveBook(@ModelAttribute BookForm bookForm, Model model) {

        // 本を登録する
        service.insert(bookForm);

        // 本の一覧表示画面にリダイレクト
        return "redirect:/book-list";
    }


}