package assignment3;

import java.util.ArrayList;
import java.util.List;

public class DuplicatesClass {
    // Fields
    private String elementStr;
    private Integer elementInt;
    private Float elementFl;
    private boolean elementBool;

    // Constructors
    public DuplicatesClass(String elementStr) {
        this.elementStr = elementStr;
    }

    public DuplicatesClass(Integer elementInt) {
        this.elementInt = elementInt;
    }

    public DuplicatesClass(Float elementFl) {
        this.elementFl = elementFl;
    }

    public DuplicatesClass(boolean elementBool) {
        this.elementBool = elementBool;
    }

    // Getters and Setters
    public String getElementStr() {
        return elementStr;
    }

    public void setElementStr(String elementStr) {
        this.elementStr = elementStr;
    }

    public Integer getElementInt() {
        return elementInt;
    }

    public void setElementInt(Integer elementInt) {
        this.elementInt = elementInt;
    }

    public Float getElementFl() {
        return elementFl;
    }

    public void setElementFl(Float elementFl) {
        this.elementFl = elementFl;
    }

    public boolean isElementBool() {
        return elementBool;
    }

    public void setElementBool(boolean elementBool) {
        this.elementBool = elementBool;
    }

    // Methods
    public static ArrayList<DuplicatesClass> createArrayOfDifferentElements(){
        ArrayList<DuplicatesClass> temp = new ArrayList<>();
        temp.add(new DuplicatesClass(1));
        temp.add(new DuplicatesClass(3));
        temp.add(new DuplicatesClass(67));
        temp.add(new DuplicatesClass("1"));
        temp.add(new DuplicatesClass("62"));
        temp.add(new DuplicatesClass("Foo"));
        temp.add(new DuplicatesClass("3"));
        temp.add(new DuplicatesClass(5));
        temp.add(new DuplicatesClass(1));
        temp.add(new DuplicatesClass(3));
        temp.add(new DuplicatesClass(false));
        temp.add(new DuplicatesClass(1.3f));

        return temp;
    }
}
