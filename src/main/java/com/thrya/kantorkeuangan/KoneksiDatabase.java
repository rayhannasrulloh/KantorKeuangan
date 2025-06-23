package com.thrya.kantorkeuangan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class KoneksiDatabase {

    // jdbc:mysql:// -> protokol untuk koneksi
    // localhost -> nama host tempat database berjalan (komputer Anda sendiri)
    // 3306 -> port default untuk MySQL
    // db_kantor -> nama database yang ingin kita gunakan
    private static final String URL = "jdbc:mysql://localhost:3306/db_kantor";

    private static final String USER = "root";

    private static final String PASSWORD = "";

    private static Connection koneksi;

    public static Connection getKoneksi() {
        try {
            if (koneksi == null || koneksi.isClosed()) {
                koneksi = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("Koneksi ke database berhasil!");
            }
        } catch (SQLException e) {
            System.err.println("Koneksi ke database gagal: " + e.getMessage());
        }
        return koneksi;
    }

    public static void main(String[] args) {
        Connection testKoneksi = KoneksiDatabase.getKoneksi();

        if (testKoneksi != null) {
            System.out.println("Pengujian koneksi berhasil");
            try {
                testKoneksi.close();
                System.out.println("Koneksi berhasil ditutup.");
            } catch (SQLException e) {
                System.err.println("Gagal menutup koneksi: " + e.getMessage());
            }
        } else {
            System.err.println("Pengujian koneksi gagal. Cek kembali URL, username, dan password Anda.");
        }
    }
}