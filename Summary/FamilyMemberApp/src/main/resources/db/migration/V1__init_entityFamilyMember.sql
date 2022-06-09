create table familymembers(
    id int primary key auto_increment,
    familyId int not null,
    givenName varchar(20) not null,
    familyName varchar(20) not null,
    age int not null
)