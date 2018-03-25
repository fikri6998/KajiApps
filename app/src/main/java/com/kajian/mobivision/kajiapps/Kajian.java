package com.kajian.mobivision.kajiapps;

/**
 * Created by asus a456 on 25/02/2018.
 */

public class Kajian {
    //deklarasi variable
    int foto;
    String nama, detail;

    //method setter
    public Kajian(int foto, String nama, String detail) {
        this.foto = foto;
        this.nama = nama;
        this.detail = detail;
    }

    //method getter
    public int getFoto() {
        return foto;
    }

    public String getNama() {
        return nama;
    }

    public String getDetail() {return detail; }
}
