/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg20171130;

public class Tweet {

    //フィールド
    private int tweetNo;	//ツイートの番号
    private String twitterID;	//twitterID
    private String name;	//氏名
    private String tweetTime;	//投稿日時
    private String text;	//投稿内容

    //コンストラクタ
    public Tweet() {
        //とりあえず何もしない
    }

    //ツイート番号をセットするメソッド
    public void setNo(int tn) {
        this.tweetNo = tn;
    }

    //twitterIDをセットするメソッド
    public void setTID(String tid) {
        this.twitterID = tid;
    }

    public void setAll(int no, String id, String name, String time, String text) {
        this.tweetNo = no;
        this.twitterID = id;
        this.name = name;
        this.tweetTime = time;
        this.text = text;
    }

    //氏名をセットするメソッド
    public void setTweetNo(int tweetNo) {
        this.tweetNo = tweetNo;
    }

    public void setTwitterID(String twitterID) {
        this.twitterID = twitterID;
    }

    public void setTweetTime(String tweetTime) {
        this.tweetTime = tweetTime;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setName(String name) {
        this.name = name;
    }

    //投稿日時をセットするメソッド
    //投稿内容をセットするメソッド
    //ツイート情報を出力するメソッド
    public void printTweet() {
        System.out.println(tweetNo + ":"
                + twitterID + "(" + name + ")\n"
                + tweetTime + "\n" + text);
    }

    public String printHTML() {
        return this.tweetNo +":"+ this.twitterID + "(" + this.name + ")<br>" + this.tweetTime + "<br>" + this.text+"<hr>";
    }
}


