select * from Cars;

create table Cars(
CARID number(20),
CARNAME varchar2(20),
CARYEAR number(4),
CARMODEL varchar2(20),
CARCOLOR varchar2(20),
constraint pk_carID primary key (carID)
);
INSERT INTO Cars (CARID, CARNAME, CARYEAR, CARMODEL, CARCOLOR) VALUES ('1', 'BMW-X5', '2016', 'SAV', 'BLACK');
INSERT INTO Cars (CARID, CARNAME, CARYEAR, CARMODEL, CARCOLOR) VALUES ('2', 'BMW-X3', '2018', 'SAV', 'WHITE');
INSERT INTO Cars (CARID, CARNAME, CARYEAR, CARMODEL, CARCOLOR) VALUES ('3', 'BMW-540I', '2017', 'SEDAN', 'BLACK');
INSERT INTO Cars (CARID, CARNAME, CARYEAR, CARMODEL, CARCOLOR) VALUES ('4', 'BMW-530I', '2015', 'SEDAN', 'BLUE');
INSERT INTO Cars (CARID, CARNAME, CARYEAR, CARMODEL, CARCOLOR) VALUES ('5', 'BMW-M5', '2018', 'SEDAN', 'RED');
INSERT INTO Cars (CARID, CARNAME, CARYEAR, CARMODEL, CARCOLOR) VALUES ('6', 'BMW-M6', '2016', 'SEDAN', 'RED');


create sequence cars_incr start with 1
increment by 1;

create or replace trigger cars_trigger
before insert on Cars
for each row
begin
:new.CARID := CARS_INCR.NEXTVAL;
end;
