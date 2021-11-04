/**
 * Ilman Nawali 1972003
 */
package com.example.entity;

public class Player {
    private int id;
    private String nama;
    private int umur;
    private String kehlian;


    public Player(int id, String nama, int umur, String kehlian) {
        this.id = id;
        this.nama = nama;
        this.umur = umur;
        this.kehlian = kehlian;
    }

    public Player() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getUmur() {
        return umur;
    }

    public void setUmur(int umur) {
        this.umur = umur;
    }

    public String getKehlian() {
        return kehlian;
    }

    public void setKehlian(String kehlian) {
        this.kehlian = kehlian;
    }

    @Override
    public String toString() {
        return nama;
    }
}
