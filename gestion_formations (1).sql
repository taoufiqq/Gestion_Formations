-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  mer. 20 jan. 2021 à 08:54
-- Version du serveur :  10.4.10-MariaDB
-- Version de PHP :  7.4.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `gestion_formations`
--

-- --------------------------------------------------------

--
-- Structure de la table `employe`
--

DROP TABLE IF EXISTS `employe`;
CREATE TABLE IF NOT EXISTS `employe` (
  `idEmploye` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) NOT NULL,
  `prenom` varchar(255) NOT NULL,
  `login` varchar(255) NOT NULL,
  `password` varchar(15) NOT NULL,
  `confirm_password` varchar(15) NOT NULL,
  `ville` varchar(20) NOT NULL,
  `type_user` varchar(11) NOT NULL,
  PRIMARY KEY (`idEmploye`)
) ENGINE=MyISAM AUTO_INCREMENT=47 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `employe`
--

INSERT INTO `employe` (`idEmploye`, `nom`, `prenom`, `login`, `password`, `confirm_password`, `ville`, `type_user`) VALUES
(35, 'Belcaidnnia', 'Abderrahim', 'ABelcaid', '123', '123', 'Lbalda', 'admin'),
(46, 'test1', 'test3', 'admin2', 'aaa', 'aaa', 'safi', 'admin'),
(34, 'test1', 'test1', 'admin', 'admin', 'admin', 'agadir', 'admin'),
(41, 'test2', 'test2', 'test', 'ttt', 'ttt', 'safi', 'user'),
(38, 'ELHANCHAOUI', 'Taoufiq', 'taoufiqq', 'aaa', 'aaa', 'agadir', 'admin');

-- --------------------------------------------------------

--
-- Structure de la table `formation`
--

DROP TABLE IF EXISTS `formation`;
CREATE TABLE IF NOT EXISTS `formation` (
  `idFormation` int(11) NOT NULL AUTO_INCREMENT,
  `libelle` varchar(255) NOT NULL,
  `description` varchar(500) NOT NULL,
  PRIMARY KEY (`idFormation`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `formation`
--

INSERT INTO `formation` (`idFormation`, `libelle`, `description`) VALUES
(1, 'FrontEnd BackEnd', 'front end and back end refer to the separation of concerns between the presentation layer (front end), and the data access layer (back end) of a piece of software'),
(6, 'C++', 'ccccccccccccccZzzzzzzzz'),
(5, 'C#', ' multi-paradigm programming language encompassing static typing');

-- --------------------------------------------------------

--
-- Structure de la table `session`
--

DROP TABLE IF EXISTS `session`;
CREATE TABLE IF NOT EXISTS `session` (
  `idSession` int(11) NOT NULL AUTO_INCREMENT,
  `libelle` varchar(255) NOT NULL,
  `formation` varchar(255) NOT NULL,
  PRIMARY KEY (`idSession`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `session`
--

INSERT INTO `session` (`idSession`, `libelle`, `formation`) VALUES
(2, 'April 2021', 'Java'),
(4, 'janvier 2021', 'C++'),
(7, 'Octobre 2021 ', 'FrontEnd BackEnd');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
