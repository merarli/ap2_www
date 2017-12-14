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
public class Student {
    //フィールド
    private int student_id;     //STUDENT_IDに対応
    private String fullname;    //FULLNAMEに対応
    private int gakubu_id;      //GAKUBU_IDに対応
    private int grade;          //GRADEに対応

    //コンストラクタ
    public Student(){
        
    }
    //インスタンス化と同時にフィールド値を設定するコンストラクタ
    public Student(int sid, String fn, int gi, int gr){
        student_id = sid;
        fullname = fn;
        gakubu_id = gi;
        grade = gr;
    }
    
    //STUDENT_IDの設定
    public void setSID(int sid) {
        student_id = sid;
    }
        //Student_IDの取得
    public int getSID() {
        return student_id;
    }
    //FULLNAMEの設定
    public void setName(String fn) {
        fullname = fn;
    }
    //FULLNAMEの取得
    public String getName() {
        return fullname;
    }
    //GAKUBU_IDの設定
    public void setGakubu(int gi) {
        gakubu_id = gi;
    }
    //GAKUBU_IDの取得
    public int getGakubu() {
        return gakubu_id;
    }
    //GRADEの設定
    public void setGrade(int gr) {
        grade = gr;
    }
    //GRADEの取得
    public int getGrade() {
        return grade;
    }
}
