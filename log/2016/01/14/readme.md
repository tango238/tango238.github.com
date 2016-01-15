# Study

## Scala

## PHP

- `phpunit --testdox`

  一覧でテストメソッド名が出てきてどのテストが落ちるか把握しやすい

- `phpunit --filter 文字列 xxxxTest.php`

  文字列にマッチしたテストケースだけ実行される

## Linux

`umask`

- 使用ユーザーのアクセス権限の初期設定を変更、確認する

  新しくファイルを作成すると普通、権限は「644」(-rw-r--r--)になる、しかしこのマスクで値を変更するとファイルやディレクトリを新しく作成した場合の初期のアクセス権限を変更することができる

  デフォルト: umask 022 (-rw-r--r--)
            umask 002 (-rw-rw-r--)


### Dockerでsupervisor経由で動かしているApacheのumaskを変更したい

Apache/2.2.15 (Unix)

* 試した内容

  - 試したこと１（動かない）

    [Supervisor - Configuration File](http://supervisord.org/configuration.html)

    ```
    [program:httpd]
    ;user=root
    ;environment=HOME="/root",USER="root",APACHE_RUN_USER="root", APACHE_RUN_GROUP="root"
    command=/usr/sbin/httpd -D FOREGROUND
    umask=002
    ```


  - 次ためしたい

  [Apache2 foreground does not source /etc/apache2/envvars](https://github.com/docker-library/php/issues/97)

  [Apache on Docker can't write to volume filesystem](http://serverfault.com/questions/652743/apache-on-docker-cant-write-to-volume-filesystem/652852#652852)




# Blog
[合成できるモナド、モナドが合成できる時](http://d.hatena.ne.jp/everpeace/20120917/1347868517)

[Martin Odersky - NEW YEAR RESOLUTIONS](http://www.scala-lang.org/blog/2016/01/02/new-year-resolutions.html)
