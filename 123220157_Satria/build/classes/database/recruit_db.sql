-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 31 Bulan Mei 2024 pada 05.56
-- Versi server: 10.4.32-MariaDB
-- Versi PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `recruit_db`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `recruitment`
--

CREATE TABLE `recruitment` (
  `name` varchar(255) NOT NULL,
  `path` varchar(255) NOT NULL,
  `writing` float NOT NULL,
  `coding` float NOT NULL,
  `interview` float NOT NULL,
  `score` float NOT NULL,
  `status` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `recruitment`
--

INSERT INTO `recruitment` (`name`, `path`, `writing`, `coding`, `interview`, `score`, `status`) VALUES
('Arda', 'Android Developer', 45, 64, 45, 54.5, 'DITOLAK'),
('nolan', 'Web Developer', 90, 80, 100, 89, 'DITERIMA');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
