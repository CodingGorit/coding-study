package cn.gorit.jzoffer;

public class JZ2 {
    public String replaceSpace(StringBuffer str) {
        for (int i=0;i<str.length();i++) {
            if (str.charAt(i) == ' ') {
                str.replace(i,i+1,"%20");
            }
        }
        return String.valueOf(str);
    }
}
