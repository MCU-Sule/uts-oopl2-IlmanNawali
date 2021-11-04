/**
 * Ilman Nawali 1972003
 */
package com.example.entity;

public class Hutang {
    private int id;
    private String pengutang;
    private double jumlah;
    private Player player;

    public Hutang() {
    }

    public Hutang(int id, String pengutang, double jumlah, Player player) {
        this.id = id;
        this.pengutang = pengutang;
        this.jumlah = jumlah;
        this.player = player;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPengutang() {
        return pengutang;
    }

    public void setPengutang(String pengutang) {
        this.pengutang = pengutang;
    }

    public Double getJumlah() {
        return jumlah;
    }

    public void setJumlah(Double jumlah) {
        this.jumlah = jumlah;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
