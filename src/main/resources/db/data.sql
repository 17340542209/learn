INSERT INTO `user` (id, username, password, role) VALUES ('1', 'root', '1234', 'admin');
INSERT INTO `user` (id, username, password, role) VALUES ('2', 'user', '1234', 'user');
INSERT INTO `user` (id, username, password, role) VALUES ('3', 'user1', '1234', 'user');
INSERT INTO `user` (id, username, password, role) VALUES ('4', 'user2', '1234', 'user');
INSERT INTO `user` (id, username, password, role) VALUES ('5', 'user3', '1234', 'user');
INSERT INTO `user` (id, username, password, role) VALUES ('6', 'user4', '1234', 'user');

INSERT INTO `tourist` (writer, city, keyword, title) VALUES ('swag', '西安', '大学生', '西安三天两夜游');
INSERT INTO `tourist` (writer, city, keyword, title) VALUES ('swaglll', '武汉', '穷游', '武汉每天不一样');
INSERT INTO `tourist` (writer, city, keyword, title) VALUES ('wtt', '南京', '组团旅游', '你不知道的南京');


COMMIT;