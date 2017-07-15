INSERT INTO estados(sigla, descricao) VALUES('AC', 'Acre');
INSERT INTO estados(sigla, descricao) VALUES('AL', 'Alagoas');
INSERT INTO estados(sigla, descricao) VALUES('AP', 'Amapá');
INSERT INTO estados(sigla, descricao) VALUES('AM', 'Amazonas');
INSERT INTO estados(sigla, descricao) VALUES('BA', 'Bahia');
INSERT INTO estados(sigla, descricao) VALUES('CE', 'Ceará');
INSERT INTO estados(sigla, descricao) VALUES('DF', 'Distrito Federal');
INSERT INTO estados(sigla, descricao) VALUES('ES', 'Espírito Santo');
INSERT INTO estados(sigla, descricao) VALUES('GO', 'Goiás');
INSERT INTO estados(sigla, descricao) VALUES('MA', 'Maranhão');
INSERT INTO estados(sigla, descricao) VALUES('MT', 'Mato Grosso');
INSERT INTO estados(sigla, descricao) VALUES('MS', 'Mato Grosso do Sul');
INSERT INTO estados(sigla, descricao) VALUES('MG', 'Minas Gerais');
INSERT INTO estados(sigla, descricao) VALUES('PA', 'Pará');
INSERT INTO estados(sigla, descricao) VALUES('PB', 'Paraíba');
INSERT INTO estados(sigla, descricao) VALUES('PR', 'Paraná');
INSERT INTO estados(sigla, descricao) VALUES('PE', 'Pernambuco');
INSERT INTO estados(sigla, descricao) VALUES('PI', 'Piauí');
INSERT INTO estados(sigla, descricao) VALUES('RJ', 'Rio de Janeiro');
INSERT INTO estados(sigla, descricao) VALUES('RN', 'Rio Grande do Norte');
INSERT INTO estados(sigla, descricao) VALUES('RS', 'Rio Grande do Sul');
INSERT INTO estados(sigla, descricao) VALUES('RO', 'Rondônia');
INSERT INTO estados(sigla, descricao) VALUES('RR', 'Roraima');
INSERT INTO estados(sigla, descricao) VALUES('SC', 'Santa Catarina');
INSERT INTO estados(sigla, descricao) VALUES('SP', 'São Paulo');
INSERT INTO estados(sigla, descricao) VALUES('SE', 'Sergipe');
INSERT INTO estados(sigla, descricao) VALUES('TO', 'Tocantins');


insert into endereco value
(null,"Brasil",1,"Maricá", "Itaipuaçu", "Rua 16", 57,"apt 201", "24.935.595");

insert into usuario value
(null, 1,"Pedro Victor","Abreu de Andrade","2017-06-21","Masculino","(21)9934-99919","(21) 2222-2222","123.456.789-00", "00.123.456-7","admin@gmail.com","25f9e794323b453885f5181f1b624d0b","administrador",true);

insert into fabricante value
(null, "Sony", "16.574.333/0001-64", true);

insert into categoria value
(null, "Quadrinho", true),
(null, "Livro", true),
(null, "Action Figure", true);

insert into formaPagamento value
(null, "cartão", 10, "1200,00","teste.teste.com");

insert into frete value
(null,"10 dias", "17.20");

insert into produto value
(null, 1, 1, "Playstation 4", "VideoGames da Marca Sony","1.200", 10,"imagem.jpg");

insert into pedido value
(null, 1, 1, 1, 123, "Em Análise","2017-06-21","1500");

insert into item value
(null, 1, 1, 2,"2400.00");

select i.pedido_id, p.numeroPedido,pr.nome, u.nome  
from pedido p, item i, produto pr, usuario u
where i.pedido_id=p.id and i.produto_id=pr.id and u.id=p.usuario_id;
