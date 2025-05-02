# QRコードジェネレータ＆リーダーアプリ

## 📝 概要
Kotlin×Androidで実装した、シンプルかつ使いやすいQRコード生成・読み取りアプリです。  
Bottom Navigationで「生成」「読み取り」の２画面を切り替えて利用できます。

---

## 📱 画面構成
1. **生成タブ (HomeFragment)**  
   - テキスト入力欄  
   - 「生成」ボタン → QRコードをBitmapで描画  
   - 生成されたQRコードを `ImageView` に表示  

2. **読み取りタブ (DashboardFragment)**  
   - 「読み取る」ボタン → カメラ起動＆スキャン  
   - 読み取った結果を `TextView` に表示  
   - 長押し or 「コピー」ボタンでクリップボードにコピー可能  

---

## 🔧 技術スタック
- **言語**：Kotlin  
- **ライブラリ**：  
  - ZXing Android Embedded (`com.journeyapps:zxing-android-embedded`)  
  - AndroidX Navigation + BottomNavigationView  
- **レイアウト**：ConstraintLayout  
- **パーミッション**：カメラ（`<uses-permission android:name="android.permission.CAMERA"/>`）  

---

## 🚀 使い方
1. **QRコード生成**  
   1. 「生成」タブで任意の文字列を入力  
   2. **生成**ボタンを押す  
   3. 下部にQRコードが表示される  

2. **QRコード読み取り**  
   1. 「読み取り」タブで **読み取る** ボタンを押す  
   2. カメラでQRコードをスキャン  
   3. 読み取り結果が画面に表示  
   4. 長押し or **コピー** ボタンでクリップボードに保存  

---

## 🎨 アプリアイコン
- 鮮やかなブルー背景に、白いQRコードモチーフ  
- シンプルかつ視認性高いデザイン

---

## 💡 今後の拡張案
- 履歴の保存／閲覧機能  
- テーマ（ライト／ダークモード）対応  
- 生成・読み取り結果のファイル出力（画像・CSV）  
- カスタムQRデザイン（色変更・ロゴ埋め込み）  

---