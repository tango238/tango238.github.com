# Study

## Scala

### FP in Scala

- §1
  - 関数型プログラミングとは
    - 純粋関数だけをつかってプログラムを構築する
    - 純粋関数
      - 副作用のない関数
    - 副作用
      - 変数を変更する
      - データ構造を直接変更する
      - オブジェクトのフィールドを設定する
      - 例外をスローする、エラーで停止する
      - コンソールに出力する、ユーザー入力を受け取る
      - ファイルを読み込む、ファイルに書き出す
      - 画面上に描画する

- §2
  - `object` キーワード

    新しいシングルトン型を作成する。
    Scalaのobjectは、Javaでstaticメンバーを持つクラスを使用するような場所でよく使用される。

  - プロシージャ（procedure）、非純粋関数（impure function）

    純粋関数型のコアを呼び出し答えを出力するなどの外殻んおメソッドは副作用があることを強調する意味で関数ではなく *プロシージャ（procedure）* または *非純粋関数（impure function）* と呼ばれることがある

  - 多相関数：型の抽象化

    一つの型のデータだけを操作する関数を *単相関数（monomorphic function）* と呼ぶ。
    どのような型が渡されても動作するコードを記述する場合は *多相関数（polymorphic function）* を定義する必要がある。


Ex 2.2) 指定された比較関数に従って `Array[A]` がそーとされているかどうかを調べる `isSorted` を実装せよ

`def isSorted[A](as: Array[A], ordered: (A, A) => Boolean): Boolean`

```

object MyModule {
  def isSorted[A](as: Array[A], ordered: (A,A) => Boolean): Boolean = {
    @annotation.tailrec
    def loop(n: Int): Boolean = {
      val nn = n+1
      if (nn >= as.length - 1) true
      else if (ordered(as(n), as(nn))) loop(nn)
      else false
    }
    loop(0)
  }

  def main(args: Array[String]): Unit = {
    val as:Array[Int] = Array(1, 2, 3, 4, 5)
    val result = isSorted(as, (a:Int, b:Int) => a < b)
    println(result)
  }
}
```

# Blog

[Scala の関数](http://tkawachi.github.io/blog/2014/11/26/1/)

関数には次の2つに大別される

 - メソッド

   ```
   scala> def f(i: Int): Int = i + 1
   scala> f(10)
   res0: Int = 11
   ```

 - apply() メソッドをもつオブジェクト

   ```
   scala> object f { def apply(i: Int): Int = i + 1 }
   scala> f(10)
   res1: Int = 11
   ```

   ```
   scala> class C { def apply(i: Int): Int = i + 1 }
   scala> val f = new C
   scala> f(10)
   res3: Int = 11
   ```


関数型言語の性質として「関数が第一級である」ことがあげられる。 次の特徴を持つものを第一級と呼ぶ（関数プログラミング実践入門より引用）。

- リテラルがある
- 実行時に生成できる
- 変数に入れて使える
- 手続きや関数に引数として与えることができる
- 手続きや関数の結果として返すことができる

メソッド ・・・ 上記のいずれも満たさない

apply() メソッドをもつオブジェクト ・・・ リテラルがない以外は満たしている

*FunctionN trait*

apply() をもつオブジェクトのうち、 Function1, Function2 , … Function22 trait を継承するオブジェクト（以下 FunctionN オブジェクトと呼ぶ）は言語から特別な扱いを受ける。


*リテラル*

`FunctionN` オブジェクトにはリテラルがある。

 `(x: Int) => x + 1`  は以下と同じ意味

```
new Function1[Int, Int] {
    def apply(x: Int): Int = x + 1
}
```


*eta expansion*

メソッドから FunctionN へ変換すること

```
scala> def f(i: Int) = i + 1
f: (i: Int)Int

scala> f _
res0: Int => Int = <function1>
```


[Scala的な考え方 - Scalaがとっつきにくいと思っている人へ](http://yuroyoro.hatenablog.com/entry/20100317/1268819400)

immutableなクラスを手っ取り早く作るために caseクラスを利用する

`classキーワードの前に"case"をつけて、コンストラクタ引数のvar/valを外す、だけです。`

```
case class URL( url:String ) {
  if( url == null )throw new IllegalArgumentException

  def scheme = url.split(":").first
  def hostname = url.split("/").toList.tail.dropWhile("" == ).first
  def pathinfo = url.split("/").toList.tail.dropWhile("" == ).tail
}
```

これだけで、このURLクラスはimutableなクラスになります。他にも様々な恩恵を得ることができます。

- newキーワードなしで `URL("http://d.hatena.ne.jp/yuroyoro")` のようにオブジェクトを生成できる
- 引数のプロパティが自動的に読み取り専用で公開される
- `equals`,`hashCode`,`toString` が適切に実装される
- パターンマッチ(後述)で使えるようになる
