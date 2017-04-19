# Uporaba podatkovne baze v spletni aplikaciji
Primer demonstrira povezovanje na podatkovno bazo s pomo�jo stre�nika Tomcat

Povezovanje na MySql podatkovno bazo je dolo�eno v datoteki META-INF/context.xml

V datoteki WEB-INF/web.xml je povezava med stre�nikovim podatkovnim virom in spletno aplikacijo.

Gonilnik za MySql se nahaja v WEB-INF/lib

Uporabo SQL v Javi demonstrira razred si.um.feri.ost.OsebaDao


Podatkovna baza:
- create database ost;
- use ost;
- create table oseba(id int auto_increment, ime varchar(255), priimek varchar(255), primary key (id));
	
	