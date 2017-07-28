/*ARQUIVO DE CARGA NO BANCO DE DADOS - PROJETO GEEKUNIVERSE - TURMA 2016.1
Erro Na query de endereço...
**/

insert into estados value
(null,"AC", "ACRE"),
(null,"AL", "ALAGOAS"),
(null,"AP", "AMAPÁ"),
(null,"AM", "AMAZONAS"),
(null,"BA", "BAHIA"),
(null,"CE", "CEARÁ"),
(null,"DF", "DISTRITO FEDERAL"),
(null,"ES", "ESPIRITO SANTO"),
(null,"GO", "GOIÁS"),
(null,"MA", "MARANHÃO"),
(null,"MT", "MATO GROSSO"),
(null,"MS", "MATO GROSSO DO SUL"),
(null,"MG", "MINAS GERAIS"),
(null,"PA", "PARÁ"),
(null,"PB", "PARAÍBA"),
(null,"PR", "PARANÁ"),
(null,"PE", "PERNAMBUCO"),
(null,"PI", "PIAUÍ"),
(null,"RJ", "RIO DE JANEIRO"),
(null,"RN", "RIO GRANDE DO NORTE"),
(null,"RS", "RIO GRANDE DO SUL"),
(null,"RO", "RONDÔNIA"),
(null,"RR", "RORAIMA"),
(null,"SC", "SANTA CATARINA"),
(null,"SP", "SÃO PAULO"),
(null,"SE", "SERGIPE"),
(null,"TO", "TOCANTINS");

insert into endereco value
(null,"Brasil",19,"Niterói","Almirante Teffé","Atrás do Plaza",680,"Centro","24030-085"),
(null,"Brasil",19,"Maricá","Itaipuaçu","Rua 16",57,"Apt 201","249355-95");

insert into usuario value
(null,1,"Administrador","Administrador","1999-03-09","Masculino","(21)9934-99919","(21)2222-2222","123.456.789-00","00.123.456-7","admin@admin.com","25f9e794323b453885f5181f1b624d0b", "administrador",true),
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
(null,1,1,"Cavaleiro Negro"," Heróis mais Poderosos da Marvel","19.90",10,"CavaleiroNegro.jpg"),
(null,1,1,"Homem Aranha","Entre os Mortos","25.00",9,"HomemAranha.jpg"),
(null,1,1,"Vingadores","Infinito","59.90",8,"Vingadores.jpg"),
(null,1,1,"Guardiões da Galáxia","Angela","56.52",7,"GuardioesdaGalaxia.jpg"),
(null,1,1,"Magnum","Heróis mais Poderosos da Marvel","21.50",6,"Magnum.jpg"),
(null,1,1,"Hulk","Terra Arrasada","49.00",5,"Hulk.jpg"),
(null,1,1,"Thor","Heróis mais Poderosos da Marvel","49.90",4,"Thor.jpg"),
(null,1,1,"Vingadores Iluminati","Novos Vingadores","63.50",3,"VingadoresIluminati.jpg"),
(null,1,1,"Logan","Do outro lado da Lei","37.50",2,"Logan.jpg"),
(null,1,1,"Fera","Heróis mais Poderosos da Marvel","32.50",1,"Fera.jpg"),
(null,2,2,"Harry Potter","O Princípe Mestiço","39.90",1,"HarryPotter.jpg"),
(null,2,2,"O senhor Dos Aneis","Segunda Torre","25.50",2,"OsenhorDosAneis.jpg"),
(null,2,2,"Percy Jackson","Os Olimpianos","35.69",3,"PercyJackson.jpg"),
(null,2,2,"American Gods","Best-Seller","45.68",4,"AmericanGods.jpg"),
(null,2,2,"Shadow Hunters","Instrumentos Mortais","96.65",5,"Shadowhunters.jpg"),
(null,2,2,"The Originals","Ascensão","85.52",6,"thOriginals.jpg"),
(null,2,2,"The Vampire Diaries","Sede de Sangue","25.45",7,"theVampireDiares.jpg"),
(null,2,2,"Supernatural","Coração de Dragão","32.35",8,"Supernatural.png"),
(null,2,2,"A Cabana","Petalas do Coração","12.69",9,"ACabana.jpg"),
(null,2,2,"Star Wars","O despertar das Forças","58.60",10,"StarWars.jpg"),
(null,3,3,"Juggernaut","1/10","300.00",121,"Juggernaut.jpg"),
(null,3,3,"Mickey","Disney","150.00",2311,"Mickey.jpg"),
(null,3,3,"Magneto","X-men","200.00",1312,"Magneto.jpg"),
(null,3,3,"Lobo","Unknow","250.00",95,"Lobo.jpg"),
(null,3,3,"Groot","Guardiões da Galáxia","260.00",61,"Groot.jpg"),
(null,3,3,"Gamora","Guardiões da Galáxia","270.00",15,"Gamora.jpg"),
(null,3,3,"Hulk Cinza","Os Vingadores","490.00",14,"HulkCinza.jpg"),
(null,3,3,"Thor","Os Vingadores","132.30",14,"ThorAF.jpg"),
(null,3,3,"Rhino","Homem Aranha","23.65",13,"Rhino.jpg"),
(null,3,3,"Rocket","Guardiões da Galáxia","256.20",12,"Rocket.jpg");
