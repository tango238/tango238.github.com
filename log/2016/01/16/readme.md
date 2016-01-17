# Study

## Scala

### FP in Action

* 正格と遅延

  - 正格
    - 変換演算子の戻り値として全ての要素を含む新たなコレクションを返す
    - 正格関数
      - 引数が常に評価される
      - 一般的なプログラム言語では標準

  - 非正格
    - 遅延評価
    - 結果のコレクションの代理のみを構築して返し、実際の要素は必用に応じて構築される
    - 評価されない形式の式を一般的にサンクと呼ぶ
      - 評価の式と結果の取得を強制することができる
    - Scalaの非正格関数は引数を値渡しでなく名前渡しで受け取ります

非正格の例
```
def if2[A](cond: Boolean, onTrue: () => A, onFalse: () => A): A = {
  if(cond) onTrue() else onFalse()
}

if2(a < 22, () => println("true"), () => println("false"))
```

以下のように書くことができる
```
def if3[A](cond: Boolean, onTrue: => A, onFalse: => A): A = {
  if(cond) onTrue else onFalse
}

if3(a < 22, { println("true") }, { println("false") })
```

`() => A` 型は `Function0[A]` 型の構文エイリアス


`lazy` キーワードを使うと値を明示的にキャッシュできる

```

def maybeTwice2(b: Boolean, i: => Int):Int = {
  lazy val j = i
  if(b) j+j else 0
}

val y = maybeTwice2(true, { println("hi2"); 1+41 })
```


### 遅延リスト
