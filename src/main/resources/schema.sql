DROP TABLE IF EXISTS TB_NOTICIA;
DROP TABLE IF EXISTS TB_CLIENTE;

--tabela noticia
CREATE TABLE TB_NOTICIA (
	id BIGINT NOT NULL AUTO_INCREMENT,
	titulo VARCHAR(60) NOT NULL,
	descricao VARCHAR(350) NOT NULL,
	imagem VARCHAR(500),
	data_criacao DATETIME NOT NULL,
	data_alteracao DATETIME,
	CONSTRAINT PK_TB_NOTICIA_ID PRIMARY KEY (id)
);


-- tabela usuario
CREATE TABLE TB_CLIENTE (
	id BIGINT NOT NULL AUTO_INCREMENT,
	nome VARCHAR(250) NOT NULL,
	usuario VARCHAR(50) NOT NULL,
	senha VARCHAR(15) NOT NULL,
	CONSTRAINT PK_TB_CLIENTE_ID PRIMARY KEY (id)
);


-- tabela cliente_noticia
CREATE TABLE TB_CLIENTE_NOTICIA (
	cliente_id BIGINT NOT NULL, 
	noticia_id BIGINT NOT NULL,
	PRIMARY KEY (cliente_id, noticia_id),
	CONSTRAINT FK_TB_CLIENTE_NOTICIA_TB_CLIENTE FOREIGN KEY (cliente_id) REFERENCES TB_CLIENTE (id),
	CONSTRAINT FK_TB_CLIENTE_NOTICIA_TB_NOTICIA FOREIGN KEY (noticia_id) REFERENCES TB_NOTICIA (id)
);


--inserindo dados na tabela noticia
INSERT INTO TB_NOTICIA 
(titulo, descricao, imagem, data_criacao) 
VALUES
('One Piece', 'Luffy de 17 anos não tem a típica personalidade vil e cruel de um pirata. Ele encontra companheiros e partem em direção à Grand Line, a mais perigosa das rotas do mundo, em incríveis aventuras, revelando mistérios e enfrentando poderosos oponentes em busca do One Piece, o maior tesouro pirata.', 'https://img1.ak.crunchyroll.com/i/spire4/8056a82e973dde98ebb82abd39dc69731564519729_full.jpg', LOCALTIMESTAMP),
('Dragon Ball', 'A série Dragon Ball segue as aventuras de Son Goku desde a sua infância até a idade adulta enquanto ele treina em artes marciais e explora o mundo em busca das sete esferas místicas conhecidas como Dragon Balls, que podem invocar um dragão que concede desejos quando reunidos.','https://www.komix.com.br/wp-content/uploads/2020/05/drag-bal.jpg', LOCALTIMESTAMP),
('Neon Genesis Evangelion', 'Em 2015, os anjos, máquinas de guerra enormes, tremendamente poderosas e alienígenas, aparecem em Tóquio pela segunda vez. A única esperança de sobrevivência da Humanidade está no Evangelion, uma máquina de combate humanóide desenvolvida pela NERV e somente adolescentes são capazes de pilotá-los.', 'https://pipocamoderna.com.br/wp-content/uploads/2019/07/neon-genesis-evangelion.jpg', LOCALTIMESTAMP),
('Vagabond', 'Releitura fictícia da vida de um dos espadachins mais famosos do Japão, o "Santo da Espada" Musashi Miyamoto. Sua ascensão de um espadachim sem nenhum desejo que não seja para se tornar "Invincible debaixo dos céus" para um guerreiro iluminado que lentamente aprende do importância de amigos íntimos, auto-reflexão e a própria vida.','https://images-na.ssl-images-amazon.com/images/I/91KDm4kUI2L.jpg', LOCALTIMESTAMP),
('Bleach', 'Bleach segue as aventuras de Ichigo Kurosaki que após ganhar os poderes de Shinigami, através de uma Shinigami, Rukia Kuchiki. Com os seus novos poderes, Ichigo é forçado a assumir o dever de guiar almas boas ao mundo pós-vida à Soul Society, e derrotar os Hollows (monstros espirituais malignos).','https://images-na.ssl-images-amazon.com/images/I/71YKjjLJtmL.jpg', LOCALTIMESTAMP),
('Naruto', 'Uzumaki Naruto é um menino que vive em Konoha ou Vila Oculta da Folha, a vila ninja do País do Fogo. Desde de pequeno, Naruto é visto por muitas pessoas como um monstro, por causa de besta de caudas chamada Kyuubi que habita seu corpo. Naruto sonha em se tornar o Hokage, um ninja poderoso e respeitado, para assim poder ser reconhecido por todos.','https://i.pinimg.com/originals/f6/53/b3/f653b31b57868d1a869595cfb238195d.jpg', LOCALTIMESTAMP);


--inserindo dados na tabela cliente
INSERT INTO TB_CLIENTE (nome, usuario, senha) VALUES
('Administrador', 'admin', 'admin'),
('Braian Fernandes Xavier', 'Braian', '123'),
('Daniel de Oliveira', 'Daniel', '456'),
('Thiago Costa Martins', 'Thiago', '789');


--inserindo dados na tabela cliente_noticia
INSERT INTO TB_CLIENTE_NOTICIA (cliente_id, noticia_id) VALUES
(4,2),
(4,6),
(4,5),
(2,2),
(2,5),
(1,1),
(1,3),
(1,4),
(3,3)




