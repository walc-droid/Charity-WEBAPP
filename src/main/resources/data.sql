INSERT INTO Category (id,name) VALUES (NULL,'Odzież');
INSERT INTO Category (id,name) VALUES (NULL,'Elektronika');
INSERT INTO Category (id,name) VALUES (NULL,'Zabawki');
INSERT INTO Category (id,name) VALUES (NULL,'Żywność');
INSERT INTO Category (id,name) VALUES (NULL,'Pieniądze');
INSERT INTO Category (id,name) VALUES (NULL,'Ksiązki');
--
INSERT INTO Institution (id,name,description) VALUES (NULL ,'Dbam o Zdrowie','Pomoc dzieciom z ubogich rodzin');
INSERT INTO Institution (id,name,description) VALUES (NULL ,'Dla dzieci','Pomoc osobom znajdującym się w trudnej sytuacji życiowej');
INSERT INTO Institution (id,name,description) VALUES (NULL,'A kogo','Pomoc wybudzaniu dzieci ze śpiączki');
INSERT INTO Institution (id,name,description) VALUES (NULL,'Bez domu','Pomoc dla osób nie posiadających miejsca zamieszkania');

INSERT INTO donation
VALUES (NULL , 'Kraków','733215099' ,'Odebrać jak najszybciej!', '2021-05-11', '08:00', 6, 'Jagiełły 60B',
        '32-560', 1),
       (NULL , 'Warszawa', '763123456','Zadzwoń przed 12.', '2021-01-29', '09:15', 3, 'Akacjowa 11',
        '32-111', 2),
       (NULL , 'Oświęcim', '677543012','Uwaga na wagę paczki!', '2021-05-04', '08:00', 5, 'Podwawelska 69',
        '32-600', 3);


INSERT INTO app_user (id,app_user_role,first_name,last_name,username,email,password,password_confirm,locked,enabled)
VALUES (NULL,'ROLE_USER','Michal','Walczyk','walc','test@gmail.com','test','test',false,true);