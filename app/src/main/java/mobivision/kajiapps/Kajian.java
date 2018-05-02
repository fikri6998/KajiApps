package mobivision.kajiapps;

/**
 * Created by asus a456 on 16/04/2018.
 */

public class Kajian {
    private String potokajian;
    private String judulkajian;
    private String lokasikajian;
    private String penceramahkajian;
    private String deskripsikajian;
    private String waktukajian;

    public Kajian(String potokajian, String judulkajian, String lokasikajian, String penceramahkajian,String deskripsikajian, String waktukajian) {
        this.potokajian = potokajian;
        this.judulkajian = judulkajian;
        this.lokasikajian = lokasikajian;
        this.penceramahkajian = penceramahkajian;
        this.deskripsikajian = deskripsikajian;
        this.waktukajian = waktukajian;
    }

    public String getPotokajian() {
        return potokajian;
    }

    public void setPotokajian(String potokajian) {
        this.potokajian = potokajian;
    }

    public String getJudulkajian() {
        return judulkajian;
    }

    public void setJudulkajian(String judulkajian) {
        this.judulkajian = judulkajian;
    }

    public String getLokasikajian() {
        return lokasikajian;
    }

    public void setLokasikajian(String lokasikajian) {
        this.lokasikajian = lokasikajian;
    }

    public String getPenceramahkajian() {
        return penceramahkajian;
    }

    public void setPenceramahkajian(String penceramahkajian) {
        this.penceramahkajian = penceramahkajian;
    }

    public String getWaktukajian() {
        return waktukajian;
    }

    public void setWaktukajian(String waktukajian) {
        this.waktukajian = waktukajian;
    }

    public String getDeskripsikajian() {
        return deskripsikajian;
    }

    public void setDeskripsikajian(String deskripsikajian) {
        this.deskripsikajian = deskripsikajian;
    }

    public Kajian(){

    }
}
