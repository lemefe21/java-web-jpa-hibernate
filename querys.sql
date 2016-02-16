-- drop database financas;
-- create database financas;

use financas;

show tables;

desc conta;
desc movimentacao;

select * from conta;
select * from movimentacao;

select * from movimentacao where conta_id = 1 and tipoMovimentacao = 'SAIDA';

select * from movimentacao where conta_id = 1;

select c.titular from conta c left join movimentacao m 
on c.id = m.conta_id and m.id = 1;

select c.titular from conta c right join movimentacao m 
on c.id = m.conta_id and m.id = 1;

select c.titular from conta c inner join movimentacao m 
on c.id = m.conta_id and m.id = 1; -- retorna somente o titular do movimento id 1

select sum(m.valor) from movimentacao m where m.conta_id = 1 and m.tipoMovimentacao = 'ENTRADA';

select avg(m.valor) from movimentacao m where m.conta_id = 1 and m.tipoMovimentacao = 'ENTRADA';



