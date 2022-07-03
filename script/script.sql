--criando e selecionando o banco de dados
CREATE DATABASE IF NOT EXISTS `dbfuncionario`;
USE `dbfuncionario`;

--criando a tabela funcionario
CREATE TABLE IF NOT EXISTS `funcionario` (
  `id_funcionario` int NOT NULL,
  `nome` varchar(255) NOT NULL,
  `sobrenome` varchar(255) NOT NULL,
  `cargo` varchar(255) NOT NULL,
  `salario` DOUBLE(9,2) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- ALTER TABLE `funcionario`ADD COLUMN `id_funcionario` INT NOT NULL AFTER `id`;

-- ALTER TABLE `funcionario` MODIFY COLUMN `salario` DOUBLE(9,2) NOT NULL;

-- ALTER TABLE `funcionario` DROP COLUMN `id`;