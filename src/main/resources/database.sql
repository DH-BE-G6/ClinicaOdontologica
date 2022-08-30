create table if not exists paciente(id int auto_increment primary key, nome varchar(255), sobrenome varchar(255), rg varchar(255), endereco int, dataAlta varchar(255);
create table if not exists dentista(id int auto_increment primary key, nome varchar(255), sobrenome varchar(255), matricula varchar(255);
create table if not exists endereco(id int auto_increment primary key, logradouro varchar(255), numero varchar(255), bairro varchar(255), cidade varchar(255), estado varchar(255), cep varchar(255);
create table if not exists procedimento(id int auto_increment primary key, nome varchar(255), dataConsulta varchar(255);
