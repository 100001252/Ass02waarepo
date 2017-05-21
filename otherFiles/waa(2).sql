-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: May 21, 2017 at 08:08 AM
-- Server version: 10.1.9-MariaDB
-- PHP Version: 5.6.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `waa`
--

-- --------------------------------------------------------

--
-- Table structure for table `books`
--

CREATE TABLE `books` (
  `id` int(11) NOT NULL,
  `title` varchar(250) DEFAULT NULL,
  `authorList` varchar(250) DEFAULT NULL,
  `isbn` varchar(250) DEFAULT NULL,
  `publisher` varchar(250) DEFAULT NULL,
  `publishDate` varchar(250) DEFAULT NULL,
  `status` varchar(250) DEFAULT NULL,
  `extInfo` varchar(250) DEFAULT NULL,
  `createdTime` datetime DEFAULT NULL,
  `updatedTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `books`
--

INSERT INTO `books` (`id`, `title`, `authorList`, `isbn`, `publisher`, `publishDate`, `status`, `extInfo`, `createdTime`, `updatedTime`) VALUES
(2, 'bok2', 'authorlist', '1234567987', 'publisher', '12/09/1980', 'on loan', NULL, '2017-04-09 18:52:07', '2017-05-07 03:30:11'),
(3, 'book3', 'book3author', '1234567893', 'publisher3', '26/09/2012', 'on loan', NULL, NULL, '2017-04-23 11:52:42'),
(4, 'book4', 'book3author', '1234567894', 'publisher3', '26/09/2012', 'on loan', NULL, NULL, '2017-04-25 02:13:22'),
(5, 'book5', 'book3author', '1234567895', 'publisher3', '26/09/2012', 'available', NULL, NULL, '2017-04-23 11:40:22'),
(6, 'test20', 'test20author', '1234567891', 'mypublisher', '26/05/2012', 'on loan', NULL, '2017-05-02 20:47:07', '2017-05-02 11:40:50'),
(7, 'test90', 'test90 publisher', '1234324123', 'mypublisher', '25/09/2015', 'available', NULL, '2017-05-02 21:30:28', '2017-05-02 11:30:52'),
(8, 'testtitle44', 'testautorlist', '1241233454', 'publishername', 'Tue Sep 22 00:00:00 AEST 2015', 'available', NULL, '2017-05-13 20:43:01', '2017-05-13 10:43:01'),
(9, 'test55', 'my author list', '1234567777', 'publisher', 'Tue Mar 22 00:00:00 AEDT 2016', 'available', NULL, '2017-05-13 20:47:54', '2017-05-13 10:47:54'),
(10, 'test444', 'my author list', '8888888888', 'publisher', '22/03/2016', 'available', NULL, '2017-05-13 20:54:06', '2017-05-13 10:54:06');

-- --------------------------------------------------------

--
-- Table structure for table `bookshop`
--

CREATE TABLE `bookshop` (
  `id` int(11) NOT NULL,
  `title` varchar(250) DEFAULT NULL,
  `authorList` varchar(250) DEFAULT NULL,
  `isbn` varchar(250) DEFAULT NULL,
  `publisher` varchar(250) DEFAULT NULL,
  `publishDate` varchar(250) DEFAULT NULL,
  `rating` int(11) DEFAULT NULL,
  `availabilityaus` tinyint(1) DEFAULT '1',
  `ebook` tinyint(1) DEFAULT '0',
  `createdTime` datetime DEFAULT NULL,
  `updatedTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bookshop`
--

INSERT INTO `bookshop` (`id`, `title`, `authorList`, `isbn`, `publisher`, `publishDate`, `rating`, `availabilityaus`, `ebook`, `createdTime`, `updatedTime`) VALUES
(1, 'test1', NULL, '1234566666', NULL, NULL, 2, 1, 1, NULL, '2017-05-21 05:43:27'),
(2, 'test2', NULL, '1234566616', NULL, NULL, 3, 1, 1, NULL, '2017-05-21 05:46:15'),
(3, 'test2', NULL, '1234566626', NULL, NULL, 4, 1, 1, NULL, '2017-05-21 05:46:44'),
(4, 'test2', NULL, '1234566636', NULL, NULL, 4, 0, 1, NULL, '2017-05-21 05:46:59'),
(6, 'test2', NULL, '1234566646', NULL, NULL, 4, 0, 0, NULL, '2017-05-21 05:47:15');

-- --------------------------------------------------------

--
-- Table structure for table `students`
--

CREATE TABLE `students` (
  `id` int(11) NOT NULL,
  `fullName` varchar(250) DEFAULT NULL,
  `pin` varchar(250) DEFAULT NULL,
  `extInfo` varchar(250) DEFAULT NULL,
  `createdTime` datetime DEFAULT NULL,
  `updatedTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `students`
--

INSERT INTO `students` (`id`, `fullName`, `pin`, `extInfo`, `createdTime`, `updatedTime`) VALUES
(2, 'mansour shadloo', '2222', NULL, '2017-04-08 21:42:40', '2017-04-08 11:42:40'),
(3, 'test3', '33', NULL, '2017-04-08 21:43:01', '2017-04-08 11:43:01'),
(4, 'test4', '44', NULL, '2017-04-08 21:43:17', '2017-04-08 11:43:17'),
(5, 'mansour', '3333', NULL, '2017-04-10 18:58:18', '2017-04-10 08:58:18'),
(6, 'mansour', '3333', NULL, '2017-04-10 20:45:09', '2017-04-10 10:45:09'),
(7, 'mansour', '3333', NULL, '2017-04-10 20:45:27', '2017-04-10 10:45:27'),
(8, 'mansour', '3333', NULL, '2017-04-10 20:45:48', '2017-04-10 10:45:48'),
(9, 'mansour', '3333', NULL, '2017-04-10 20:50:08', '2017-04-10 10:50:08'),
(10, 'mansour', '3333', NULL, '2017-04-10 20:58:36', '2017-04-10 10:58:36'),
(11, 'mansour', '3333', NULL, '2017-04-10 20:58:52', '2017-04-10 10:58:52'),
(12, 'alan', '333', NULL, '2017-04-10 21:16:30', '2017-04-10 11:16:30'),
(13, 'alan', '333', NULL, '2017-04-11 22:06:24', '2017-04-11 12:06:24'),
(14, 'alan', '333', NULL, '2017-04-11 22:09:27', '2017-04-11 12:09:27'),
(15, 'alan', '333', NULL, '2017-04-11 22:09:58', '2017-04-11 12:09:58'),
(16, 'test44', '44', NULL, '2017-05-13 20:44:11', '2017-05-13 10:44:11'),
(17, 'testtttt', '22', NULL, '2017-05-19 20:55:35', '2017-05-19 10:55:35');

-- --------------------------------------------------------

--
-- Table structure for table `student_borrow`
--

CREATE TABLE `student_borrow` (
  `id` int(11) NOT NULL,
  `student_id` int(11) DEFAULT NULL,
  `book_id` int(11) DEFAULT NULL,
  `action` varchar(250) DEFAULT NULL,
  `createdTime` datetime DEFAULT NULL,
  `updatedTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `student_borrow`
--

INSERT INTO `student_borrow` (`id`, `student_id`, `book_id`, `action`, `createdTime`, `updatedTime`) VALUES
(18, 2, 2, 'on loan', NULL, '2017-04-23 11:44:41'),
(19, 2, 3, 'on loan', '2017-04-23 21:52:42', '2017-04-23 11:52:42'),
(20, 2, 4, 'on loan', '2017-04-25 12:13:22', '2017-05-02 11:36:29'),
(21, 3, 7, 'on loan', '2017-05-02 21:37:46', '2017-05-02 11:37:46'),
(22, 15, 6, 'on loan', '2017-05-02 21:40:50', '2017-05-02 11:40:50');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `books`
--
ALTER TABLE `books`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `uq_book_cons` (`isbn`);

--
-- Indexes for table `bookshop`
--
ALTER TABLE `bookshop`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `isbn` (`isbn`);

--
-- Indexes for table `students`
--
ALTER TABLE `students`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `student_borrow`
--
ALTER TABLE `student_borrow`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `student_borrow_uniquekey` (`book_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `books`
--
ALTER TABLE `books`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT for table `bookshop`
--
ALTER TABLE `bookshop`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `students`
--
ALTER TABLE `students`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;
--
-- AUTO_INCREMENT for table `student_borrow`
--
ALTER TABLE `student_borrow`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
