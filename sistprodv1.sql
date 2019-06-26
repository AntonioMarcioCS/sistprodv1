SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;



CREATE TABLE IF NOT EXISTS `animal` (
  `id` int(11) NOT NULL,
  `nascimento` datetime DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `raca` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `tipo` int(11) DEFAULT NULL,
  `criatorio_id` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;



CREATE TABLE IF NOT EXISTS `canteiro` (
  `id` int(11) NOT NULL,
  `comprimento` double DEFAULT NULL,
  `largura` double DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `sistema_id` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;



CREATE TABLE IF NOT EXISTS `criatorio` (
  `id` int(11) NOT NULL,
  `comprimento` double DEFAULT NULL,
  `data` datetime DEFAULT NULL,
  `largura` double DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `profundidade` double DEFAULT NULL,
  `tipo` int(11) DEFAULT NULL,
  `sistema_id` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;



CREATE TABLE IF NOT EXISTS `cultura` (
  `id` int(11) NOT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `tempo` int(11) DEFAULT NULL
) ENGINE=MyISAM AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;



INSERT INTO `cultura` (`id`, `nome`, `tempo`) VALUES
(1, 'Abobrinha', 60),
(2, 'Alface', 60),
(3, 'Berinjela', 90),
(4, 'Beterraba', 90),
(5, 'Cebola', 120),
(6, 'Cebolinha', 60),
(7, 'Cenoura', 90),
(8, 'Couve', 60),
(9, 'Espinafre', 60),
(10, 'Pepino', 60),
(11, 'Pimentão', 90),
(12, 'Quiabo', 60),
(13, 'Rabanete', 30),
(14, 'Repolho', 120),
(15, 'Tomate', 120),
(16, 'Coentro', 60),
(17, 'Milho', 90),
(18, 'Feijão', 90),
(19, 'Salsa', 60);



CREATE TABLE IF NOT EXISTS `cultura_grupo` (
  `cultura_id` int(11) NOT NULL,
  `grupo_id` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;



INSERT INTO `cultura_grupo` (`cultura_id`, `grupo_id`) VALUES
(1, 1),
(2, 2),
(3, 2);



CREATE TABLE IF NOT EXISTS `defensivo` (
  `id` int(11) NOT NULL,
  `data` datetime DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `qtd` int(11) DEFAULT NULL,
  `plantio_id` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;



CREATE TABLE IF NOT EXISTS `fertilizante` (
  `id` int(11) NOT NULL,
  `data` datetime DEFAULT NULL,
  `descricao` varchar(255) DEFAULT NULL,
  `qtd` int(11) DEFAULT NULL,
  `plantio_id` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;



CREATE TABLE IF NOT EXISTS `grupo` (
  `id` int(11) NOT NULL,
  `nome` varchar(255) DEFAULT NULL
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;



INSERT INTO `grupo` (`id`, `nome`) VALUES
(1, 'Hortalícias'),
(2, 'Grãos');



CREATE TABLE IF NOT EXISTS `irrigacao` (
  `id` int(11) NOT NULL,
  `data` datetime DEFAULT NULL,
  `tempo` double NOT NULL,
  `plantio_id` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;



CREATE TABLE IF NOT EXISTS `perfis` (
  `usuario_id` int(11) NOT NULL,
  `perfis` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;



INSERT INTO `perfis` (`usuario_id`, `perfis`) VALUES
(1, 1),
(1, 2),
(2, 2),
(3, 2);



CREATE TABLE IF NOT EXISTS `plantio` (
  `id` int(11) NOT NULL,
  `colheita` datetime DEFAULT NULL,
  `data` datetime DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `qtd` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `canteiro_id` int(11) DEFAULT NULL,
  `cultura_id` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;


CREATE TABLE IF NOT EXISTS `sistema_producao` (
  `id` int(11) NOT NULL,
  `comprimento` double DEFAULT NULL,
  `data` datetime DEFAULT NULL,
  `largura` double DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `usuario_id` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuario`
--

CREATE TABLE IF NOT EXISTS `usuario` (
  `id` int(11) NOT NULL,
  `cpf` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `senha` varchar(255) DEFAULT NULL,
  `tipo` int(11) DEFAULT NULL
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `usuario`
--

INSERT INTO `usuario` (`id`, `cpf`, `email`, `nome`, `senha`, `tipo`) VALUES
(1, '123.432.123-56', 'marcio@gmail.com', 'Marcio', '$2a$10$.iu9wiXNjNNl8M5x5w6vquqTv3wXNo8rmIWjWx0qMPSTs4gLfZnWa', 1),
(2, '123.432.123-56', 'levi@gmail.com', 'Levi', '$2a$10$wZG0TWzj7ujKw1e.nESkYOaSaEPakUoTNMj/vDfLXPhYYeQSdmhZ.', 2),
(3, '123.432.123-56', 'luna@gmail.com', 'Luna', '$2a$10$8soNzNP.ItR6YPXOZA/9r.PbRhWpPTDvD5p10XaOUMk0u4RmxU2ni', 1);

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
  ADD KEY `FK7iwkj3u60095f1irvnm03fxlt` (`sistema_id`);

--
-- Indexes for table `criatorio`
--
ALTER TABLE `criatorio`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKej57grjscqdncg3p4n456tk76` (`sistema_id`);

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
-- Indexes for table `perfis`
--
ALTER TABLE `perfis`
  ADD KEY `FKiso72ajmkk36lw7dqjva1h8hl` (`usuario_id`);

--
-- Indexes for table `plantio`
--
ALTER TABLE `plantio`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKoy1x4ydvb2v7r84y3decmawen` (`canteiro_id`),
  ADD KEY `FKdeqn1v6qdpd1urahfj9aw4m21` (`cultura_id`);

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
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_5171l57faosmj8myawaucatdw` (`email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `animal`
--
ALTER TABLE `animal`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `canteiro`
--
ALTER TABLE `canteiro`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `criatorio`
--
ALTER TABLE `criatorio`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `cultura`
--
ALTER TABLE `cultura`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=20;
--
-- AUTO_INCREMENT for table `defensivo`
--
ALTER TABLE `defensivo`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `fertilizante`
--
ALTER TABLE `fertilizante`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `grupo`
--
ALTER TABLE `grupo`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `irrigacao`
--
ALTER TABLE `irrigacao`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `plantio`
--
ALTER TABLE `plantio`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `sistema_producao`
--
ALTER TABLE `sistema_producao`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
