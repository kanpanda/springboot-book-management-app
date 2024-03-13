// modelクラスの作成
// modelクラスはテーブルのデータを保持する役割を持つ
package com.example.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;

@Data //各フィールドのsetterとgetterを自動で生成
@Entity
@Table(name = "booksinfo") //対応するテーブルを設定
public class Book {

    @Id
    @GeneratedValue(	//idが自動で生成される値であることを明示
		strategy=GenerationType.IDENTITY
		)
    @Column(name="id")
    // 本のidを保持するフィールド
    private Integer id;
	
    @Column(name="title")
    // 本のタイトルを保持するフィールド
    private String title;
	
    @Column(name="price")
    // 本の値段を保持するフィールド
    private Integer price;
}
