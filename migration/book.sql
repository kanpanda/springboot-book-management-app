-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- 
-- -- -- -- -- -- -- -- 本管理データベースの作成-- -- -- -- -- -- -- -- -- 
-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- 

create table booksinfo(id serial, title varchar(50), price int);

-- データをいくつか登録する
insert into booksinfo(title,price) values ('渋谷ではたらく社長の告白', 800),('起業家', 800), ('藤田晋の成長論', 1540);

-- テーブルを表示する
select * from booksinfo;