-- ===================================================
-- Database: AirlineDB
-- Project: Airline Reservation System
-- Developer: Mahi Rajawat (PIET25CS088)
-- ===================================================

CREATE DATABASE IF NOT EXISTS AirlineDB;
USE AirlineDB;

-- Admin Credentials Table
CREATE TABLE IF NOT EXISTS admin (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL
);

-- Insert Default Admin
INSERT INTO admin (username, password) VALUES ('admin', 'admin123')
ON DUPLICATE KEY UPDATE username=username;

-- Flights Table
CREATE TABLE IF NOT EXISTS Flights (
    id INT AUTO_INCREMENT PRIMARY KEY,
    flight_number VARCHAR(50) NOT NULL,
    source VARCHAR(50) NOT NULL,
    destination VARCHAR(50) NOT NULL,
    date VARCHAR(20) NOT NULL,
    time VARCHAR(20) NOT NULL,
    total_seats INT NOT NULL,
    available_seats INT NOT NULL
);

-- Sample Data
INSERT INTO Flights (flight_number, source, destination, date, time, total_seats, available_seats) VALUES
('108', 'dehli', 'jaipur', '2026-11-02', '10:00:00', 1004, 90),
('201', 'Jaipur', 'DEHLI', '2026-09-02', '11:00:00', 1022, 20),
('66', 'japan', 'NYU', '2027-08-09', '13:00:00', 1331, 121),
('11', 'korea', 'THAILAND', '2027-08-06', '10:00:00', 1234, 223),
('123', 'jaipur', 'dehli', '2026-08-09', '12:00:00', 12, 1);