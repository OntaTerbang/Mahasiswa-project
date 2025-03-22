/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tugas1oop2fadillahfajri19552011285;

/**
 *
 * @author Fadil
 */
public class Mahasiswa {
    private int idMahasiswa;
    private String nim;
    private String namaLengkap;
    private String tanggalLahir;
    private String jenisKelamin;
    private String alamat;
    private String noTelp;
    private String email;
    private String tanggalDaftar;

    // Constructor untuk inisialisasi objek Mahasiswa
    public Mahasiswa(int idMahasiswa, String nim, String namaLengkap, String tanggalLahir, String jenisKelamin, String alamat, String noTelp, String email, String tanggalDaftar) {
        this.idMahasiswa = idMahasiswa;
        this.nim = nim;
        this.namaLengkap = namaLengkap;
        this.tanggalLahir = tanggalLahir;
        this.jenisKelamin = jenisKelamin;
        this.alamat = alamat;
        this.noTelp = noTelp;
        this.email = email;
        this.tanggalDaftar = tanggalDaftar;
    }

    // Constructor untuk menambahkan mahasiswa baru (tanpa id dan tanggal_daftar)
    public Mahasiswa(String nim, String namaLengkap, String tanggalLahir, String jenisKelamin, String alamat, String noTelp, String email) {
        this.nim = nim;
        this.namaLengkap = namaLengkap;
        this.tanggalLahir = tanggalLahir;
        this.jenisKelamin = jenisKelamin;
        this.alamat = alamat;
        this.noTelp = noTelp;
        this.email = email;
    }

    // Getters and Setters
    public int getIdMahasiswa() {
        return idMahasiswa;
    }

    public String getNim() {
        return nim;
    }

    public String getNamaLengkap() {
        return namaLengkap;
    }

    public String getTanggalLahir() {
        return tanggalLahir;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public String getAlamat() {
        return alamat;
    }

    public String getNoTelp() {
        return noTelp;
    }

    public String getEmail() {
        return email;
    }

    public String getTanggalDaftar() {
        return tanggalDaftar;
    }

    @Override
    public String toString() {
        return "Mahasiswa{" +
                "idMahasiswa=" + idMahasiswa +
                ", nim='" + nim + '\'' +
                ", namaLengkap='" + namaLengkap + '\'' +
                ", tanggalLahir='" + tanggalLahir + '\'' +
                ", jenisKelamin='" + jenisKelamin + '\'' +
                ", alamat='" + alamat + '\'' +
                ", noTelp='" + noTelp + '\'' +
                ", email='" + email + '\'' +
                ", tanggalDaftar='" + tanggalDaftar + '\'' +
                '}';
    }
}
