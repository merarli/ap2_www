/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author merarli
 */
public class Item {

    private String name;
    private int value;

    public Item(String nm, int val) {
        this.name = nm;
        this.value = val;
    }

    public String getName() {
        return name;
    }

    public void setName(String nm) {
        this.name = nm;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int val) {
        this.value = val;
    }
}
