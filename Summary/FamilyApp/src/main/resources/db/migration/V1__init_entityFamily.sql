create table family(
    id int primary key auto_increment,
    familyName varchar(20) not null,
    nrOfAdults int not null,
    nrOfChildren int not null,
    nrOfInfants int not null
)