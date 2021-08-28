package main.java;

public class SwitchTest {
    public static void main(String[] args) {
        String res;
        switch(getName()){
            case "Samyar":
                res = "boy";
                break;
            case "Shahab":
                res = "man";
                break;
            default:
                res = "woman";
                        break;
        }
        System.out.println(res);
    }

    public static String getName(){
        return "Shahab";
    }
}
