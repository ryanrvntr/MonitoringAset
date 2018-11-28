package com.example.ryanr.monitoringaset.Model;

public class InventoryModel {
    String nama,merk,jumlah,satuan,ruang,keterangan,jenis,gambar,tanggal;

    public InventoryModel() {
    }


    public InventoryModel(String nama, String merk, String jumlah, String satuan, String ruang, String keterangan, String jenis, String gambar, String tanggal) {

        this.nama = nama;
        this.merk = merk;
        this.jumlah = jumlah;
        this.satuan = satuan;
        this.ruang = ruang;
        this.keterangan = keterangan;
        this.jenis = jenis;
        this.gambar = gambar;
        this.tanggal = tanggal;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getMerk() {
        return merk;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public String getJumlah() {
        return jumlah;
    }

    public void setJumlah(String jumlah) {
        this.jumlah = jumlah;
    }

    public String getSatuan() {
        return satuan;
    }

    public void setSatuan(String satuan) {
        this.satuan = satuan;
    }

    public String getRuang() {
        return ruang;
    }

    public void setRuang(String ruang) {
        this.ruang = ruang;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }
    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }
}
