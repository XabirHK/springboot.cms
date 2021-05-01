
INSERT INTO `role` (`id`, `name`) VALUES
(1, 'ROLE_ADMIN'),
(2, 'ROLE_MODERATOR'),
(3, 'ROLE_USER');

INSERT INTO `user_roles` (`user_id`, `roles_id`) VALUES
(1, 1),
(2, 3);

INSERT INTO `user` (`id`, `email`, `password`, `username`) VALUES
(1, 'xabir.khan@gmail.com', '$2a$10$nIitt.UQqhGV.V53l26TmeYNvDsQZ3Lap0VGAPfm2TRjoaZm0nz3K', 'xabir'),
(2, 'sami@mou.de', '$2a$10$Qh8mtMCEopaRDIlCFYoli.l1zhOfMhCl8FpXHUEgHK7f6Z6e1K/.O', 'sami');
