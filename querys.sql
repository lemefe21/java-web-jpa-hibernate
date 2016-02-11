-- drop database financas;
-- create database financas;

use financas;

show tables;

desc conta;
desc movimentacao;

select * from conta;
select * from movimentacao;

select * from movimentacao where conta_id = 1 and tipoMovimentacao = 'SAIDA';

