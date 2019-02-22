
insert into scientific_field (id, field_name) values (-1, 'Mathematics');
insert into scientific_field (id, field_name) values (-2, 'Chemistry');
insert into scientific_field (id, field_name) values (-3, 'English');

insert into co_author (id, first_name, last_name, e_mail, address) values (-1, 'Petar', 'Petrovic', 'petrovic@gmail.com', 'Zmaj Jovina 3');
insert into co_author (id, first_name, last_name, e_mail, address) values (-2, 'Jovan', 'Jovanovic', 'jovanovic@gmail.com', 'Zmaj Jovina 3');

insert into author (id, first_name, last_name, e_mail, address, city, country, title, username, password) values (-1, 'Marko', 'Markovic', 'marko.krajinovic1233@gmail.com', 'Zmaj Jovina 4', 'Novi Sad', 'Srbija', 'doktor', 'marko', 'marko');
insert into author (id, first_name, last_name, e_mail, address, city, country, title, username, password) values (-2, 'Milutin', 'Milankovic', 'marko.krajinovic1233@gmail.com', 'Zmaj Jovina 4', 'Novi Sad', 'Srbija', 'master', 'milan', 'milan');

insert into editor(id,  first_name, last_name, e_mail, city, country, username, password) values (-1, 'Petar', 'Petrovic', 'marko.krajinovic1233@gmail.com', 'Novi Sad', 'Srbija', 'pera', 'pera');
insert into editor(id,  first_name, last_name, e_mail, city, country, username, password) values (-2, 'Djuradj', 'Djuric', 'marko.krajinovic1233@gmail.com', 'Novi Sad', 'Srbija', 'djura', 'djura');

insert into editor_comitee(id, chief_editor_id) values (-1, -1);
insert into editor_comitee(id, chief_editor_id) values (-2, -2);

insert into editor(id,  first_name, last_name, e_mail, city, country, username, password, editor_comitee_id) values (-3, 'Maja', 'Majovski', 'marko.krajinovic1233@gmail.com', 'Novi Sad', 'Srbija', 'maja', 'maja', -2);

insert into magazine (id, name, issn, type, editor_comitee_id) values (-1, 'Magazin 1', 'issn1', 'OPEN_ACCESS', -1);
insert into magazine (id, name, issn, type, editor_comitee_id) values (-2, 'Magazin 2', 'issn2', 'PAYED_ACCESS', -2);

insert into scientific_field_editors (scientific_fields_id, editors_id) values (-3, -1);
insert into scientific_field_editors (scientific_fields_id, editors_id) values (-3, -2);
insert into scientific_field_editors (scientific_fields_id, editors_id) values (-3, -3);

insert into scientific_field_magazines (scientific_fields_id, magazines_id) values (-1, -1);
insert into scientific_field_magazines (scientific_fields_id, magazines_id) values (-2, -1);
insert into scientific_field_magazines (scientific_fields_id, magazines_id) values (-3, -1);

insert into scientific_field_magazines (scientific_fields_id, magazines_id) values (-1, -2);
insert into scientific_field_magazines (scientific_fields_id, magazines_id) values (-2, -2);
insert into scientific_field_magazines (scientific_fields_id, magazines_id) values (-3, -2);
