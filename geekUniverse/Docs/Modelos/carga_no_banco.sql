insert into estados value
(null,"am","Amazonas");

insert into endereco value
(null,"Brasil",1,"Maricá", "Itaipuaçu", "Rua 16", 57,"apt 201", "24.935.595");

insert into usuario value
(null, 1,"Pedro Victor","Abreu de Andrade","2017-06-21","Masculino","(21)9934-99919","(21) 2222-2222","123.456.789-00", "00.123.456-7","teste@teste.com","admin123","administrador",true);

insert into fabricante value
(null, "Sony", "16.574.333/0001-64", true);

insert into categoria value
(null, "VideoGames", true);

insert into formaPagamento value
(null, "cartão", 10, "1200,00");

insert into frete value
(null,"10 dias", "17.20");

insert into produto value
(null, 1, 1, "Playstation 4", "VideoGames da Marca Sony","1.200", 10,"imagem.jpg");

insert into pedido value
(null, 1, 1, 1, 123, "Em Análise","2017-06-21");

insert into item value
(null, 1, 1, 2,"2400.00");

select i.pedido_id, p.numeroPedido,pr.nome, u.nome  
from pedido p, item i, produto pr, usuario u
where i.pedido_id=p.id and i.produto_id=pr.id and u.id=p.usuario_id;
