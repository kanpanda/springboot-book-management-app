// serviceクラスの作成
// serviceクラスは、controllerとrepositoryの橋渡し役
// コントローラーでリクエストを受け取り、サービスクラスでデータベースとのやり取りや処理を行う

package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.model.Book;
import com.example.repository.BookRepository;

@Service
@Transactional
public class BookService {
	
    @Autowired //BookRepositoryのインスタンスを保持する
    BookRepository repository;
	
    /**
     * データベースから本の一覧を取得する
     * @return
     */
    public List<Book> findAll() {  //データベースからデータを取得する
        return repository.findAll(); // データベースのデータをreturnする
    }
}