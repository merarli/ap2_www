/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg20171213;

/**
 *
 * @author merarli
 */
public class Exam {
 //フィールド
    private String name;    //氏名
    private int point;      //点数

    //コンストラクタ
    public Exam(String n, int p) {
        this.name = n;
        this.point = p;
    }

    //フィールドnameを返すメソッド
    public String getName() {
        return name;
    }
    //フィールドpointを返すメソッド
    public int getPoint() {
        return point;
    }
    //評価を返すメソッド
    public String getResult() {
        if (point >= 80) {
            return "A";
        } else if (point >= 60) {
            return "B";
        } else {
            return "C";
        }
    }   
}
