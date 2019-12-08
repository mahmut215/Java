package contloler;

import dao.SorguDao;
import entity.Bilgi;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
// @SessionScoped kapsamlarimizi belerliyoruz * oturum kapsamli
@SessionScoped

public class SorguConntroler implements Serializable {
    String sorgu;
    String name[];
    private SorguDao sorguDao;
    private List<Bilgi> sorguList;
    private Bilgi bilgi;

    public SorguConntroler() {
        this.sorgu = "";
        this.sorguList = new ArrayList();
        this.name = new String[20];
        this.bilgi = new Bilgi();
    }

    public void sorgula() {
        this.name = new String[20];
        
        this.getSorguDao().sorgula(sorgu, name);
        this.sorguList = this.getSorguDao().sorgula(sorgu, name);
    }

    public SorguDao getSorguDao() {
        if (this.sorguDao == null){
            this.sorguDao = new SorguDao();
        }
        return sorguDao;
    }

    public void setSorguDao(SorguDao sorguDao) {
        this.sorguDao = sorguDao;
    }

   
    public String getSorgu() {
        return sorgu;
    }

    public void setSorgu(String sorgu) {
        this.sorgu = sorgu;
    }

    public List<Bilgi> getSorguList() {
       // this.sorguList = this.getSorguDao().sorgula(sorgu, name);
        return sorguList;
    }

    public void setSorguList(List<Bilgi> sorguList) {
        this.sorguList = sorguList;
    }
    
    
    
/*
    public List<Bilgi> getKisiList() {
//        this.kisiList = this.getIzinDA().insert(sorgu);
        return kisiList;
    }

    public void setKisiList(List<Bilgi> kisiList) {
        this.kisiList = kisiList;
    }
*/
    public Bilgi getBilgi() {
        if (this.bilgi == null) {
            this.bilgi = new Bilgi();
        }
        return bilgi;
    }

    public void setBilgi(Bilgi bilgi) {
        this.bilgi = bilgi;
    }

    public String[] getName() {
        return name;
    }

    public void setName(String[] name) {
        this.name = name;
    }

}
