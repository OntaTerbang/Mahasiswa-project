/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.tugas1oop2fadillahfajri19552011285;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
       MahasiswaOperations operations = new MahasiswaOperations();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Menu Mahasiswa ---");
            System.out.println("1. Tambah Mahasiswa");
            System.out.println("2. Lihat Semua Mahasiswa");
            System.out.println("3. Perbarui Data Mahasiswa");
            System.out.println("4. Hapus Mahasiswa");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Masukkan NIM: ");
                    String nim = scanner.nextLine();
                    System.out.print("Masukkan Nama Lengkap: ");
                    String namaLengkap = scanner.nextLine();
                    System.out.print("Masukkan Tanggal Lahir (YYYY-MM-DD): ");
                    String tanggalLahir = scanner.nextLine();
                    // Validasi format tanggal
                        if (!tanggalLahir.matches("\\d{4}-\\d{2}-\\d{2}")) {
                          System.out.println("Format tanggal salah! Gunakan format YYYY-MM-DD.");
                             continue;} // Kembali ke menu]
                    System.out.print("Masukkan Jenis Kelamin (Laki-laki/Perempuan): ");
                    String jenisKelamin = scanner.nextLine();
                    System.out.print("Masukkan Alamat: ");
                    String alamat = scanner.nextLine();
                    System.out.print("Masukkan No. Telp: ");
                    String noTelp = scanner.nextLine();
                    System.out.print("Masukkan Email: ");
                    String email = scanner.nextLine();

                    Mahasiswa mahasiswa = new Mahasiswa(nim, namaLengkap, tanggalLahir, jenisKelamin, alamat, noTelp, email);
                    operations.addMahasiswa(mahasiswa);
                    break;

                case 2:
                    System.out.println("\nDaftar Mahasiswa:");
                    List<Mahasiswa> mahasiswas = operations.getAllMahasiswa();
                    mahasiswas.forEach(System.out::println);
                    break;

                case 3:
                    System.out.print("Masukkan ID Mahasiswa yang akan diperbarui: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Masukkan NIM Baru: ");
                    String newNim = scanner.nextLine();
                    System.out.print("Masukkan Nama Lengkap Baru: ");
                    String newNamaLengkap = scanner.nextLine();
                    System.out.print("Masukkan Tanggal Lahir Baru (YYYY-MM-DD): ");
                    String newTanggalLahir = scanner.nextLine();
                    System.out.print("Masukkan Jenis Kelamin Baru (Laki-laki/Perempuan): ");
                    String newJenisKelamin = scanner.nextLine();
                    System.out.print("Masukkan Alamat Baru: ");
                    String newAlamat = scanner.nextLine();
                    System.out.print("Masukkan No. Telp Baru: ");
                    String newNoTelp = scanner.nextLine();
                    System.out.print("Masukkan Email Baru: ");
                    String newEmail = scanner.nextLine();

                    operations.updateMahasiswa(updateId, newNim, newNamaLengkap, newTanggalLahir, newJenisKelamin, newAlamat, newNoTelp, newEmail);
                    break;

                case 4:
                    System.out.print("Masukkan ID Mahasiswa yang akan dihapus: ");
                    int deleteId = scanner.nextInt();
                    operations.deleteMahasiswa(deleteId);
                    break;

                case 0:
                    System.out.println("Keluar dari aplikasi...");
                    break;

                default:
                    System.out.println("Pilihan tidak valid!");
            }
        } while (choice != 0);

        operations.closeConnection();
        scanner.close();
    }
}
