package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestMethod;

// jsonやxmlを返す時には@RestControllerを使う
@Controller
@RequestMapping("/home") // このURLにアクセスすると真下のクラスやメソッドの内容が実行される
// Corsの設定をいい感じにする
@CrossOrigin(origins = "*")

// http://localhost:8080/home

public class HomeController {
    @GetMapping()  //httpリクエストのGETでアクセスされたとき、真下のクラスやメソッドの内容が実行される
    public String home() {
        return "home"; // メソッドの戻り値homeが指定したhtml(/templates/home.html)を呼び出す。
        // これができるのはthymeleafというフレームワークを使っているから
        // thymeleafを使用するには、pom.xmlに記述が必要
    }
}
