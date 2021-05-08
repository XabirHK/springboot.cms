INSERT INTO role (name) VALUES ('ROLE_ADMIN');
INSERT INTO role (name) VALUES ('ROLE_MODERATOR');
INSERT INTO role (name) VALUES ('ROLE_USER');

INSERT INTO admin_user (id, email, password, username) VALUES (1, 'xabir.khan@gmail.com', '$2a$10$nIitt.UQqhGV.V53l26TmeYNvDsQZ3Lap0VGAPfm2TRjoaZm0nz3K', 'xabir');
INSERT INTO admin_user (id, email, password, username) VALUES (2, 'sami@mou.de', '$2a$10$Qh8mtMCEopaRDIlCFYoli.l1zhOfMhCl8FpXHUEgHK7f6Z6e1K/.O', 'sami');

INSERT INTO user_roles (user_id, roles_id) VALUES (1, 1);
INSERT INTO user_roles (user_id, roles_id) VALUES (2, 3);

