
package entity;

public class Bilgi {
  
String bilgi [] = new String[20];
    public String[] getBilgi() {
        return bilgi;
    }
    public void setBilgi(String bilgi , int i) {
        this.bilgi[i] = bilgi;
    }
}