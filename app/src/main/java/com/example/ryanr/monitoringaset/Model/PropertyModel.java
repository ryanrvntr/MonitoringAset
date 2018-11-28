package com.example.ryanr.monitoringaset.Model;

public class PropertyModel {
    String nama,alamat,kecamatan,kabupaten,profinsi,kodePos,gambar,keterangan;

    public PropertyModel() {
    }

    public PropertyModel(String nama, String alamat, String kecamatan, String kabupaten, String profinsi, String kodePos, String gambar, String keterangan) {
        this.nama = nama;
        this.alamat = alamat;
        this.kecamatan = kecamatan;
        this.kabupaten = kabupaten;
        this.profinsi = profinsi;
        this.kodePos = kodePos;
        this.gambar = gambar;
        this.keterangan = keterangan;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getKecamatan() {
        return kecamatan;
    }

    public void setKecamatan(String kecamatan) {
        this.kecamatan = kecamatan;
    }

    public String getKabupaten() {
        return kabupaten;
    }

    public void setKabupaten(String kabupaten) {
        this.kabupaten = kabupaten;
    }

    public String getProfinsi() {
        return profinsi;
    }

    public void setProfinsi(String profinsi) {
        this.profinsi = profinsi;
    }

    public String getKodePos() {
        return kodePos;
    }

    public void setKodePos(String kodePos) {
        this.kodePos = kodePos;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }
}
