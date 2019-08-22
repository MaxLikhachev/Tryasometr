insert into brands (id, name) values (1,'Audi'), (2,'BMW');
insert into models (id, name, year_from, year_to) values (1,'100',1998,2000), (2,'80',1998,2000);
insert into brands_models (brand_id, models_id) values (1,1),(1,2);
/*insert into users (username, password, authorities) values ('guest','$2a$10$pYqUAZ9vMgosQPk5MVa6Ke3l0u2i6cydbBv2PIAtPa6LmEen3NoKG','ROLE_GUEST');
insert into roles (id, name) VALUES (0,'ROLE_GUEST'),(1,'ROLE_ANDROID_USER'),(2,'ROLE_WEB_USER');*/
/*insert into holes_buffer*/