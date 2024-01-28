INSERT INTO roles (id, name) VALUES (1, 'MANAGER');
INSERT INTO roles (id, name) VALUES (2, 'USER');

-- password
INSERT INTO users (id, username, password, name) VALUES (1, 'user1', '$2a$10$WyuwOMfujNZzNYCn65s7SuEWexIH8f.JLlLkihJJu2kgluwKTNE2.', 'Jon Doe');
-- password1
INSERT INTO users (id, username, password, name) VALUES (2, 'manager1', '$2a$10$wc6VcLD746e8it/g..c5Nuv5NItzIa5Cy/TJDmeFEb4v.8HLuFKJ2', 'Manager Doe');

INSERT INTO user_roles (user_id, role_id) VALUES(1, 2); -- Jon Doe is a normal user
INSERT INTO user_roles (user_id, role_id) VALUES(2, 1); -- Manager Doe is a manger