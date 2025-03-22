/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tugas1oop2fadillahfajri19552011285;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Fadil
 */
public class MahasiswaOperations {
    private Connection connection;

    public MahasiswaOperations() {
        // Initialize connection using DatabaseConnection
        this.connection = DatabaseConnection.getConnection();
        if (this.connection == null) {
            throw new RuntimeException("Failed to initialize database connection.");
        }
    }

    // Method untuk menambahkan mahasiswa
    public void addMahasiswa(Mahasiswa mahasiswa) {
        String query = "INSERT INTO mahasiswa_baru (nim, nama_lengkap, tanggal_lahir, jenis_kelamin, alamat, no_telp, email) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, mahasiswa.getNim());
            stmt.setString(2, mahasiswa.getNamaLengkap());
            stmt.setString(3, mahasiswa.getTanggalLahir());
            stmt.setString(4, mahasiswa.getJenisKelamin());
            stmt.setString(5, mahasiswa.getAlamat());
            stmt.setString(6, mahasiswa.getNoTelp());
            stmt.setString(7, mahasiswa.getEmail());
            int rowsAffected = stmt.executeUpdate(); // Eksekusi query
        if (rowsAffected > 0) {
            System.out.println("Mahasiswa added successfully!");
            } else {
            System.out.println("Failed to add mahasiswa.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method untuk mengambil semua data mahasiswa
    public List<Mahasiswa> getAllMahasiswa() {
        List<Mahasiswa> mahasiswas = new ArrayList<>();
        String query = "SELECT * FROM mahasiswa_baru";
        try (PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Mahasiswa mahasiswa = new Mahasiswa(
                        rs.getInt("id_mahasiswa"),
                        rs.getString("nim"),
                        rs.getString("nama_lengkap"),
                        rs.getString("tanggal_lahir"),
                        rs.getString("jenis_kelamin"),
                        rs.getString("alamat"),
                        rs.getString("no_telp"),
                        rs.getString("email"),
                        rs.getString("tanggal_daftar")
                );
                mahasiswas.add(mahasiswa);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mahasiswas;
    }

    // Method untuk memperbarui data mahasiswa
    public void updateMahasiswa(int idMahasiswa, String newNim, String newNamaLengkap, String newTanggalLahir, String newJenisKelamin, String newAlamat, String newNoTelp, String newEmail) {
        String query = "UPDATE mahasiswa_baru SET nim = ?, nama_lengkap = ?, tanggal_lahir = ?, jenis_kelamin = ?, alamat = ?, no_telp = ?, email = ? WHERE id_mahasiswa = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, newNim);
            stmt.setString(2, newNamaLengkap);
            stmt.setString(3, newTanggalLahir);
            stmt.setString(4, newJenisKelamin);
            stmt.setString(5, newAlamat);
            stmt.setString(6, newNoTelp);
            stmt.setString(7, newEmail);
            stmt.setInt(8, idMahasiswa);
            stmt.executeUpdate();
            System.out.println("Mahasiswa updated successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method untuk menghapus data mahasiswa
    public void deleteMahasiswa(int idMahasiswa) {
        String query = "DELETE FROM mahasiswa_baru WHERE id_mahasiswa = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, idMahasiswa);
            stmt.executeUpdate();
            System.out.println("Mahasiswa deleted successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method untuk menutup koneksi (opsional)
    public void closeConnection() {
        DatabaseConnection.closeConnection();
    }
}
