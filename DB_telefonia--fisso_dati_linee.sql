-- --------------------------------------------------------
-- Host:                         lnx023
-- Versione server:              5.1.73-0ubuntu0.10.04.1 - (Ubuntu)
-- S.O. server:                  debian-linux-gnu
-- HeidiSQL Versione:            9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dump della struttura del database telefonia
CREATE DATABASE IF NOT EXISTS `telefonia` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `telefonia`;

-- Dump della struttura di tabella telefonia.fisso_dati_linee
CREATE TABLE IF NOT EXISTS `fisso_dati_linee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `n_linea` varchar(50) DEFAULT NULL,
  `cap_spesa` varchar(50) DEFAULT NULL,
  `cdr` varchar(50) DEFAULT NULL,
  `cdg` varchar(50) DEFAULT NULL,
  `ril_iva` varchar(50) DEFAULT NULL,
  `impegno` varchar(50) DEFAULT NULL,
  `note` varchar(50) DEFAULT NULL,
  `data_att` date DEFAULT NULL,
  `data_cess` date DEFAULT NULL,
  KEY `Indice 1` (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=280 DEFAULT CHARSET=latin1;

-- Dump dei dati della tabella telefonia.fisso_dati_linee: 279 rows
DELETE FROM `fisso_dati_linee`;
/*!40000 ALTER TABLE `fisso_dati_linee` DISABLE KEYS */;
INSERT INTO `fisso_dati_linee` (`id`, `n_linea`, `cap_spesa`, `cdr`, `cdg`, `ril_iva`, `impegno`, `note`, `data_att`, `data_cess`) VALUES
	(1, '054311148648', '20200/3343', '181', '181', '', '2016 127/1', 'WI-FI', NULL, NULL),
	(2, '054321013', '55750/3335', '436', '181', '', '2016 445/1', '', NULL, NULL),
	(3, '054321109', '37400/3335', '422', '181', '', '2016 437/1', '', NULL, NULL),
	(4, '054321217', '20200/3335', '181', '181', '', '2016 468/1', '', NULL, NULL),
	(5, '054321231', '37400/3335', '422', '181', '', '2016 437/1', '', NULL, NULL),
	(6, '054321317', '28300/3335', '465', '181', '', '2016 435/1', '', NULL, NULL),
	(7, '054321424', '37400/3335', '422', '181', '', '2016 437/1', '', NULL, NULL),
	(8, '054321875', '37400/3335', '422', '181', '', '2016 437/1', '', NULL, NULL),
	(9, '054321986', '55750/3335', '436', '181', '', '2016 445/1', '', NULL, NULL),
	(10, '054322618', '37400/3335', '422', '181', '', '2016 437/1', '', NULL, NULL),
	(11, '054324184', '37400/3335', '422', '181', '', '2016 437/1', '', NULL, NULL),
	(12, '054325508', '20200/3335', '181', '181', '', '2016 468/1', '', NULL, NULL),
	(13, '054325617', '25700/3335', '455', '181', 'IVA', '2016 433/1', '', NULL, NULL),
	(14, '054325656', '27300/3335', '464', '181', '', '2016 434/1', '', NULL, NULL),
	(15, '054326039', '04200/3335', '117', '181', '', '2016 429/1', '', NULL, NULL),
	(16, '054327048', '60060/3335', '434', '181', '', '2016 469/1', '', NULL, NULL),
	(17, '054329059', '55750/3335', '436', '181', '', '2016 445/1', '', NULL, NULL),
	(18, '054329344', '25700/3335', '455', '181', 'IVA', '2016 433/1', '', NULL, NULL),
	(19, '054329510', '60090/3335', '449', '181', '', '2016 447/1', '', NULL, NULL),
	(20, '054330244', '20200/3335', '181', '181', '', '2016 468/1', '', NULL, NULL),
	(21, '054330593', '37400/3335', '422', '181', '', '2016 437/1', '', NULL, NULL),
	(22, '054330709', '55750/3335', '436', '181', '', '2016 445/1', '', NULL, NULL),
	(23, '054331207', '25700/3335', '455', '181', 'IVA', '2016 433/1', '', NULL, NULL),
	(24, '054331454', '04200/3335', '117', '181', '', '2016 429/1', '', NULL, NULL),
	(25, '054332042', '20200/3335', '181', '181', '', '2016 468/1', '', NULL, NULL),
	(26, '054332121', '20200/3335', '181', '181', '', '2016 468/1', '', NULL, NULL),
	(27, '054332193', '25700/3335', '455', '181', 'IVA', '2016 433/1', '', NULL, NULL),
	(28, '054332991', '27300/3335', '464', '181', '', '2016 434/1', '', NULL, NULL),
	(29, '054333163', '20200/3335', '181', '181', '', '2016 468/1', '', NULL, NULL),
	(30, '054333378', '20200/3335', '181', '181', '', '2016 468/1', '', NULL, NULL),
	(31, '054333386', '38400/3335', '412', '181', 'IVA', '2017 156/1', '', NULL, NULL),
	(32, '054333599', '60090/3335', '779', '181', '', '2016 447/1', '', NULL, NULL),
	(33, '054334002', '23300/3335', '131', '181', '', '2016 432/1', '', NULL, NULL),
	(34, '054334070', '20200/3335', '181', '181', '', '2016 468/1', '', NULL, NULL),
	(35, '054334092', '41700/3335', '417', '181', 'IVA', '2016 440/1', '', NULL, NULL),
	(36, '054334180', '27300/3335', '464', '181', '', '2016 434/1', '', NULL, NULL),
	(37, '054334491', '55750/3335', '436', '181', '', '2016 445/1', '', NULL, NULL),
	(38, '054334951', '25700/3335', '455', '181', 'IVA', '2016 433/1', '', NULL, NULL),
	(39, '054335435', '23300/3335', '131', '181', '', '2016 432/1', '', NULL, NULL),
	(40, '054335665', '37400/3335', '422', '181', '', '2016 437/1', '', NULL, NULL),
	(41, '054336154', '37400/3335', '422', '181', '', '2016 437/1', '', NULL, NULL),
	(42, '054336349', '23300/3335', '131', '181', '', '2016 432/1', '', NULL, NULL),
	(43, '054336615', '25700/3335', '455', '181', 'iVA', '2016 433/1', '', NULL, NULL),
	(44, '054336691', '20200/3335', '181', '181', '', '2016 468/1', '', NULL, NULL),
	(45, '0543370096', '65600/3335', '223', '181', 'IVA', '2016 450/1', '', NULL, NULL),
	(46, '0543370444', '37400/3335', '422', '181', '', '2016 437/1', '', NULL, NULL),
	(47, '0543371067', '20200/3335', '181', '181', '', '2016 468/1', '', NULL, NULL),
	(48, '0543400635', '23300/3335', '131', '181', '', '2016 432/1', '', NULL, NULL),
	(49, '0543401376', '27300/3335', '464', '181', '', '2016 434/1', '', NULL, NULL),
	(50, '0543401421', '55600/3335', '452', '181', 'IVA', '2017 162/1', '', NULL, NULL),
	(51, '0543403003', '27300/3335', '464', '181', '', '2016 434/1', '', NULL, NULL),
	(52, '0543404137', '04200/3335', '117', '181', '', '2016 429/1', '', NULL, NULL),
	(53, '0543404239', '37400/3335', '422', '181', '', '2016 437/1', '', NULL, NULL),
	(54, '0543404367', '28300/3335', '465', '181', '', '2016 435/1', '', NULL, NULL),
	(55, '0543405066', '20200/3335', '181', '181', '', '2016 468/1', '', NULL, NULL),
	(56, '0543473571', '27300/3335', '464', '181', '', '2016 434/1', '', NULL, NULL),
	(57, '0543473961', '27300/3335', '464', '181', '', '2016 434/1', '', NULL, NULL),
	(58, '0543476042', '27300/3335', '464', '181', '', '2016 434/1', '', NULL, NULL),
	(59, '0543479192', '37400/3335', '422', '181', '', '2016 437/1', '', NULL, NULL),
	(60, '0543479436', '41700/3335', '418', '181', 'IVA', '2016 441/1', 'CREDITO 0', NULL, NULL),
	(61, '0543479502', '20200/3335', '181', '181', '', '2016 468/1', '', NULL, NULL),
	(62, '0543479683', '20200/3335', '181', '181', '', '2016 468/1', '', NULL, NULL),
	(63, '0543480153', '60060/3335', '434', '181', '', '2016 469/1', '', NULL, NULL),
	(64, '0543480482', '25700/3335', '455', '181', 'IVA', '2016 433/1', '', NULL, NULL),
	(65, '0543481408', '04200/3335', '117', '181', '', '2016 429/1', '', NULL, NULL),
	(66, '0543488247', '27300/3335', '464', '181', '', '2016 434/1', '', NULL, NULL),
	(67, '0543494899', '20200/3335', '181', '181', '', '2016 468/1', '', NULL, NULL),
	(68, '0543551255', '04200/3335', '117', '181', '', '2016 429/1', 'Via Dragoni, 57', NULL, NULL),
	(69, '0543551351', '20200/3335', '181', '181', '', '2016 468/1', '', NULL, NULL),
	(70, '0543551533', '04200/3335', '117', '181', '', '2016 429/1', '', NULL, NULL),
	(71, '0543553623', '55600/3335', '452', '181', 'IVA', '2017 162/1', '', NULL, NULL),
	(72, '0543553633', '55600/3335', '452', '181', 'IVA', '2017 162/1', '', NULL, NULL),
	(73, '0543553643', '25700/3335', '455', '181', 'IVA', '2016 433/1', '', NULL, NULL),
	(74, '0543553650', '25700/3335', '455', '181', 'IVA', '2016 433/1', '', NULL, NULL),
	(75, '0543553656', '25700/3335', '455', '181', 'IVA', '2016 433/1', '', NULL, NULL),
	(76, '0543553663', '55600/3335', '452', '181', 'IVA', '2017 162/1', '', NULL, NULL),
	(77, '0543554176', '55600/3335', '452', '181', 'IVA', '2017 162/1', '', NULL, NULL),
	(78, '0543554339', '27300/3335', '464', '181', '', '2016 434/1', '', NULL, NULL),
	(79, '0543554393', '55600/3335', '452', '181', 'IVA', '2017 162/1', '', NULL, NULL),
	(80, '054360157', '25700/3335', '455', '181', 'iVA', '2016 433/1', '', NULL, NULL),
	(81, '054360815', '04200/3335', '117', '181', '', '2016 429/1', '', NULL, NULL),
	(82, '054361267', '41700/3335', '418', '181', 'IVA', '2016 441/1', 'CREDITO 0', NULL, NULL),
	(83, '054362000', '25700/3335', '455', '181', 'IVA', '2016 433/1', '', NULL, NULL),
	(84, '054362046', '55600/3335', '452', '181', 'IVA', '2017 162/1', '', NULL, NULL),
	(85, '054362269', '55600/3335', '452', '181', 'IVA', '2017 162/1', '', NULL, NULL),
	(86, '054362409', '55600/3335', '452', '181', 'IVA', '2017 162/1', '', NULL, NULL),
	(87, '054362524', '55600/3335', '452', '181', 'IVA', '2017 162/1', '', NULL, NULL),
	(88, '054363004', '25700/3335', '455', '181', 'IVA', '2016 433/1', '', NULL, NULL),
	(89, '054365753', '27300/3335', '464', '181', '', '2016 434/1', '', NULL, NULL),
	(90, '054365988', '04200/3335', '117', '181', '', '2016 429/1', '', NULL, NULL),
	(91, '054366627', '53000/3335', '364', '181', '', '2016 442/1', '', NULL, NULL),
	(92, '054367768', '55600/3335', '452', '181', 'IVA', '2017 162/1', '', NULL, NULL),
	(93, '054368046', '27300/3335', '464', '181', '', '2016 434/1', '', NULL, NULL),
	(94, '0543700640', '04200/3335', '117', '181', '', '2016 429/1', '', NULL, NULL),
	(95, '0543700699', '55600/3335', '452', '181', 'IVA', '2017 162/1', '', NULL, NULL),
	(96, '0543701010', '25700/3335', '455', '181', 'IVA', '2016 433/1', '', NULL, NULL),
	(97, '0543702031', '20200/3335', '181', '181', '', '2016 468/1', '', NULL, NULL),
	(98, '0543702170', '55600/3335', '452', '181', 'IVA', '2017 162/1', '', NULL, NULL),
	(99, '0543702190', '25700/3335', '455', '181', 'IVA', '2016 433/1', '', NULL, NULL),
	(100, '0543702401', '20200/3335', '181', '181', '', '2016 468/1', '', NULL, NULL),
	(101, '0543702473', '41700/3335', '415', '181', 'IVA', '2016 439/1', ' ', NULL, NULL),
	(102, '0543702582', '23300/3335', '131', '181', '', '2016 432/1', '', NULL, NULL),
	(103, '0543703873', '27300/3335', '464', '181', '', '2016 434/1', '', NULL, NULL),
	(104, '0543704031', '27300/3335', '464', '181', '', '2016 434/1', '', NULL, NULL),
	(105, '0543705159', '04200/3335', '117', '181', '', '2016 429/1', '', NULL, NULL),
	(106, '0543705457', '23300/3335', '131', '181', '', '2016 432/1', '', NULL, NULL),
	(107, '0543720541', '55600/3335', '452', '181', 'IVA', '2017 162/1', '', NULL, NULL),
	(108, '0543720613', '20200/3335', '181', '181', '', '2016 468/1', '', NULL, NULL),
	(109, '0543720704', '25700/3335', '455', '181', 'IVA', '2016 433/1', '', NULL, NULL),
	(110, '0543721051', '53000/3335', '364', '181', '', '2016 442/1', '', NULL, NULL),
	(111, '0543721916', '33000/3335', '164', '181', 'IVA', '2017 154/1', '', NULL, NULL),
	(112, '0543722307', '33000/3335', '164', '181', 'IVA', '2017 154/1', '', NULL, NULL),
	(113, '0543722597', '20200/3335', '181', '181', '', '2016 468/1', '', NULL, NULL),
	(114, '0543722792', '33000/3335', '164', '181', 'IVA', '2017 154/1', '', NULL, NULL),
	(115, '0543723469', '20200/3335', '181', '181', '', '2016 468/1', '', NULL, NULL),
	(116, '0543723884', '20200/3335', '181', '181', '', '2016 468/1', '', NULL, NULL),
	(117, '0543724313', '33000/3335', '164', '181', 'IVA', '2017 154/1', '', NULL, NULL),
	(118, '0543724578', '33000/3335', '164', '181', 'IVA', '2017 154/1', '', NULL, NULL),
	(119, '0543725674', '04200/3335', '117', '181', '', '2016 429/1', '', NULL, NULL),
	(120, '0543725764', '55600/3335', '452', '181', 'IVA', '2017 162/1', '', NULL, NULL),
	(121, '0543725772', '25700/3335', '455', '181', 'IVA', '2016 433/1', '', NULL, NULL),
	(122, '0543728164', '04200/3335', '117', '181', '', '2016 429/1', '', NULL, NULL),
	(123, '0543756296', '27300/3335', '464', '181', '', '2016 434/1', '', NULL, NULL),
	(124, '0543764440', '27300/3335', '464', '181', '', '2016 434/1', '', NULL, NULL),
	(125, '0543764455', '27300/3335', '464', '181', '', '2016 434/1', '', NULL, NULL),
	(126, '0543764499', '27300/3335', '464', '181', '', '2016 434/1', '', NULL, NULL),
	(127, '0543780050', '27300/3335', '464', '181', '', '2016 434/1', '', NULL, NULL),
	(128, '0543780051', '27300/3335', '464', '181', '', '2016 434/1', '', NULL, NULL),
	(129, '0543780089', '41700/3335', '418', '181', 'IVA', '2016 441/1', 'CREDITO 0', NULL, NULL),
	(130, '0543780512', '55600/3335', '452', '181', 'IVA', '2017 162/1', '', NULL, NULL),
	(131, '0543783020', '55600/3335', '452', '181', 'IVA', '2017 162/1', '', NULL, NULL),
	(132, '0543783043', '20230/3335', '31', '181', '', '2016 430/1', '', NULL, NULL),
	(133, '0543795029', '27300/3335', '464', '181', '', '2016 434/1', '', NULL, NULL),
	(134, '0543795879', '20250/3335', '366', '181', '', '2016 431/1', '', NULL, NULL),
	(135, '0543798802', '28300/3335', '465', '181', '', '2016 435/1', '', NULL, NULL),
	(136, '0543798893', '55600/3335', '452', '181', 'IVA', '2017 162/1', '', NULL, NULL),
	(137, '0543799923', '55600/3335', '452', '181', 'IVA', '2017 162/1', '', NULL, NULL),
	(138, '0543818364', '27300/3335', '464', '181', '', '2016 434/1', '', NULL, NULL),
	(139, '0543818384', '27300/3335', '464', '181', '', '2016 434/1', '', NULL, NULL),
	(140, '0543818575', '04200/3335', '117', '181', '', '2016 429/1', '', NULL, NULL),
	(141, '054383400', '27300/3335', '464', '181', '', '2016 434/1', '', NULL, NULL),
	(142, '054386016', '28300/3335', '465', '181', '', '2016 435/1', '', NULL, NULL),
	(143, '054386037', '27300/3335', '464', '181', '', '2016 434/1', '', NULL, NULL),
	(144, '054386324', '25700/3335', '455', '181', 'IVA', '2016 433/1', '', NULL, NULL),
	(145, '054386392', '27300/3335', '464', '181', '', '2016 434/1', '', NULL, NULL),
	(146, '054386447', '27300/3335', '464', '181', '', '2016 434/1', '', NULL, NULL),
	(147, '054389537', '27300/3335', '464', '181', '', '2016 434/1', '', NULL, NULL),
	(148, '054389541', '27300/3335', '464', '181', '', '2016 434/1', '', NULL, NULL),
	(149, '054320040', '38400/3335', '412', '181', 'IVA', '2017 156/1', 'Teatro Centralino?', NULL, NULL),
	(150, '054320897', '55750/3335', '436', '181', '', '2016 445/1', '', NULL, NULL),
	(151, '054321203', '38400/3335', '412', '181', 'IVA', '2017 156/1', '', NULL, NULL),
	(152, '054321241', '55750/3335', '436', '181', '', '2016 445/1', 'Centro Donna?', NULL, NULL),
	(153, '054321895', '28300/3335', '465', '181', '', '2016 435/1', '', NULL, NULL),
	(154, '054324013', '04200/3335', '117', '181', '', '2016 429/1', '', NULL, NULL),
	(155, '054325275', '27300/3335', '464', '181', '', '2016 434/1', '', NULL, NULL),
	(156, '054325505', '20200/3335', '181', '181', '', '2016 468/1', '', NULL, NULL),
	(157, '054325976', '55750/3335', '436', '181', '', '2016 445/1', '', NULL, NULL),
	(158, '054331978', '37400/3335', '422', '181', '', '2016 437/1', '', NULL, NULL),
	(159, '054332019', '28300/3335', '465', '181', '', '2016 435/1', '', NULL, NULL),
	(160, '054333100', '27300/3335', '464', '181', '', '2016 434/1', '', NULL, NULL),
	(161, '054333345', '27300/3335', '464', '181', '', '2016 434/1', '', NULL, NULL),
	(162, '054336220', '20200/3335', '181', '181', '', '2016 468/1', 'Centralino Comune', NULL, NULL),
	(163, '054336221', '20200/3335', '181', '181', '', '2016 468/1', '', NULL, NULL),
	(164, '054336222', '20200/3335', '181', '181', '', '2016 468/1', '', NULL, NULL),
	(165, '054336224', '23300/3335', '131', '181', '', '2016 432/1', 'C.so rep?', NULL, NULL),
	(166, '054336225', '23300/3335', '131', '181', '', '2016 432/1', '', NULL, NULL),
	(167, '054336226', '23300/3335', '131', '181', '', '2016 432/1', '', NULL, NULL),
	(168, '054336227', '23300/3335', '131', '181', '', '2016 432/1', '', NULL, NULL),
	(169, '054336272', '65602/3335', '221', '181', 'IVA', '2017 168/1', '', NULL, NULL),
	(170, '054336273', '65602/3335', '221', '181', 'IVA', '2017 168/1', '', NULL, NULL),
	(171, '054336274', '55750/3335', '436', '181', '', '2016 445/1', 'Welfare G. saffi', NULL, NULL),
	(172, '054336662', '20200/3335', '181', '181', '', '2016 468/1', '', NULL, NULL),
	(173, '054336703', '20200/3335', '181', '181', '', '2016 468/1', '', NULL, NULL),
	(174, '0543370850', '20200/3335', '181', '181', '', '2016 468/1', '', NULL, NULL),
	(175, '0543403007', '20200/3335', '181', '181', '', '2016 468/1', '', NULL, NULL),
	(176, '0543403205', '27300/3335', '464', '181', '', '2016 434/1', '', NULL, NULL),
	(177, '0543404110', '23300/3335', '131', '181', '', '2016 432/1', 'Curiel', NULL, NULL),
	(178, '0543404111', '23300/3335', '131', '181', '', '2016 432/1', '', NULL, NULL),
	(179, '054360499', '28300/3335', '465', '181', '', '2016 435/1', '', NULL, NULL),
	(180, '054361268', '27300/3335', '464', '181', '', '2016 434/1', '', NULL, NULL),
	(181, '054362124', '20200/3335', '181', '181', '', '2016 468/1', '', NULL, NULL),
	(182, '054363074', '27300/3335', '464', '181', '', '2016 434/1', '', NULL, NULL),
	(183, '054363439', '28300/3335', '465', '181', '', '2016 435/1', '', NULL, NULL),
	(184, '054363508', '27300/3335', '464', '181', '', '2016 434/1', '', NULL, NULL),
	(185, '054365089', '28300/3335', '465', '181', '', '2016 435/1', '', NULL, NULL),
	(186, '054366658', '28300/3335', '465', '181', '', '2016 435/1', '', NULL, NULL),
	(187, '054367215', '27300/3335', '464', '181', '', '2016 434/1', '', NULL, NULL),
	(188, '0543700661', '27300/3335', '464', '181', '', '2016 434/1', '', NULL, NULL),
	(189, '0543700777', '20200/3335', '181', '181', '', '2016 468/1', '', NULL, NULL),
	(190, '0543703001', '28300/3335', '465', '181', '', '2016 435/1', '', NULL, NULL),
	(191, '0543721072', '27300/3335', '464', '181', '', '2016 434/1', '', NULL, NULL),
	(192, '0543721077', '28300/3335', '465', '181', '', '2016 435/1', '', NULL, NULL),
	(193, '0543724014', '27300/3335', '464', '181', '', '2016 434/1', '', NULL, NULL),
	(194, '0543726006', '27300/3335', '464', '181', '', '2016 434/1', '', NULL, NULL),
	(195, '0543726007', '27300/3335', '464', '181', '', '2016 434/1', '', NULL, NULL),
	(196, '0543764433', '28300/3335', '465', '181', '', '2016 435/1', '', NULL, NULL),
	(197, '0543770601', '65601/3335', '221', '181', 'IVA', '2017 137/1', 'Contrattazioni', NULL, NULL),
	(198, '0543774939', '63700/3335', '126', '181', '', '2016 448/1', 'Cimiteriali', NULL, NULL),
	(199, '0543775359', '20200/3335', '181', '181', '', '2016 468/1', '', NULL, NULL),
	(200, '0543798270', '04200/3335', '117', '181', '', '2016 429/1', '', NULL, NULL),
	(201, '0543816001', '20200/3335', '181', '181', '', '2016 468/1', '', NULL, NULL),
	(202, '054313344270', '20200/3343', '181', '181', ' ', '2016 127/1', 'Centro Stella MPLS', NULL, NULL),
	(203, '054313340601', '20200/3343', '181', '181', ' ', '2016 127/1', 'HDL Wifi', NULL, NULL),
	(204, '054313345069', '20200/3335', '181', '181', '', '2016 468/1', 'Voip', NULL, NULL),
	(205, '054313340642', '20200/3343', '181', '181', ' ', '2016 127/1', 'HDSL FMI', NULL, NULL),
	(206, '054313341670', '41700/3335', '418', '181', 'IVA', '2016 441/1', 'CREDITO 0', NULL, NULL),
	(207, '054313341671', '04200/3335', '117', '181', '', '2016 429/1', '', NULL, NULL),
	(208, '054313341672', '27300/3335', '464', '181', '', '2016 434/1', '', NULL, NULL),
	(209, '054313341676', '23300/3335', '131', '181', '', '2016 432/1', '', NULL, NULL),
	(210, '054313341678', '60090/3335', '449', '181', '', '2016 447/1', '', NULL, NULL),
	(211, '054313341679', '41700/3335', '415', '181', 'IVA', '2016 439/1', ' ', NULL, NULL),
	(212, '054313341680', '27300/3335', '464', '181', '', '2016 434/1', '', NULL, NULL),
	(213, '054313341683', '41700/3335', '417', '181', 'IVA', '2016 440/1', ' ', NULL, NULL),
	(214, '054313341687', '27300/3335', '464', '181', '', '2016 434/1', '', NULL, NULL),
	(215, '054313341688', '04200/3335', '117', '181', '', '2016 429/1', '', NULL, NULL),
	(216, '054313341689', '20200/3343', '181', '181', ' ', '2016 127/1', '', NULL, NULL),
	(217, '054313341691', '04200/3335', '117', '181', '', '2016 429/1', '', NULL, NULL),
	(218, '054313341694', '20200/3343', '181', '181', ' ', '2016 127/1', '', NULL, NULL),
	(219, '054313341695', '28300/3335', '465', '181', '', '2016 435/1', '', NULL, NULL),
	(220, '054313341696', '04200/3335', '117', '181', '', '2016 429/1', '', NULL, NULL),
	(221, '054313341697', '04200/3335', '117', '181', '', '2016 429/1', '', NULL, NULL),
	(222, '054313341700', '27300/3335', '464', '181', '', '2016 434/1', '', NULL, NULL),
	(223, '054313341701', '04200/3335', '117', '181', '', '2016 429/1', '', NULL, NULL),
	(224, '054313341702', '27300/3335', '464', '181', '', '2016 434/1', '', NULL, NULL),
	(225, '054313341703', '04200/3335', '117', '181', '', '2016 429/1', '', NULL, NULL),
	(226, '054313341704', '27300/3335', '464', '181', '', '2016 434/1', '', NULL, NULL),
	(227, '054313341705', '27300/3335', '464', '181', '', '2016 434/1', '', NULL, NULL),
	(228, '054313341706', '27300/3335', '464', '181', '', '2016 434/1', '', NULL, NULL),
	(229, '054313341707', '27300/3335', '464', '181', '', '2016 434/1', '', NULL, NULL),
	(230, '054313341708', '28300/3335', '465', '181', '', '2016 435/1', '', NULL, NULL),
	(231, '054313341709', '27300/3335', '464', '181', '', '2016 434/1', '', NULL, NULL),
	(232, '054313341710', '27300/3335', '464', '181', '', '2016 434/1', '', NULL, NULL),
	(233, '054313341711', '27300/3335', '464', '181', '', '2016 434/1', '', NULL, NULL),
	(234, '054313341712', '27300/3335', '464', '181', '', '2016 434/1', '', NULL, NULL),
	(235, '054313341719', '55600/3335', '452', '181', 'IVA', '2017 162/1', '', NULL, NULL),
	(236, '054313341720', '55600/3335', '452', '181', 'IVA', '2017 162/1', '', NULL, NULL),
	(237, '054313341721', '55600/3335', '452', '181', 'IVA', '2017 162/1', '', NULL, NULL),
	(238, '054313341729', '04200/3335', '117', '181', '', '2016 429/1', '', NULL, NULL),
	(239, '054313341730', '25700/3335', '455', '181', 'IVA', '2016 433/1', '', NULL, NULL),
	(240, '054313341731', '25700/3335', '455', '181', 'IVA', '2016 433/1', '', NULL, NULL),
	(241, '054313341732', '25700/3335', '455', '181', 'IVA', '2016 433/1', '', NULL, NULL),
	(242, '054313341733', '25700/3335', '455', '181', 'IVA', '2016 433/1', '', NULL, NULL),
	(243, '054313341734', '55750/3335', '436', '181', '', '2016 445/1', '', NULL, NULL),
	(244, '054313341735', '04200/3335', '117', '181', '', '2016 429/1', '', NULL, NULL),
	(245, '054313341736', '55600/3335', '452', '181', 'IVA', '2017 162/1', '', NULL, NULL),
	(246, '054313341737', '55600/3335', '452', '181', 'IVA', '2017 162/1', '', NULL, NULL),
	(247, '054313341738', '25700/3335', '455', '181', 'IVA', '2016 433/1', '', NULL, NULL),
	(248, '054313341739', '25700/3335', '455', '181', 'IVA', '2016 433/1', '', NULL, NULL),
	(249, '054313341746', '55600/3335', '452', '181', 'IVA', '2017 162/1', '', NULL, NULL),
	(250, '054313341747', '27300/3335', '464', '181', '', '2016 434/1', '', NULL, NULL),
	(251, '054313341748', '25700/3335', '455', '181', 'IVA', '2016 433/1', '', NULL, NULL),
	(252, '054313341774', '25700/3335', '455', '181', 'IVA', '2016 433/1', '', NULL, NULL),
	(253, '054313341783', '25700/3335', '455', '181', 'IVA', '2016 433/1', '', NULL, NULL),
	(254, '054313341824', '27300/3335', '464', '181', '', '2016 434/1', '', NULL, NULL),
	(255, '054313342021', '60060/3335', '431', '181', '', '2016 446/1', '', NULL, NULL),
	(256, '054313342049', '65600/3335', '222', '181', 'IVA', '2016 449/1', '', NULL, NULL),
	(257, '054313342050', '20200/3343', '181', '181', '', '2016 127/1', '', NULL, NULL),
	(258, '054313342052', '55750/3335', '436', '181', '', '2016 445/1', '', NULL, NULL),
	(259, '054313342053', '20200/3343', '181', '181', ' ', '2016 127/1', '', NULL, NULL),
	(260, '054313342059', '37400/3335', '422', '181', '', '2016 437/1', '', NULL, NULL),
	(261, '054313342163', '27300/3335', '464', '181', '', '2016 434/1', '', NULL, NULL),
	(262, '054313342858', '20200/3343', '181', '181', ' ', '2016 127/1', '', NULL, NULL),
	(263, '054313343408', '23300/3335', '131', '181', '', '2016 432/1', '', NULL, NULL),
	(264, '054313344286', '27300/3335', '464', '181', '', '2016 434/1', '', NULL, NULL),
	(265, '054313344287', '27300/3335', '464', '181', '', '2016 434/1', '', NULL, NULL),
	(266, '054313344288', '28300/3335', '465', '181', '', '2016 435/1', '', NULL, NULL),
	(267, '054313344289', '28300/3335', '465', '181', '', '2016 435/1', '', NULL, NULL),
	(268, '054313344290', '27300/3335', '464', '181', '', '2016 434/1', '', NULL, NULL),
	(269, '054313344291', '28300/3335', '465', '181', '', '2016 435/1', '', NULL, NULL),
	(270, '054313344292', '27300/3335', '464', '181', '', '2016 434/1', '', NULL, NULL),
	(271, '054313344293', '28300/3335', '465', '181', '', '2016 435/1', '', NULL, NULL),
	(272, '054313344294', '28300/3335', '465', '181', '', '2016 435/1', '', NULL, NULL),
	(273, '054313344295', '27300/3335', '464', '181', '', '2016 434/1', '', NULL, NULL),
	(274, '054313344296', '28300/3335', '465', '181', '', '2016 435/1', '', NULL, NULL),
	(275, '054313344297', '27300/3335', '464', '181', '', '2016 434/1', '', NULL, NULL),
	(276, '054313503864', '04200/3335', '117', '181', '', '2016 429/1', '', NULL, NULL),
	(277, '054313503865', '04200/3335', '117', '181', '', '2016 429/1', '', NULL, NULL),
	(278, '054313503902', '', '', '', '', '', 'NON C\'E\'', NULL, NULL),
	(279, '054613513382', '20200/3343', '181', '181', ' ', '2016 127/1', '', NULL, NULL);
/*!40000 ALTER TABLE `fisso_dati_linee` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;