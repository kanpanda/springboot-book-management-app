// serviceクラスの作成
// serviceクラスは、controllerとrepositoryの橋渡し役
// コントローラーでリクエストを受け取り、サービスクラスでデータベースとのやり取りや処理を行う

package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.form.BookForm;
import com.example.model.Book;
import com.example.repository.BookRepository;

@Service
@Transactional
public class BookService {
	
    @Autowired //serviceクラスであるBookRepositoryのインスタンスを保持する
    BookRepository repository;
	

    /**------------------------------------------
    ------------------------------------------
     * 「findAll」メソッド・・・データベースから本の一覧を取得する。
    ------------------------------------------ 
     ------------------------------------------*/
     /**
    /**
     * データベースから本の一覧を取得する
     * @return
     */
    public List<Book> findAll() {  //データベースからデータを取得する
        return repository.findAll(); // データベースのデータを返却する
    }



    /**------------------------------------------
    ------------------------------------------
     * 「insert」メソッド・・・データベースに画面からの入力値を登録する。
    ------------------------------------------ 
     ------------------------------------------*/
     /**
     /**
     * データベースにデータを登録する
     * @return
     */
    public void insert(BookForm bookForm) {
        // データベースに登録する値を保持するインスタンス
        Book book = new Book();

        // 画面から受け取った値をデータベースに保存するインスタンスに渡す
        book.setTitle(bookForm.getTitle());
        book.setPrice(bookForm.getPrice());

        // データベースに登録する
        repository.save(book);
    }


}