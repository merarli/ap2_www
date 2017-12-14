/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg20171214;

/**
 *
 * @author merarli
 */
public class Human {
    private String name;
    private int Age;
    
    public Human(String name, int Age) {
        this.name = name;
        this.Age = Age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return Age;
    }
    
    public String getKind(){
        String ans = "";
        
        if(Age < 6){
            ans = "乳幼児";
        }else if(Age >= 6 && Age < 12){
            ans = "こども";
        }else if(Age >= 12){
            ans = "おとな";
        }else{
            ans = "正しい年齢を入力してください";
        }
        return ans;
    }
}
