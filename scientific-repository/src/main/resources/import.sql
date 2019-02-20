
insert into scientific_field (id, field_name) values (-1, 'Mathematics');
insert into scientific_field (id, field_name) values (-2, 'Chemistry');
insert into scientific_field (id, field_name) values (-3, 'English');


insert into co_author (id, first_name, last_name, e_mail, address) values (-1, 'Petar', 'Petrovic', 'petrovic@gmail.com', 'Zmaj Jovina 3');
insert into co_author (id, first_name, last_name, e_mail, address) values (-2, 'Jovan', 'Jovanovic', 'jovanovic@gmail.com', 'Zmaj Jovina 3');

insert into author (id, first_name, last_name, e_mail, address, city, country, title, username, password) values (-1, 'Marko', 'Markovic', 'marko.krajinovic1233@gmail.com', 'Zmaj Jovina 4', 'Novi Sad', 'Srbija', 'doktor', 'marko', 'marko');
insert into author (id, first_name, last_name, e_mail, address, city, country, title, username, password) values (-2, 'Milutin', 'Milankovic', 'marko.krajinovic1233@gmail.com', 'Zmaj Jovina 4', 'Novi Sad', 'Srbija', 'master', 'milan', 'milan');

insert into thesis (id, title, summary, pdf_location, author_fk, field_fk) values (-1, 'doktorat Spring Boot-a', 'opis doktorata spring boot-a', '/scientific-repository/uploads/Specifikacija projekta - Naučna centrala.pdf', -1, -1);

insert into thesis_co_authors (theses_id, co_authors_id) values (-1, -1);
insert into thesis_co_authors (theses_id, co_authors_id) values (-1, -2);

insert into editor(id,  first_name, last_name, e_mail, city, country, username, password) values (-1, 'Petar', 'Petrovic', 'marko.krajinovic1233@gmail.com', 'Novi Sad', 'Srbija', 'pera', 'pera');
insert into editor(id,  first_name, last_name, e_mail, city, country, username, password) values (-2, 'Djuradj', 'Djuric', 'marko.krajinovic1233@gmail.com', 'Novi Sad', 'Srbija', 'djura', 'djura');

insert into editor_comitee(id, chief_editor_id) values (-1, -1);
insert into editor_comitee(id, chief_editor_id) values (-2, -2);

insert into magazine (id, name, issn, type, editor_comitee_id) values (-1, 'Magazin1', 'issn1', 'OPEN_ACCESS', -1);
insert into magazine (id, name, issn, type, editor_comitee_id) values (-2, 'Magazin2', 'issn2', 'PAYED_ACCESS', -2);