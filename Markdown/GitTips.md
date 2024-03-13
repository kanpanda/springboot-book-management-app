# Markdownチートシート
https://qiita.com/Qiita/items/c686397e4a0f4f11683d

# fechとpull

https://qiita.com/wann/items/688bc17460a457104d7d

「git pull」はローカルにある「master」ブランチに情報をとりこむ

「git fetch」はローカルにある「origin/master」ブランチに情報を取り込む（諸説あり：orign/masterはURLがリモートにある→リモートにあるともいえる

git fetch…リモートの「master」ブランチ → ローカルの「origin/master」ブランチ

git merge…ローカルの「origin/master」ブランチ → ローカルの「master」ブランチ

git pullは、上のgit fetch、git mergeを同時に行うコマンド

git pull…リモートの「master」ブランチ →（ローカルの「origin/master」ブランチ→） ローカルの「master」ブランチ

## fetchを戻す方法

<!-- これは `インラインコード`です。 -->
 `git fetch` でのエラー

`git reset --hard HEAD`
 

 # リモート名
 `git remote`でリモート名の確認
 `git remote -v` でリモート名のURLを確認
 デフォルトリモート名は「origin」


## リモートリポジトリが更新され、自分もローカルで更新したとき
1. リモートリポジトリをフォーク
- 今回のリポジトリ（CratingJavaApp）はtool/git内にある
- フォークしただけではmasterブランチしかローカルにはない  
2. 自分が更新したフォルダを1.にコピペ
3. ローカルブランチに「apidev」を追加する`git checkout -b <apidev> <remotes/origin/apidev>`
4. マスターブランチに移動
 - マージで吸収元ととなる（ベースとなる）ブランチに移動する
5. 今いるブランチ(master)にapdevをマージ
- `merge apidev` 
6. ローカルでの変更をリモートに反映する
- `git push`
- gitグラフを確認すると,masterがmaster/orginになっている

 `git branch`ローカルブランチの一覧を表示

`git branch -r`リモートブランチの一覧を表示

`git branch -a`リモートブランチを含んだブランチ一覧を表示


 



 ## Gitグラフを開く（VScodeの拡張機能）

