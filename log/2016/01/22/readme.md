# Study

## Scala

コンビネータ

# English
http://q-eng.com/diary/165

[自・他動詞](https://www.youtube.com/watch?v=3T7Ih7kMMBw)

- 自動詞
直後に目的語をとれない動詞

- 他動詞
直後に目的語をとらなければいけない動詞

- 目的語
訳すと「〜を、〜に、〜へ」の「〜」にあたる名詞

*go = 自動詞*

  x: `I went the station.``
  o: `I went to the station.``

*have = 他動詞*

 o: `I had a pen.`
 x: `I had with a pen.`

arrive = 自動詞
I arrived at the station

reach = 他動詞
I reached the station

# Geb

オレオレ認証してるローカル環境をGenでスクレイピングしたい

SSLの認証でエラーになる

- GebConfig.groovy

```
environments {

    firefox {
        driver = {
            ProfilesIni allProfiles = new ProfilesIni()
            FirefoxProfile profile = allProfiles.getProfile("Geb")
            profile.setAcceptUntrustedCertificates(true)
            profile.setAssumeUntrustedCertificateIssuer(true)
            profile.setPreference("security.default_personal_cert" , "SelectAutomatically")
            new FirefoxDriver(profile)
        }
    }
}
```

`allProfiles.getProfile("Geb")` で `NullPointerException` になる


ターミナルから次のコマンドを叩く

`/Applications/Firefox.app/Contents/MacOS/firefox-bin -P "Geb"`


`groovy -Dgeb.env="firefox" scraping.groovy`


WebDriverからFirefoxを起動する際、下記エラーが発生。
org.openqa.selenium.firefox.NotConnectedException: Unable to connect to host 127.0.0.1 on port 7055 after 45000 ms. Firefox console output:

WebDriverのバージョンがFirefoxのバージョンに対応していない場合に上記のエラーが出るとのこと。

暫定回避としてFirefoxのバージョンダウン(→ ver30)を実施。

下記ページから "Firefox Setup 30.0.exe" を落としてきてインストール

https://ftp.mozilla.org/pub/firefox/releases/30.0



Firefoxはデフォルトで自動verupするので下記のように設定を変えておく。

```
メニューから[環境設定]-[詳細]-[更新]-[Firefoxの更新]と辿って、
    "更新の確認は行うが、インストールするかどうかを選択する"　を選択
```

もう一度実行すると正常に表示された

`groovy -Dgeb.env="firefox" scraping.groovy`
