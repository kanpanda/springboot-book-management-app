package com.example.demo;

import java.util.ArrayList;
import java.util.List;

// import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

// restControllerであることの宣言　ざっくり、「APIであること宣言する」ぐらいの解釈でいいと思う。
// RESTAPIという単語を知ってると理解が早いが、知らなければ、調べるより、手を動かしたほうがいい。
@RestController
// URLに/userと入力することで、このclass(ここでいうと、HelloControllerクラス)に結び付くよ、というおまじない
@RequestMapping("/user")
// Corsの設定をいい感じにする
@CrossOrigin(origins = "*")
public class HelloController {

	// "Get"Mappingであることに注意。これは、「/getというパスに、GETリクエストが飛んでくると、この中身が動くよ」というおまじない。正確に言うと、上で指定したものを加味して「/user/get」である。
	@GetMapping("/get")
	// 返却する値をJSONで返せるようにいい感じにしてくれるおまじない。JSONというものは、形だけ知ってほしい。活用場所は、まだ知らなくていい。
	// http://localhost:8080/user/get
	@ResponseBody
	public String getUser() {
		String result = "Stringを返します";
		String result2 = "Stringを返しますyo";
		String result3 = result + "。そして、" + result2;
		return result3;
	}

	// user/test というパスに、GETリクエストを送ると、実行される。ここは、返値が「void」(public void~)であるため、返値無し。
	//getリクエストはhttpリクエストの一種。webブラウザからwebサーバに対して出されるお願い（要求）
	// さらに、メソッドにparamという変数名で、String型を渡すように言われている。たとえのリクエストを張っておくので、これをブラウザに突っ込んでほしい。
	// http://localhost:8080/user/test?param=あばば　
	// http://localhost:8080/user/test?param=あべし　

	@GetMapping("/test")
	public void testMethod(@RequestParam String param) { //RequestParamの変数名と関連付ける引数の変数（ここではparam）が同じ場合は、このように記述を省略できる
		System.out.println("----------次の行で、引数を出力します。");
		System.out.println(param);
	}

	// これは、データのやり取りの実感がわきやすい感じで作ってみた。
	// shinoru と nks というユーザーを、個々の中でnewで作成しているが、ここを、本当はデータベースからとってくる、というイメージ。
	// 実際に下記のURLをブラウザに入れて、帰ってくる文字を見てほしい。その帰ってきたものが、JSONといわれるもので、フロントは、このJSONを使って、内容を表示していく。
	// http://localhost:8080/user/all
	@GetMapping("/all")
	public List<User> getAllUser() {
		List<User> allUserList = new ArrayList<>();
		for (int i = 1; i < 10; i++) {
			User user = new User();	 //User型のインスタンス「user」を生成
			user.setAge(10 + i);
			user.setUserId(i);
			String _name = "Name" + i;
			user.setUserName(_name);
			allUserList.add(user);
		}

		return allUserList;
	}

	// なかしへの課題
	// http://localhost:8080/user/search
	@GetMapping("/search")
	public User getOneUser(@RequestParam Integer id) {

		// allUserListに、５０人のユーザー情報を入れ込みました。
		// ここは、データベースに保存されている５０人の全情報を取ってきました、ということになる（実務では）
		List<User> allUserList = new ArrayList<>();
		for (int i = 1; i < 50; i++) {
			User user = new User(); //User型で新しいインスタンスを生成する
			user.setAge(10 + i);
			user.setUserId(i);
			String _name = "Name" + i;
			user.setUserName(_name);
			allUserList.add(user);
		}

		// では、allUserListから、userIdを指定して、userIdが一致する一人だけを、JSONとして返すにはどのようにしたらよいか？
		// 方針としては、このgetOneUserメソッドに、userIdの引数を渡せるように設定する。（↑のtestMethodを参考にするとよい）
		// では、そのuserIdを使用して、どのようにして一人だけを返すようにするか、実装してほしい。
		return allUserList.get(id);
	}
}