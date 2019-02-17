insert into key_word (id, word) values (-1, 'polimorfizam');
insert into key_word (id, word) values (-2, 'matrica');
insert into key_word (id, word) values (-3, 'diferencijabilnost');
insert into key_word (id, word) values (-4, 'konjuktivnost');
insert into key_word (id, word) values (-5, 'doplerov efekat');

insert into scientific_field (id, field_name) values (-1, 'Mathematics');
insert into scientific_field (id, field_name) values (-2, 'Chemistry');
insert into scientific_field (id, field_name) values (-3, 'English');

insert into magazine (id, name, type) values (-1, 'Magazin1', 'OPEN_ACCESS');
insert into magazine (id, name, type) values (-2, 'Magazin2', 'PAYED_ACCESS');

insert into co_author (id, first_name, last_name, e_mail, address) values (-1, 'Petar', 'Petrovic', 'petrovic@gmail.com', 'Zmaj Jovina 3');
insert into co_author (id, first_name, last_name, e_mail, address) values (-2, 'Jovan', 'Jovanovic', 'jovanovic@gmail.com', 'Zmaj Jovina 3');

insert into author (id, first_name, last_name, e_mail, address, city, country, title, username, password) values (-1, 'Marko', 'Markovic', 'markovic@gmail.com', 'Zmaj Jovina 4', 'Novi Sad', 'Srbija', 'doktor', 'marko', 'marko');
insert into author (id, first_name, last_name, e_mail, address, city, country, title, username, password) values (-2, 'Milutin', 'Milankovic', 'milankovic@gmail.com', 'Zmaj Jovina 4', 'Novi Sad', 'Srbija', 'master', 'milan', 'milan');

insert into thesis (id, title, summary, pdf_location, author_fk, field_fk) values (-1, 'doktorat Spring Boot-a', 'opis doktorata spring boot-a', '/scientific-repository/uploads/Specifikacija projekta - Naučna centrala.pdf', -1, -1);

insert into thesis_co_authors (theses_id, co_authors_id) values (-1, -1);
insert into thesis_co_authors (theses_id, co_authors_id) values (-1, -2);

insert into thesis_key_words (theses_id, key_words_id) values (-1, -1);
insert into thesis_key_words (theses_id, key_words_id) values (-1, -2);
insert into thesis_key_words (theses_id, key_words_id) values (-1, -3);
insert into thesis_key_words (theses_id, key_words_id) values (-1, -4);