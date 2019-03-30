-- phpMyAdmin SQL Dump
-- version 4.4.12
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 30-Mar-2019 às 22:15
-- Versão do servidor: 5.6.25
-- PHP Version: 5.6.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `sistprodv1`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `animal`
--

CREATE TABLE IF NOT EXISTS `animal` (
  `id` int(11) NOT NULL,
  `nascimento` datetime DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `raca` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `tipo` int(11) DEFAULT NULL,
  `criatorio_id` int(11) DEFAULT NULL
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `animal`
--

INSERT INTO `animal` (`id`, `nascimento`, `nome`, `raca`, `status`, `tipo`, `criatorio_id`) VALUES
(1, '2019-02-12 00:27:00', 'Galinha caipira', 'Caipira', 2, 3, 2),
(2, '2019-02-12 00:28:00', 'Galinha Boa', 'Caipira', 2, 3, 2);

-- --------------------------------------------------------

--
-- Estrutura da tabela `canteiro`
--

CREATE TABLE IF NOT EXISTS `canteiro` (
  `id` int(11) NOT NULL,
  `comprimento` double DEFAULT NULL,
  `largaura` double DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `setor_id` int(11) DEFAULT NULL
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `canteiro`
--

INSERT INTO `canteiro` (`id`, `comprimento`, `largaura`, `nome`, `setor_id`) VALUES
(1, 100, 20, 'Canteiro do Repolho', 1),
(2, 100, 20, 'Canteiro do Alface', 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `criatorio`
--

CREATE TABLE IF NOT EXISTS `criatorio` (
  `id` int(11) NOT NULL,
  `comprimento` double DEFAULT NULL,
  `largura` double DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `profundidade` double DEFAULT NULL,
  `setor_id` int(11) DEFAULT NULL
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `criatorio`
--

INSERT INTO `criatorio` (`id`, `comprimento`, `largura`, `nome`, `profundidade`, `setor_id`) VALUES
(1, 100, 20, 'Tanque de Peixes', 10, 2),
(2, 100, 20, 'Poleiro das galinhas', 0, 2);

-- --------------------------------------------------------

--
-- Estrutura da tabela `cultura`
--

CREATE TABLE IF NOT EXISTS `cultura` (
  `id` int(11) NOT NULL,
  `nome` varchar(255) DEFAULT NULL
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `cultura`
--

INSERT INTO `cultura` (`id`, `nome`) VALUES
(1, 'Cebola'),
(2, 'Coentro'),
(3, 'Milho');

-- --------------------------------------------------------

--
-- Estrutura da tabela `cultura_grupo`
--

CREATE TABLE IF NOT EXISTS `cultura_grupo` (
  `cultura_id` int(11) NOT NULL,
  `grupo_id` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `cultura_grupo`
--

INSERT INTO `cultura_grupo` (`cultura_id`, `grupo_id`) VALUES
(1, 1),
(2, 2);

-- --------------------------------------------------------

--
-- Estrutura da tabela `defensivo`
--

CREATE TABLE IF NOT EXISTS `defensivo` (
  `id` int(11) NOT NULL,
  `data` datetime DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `qtd` int(11) DEFAULT NULL,
  `plantio_id` int(11) DEFAULT NULL
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `defensivo`
--

INSERT INTO `defensivo` (`id`, `data`, `nome`, `qtd`, `plantio_id`) VALUES
(1, '2019-02-13 16:00:00', 'Defensivo biológico', 2, 1),
(2, '2019-02-13 16:00:00', 'Defensivo biológico', 2, 2),
(3, '2019-02-13 16:00:00', 'Defensivo biológico', 2, 3);

-- --------------------------------------------------------

--
-- Estrutura da tabela `fertilizante`
--

CREATE TABLE IF NOT EXISTS `fertilizante` (
  `id` int(11) NOT NULL,
  `data` datetime DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `qtd` int(11) DEFAULT NULL,
  `plantio_id` int(11) DEFAULT NULL
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `fertilizante`
--

INSERT INTO `fertilizante` (`id`, `data`, `nome`, `qtd`, `plantio_id`) VALUES
(1, '2019-02-07 15:58:00', 'Adubo orgânico', 2, 2),
(2, '2019-02-13 15:58:00', 'Adubo orgânico', 2, 2),
(3, '2019-02-13 16:00:00', 'Adubo orgânico', 2, 3),
(4, '2019-02-13 16:00:00', 'Adubo químico', 2, 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `grupo`
--

CREATE TABLE IF NOT EXISTS `grupo` (
  `id` int(11) NOT NULL,
  `nome` varchar(255) DEFAULT NULL
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `grupo`
--

INSERT INTO `grupo` (`id`, `nome`) VALUES
(1, 'Hortalícias'),
(2, 'Grãos');

-- --------------------------------------------------------

--
-- Estrutura da tabela `irrigacao`
--

CREATE TABLE IF NOT EXISTS `irrigacao` (
  `id` int(11) NOT NULL,
  `data` datetime DEFAULT NULL,
  `plantio_id` int(11) DEFAULT NULL
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `irrigacao`
--

INSERT INTO `irrigacao` (`id`, `data`, `plantio_id`) VALUES
(1, '2019-02-13 16:00:00', 1),
(2, '2019-02-13 16:00:00', 1),
(3, '2019-02-13 16:00:00', 2),
(4, '2019-02-13 16:00:00', 3);

-- --------------------------------------------------------

--
-- Estrutura da tabela `plantio`
--

CREATE TABLE IF NOT EXISTS `plantio` (
  `id` int(11) NOT NULL,
  `data` datetime DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `qtd` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `canteiro_id` int(11) DEFAULT NULL,
  `cultura_id` int(11) DEFAULT NULL
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `plantio`
--

INSERT INTO `plantio` (`id`, `data`, `nome`, `qtd`, `status`, `canteiro_id`, `cultura_id`) VALUES
(1, '2019-02-13 10:44:00', 'Cebolas', 50, 2, 1, 1),
(2, '2019-02-13 10:48:00', 'Coentro', 20, 2, 2, 2),
(3, '2019-02-13 10:48:00', 'Milho', 20, 2, 2, 3);

-- --------------------------------------------------------

--
-- Estrutura da tabela `setor`
--

CREATE TABLE IF NOT EXISTS `setor` (
  `id` int(11) NOT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `regiao` varchar(255) DEFAULT NULL,
  `sistema_id` int(11) DEFAULT NULL
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `setor`
--

INSERT INTO `setor` (`id`, `nome`, `regiao`, `sistema_id`) VALUES
(1, 'Hortalícias', 'Sul', 1),
(2, 'Galinhas', 'Norte', 2);

-- --------------------------------------------------------

--
-- Estrutura da tabela `sistema_producao`
--

CREATE TABLE IF NOT EXISTS `sistema_producao` (
  `id` int(11) NOT NULL,
  `comprimento` double DEFAULT NULL,
  `largura` double DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `usuario_id` int(11) DEFAULT NULL
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `sistema_producao`
--

INSERT INTO `sistema_producao` (`id`, `comprimento`, `largura`, `nome`, `usuario_id`) VALUES
(1, 100, 80, 'Sisteminha', 1),
(2, 50, 50, 'Sisteminha do IF', 1),
(3, 100, 80, 'Sisteminha três', 1),
(4, 50, 50, 'Sisteminha Quatro', 2),
(5, 100, 80, 'Sisteminha Cinco', 2),
(6, 50, 50, 'Sisteminha Seis', 2);

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuario`
--

CREATE TABLE IF NOT EXISTS `usuario` (
  `id` int(11) NOT NULL,
  `cpf` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `senha` varchar(255) DEFAULT NULL
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `usuario`
--

INSERT INTO `usuario` (`id`, `cpf`, `email`, `nome`, `senha`) VALUES
(1, '123.432.123-56', 'marcio@gmail.com', 'Marcio', '123'),
(2, '123.432.123-56', 'levi@gmail.com', 'Levi', '123');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `animal`
--
ALTER TABLE `animal`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKjbl55y34xnal4y8kkl8xf0e8w` (`criatorio_id`);

--
-- Indexes for table `canteiro`
--
ALTER TABLE `canteiro`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK3nwybgwl57nmqs1s1ky0camh` (`setor_id`);

--
-- Indexes for table `criatorio`
--
ALTER TABLE `criatorio`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKr7xoblvpbdvncvkoj13lb7kh5` (`setor_id`);

--
-- Indexes for table `cultura`
--
ALTER TABLE `cultura`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `cultura_grupo`
--
ALTER TABLE `cultura_grupo`
  ADD KEY `FK4n7i2ic4rdyr1wt8onl0jhiv` (`grupo_id`),
  ADD KEY `FK73w4wm6bxhlg7amm0e6k0cg46` (`cultura_id`);

--
-- Indexes for table `defensivo`
--
ALTER TABLE `defensivo`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK9mlnsvi08189bj7jnayh2xpu9` (`plantio_id`);

--
-- Indexes for table `fertilizante`
--
ALTER TABLE `fertilizante`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKl26t54rr0e5xgytxeegr4p1m2` (`plantio_id`);

--
-- Indexes for table `grupo`
--
ALTER TABLE `grupo`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `irrigacao`
--
ALTER TABLE `irrigacao`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK67uitqi7frkbuilf3v3lx0j2d` (`plantio_id`);

--
-- Indexes for table `plantio`
--
ALTER TABLE `plantio`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKoy1x4ydvb2v7r84y3decmawen` (`canteiro_id`),
  ADD KEY `FKdeqn1v6qdpd1urahfj9aw4m21` (`cultura_id`);

--
-- Indexes for table `setor`
--
ALTER TABLE `setor`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKc75srp8nhfv37ksqvvpi8jlyt` (`sistema_id`);

--
-- Indexes for table `sistema_producao`
--
ALTER TABLE `sistema_producao`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKonrhb3laltpn4hbhhy81e9sya` (`usuario_id`);

--
-- Indexes for table `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `animal`
--
ALTER TABLE `animal`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `canteiro`
--
ALTER TABLE `canteiro`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `criatorio`
--
ALTER TABLE `criatorio`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `cultura`
--
ALTER TABLE `cultura`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `defensivo`
--
ALTER TABLE `defensivo`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `fertilizante`
--
ALTER TABLE `fertilizante`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `grupo`
--
ALTER TABLE `grupo`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `irrigacao`
--
ALTER TABLE `irrigacao`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `plantio`
--
ALTER TABLE `plantio`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `setor`
--
ALTER TABLE `setor`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `sistema_producao`
--
ALTER TABLE `sistema_producao`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
