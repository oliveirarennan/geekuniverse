/*ARQUIVO DE CARGA NO BANCO DE DADOS - PROJETO GEEKUNIVERSE - TURMA 2016.1
Erro Na query de endere�o...
**/

insert into estados value
(null,"AC", "ACRE"),
(null,"AL", "ALAGOAS"),
(null,"AP", "AMAP�"),
(null,"AM", "AMAZONAS"),
(null,"BA", "BAHIA"),
(null,"CE", "CEAR�"),
(null,"DF", "DISTRITO FEDERAL"),
(null,"ES", "ESPIRITO SANTO"),
(null,"GO", "GOI�S"),
(null,"MA", "MARANH�O"),
(null,"MT", "MATO GROSSO"),
(null,"MS", "MATO GROSSO DO SUL"),
(null,"MG", "MINAS GERAIS"),
(null,"PA", "PAR�"),
(null,"PB", "PARA�BA"),
(null,"PR", "PARAN�"),
(null,"PE", "PERNAMBUCO"),
(null,"PI", "PIAU�"),
(null,"RJ", "RIO DE JANEIRO"),
(null,"RN", "RIO GRANDE DO NORTE"),
(null,"RS", "RIO GRANDE DO SUL"),
(null,"RO", "ROND�NIA"),
(null,"RR", "RORAIMA"),
(null,"SC", "SANTA CATARINA"),
(null,"SP", "S�O PAULO"),
(null,"SE", "SERGIPE"),
(null,"TO", "TOCANTINS");

insert into endereco value
(null,"Brasil",19,"Niter�i","Almirante Teff�","Atr�s do Plaza",680,"Centro","24030-085"),
(null,"Brasil",19,"Maric�","Itaipua�u","Rua 16",57,"Apt 201","249355-95");

insert into usuario value
(null,1,"Administrador","Administrador","1999-03-09","Masculino","(21)9934-99919","(21)2222-2222","123.456.789-00","00.123.456-7","admin@admin.com","25f9e794323b453885f5181f1b624d0b", "administrador,",true),
(null,2,"Cliente","Cliente","2017-25-21","Feminino","(21)9934-99666","(21)3322-2222","123.456.789-12","00.123.458-9","cliente@cliente.com","25f9e794323b453885f5181f1b624d0b", "cliente",true);

insert into fabricante value
(null,"Marvel", "16.574.333/0001-64", true),
(null,"Saraiva","33.999.666/0001-95", true),
(null,"Fantoy","55.789.652/0001-52", true);

insert into categoria value
(null, "Quadrinho", true),
(null, "Livro", true),
(null, "Action Figure", true);

insert into produto value
(null,1,1,"Cavaleiro Negro"," Her�is mais Poderosos da Marvel","19.90",10,""),
(null,1,1,"Homem Aranha","Entre os Mortos","25.00",9,""),
(null,1,1,"Vingadores","Infinito","59.90",8,""),
(null,1,1,"Guardi�es da Gal�xia","Angela","56.52",7,""),
(null,1,1,"Magnum","Her�is mais Poderosos da Marvel","21.50",6,""),
(null,1,1,"Hulk","Terra Arrasada","49.00",5,""),
(null,1,1,"Thor","Her�is mais Poderosos da Marvel","49.90",4,""),
(null,1,1,"Vingadores Iluminati","Novos Vingadores","63.50",3,""),
(null,1,1,"Logan","Do outro lado da Lei","37.50",2,""),
(null,1,1,"Fera","Her�is mais Poderosos da Marvel","32.50",1,""),
(null,2,2,"Harry Potter","O Princ�pe Mesti�o","39.90",1,""),
(null,2,2,"O senhor Dos Aneis","Segunda Torre","25.50",2,""),
(null,2,2,"Percy Jackson","Os Olimpianos","35.69",3,""),
(null,2,2,"American Gods","Best-Seller","45.68",4,""),
(null,2,2,"Shadow Hunters","Instrumentos Mortais","96.65",5,""),
(null,2,2,"The Originals","Ascens�o","85.52",6,""),
(null,2,2,"The Vampire Diaries","Sede de Sangue","25.45",7,""),
(null,2,2,"Supernatural","Cora��o de Drag�o","32.35",8,""),
(null,2,2,"A Cabana","Petalas do Cora��o","12.69",9,""),
(null,2,2,"Star Wars","O despertar das For�as","58.60",10,""),
(null,3,3,"Juggernaut","1/10","300.00",121,""),
(null,3,3,"Mickey","Disney","150.00",2311,""),
(null,3,3,"Magneto","X-men","200.00",1312,""),
(null,3,3,"Lobo","Unknow","250.00",95,""),
(null,3,3,"Groot","Guardi�es da Gal�xia","260.00",61,""),
(null,3,3,"Gamora","Guardi�es da Gal�xia","270.00",15,""),
(null,3,3,"Hulk Cinza","Os Vingadores","490.00",14,""),
(null,3,3,"ThorAF","Os Vingadores","132.30",14,""),
(null,3,3,"Rhino","Homem Aranha","23.65",13,""),
(null,3,3,"Rocket","Guardi�es da Gal�xia","256.20",12,"");
