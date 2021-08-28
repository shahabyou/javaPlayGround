package main.java.coding;

public class BackspaceCompare {
    public static void main(String[] args) {
        System.out.println(backspaceCompare("ab##","c#d#"));
    }
    public static boolean backspaceCompare(String s, String t) {

        int i=s.length()-1;
        int j=t.length()-1;
        int ib = 0;
        int jb = 0;
        while(0<=i && 0<=j){
            if(s.charAt(i)=='#') {
                i--;
                ib++;
                continue;
            }
            if(t.charAt(j)=='#') {
                j--;
                jb++;
                continue;
            }
            if(ib>0){
                i-=ib;
                ib=0;
            }
            if(jb>0){
                j-=jb;
                jb=0;
            }

            if(0<=i && 0<=j && s.charAt(i)!=s.charAt(j)) return false;

            i--;
            j--;
        }

        return (i==-1 && j==-1);
    }
}
