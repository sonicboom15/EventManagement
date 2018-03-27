-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 22, 2018 at 05:47 PM
-- Server version: 10.1.21-MariaDB
-- PHP Version: 7.1.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `android`
--

-- --------------------------------------------------------

--
-- Table structure for table `user_table`
--

CREATE TABLE `user_table` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `reg_no` varchar(15) NOT NULL,
  `dob` date NOT NULL,
  `college_name` varchar(50) NOT NULL,
  `dept` varchar(30) NOT NULL,
  `year` int(11) NOT NULL,
  `AOI` text NOT NULL,
  `phone_no` varchar(15) NOT NULL,
  `pswd` varchar(255) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_at` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `email_id` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_table`
--

INSERT INTO `user_table` (`id`, `name`, `reg_no`, `dob`, `college_name`, `dept`, `year`, `AOI`, `phone_no`, `pswd`, `created_at`, `updated_at`, `email_id`) VALUES
(1, 'Aatisha ', '3512001', '2018-03-19', 'Sathyabama', 'IT', 3, 'singing', '123456789', '827ccb0eea8a706c4c34a16891f84e7b', '2018-03-22 16:16:57', '0000-00-00 00:00:00', 'abc@gmail.com'),
(7, 'aaa', '12314', '2018-03-08', 'aaa', 'ia', 3, 'sad', '1234512345', '827ccb0eea8a706c4c34a16891f84e7b', '2018-03-22 16:31:15', '0000-00-00 00:00:00', '123456789@g.com'),
(9, 'NIRNAY', '001', '2018-03-01', 'srm', 'cse', 3, 'football', '0000000000', '827ccb0eea8a706c4c34a16891f84e7b', '2018-03-22 16:38:54', '0000-00-00 00:00:00', '123456789@gmail.com'),
(10, 'Riya', '0002', '2018-03-02', 'sathyabama', 'cse', 4, 'Acting', '13456789', '827ccb0eea8a706c4c34a16891f84e7b', '2018-03-22 16:41:12', '0000-00-00 00:00:00', '123456789@f.gr');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `user_table`
--
ALTER TABLE `user_table`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email_id` (`email_id`),
  ADD UNIQUE KEY `phone_no` (`phone_no`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `user_table`
--
ALTER TABLE `user_table`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
