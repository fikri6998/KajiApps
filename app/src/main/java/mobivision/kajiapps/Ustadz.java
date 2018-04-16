package mobivision.kajiapps;

/**
 * Created by asus a456 on 16/04/2018.
 */

public class Ustadz {
    private String poto;
    private String nama;
    private String asal;
    private String email;
    private String bio;


    public Ustadz(String poto, String nama, String asal, String email, String bio) {
        this.poto = poto;
        this.nama = nama;
        this.asal = asal;
        this.email = email;
        this.bio = bio;
    }

    public String getPoto() {
        return poto;
    }

    public void setPoto(String poto) {
        this.poto = poto;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAsal() {
        return asal;
    }

    public void setAsal(String asal) {
        this.asal = asal;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }


    public Ustadz(){

    }
}
