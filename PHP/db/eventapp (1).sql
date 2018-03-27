-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 27, 2018 at 07:17 PM
-- Server version: 10.1.21-MariaDB
-- PHP Version: 7.1.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `eventapp`
--

-- --------------------------------------------------------

--
-- Table structure for table `category_table`
--

CREATE TABLE `category_table` (
  `category_id` int(10) NOT NULL,
  `category_name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `category_table`
--

INSERT INTO `category_table` (`category_id`, `category_name`) VALUES
(1, 'workshop'),
(2, 'symposium'),
(3, 'training'),
(4, 'conference'),
(5, 'fest');

-- --------------------------------------------------------

--
-- Table structure for table `city_table`
--

CREATE TABLE `city_table` (
  `city_id` int(10) NOT NULL,
  `state_id` int(10) NOT NULL,
  `city_name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `dept_table`
--

CREATE TABLE `dept_table` (
  `dept_id` int(10) NOT NULL,
  `dept_name` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `dept_table`
--

INSERT INTO `dept_table` (`dept_id`, `dept_name`) VALUES
(1, 'Information Technology');

-- --------------------------------------------------------

--
-- Table structure for table `event_table`
--

CREATE TABLE `event_table` (
  `event_id` int(10) NOT NULL,
  `user_id` int(10) NOT NULL,
  `event_name` varchar(100) NOT NULL,
  `event_startdate` date NOT NULL,
  `event_enddate` date NOT NULL,
  `event_time` time NOT NULL,
  `event_pic` varchar(255) NOT NULL,
  `event_desc` varchar(255) NOT NULL,
  `date_of_displayingpost` date NOT NULL,
  `status_id` int(10) NOT NULL,
  `venue_addr` varchar(255) NOT NULL,
  `category_id` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `event_table`
--

INSERT INTO `event_table` (`event_id`, `user_id`, `event_name`, `event_startdate`, `event_enddate`, `event_time`, `event_pic`, `event_desc`, `date_of_displayingpost`, `status_id`, `venue_addr`, `category_id`) VALUES
(3, 4, 'Test Event', '2018-03-31', '2018-04-06', '00:00:00', 'uploads/event_img/27-03-2018-1522164007_a-free-happy-woman-photography-hd-wallpaper-3372x2000.jpg', 'Test Event', '2018-03-15', 5, 'Sbu Lib', 2),
(4, 4, 'bye', '2018-03-16', '2018-03-08', '00:00:00', 'uploads/event_img/26-03-2018-1522088737_diagram.jpg', 'afa', '2018-03-07', 1, 'ccc', 2),
(5, 4, 'aatisha', '2018-03-15', '2018-03-17', '00:00:00', 'uploads/event_img/26-03-2018-1522089317_default.jpg', 'bsafhghegfilye', '2018-03-22', 1, 'Chennai,Arihant Heirloom', 1),
(6, 4, 'silicon', '2018-03-27', '2018-03-29', '00:00:00', 'uploads/event_img/27-03-2018-1522122793_a-free-happy-woman-photography-hd-wallpaper-3372x2000.jpg', 'event', '2018-03-27', 1, 'lab', 1),
(7, 7, 'inficodec', '2018-03-15', '2018-03-23', '00:00:00', 'uploads/event_img/27-03-2018-1522132075_default.jpg', 'rgtg', '2018-03-08', 1, 'ddfe', 1),
(8, 7, 'inficodec', '2018-03-15', '2018-03-23', '00:00:00', 'uploads/event_img/27-03-2018-1522132469_default.jpg', 'rgtg', '2018-03-08', 1, 'ddfe', 1),
(9, 7, 'inficodec', '2018-03-15', '2018-03-23', '00:00:00', 'uploads/event_img/27-03-2018-1522132474_default.jpg', 'rgtg', '2018-03-08', 1, 'ddfe', 1),
(10, 7, 'inficodec', '2018-03-15', '2018-03-23', '00:00:00', 'uploads/event_img/27-03-2018-1522132497_a-free-happy-woman-photography-hd-wallpaper-3372x2000.jpg', 'rgtg', '2018-03-08', 1, 'ddfe', 1),
(11, 7, 'Sushma', '2018-03-22', '2018-03-23', '00:00:00', 'uploads/event_img/27-03-2018-1522132765_a-free-happy-woman-photography-hd-wallpaper-3372x2000.jpg', 'hgdykgwye', '2018-03-08', 1, 'Bihar', 1),
(12, 7, 'rang', '2018-03-10', '2018-03-23', '00:00:00', 'uploads/event_img/27-03-2018-1522153257_diagram.jpg', 'rgjerhgouerjiog', '2018-03-30', 1, 'Bettiah', 1),
(13, 7, 'festival', '2018-03-23', '2018-03-02', '00:00:00', 'uploads/event_img/27-03-2018-1522160845_diagram.jpg', 'hoiuooi', '2018-03-16', 1, 'kjhukhoi', 1),
(15, 7, 'Christmas Party', '2018-03-21', '2018-03-14', '11:11:00', 'uploads/event_img/27-03-2018-1522167045_a-free-happy-woman-photography-hd-wallpaper-3372x2000.jpg', 'jhuoyerofu', '2018-03-22', 1, 'jhsjdhheuf;er', 1);

-- --------------------------------------------------------

--
-- Table structure for table `privilege_table`
--

CREATE TABLE `privilege_table` (
  `privilege_id` int(10) NOT NULL,
  `privilege_designation` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `privilege_table`
--

INSERT INTO `privilege_table` (`privilege_id`, `privilege_designation`) VALUES
(1, 'admin'),
(2, 'user');

-- --------------------------------------------------------

--
-- Table structure for table `state_table`
--

CREATE TABLE `state_table` (
  `state_id` int(10) NOT NULL,
  `state_name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `status_table`
--

CREATE TABLE `status_table` (
  `status_id` int(10) NOT NULL,
  `status_desc` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `status_table`
--

INSERT INTO `status_table` (`status_id`, `status_desc`) VALUES
(1, 'pending'),
(2, 'approved'),
(3, 'active'),
(4, 'deactive'),
(5, 'deleted');

-- --------------------------------------------------------

--
-- Table structure for table `user_table`
--

CREATE TABLE `user_table` (
  `user_id` int(10) NOT NULL,
  `phone_no` varchar(15) NOT NULL,
  `email` varchar(30) NOT NULL,
  `name` varchar(30) NOT NULL,
  `reg_no` int(15) NOT NULL,
  `college_name` varchar(100) NOT NULL,
  `dob` date NOT NULL,
  `privilege_id` int(11) NOT NULL,
  `dept_id` int(10) NOT NULL,
  `password` varchar(255) NOT NULL,
  `createdAt` datetime NOT NULL,
  `updatedAt` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_table`
--

INSERT INTO `user_table` (`user_id`, `phone_no`, `email`, `name`, `reg_no`, `college_name`, `dob`, `privilege_id`, `dept_id`, `password`, `createdAt`, `updatedAt`) VALUES
(2, '2147483647', 'cyrillaatisha@gmail.com', 'Aatisha Cyrill', 3512001, 'sathyabama', '1997-10-11', 2, 1, '202cb962ac59075b964b07152d234b70', '2018-03-26 00:00:00', '0000-00-00 00:00:00'),
(4, '8002928908', 'nigel@gmail.com', 'Nigel', 2001, 'DAV', '2018-03-14', 2, 1, '202cb962ac59075b964b07152d234b70', '2018-03-26 00:00:00', '0000-00-00 00:00:00'),
(6, '7358520390', 'sindhukb9@gmail.com', 'sindhu', 3512141, 'sathyabama', '2018-03-01', 2, 1, '827ccb0eea8a706c4c34a16891f84e7b', '2018-03-27 00:00:00', '0000-00-00 00:00:00'),
(7, '9939195737', 'sushma@gmail.com', 'raju', 3235, 'st tresa', '2018-03-08', 2, 1, 'bd1d7b0809e4b4ee9ca307aa5308ea6f', '2018-03-27 00:00:00', '2018-03-27 21:18:50');

-- --------------------------------------------------------

--
-- Table structure for table `wishlist`
--

CREATE TABLE `wishlist` (
  `wishlist_id` int(10) NOT NULL,
  `user_id` int(10) NOT NULL,
  `event_id` int(10) NOT NULL,
  `wishlist_status` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `category_table`
--
ALTER TABLE `category_table`
  ADD PRIMARY KEY (`category_id`);

--
-- Indexes for table `city_table`
--
ALTER TABLE `city_table`
  ADD PRIMARY KEY (`city_id`),
  ADD KEY `state_id` (`state_id`);

--
-- Indexes for table `dept_table`
--
ALTER TABLE `dept_table`
  ADD PRIMARY KEY (`dept_id`);

--
-- Indexes for table `event_table`
--
ALTER TABLE `event_table`
  ADD PRIMARY KEY (`event_id`),
  ADD KEY `user_id` (`user_id`),
  ADD KEY `status_id` (`status_id`),
  ADD KEY `category_id` (`category_id`);

--
-- Indexes for table `privilege_table`
--
ALTER TABLE `privilege_table`
  ADD PRIMARY KEY (`privilege_id`);

--
-- Indexes for table `state_table`
--
ALTER TABLE `state_table`
  ADD PRIMARY KEY (`state_id`);

--
-- Indexes for table `status_table`
--
ALTER TABLE `status_table`
  ADD PRIMARY KEY (`status_id`);

--
-- Indexes for table `user_table`
--
ALTER TABLE `user_table`
  ADD PRIMARY KEY (`user_id`),
  ADD UNIQUE KEY `phone_no` (`phone_no`),
  ADD UNIQUE KEY `email` (`email`),
  ADD KEY `privilege_id` (`privilege_id`),
  ADD KEY `dept_id` (`dept_id`);

--
-- Indexes for table `wishlist`
--
ALTER TABLE `wishlist`
  ADD PRIMARY KEY (`wishlist_id`),
  ADD KEY `user_id` (`user_id`),
  ADD KEY `event_id` (`event_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `dept_table`
--
ALTER TABLE `dept_table`
  MODIFY `dept_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `event_table`
--
ALTER TABLE `event_table`
  MODIFY `event_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
--
-- AUTO_INCREMENT for table `user_table`
--
ALTER TABLE `user_table`
  MODIFY `user_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `city_table`
--
ALTER TABLE `city_table`
  ADD CONSTRAINT `city_table_ibfk_1` FOREIGN KEY (`state_id`) REFERENCES `state_table` (`state_id`);

--
-- Constraints for table `event_table`
--
ALTER TABLE `event_table`
  ADD CONSTRAINT `event_table_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user_table` (`user_id`),
  ADD CONSTRAINT `event_table_ibfk_3` FOREIGN KEY (`status_id`) REFERENCES `status_table` (`status_id`),
  ADD CONSTRAINT `event_table_ibfk_5` FOREIGN KEY (`category_id`) REFERENCES `category_table` (`category_id`);

--
-- Constraints for table `user_table`
--
ALTER TABLE `user_table`
  ADD CONSTRAINT `user_table_ibfk_1` FOREIGN KEY (`privilege_id`) REFERENCES `privilege_table` (`privilege_id`),
  ADD CONSTRAINT `user_table_ibfk_2` FOREIGN KEY (`dept_id`) REFERENCES `dept_table` (`dept_id`);

--
-- Constraints for table `wishlist`
--
ALTER TABLE `wishlist`
  ADD CONSTRAINT `wishlist_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user_table` (`user_id`),
  ADD CONSTRAINT `wishlist_ibfk_2` FOREIGN KEY (`event_id`) REFERENCES `event_table` (`event_id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
