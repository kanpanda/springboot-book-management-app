// ユーザーからの入力値を保持するためのクラス

package com.example.form;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class BookForm {

    /**
     * 本のタイトルを保持する
     * チェック内容：空でないこと
     */
    @NotBlank(message="タイトルを入力してください。")
    
    private String title;

    /**
     * 本の値段を保持する
     * チェック内容：Nullでないこと、プラスであること
     */
    private Integer price;
}


