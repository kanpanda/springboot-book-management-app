// reposityoryパッケージの中にBookRepositoryを作成
// データアクセス層
// repositoryインターフェースの作成
// 実際にデータベースとのやり取りをするためのインターフェース

package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Book;

//jpaRepositoryインターフェースを継承している
// Bookクラスを操作するために、JpaRepository<Book, Integer>とする
// IntegerはBookクラスのIdの型を指定しています。
public interface BookRepository extends JpaRepository<Book, Integer> {

}