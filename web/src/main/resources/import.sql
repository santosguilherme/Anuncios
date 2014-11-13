-- import.sql
-- INSERT INTO InputSelectEntity (numberLong, numberInteger, numberBigDecimal, data, descricao) VALUES (100, 1, 1.1, '2015-10-25', 'texto1');
INSERT INTO Usuario (indice, email, senha, ativo) VALUES (1, 'admin', 'admin', True);

INSERT INTO Anuncio (indice, usuario, titulo, texto, dataCadastro) VALUES (1, 1, 'Titulo', 'Texto', '2014-10-25');

