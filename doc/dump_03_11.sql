delete from cource;
INSERT INTO `cource` (`courceName`, `description`) VALUES
  ('html_academy', 'N/A');

delete from approof;
INSERT INTO `approof` (`approof_id`, `approofName`, `description`, `totalTasks`, `courceId`) VALUES
  (1, 'Знакомство', 'N/A', 14, 'html_academy'),
  (2, 'Структура HTML-документа', 'N/A', 14, 'html_academy'),
  (3, 'Разметка текста с помощью HTML', 'N/A', 17, 'html_academy'),
  (4, 'Ссылки и изображения', 'N/A', 13, 'html_academy'),
  (5, 'Знакомство с таблицами', 'N/A', 23, 'html_academy'),
  (6, 'Знакомство с формами', 'N/A', 18, 'html_academy'),
  (7, 'Знакомство с CSS', 'N/A', 15, 'html_academy'),
  (8, 'Селекторы', 'N/A', 18, 'html_academy'),
  (9, 'Наследование и каскадирование', 'N/A', 18, 'html_academy'),
  (10, 'Промежуточные испытания', 'N/A', 3, 'html_academy'),
  (11, 'Оформление текста с помощью CSS', 'N/A', 16, 'html_academy'),
  (12, 'Блочная модель документа', 'N/A', 23, 'html_academy'),
  (13, 'Позиционирование', 'N/A', 20, 'html_academy'),
  (14, 'Сетки', 'N/A', 32, 'html_academy'),
  (15, 'Фоны', 'N/A', 16, 'html_academy'),
  (16, 'Мастерская: создаём меню', 'N/A', 28, 'html_academy'),
  (17, 'Мастерская: декоративные элементы', 'N/A', 18, 'html_academy'),
  (18, 'Завершающие испытания', 'N/A', 3, 'html_academy'),
  (19, 'Знакомство с HTML5', 'N/A', 19, 'html_academy'),
  (20, 'Формы и HTML5', 'N/A', 28, 'html_academy'),
  (21, 'Игра теней', 'N/A', 17, 'html_academy'),
  (22, 'Селекторы. Часть 2', 'N/A', 20, 'html_academy'),
  (23, 'Селекторы. Часть 3', 'N/A', 18, 'html_academy'),
  (24, 'Линейные градиенты', 'N/A', 23, 'html_academy'),
  (25, 'Двумерные трансформации', 'N/A', 32, 'html_academy'),
  (26, 'Мастерская: декоративные эффекты на HTML5 и CSS3', 'N/A', 31, 'html_academy'),
  (27, 'Оформление текста с помощью CSS. Часть 2', 'N/A', 26, 'html_academy'),
  (28, 'Анимация', 'N/A', 31, 'html_academy');

delete from user;
INSERT INTO `user` (`user_id`, `coursesFinished`, `htmlAcademyLink`, `scores`, `userName`) VALUES
  (1, 5, 'http://htmlacademy.ru/public_profiles/id48078', 9187, 'Бодров Максим'),
  (2, 6, 'http://htmlacademy.ru/public_profiles/id47471', 10282, 'Григорий Украинский'),
  (3, 4, 'http://htmlacademy.ru/public_profiles/id48128', 6785, 'Alexandrov Alexander'),
  (4, 5, 'http://htmlacademy.ru/public_profiles/id47508', 8292, 'Виталий Никоноров'),
  (5, 5, 'http://htmlacademy.ru/public_profiles/id47830', 8891, 'Женя Аман'),
  (6, 1, 'http://htmlacademy.ru/public_profiles/id48080', 1400, 'Данила Данлов'),
  (7, 2, 'http://htmlacademy.ru/public_profiles/id48564', 4500, 'Вадим Берёзка'),
  (8, 4, 'http://htmlacademy.ru/public_profiles/id47829', 7494, 'герберт ращук'),
  (9, 4, 'http://htmlacademy.ru/public_profiles/id47877', 7400, 'Эйсмонт Михаил'),
  (10, 2, 'http://htmlacademy.ru/public_profiles/id48084', 3800, 'Андрей Трофимов'),
  (11, 2, 'http://htmlacademy.ru/public_profiles/id48082', 4600, 'Саша Кузьмин'),
  (12, 0, 'http://htmlacademy.ru/public_profiles/id48087', 1300, 'Андрей Синецкий'),
  (13, 1, 'http://htmlacademy.ru/public_profiles/id47562', 2694, 'Сергей Макеев-Критский'),
  (14, 4, 'http://htmlacademy.ru/public_profiles/id48086', 6600, 'Даниил Русанов'),
  (15, 2, 'http://htmlacademy.ru/public_profiles/id50647', 4000, 'Денис Трофимов');

delete from user_approof_history;
INSERT INTO `user_approof_history` (`date`, `passedTasks`, `approof_id`, `user_id`) VALUES
  ( '2014-09-13 00:00:00', 0, 1, 1),
  ( '2014-09-13 00:00:00', 0, 1, 2),
  ( '2014-09-13 00:00:00', 0, 1, 3),
  ( '2014-09-13 00:00:00', 0, 1, 4),
  ( '2014-09-13 00:00:00', 0, 1, 5),
  ( '2014-09-13 00:00:00', 0, 1, 6),
  ( '2014-09-13 00:00:00', 0, 1, 7),
  ( '2014-09-13 00:00:00', 0, 1, 8),
  ( '2014-09-13 00:00:00', 0, 1, 9),
  ( '2014-09-13 00:00:00', 0, 1, 10),
  ( '2014-09-13 00:00:00', 0, 1, 11),
  ( '2014-09-13 00:00:00', 0, 1, 12),
  ( '2014-09-13 00:00:00', 0, 1, 13),
  ( '2014-09-13 00:00:00', 0, 1, 14),
  ( '2014-09-13 00:00:00', 0, 1, 15),
  ( '2014-10-24 13:00:00', 14, 1, 1),
  ( '2014-10-24 13:00:00', 14, 1, 2),
  ( '2014-10-24 13:00:00', 14, 1, 3),
  ( '2014-10-24 13:00:00', 14, 1, 4),
  ( '2014-10-24 13:00:00', 14, 1, 5),
  ( '2014-10-24 13:00:00', 13, 1, 6),
  ( '2014-10-24 13:00:00', 14, 1, 7),
  ( '2014-10-24 13:00:00', 14, 1, 8),
  ( '2014-10-24 13:00:00', 14, 1, 9),
  ( '2014-10-24 13:00:00', 13, 1, 10),
  ( '2014-10-24 13:00:00', 14, 1, 11),
  ( '2014-10-24 13:00:00', 13, 1, 12),
  ( '2014-10-24 13:00:00', 14, 1, 13),
  ( '2014-10-24 13:00:00', 14, 2, 1),
  ( '2014-10-24 13:00:00', 14, 2, 2),
  ( '2014-10-24 13:00:00', 14, 2, 3),
  ( '2014-10-24 13:00:00', 14, 2, 4),
  ( '2014-10-24 13:00:00', 14, 2, 5),
  ( '2014-10-24 13:00:00', 13, 2, 7),
  ( '2014-10-24 13:00:00', 14, 2, 8),
  ( '2014-10-24 13:00:00', 14, 2, 9),
  ( '2014-10-24 13:00:00', 14, 2, 10),
  ( '2014-10-24 13:00:00', 12, 2, 11),
  ( '2014-10-24 13:00:00', 13, 2, 13),
  ( '2014-10-24 13:00:00', 17, 3, 1),
  ( '2014-10-24 13:00:00', 16, 3, 2),
  ( '2014-10-24 13:00:00', 17, 3, 3),
  ( '2014-10-24 13:00:00', 17, 3, 4),
  ( '2014-10-24 13:00:00', 16, 3, 5),
  ( '2014-10-24 13:00:00', 2, 3, 7),
  ( '2014-10-24 13:00:00', 17, 3, 8),
  ( '2014-10-24 13:00:00', 17, 3, 9),
  ( '2014-10-24 13:00:00', 4, 3, 11),
  ( '2014-10-24 13:00:00', 13, 4, 1),
  ( '2014-10-24 13:00:00', 13, 4, 2),
  ( '2014-10-24 13:00:00', 13, 4, 3),
  ( '2014-10-24 13:00:00', 13, 4, 4),
  ( '2014-10-24 13:00:00', 2, 4, 5),
  ( '2014-10-24 13:00:00', 8, 4, 7),
  ( '2014-10-24 13:00:00', 12, 4, 8),
  ( '2014-10-24 13:00:00', 13, 4, 9),
  ( '2014-10-24 13:00:00', 23, 5, 1),
  ( '2014-10-24 13:00:00', 10, 5, 2),
  ( '2014-10-24 13:00:00', 8, 5, 3),
  ( '2014-10-24 13:00:00', 22, 5, 4),
  ( '2014-10-24 13:00:00', 1, 5, 7),
  ( '2014-10-24 13:00:00', 2, 5, 11),
  ( '2014-10-24 13:00:00', 4, 6, 1),
  ( '2014-10-24 13:00:00', 2, 7, 3),
  ( '2014-10-24 13:00:00', 2, 7, 7),
  ( '2014-10-24 13:00:00', 1, 16, 4),
  ( '2014-10-24 13:00:00', 1, 28, 2),
  ( '2014-10-24 13:00:00', 1, 28, 4),
  ( '2014-10-24 13:00:00', 1, 28, 10),
  ( '2014-10-25 00:00:00', 14, 1, 1),
  ( '2014-10-25 00:00:00', 14, 1, 2),
  ( '2014-10-25 00:00:00', 14, 1, 3),
  ( '2014-10-25 00:00:00', 14, 1, 4),
  ( '2014-10-25 00:00:00', 14, 1, 5),
  ( '2014-10-25 00:00:00', 13, 1, 6),
  ( '2014-10-25 00:00:00', 14, 1, 7),
  ( '2014-10-25 00:00:00', 14, 1, 8),
  ( '2014-10-25 00:00:00', 14, 1, 9),
  ( '2014-10-25 00:00:00', 13, 1, 10),
  ( '2014-10-25 00:00:00', 14, 1, 11),
  ( '2014-10-25 00:00:00', 13, 1, 12),
  ( '2014-10-25 00:00:00', 14, 1, 13),
  ( '2014-10-25 00:00:00', 14, 2, 1),
  ( '2014-10-25 00:00:00', 14, 2, 2),
  ( '2014-10-25 00:00:00', 14, 2, 3),
  ( '2014-10-25 00:00:00', 14, 2, 4),
  ( '2014-10-25 00:00:00', 14, 2, 5),
  ( '2014-10-25 00:00:00', 13, 2, 7),
  ( '2014-10-25 00:00:00', 14, 2, 8),
  ( '2014-10-25 00:00:00', 14, 2, 9),
  ( '2014-10-25 00:00:00', 14, 2, 10),
  ( '2014-10-25 00:00:00', 12, 2, 11),
  ( '2014-10-25 00:00:00', 13, 2, 13),
  ( '2014-10-25 00:00:00', 17, 3, 1),
  ( '2014-10-25 00:00:00', 16, 3, 2),
  ( '2014-10-25 00:00:00', 17, 3, 3),
  ( '2014-10-25 00:00:00', 17, 3, 4),
  ( '2014-10-25 00:00:00', 16, 3, 5),
  ( '2014-10-25 00:00:00', 2, 3, 7),
  ( '2014-10-25 00:00:00', 17, 3, 8),
  ( '2014-10-25 00:00:00', 17, 3, 9),
  ( '2014-10-25 00:00:00', 4, 3, 11),
  ( '2014-10-25 00:00:00', 13, 4, 1),
  ( '2014-10-25 00:00:00', 13, 4, 2),
  ( '2014-10-25 00:00:00', 13, 4, 3),
  ( '2014-10-25 00:00:00', 13, 4, 4),
  ( '2014-10-25 00:00:00', 2, 4, 5),
  ( '2014-10-25 00:00:00', 8, 4, 7),
  ( '2014-10-25 00:00:00', 12, 4, 8),
  ( '2014-10-25 00:00:00', 13, 4, 9),
  ( '2014-10-25 00:00:00', 23, 5, 1),
  ( '2014-10-25 00:00:00', 10, 5, 2),
  ( '2014-10-25 00:00:00', 8, 5, 3),
  ( '2014-10-25 00:00:00', 22, 5, 4),
  ( '2014-10-25 00:00:00', 1, 5, 7),
  ( '2014-10-25 00:00:00', 2, 5, 11),
  ( '2014-10-25 00:00:00', 4, 6, 1),
  ( '2014-10-25 00:00:00', 2, 7, 3),
  ( '2014-10-25 00:00:00', 2, 7, 7),
  ( '2014-10-25 00:00:00', 1, 16, 4),
  ( '2014-10-25 00:00:00', 1, 28, 2),
  ( '2014-10-25 00:00:00', 1, 28, 4),
  ( '2014-10-25 00:00:00', 1, 28, 10),
  ( '2014-10-26 00:00:00', 14, 1, 1),
  ( '2014-10-26 12:00:00', 14, 1, 2),
  ( '2014-10-26 12:00:00', 14, 1, 3),
  ( '2014-10-26 00:00:00', 14, 1, 4),
  ( '2014-10-26 12:00:00', 14, 1, 5),
  ( '2014-10-26 12:00:00', 14, 1, 6),
  ( '2014-10-26 12:00:00', 14, 1, 7),
  ( '2014-10-26 12:00:00', 14, 1, 9),
  ( '2014-10-26 12:00:00', 14, 1, 10),
  ( '2014-10-26 12:00:00', 14, 1, 11),
  ( '2014-10-26 12:00:00', 13, 1, 12),
  ( '2014-10-26 12:00:00', 14, 1, 13),
  ( '2014-10-26 12:00:00', 14, 1, 14),
  ( '2014-10-26 12:00:00', 14, 1, 15),
  ( '2014-10-26 00:00:00', 14, 2, 1),
  ( '2014-10-26 12:00:00', 14, 2, 2),
  ( '2014-10-26 12:00:00', 14, 2, 3),
  ( '2014-10-26 00:00:00', 14, 2, 4),
  ( '2014-10-26 12:00:00', 14, 2, 5),
  ( '2014-10-26 12:00:00', 13, 2, 7),
  ( '2014-10-26 12:00:00', 14, 2, 9),
  ( '2014-10-26 12:00:00', 14, 2, 10),
  ( '2014-10-26 12:00:00', 14, 2, 11),
  ( '2014-10-26 12:00:00', 13, 2, 13),
  ( '2014-10-26 12:00:00', 14, 2, 14),
  ( '2014-10-26 12:00:00', 14, 2, 15),
  ( '2014-10-26 00:00:00', 17, 3, 1),
  ( '2014-10-26 12:00:00', 16, 3, 2),
  ( '2014-10-26 12:00:00', 17, 3, 3),
  ( '2014-10-26 00:00:00', 17, 3, 4),
  ( '2014-10-26 12:00:00', 17, 3, 5),
  ( '2014-10-26 12:00:00', 2, 3, 7),
  ( '2014-10-26 12:00:00', 17, 3, 9),
  ( '2014-10-26 12:00:00', 9, 3, 10),
  ( '2014-10-26 12:00:00', 16, 3, 11),
  ( '2014-10-26 12:00:00', 17, 3, 14),
  ( '2014-10-26 12:00:00', 5, 3, 15),
  ( '2014-10-26 00:00:00', 13, 4, 1),
  ( '2014-10-26 12:00:00', 13, 4, 2),
  ( '2014-10-26 12:00:00', 13, 4, 3),
  ( '2014-10-26 00:00:00', 13, 4, 4),
  ( '2014-10-26 12:00:00', 13, 4, 5),
  ( '2014-10-26 12:00:00', 8, 4, 7),
  ( '2014-10-26 12:00:00', 13, 4, 9),
  ( '2014-10-26 12:00:00', 13, 4, 14),
  ( '2014-10-26 00:00:00', 23, 5, 1),
  ( '2014-10-26 12:00:00', 10, 5, 2),
  ( '2014-10-26 12:00:00', 8, 5, 3),
  ( '2014-10-26 00:00:00', 22, 5, 4),
  ( '2014-10-26 12:00:00', 23, 5, 5),
  ( '2014-10-26 12:00:00', 1, 5, 7),
  ( '2014-10-26 12:00:00', 2, 5, 11),
  ( '2014-10-26 12:00:00', 4, 5, 14),
  ( '2014-10-26 00:00:00', 11, 6, 1),
  ( '2014-10-26 12:00:00', 2, 7, 3),
  ( '2014-10-26 12:00:00', 2, 7, 7),
  ( '2014-10-26 00:00:00', 1, 16, 4),
  ( '2014-10-26 12:00:00', 1, 28, 2),
  ( '2014-10-26 00:00:00', 1, 28, 4),
  ( '2014-10-26 12:00:00', 1, 28, 10),
  ( '2014-10-26 12:00:00', 2, 28, 15),
  ( '2014-10-27 00:00:00', 14, 1, 1),
  ( '2014-10-27 00:00:00', 14, 1, 2),
  ( '2014-10-27 00:00:00', 14, 1, 3),
  ( '2014-10-27 00:00:00', 14, 1, 4),
  ( '2014-10-27 00:00:00', 14, 1, 5),
  ( '2014-10-27 00:00:00', 14, 1, 6),
  ( '2014-10-27 00:00:00', 14, 1, 7),
  ( '2014-10-27 00:00:00', 14, 1, 9),
  ( '2014-10-27 00:00:00', 14, 1, 10),
  ( '2014-10-27 00:00:00', 14, 1, 11),
  ( '2014-10-27 00:00:00', 13, 1, 12),
  ( '2014-10-27 00:00:00', 14, 1, 13),
  ( '2014-10-27 00:00:00', 14, 1, 14),
  ( '2014-10-27 00:00:00', 14, 1, 15),
  ( '2014-10-27 00:00:00', 14, 2, 1),
  ( '2014-10-27 00:00:00', 14, 2, 2),
  ( '2014-10-27 00:00:00', 14, 2, 3),
  ( '2014-10-27 00:00:00', 14, 2, 4),
  ( '2014-10-27 00:00:00', 14, 2, 5),
  ( '2014-10-27 00:00:00', 13, 2, 7),
  ( '2014-10-27 00:00:00', 14, 2, 9),
  ( '2014-10-27 00:00:00', 14, 2, 10),
  ( '2014-10-27 00:00:00', 14, 2, 11),
  ( '2014-10-27 00:00:00', 13, 2, 13),
  ( '2014-10-27 00:00:00', 14, 2, 14),
  ( '2014-10-27 00:00:00', 14, 2, 15),
  ( '2014-10-27 00:00:00', 17, 3, 1),
  ( '2014-10-27 00:00:00', 17, 3, 2),
  ( '2014-10-27 00:00:00', 17, 3, 3),
  ( '2014-10-27 00:00:00', 17, 3, 4),
  ( '2014-10-27 00:00:00', 17, 3, 5),
  ( '2014-10-27 00:00:00', 2, 3, 7),
  ( '2014-10-27 00:00:00', 17, 3, 9),
  ( '2014-10-27 00:00:00', 9, 3, 10),
  ( '2014-10-27 00:00:00', 16, 3, 11),
  ( '2014-10-27 00:00:00', 17, 3, 14),
  ( '2014-10-27 00:00:00', 5, 3, 15),
  ( '2014-10-27 00:00:00', 13, 4, 1),
  ( '2014-10-27 00:00:00', 13, 4, 2),
  ( '2014-10-27 00:00:00', 13, 4, 3),
  ( '2014-10-27 00:00:00', 13, 4, 4),
  ( '2014-10-27 00:00:00', 13, 4, 5),
  ( '2014-10-27 00:00:00', 8, 4, 7),
  ( '2014-10-27 00:00:00', 13, 4, 9),
  ( '2014-10-27 00:00:00', 13, 4, 14),
  ( '2014-10-27 00:00:00', 23, 5, 1),
  ( '2014-10-27 00:00:00', 16, 5, 2),
  ( '2014-10-27 00:00:00', 8, 5, 3),
  ( '2014-10-27 00:00:00', 22, 5, 4),
  ( '2014-10-27 00:00:00', 23, 5, 5),
  ( '2014-10-27 00:00:00', 1, 5, 7),
  ( '2014-10-27 00:00:00', 2, 5, 11),
  ( '2014-10-27 00:00:00', 4, 5, 14),
  ( '2014-10-27 00:00:00', 11, 6, 1),
  ( '2014-10-27 00:00:00', 2, 7, 3),
  ( '2014-10-27 00:00:00', 2, 7, 7),
  ( '2014-10-27 00:00:00', 1, 16, 4),
  ( '2014-10-27 00:00:00', 1, 28, 2),
  ( '2014-10-27 00:00:00', 1, 28, 4),
  ( '2014-10-27 00:00:00', 1, 28, 10),
  ( '2014-10-27 00:00:00', 2, 28, 15),
  ( '2014-10-28 00:00:00', 14, 1, 1),
  ( '2014-10-28 00:00:00', 14, 1, 2),
  ( '2014-10-28 00:00:00', 14, 1, 3),
  ( '2014-10-28 00:00:00', 14, 1, 4),
  ( '2014-10-28 00:00:00', 14, 1, 5),
  ( '2014-10-28 00:00:00', 14, 1, 6),
  ( '2014-10-28 00:00:00', 14, 1, 7),
  ( '2014-10-28 00:00:00', 14, 1, 9),
  ( '2014-10-28 00:00:00', 14, 1, 10),
  ( '2014-10-28 00:00:00', 14, 1, 11),
  ( '2014-10-28 00:00:00', 13, 1, 12),
  ( '2014-10-28 00:00:00', 14, 1, 13),
  ( '2014-10-28 00:00:00', 14, 1, 14),
  ( '2014-10-28 00:00:00', 14, 1, 15),
  ( '2014-10-28 00:00:00', 14, 2, 1),
  ( '2014-10-28 00:00:00', 14, 2, 2),
  ( '2014-10-28 00:00:00', 14, 2, 3),
  ( '2014-10-28 00:00:00', 14, 2, 4),
  ( '2014-10-28 00:00:00', 14, 2, 5),
  ( '2014-10-28 00:00:00', 14, 2, 7),
  ( '2014-10-28 00:00:00', 14, 2, 9),
  ( '2014-10-28 00:00:00', 14, 2, 10),
  ( '2014-10-28 00:00:00', 14, 2, 11),
  ( '2014-10-28 00:00:00', 13, 2, 13),
  ( '2014-10-28 00:00:00', 14, 2, 14),
  ( '2014-10-28 00:00:00', 14, 2, 15),
  ( '2014-10-28 00:00:00', 17, 3, 1),
  ( '2014-10-28 00:00:00', 17, 3, 2),
  ( '2014-10-28 00:00:00', 17, 3, 3),
  ( '2014-10-28 00:00:00', 17, 3, 4),
  ( '2014-10-28 00:00:00', 17, 3, 5),
  ( '2014-10-28 00:00:00', 2, 3, 7),
  ( '2014-10-28 00:00:00', 17, 3, 9),
  ( '2014-10-28 00:00:00', 9, 3, 10),
  ( '2014-10-28 00:00:00', 16, 3, 11),
  ( '2014-10-28 00:00:00', 17, 3, 14),
  ( '2014-10-28 00:00:00', 5, 3, 15),
  ( '2014-10-28 00:00:00', 13, 4, 1),
  ( '2014-10-28 00:00:00', 13, 4, 2),
  ( '2014-10-28 00:00:00', 13, 4, 3),
  ( '2014-10-28 00:00:00', 13, 4, 4),
  ( '2014-10-28 00:00:00', 13, 4, 5),
  ( '2014-10-28 00:00:00', 8, 4, 7),
  ( '2014-10-28 00:00:00', 13, 4, 9),
  ( '2014-10-28 00:00:00', 13, 4, 14),
  ( '2014-10-28 00:00:00', 23, 5, 1),
  ( '2014-10-28 00:00:00', 22, 5, 2),
  ( '2014-10-28 00:00:00', 8, 5, 3),
  ( '2014-10-28 00:00:00', 22, 5, 4),
  ( '2014-10-28 00:00:00', 23, 5, 5),
  ( '2014-10-28 00:00:00', 1, 5, 7),
  ( '2014-10-28 00:00:00', 2, 5, 11),
  ( '2014-10-28 00:00:00', 4, 5, 14),
  ( '2014-10-28 00:00:00', 11, 6, 1),
  ( '2014-10-28 00:00:00', 3, 6, 2),
  ( '2014-10-28 00:00:00', 8, 6, 5),
  ( '2014-10-28 00:00:00', 2, 7, 3),
  ( '2014-10-28 00:00:00', 2, 7, 7),
  ( '2014-10-28 00:00:00', 1, 16, 4),
  ( '2014-10-28 00:00:00', 1, 28, 2),
  ( '2014-10-28 00:00:00', 1, 28, 4),
  ( '2014-10-28 00:00:00', 1, 28, 10),
  ( '2014-10-28 00:00:00', 2, 28, 15),
  ( '2014-10-29 00:00:00', 14, 1, 1),
  ( '2014-10-29 00:00:00', 14, 1, 2),
  ( '2014-10-29 00:00:00', 14, 1, 3),
  ( '2014-10-29 00:00:00', 14, 1, 4),
  ( '2014-10-29 00:00:00', 14, 1, 5),
  ( '2014-10-29 00:00:00', 14, 1, 6),
  ( '2014-10-29 00:00:00', 14, 1, 7),
  ( '2014-10-29 00:00:00', 14, 1, 9),
  ( '2014-10-29 00:00:00', 14, 1, 10),
  ( '2014-10-29 00:00:00', 14, 1, 11),
  ( '2014-10-29 00:00:00', 13, 1, 12),
  ( '2014-10-29 00:00:00', 14, 1, 13),
  ( '2014-10-29 00:00:00', 14, 1, 14),
  ( '2014-10-29 00:00:00', 14, 1, 15),
  ( '2014-10-29 00:00:00', 14, 2, 1),
  ( '2014-10-29 00:00:00', 14, 2, 2),
  ( '2014-10-29 00:00:00', 14, 2, 3),
  ( '2014-10-29 00:00:00', 14, 2, 4),
  ( '2014-10-29 00:00:00', 14, 2, 5),
  ( '2014-10-29 00:00:00', 14, 2, 7),
  ( '2014-10-29 00:00:00', 14, 2, 9),
  ( '2014-10-29 00:00:00', 14, 2, 10),
  ( '2014-10-29 00:00:00', 14, 2, 11),
  ( '2014-10-29 00:00:00', 13, 2, 13),
  ( '2014-10-29 00:00:00', 14, 2, 14),
  ( '2014-10-29 00:00:00', 14, 2, 15),
  ( '2014-10-29 00:00:00', 17, 3, 1),
  ( '2014-10-29 00:00:00', 17, 3, 2),
  ( '2014-10-29 00:00:00', 17, 3, 3),
  ( '2014-10-29 00:00:00', 17, 3, 4),
  ( '2014-10-29 00:00:00', 17, 3, 5),
  ( '2014-10-29 00:00:00', 2, 3, 7),
  ( '2014-10-29 00:00:00', 17, 3, 9),
  ( '2014-10-29 00:00:00', 9, 3, 10),
  ( '2014-10-29 00:00:00', 16, 3, 11),
  ( '2014-10-29 00:00:00', 17, 3, 14),
  ( '2014-10-29 00:00:00', 5, 3, 15),
  ( '2014-10-29 00:00:00', 13, 4, 1),
  ( '2014-10-29 00:00:00', 13, 4, 2),
  ( '2014-10-29 00:00:00', 13, 4, 3),
  ( '2014-10-29 00:00:00', 13, 4, 4),
  ( '2014-10-29 00:00:00', 13, 4, 5),
  ( '2014-10-29 00:00:00', 8, 4, 7),
  ( '2014-10-29 00:00:00', 13, 4, 9),
  ( '2014-10-29 00:00:00', 13, 4, 14),
  ( '2014-10-29 00:00:00', 23, 5, 1),
  ( '2014-10-29 00:00:00', 22, 5, 2),
  ( '2014-10-29 00:00:00', 8, 5, 3),
  ( '2014-10-29 00:00:00', 22, 5, 4),
  ( '2014-10-29 00:00:00', 23, 5, 5),
  ( '2014-10-29 00:00:00', 1, 5, 7),
  ( '2014-10-29 00:00:00', 10, 5, 9),
  ( '2014-10-29 00:00:00', 2, 5, 11),
  ( '2014-10-29 00:00:00', 4, 5, 14),
  ( '2014-10-29 00:00:00', 11, 6, 1),
  ( '2014-10-29 00:00:00', 13, 6, 2),
  ( '2014-10-29 00:00:00', 8, 6, 5),
  ( '2014-10-29 00:00:00', 2, 7, 3),
  ( '2014-10-29 00:00:00', 2, 7, 7),
  ( '2014-10-29 00:00:00', 1, 16, 4),
  ( '2014-10-29 00:00:00', 1, 28, 2),
  ( '2014-10-29 00:00:00', 1, 28, 4),
  ( '2014-10-29 00:00:00', 1, 28, 10),
  ( '2014-10-29 00:00:00', 2, 28, 15),
  ( '2014-10-30 00:00:00', 14, 1, 1),
  ( '2014-10-30 00:00:00', 14, 1, 2),
  ( '2014-10-30 00:00:00', 14, 1, 3),
  ( '2014-10-30 00:00:00', 14, 1, 4),
  ( '2014-10-30 00:00:00', 14, 1, 5),
  ( '2014-10-30 00:00:00', 14, 1, 6),
  ( '2014-10-30 00:00:00', 14, 1, 7),
  ( '2014-10-30 00:00:00', 14, 1, 8),
  ( '2014-10-30 00:00:00', 14, 1, 9),
  ( '2014-10-30 00:00:00', 14, 1, 10),
  ( '2014-10-30 00:00:00', 14, 1, 11),
  ( '2014-10-30 00:00:00', 13, 1, 12),
  ( '2014-10-30 00:00:00', 14, 1, 13),
  ( '2014-10-30 00:00:00', 14, 1, 14),
  ( '2014-10-30 00:00:00', 14, 1, 15),
  ( '2014-10-30 00:00:00', 14, 2, 1),
  ( '2014-10-30 00:00:00', 14, 2, 2),
  ( '2014-10-30 00:00:00', 14, 2, 3),
  ( '2014-10-30 00:00:00', 14, 2, 4),
  ( '2014-10-30 00:00:00', 14, 2, 5),
  ( '2014-10-30 00:00:00', 14, 2, 7),
  ( '2014-10-30 00:00:00', 14, 2, 8),
  ( '2014-10-30 00:00:00', 14, 2, 9),
  ( '2014-10-30 00:00:00', 14, 2, 10),
  ( '2014-10-30 00:00:00', 14, 2, 11),
  ( '2014-10-30 00:00:00', 13, 2, 13),
  ( '2014-10-30 00:00:00', 14, 2, 14),
  ( '2014-10-30 00:00:00', 14, 2, 15),
  ( '2014-10-30 00:00:00', 17, 3, 1),
  ( '2014-10-30 00:00:00', 17, 3, 2),
  ( '2014-10-30 00:00:00', 17, 3, 3),
  ( '2014-10-30 00:00:00', 17, 3, 4),
  ( '2014-10-30 00:00:00', 17, 3, 5),
  ( '2014-10-30 00:00:00', 2, 3, 7),
  ( '2014-10-30 00:00:00', 17, 3, 8),
  ( '2014-10-30 00:00:00', 17, 3, 9),
  ( '2014-10-30 00:00:00', 9, 3, 10),
  ( '2014-10-30 00:00:00', 16, 3, 11),
  ( '2014-10-30 00:00:00', 17, 3, 14),
  ( '2014-10-30 00:00:00', 5, 3, 15),
  ( '2014-10-30 00:00:00', 13, 4, 1),
  ( '2014-10-30 00:00:00', 13, 4, 2),
  ( '2014-10-30 00:00:00', 13, 4, 3),
  ( '2014-10-30 00:00:00', 13, 4, 4),
  ( '2014-10-30 00:00:00', 13, 4, 5),
  ( '2014-10-30 00:00:00', 8, 4, 7),
  ( '2014-10-30 00:00:00', 13, 4, 8),
  ( '2014-10-30 00:00:00', 13, 4, 9),
  ( '2014-10-30 00:00:00', 13, 4, 14),
  ( '2014-10-30 00:00:00', 23, 5, 1),
  ( '2014-10-30 00:00:00', 22, 5, 2),
  ( '2014-10-30 00:00:00', 8, 5, 3),
  ( '2014-10-30 00:00:00', 23, 5, 4),
  ( '2014-10-30 00:00:00', 23, 5, 5),
  ( '2014-10-30 00:00:00', 5, 5, 7),
  ( '2014-10-30 00:00:00', 16, 5, 8),
  ( '2014-10-30 00:00:00', 16, 5, 9),
  ( '2014-10-30 00:00:00', 2, 5, 11),
  ( '2014-10-30 00:00:00', 8, 5, 14),
  ( '2014-10-30 00:00:00', 11, 6, 1),
  ( '2014-10-30 00:00:00', 13, 6, 2),
  ( '2014-10-30 00:00:00', 8, 6, 5),
  ( '2014-10-30 00:00:00', 2, 7, 3),
  ( '2014-10-30 00:00:00', 2, 7, 7),
  ( '2014-10-30 00:00:00', 1, 16, 4),
  ( '2014-10-30 00:00:00', 1, 28, 2),
  ( '2014-10-30 00:00:00', 1, 28, 4),
  ( '2014-10-30 00:00:00', 1, 28, 8),
  ( '2014-10-30 00:00:00', 1, 28, 10),
  ( '2014-10-30 00:00:00', 2, 28, 15),
  ( '2014-10-31 00:00:00', 14, 1, 1),
  ( '2014-10-31 00:00:00', 14, 1, 2),
  ( '2014-10-31 00:00:00', 14, 1, 3),
  ( '2014-10-31 00:00:00', 14, 1, 4),
  ( '2014-10-31 00:00:00', 14, 1, 5),
  ( '2014-10-31 00:00:00', 14, 1, 6),
  ( '2014-10-31 00:00:00', 14, 1, 7),
  ( '2014-10-31 00:00:00', 14, 1, 8),
  ( '2014-10-31 00:00:00', 14, 1, 9),
  ( '2014-10-31 00:00:00', 14, 1, 10),
  ( '2014-10-31 00:00:00', 14, 1, 11),
  ( '2014-10-31 00:00:00', 13, 1, 12),
  ( '2014-10-31 00:00:00', 14, 1, 13),
  ( '2014-10-31 00:00:00', 14, 1, 14),
  ( '2014-10-31 00:00:00', 14, 1, 15),
  ( '2014-10-31 00:00:00', 14, 2, 1),
  ( '2014-10-31 00:00:00', 14, 2, 2),
  ( '2014-10-31 00:00:00', 14, 2, 3),
  ( '2014-10-31 00:00:00', 14, 2, 4),
  ( '2014-10-31 00:00:00', 14, 2, 5),
  ( '2014-10-31 00:00:00', 14, 2, 7),
  ( '2014-10-31 00:00:00', 14, 2, 8),
  ( '2014-10-31 00:00:00', 14, 2, 9),
  ( '2014-10-31 00:00:00', 14, 2, 10),
  ( '2014-10-31 00:00:00', 14, 2, 11),
  ( '2014-10-31 00:00:00', 13, 2, 13),
  ( '2014-10-31 00:00:00', 14, 2, 14),
  ( '2014-10-31 00:00:00', 14, 2, 15),
  ( '2014-10-31 00:00:00', 17, 3, 1),
  ( '2014-10-31 00:00:00', 17, 3, 2),
  ( '2014-10-31 00:00:00', 17, 3, 3),
  ( '2014-10-31 00:00:00', 17, 3, 4),
  ( '2014-10-31 00:00:00', 17, 3, 5),
  ( '2014-10-31 00:00:00', 2, 3, 7),
  ( '2014-10-31 00:00:00', 17, 3, 8),
  ( '2014-10-31 00:00:00', 17, 3, 9),
  ( '2014-10-31 00:00:00', 9, 3, 10),
  ( '2014-10-31 00:00:00', 16, 3, 11),
  ( '2014-10-31 00:00:00', 17, 3, 14),
  ( '2014-10-31 00:00:00', 5, 3, 15),
  ( '2014-10-31 00:00:00', 13, 4, 1),
  ( '2014-10-31 00:00:00', 13, 4, 2),
  ( '2014-10-31 00:00:00', 13, 4, 3),
  ( '2014-10-31 00:00:00', 13, 4, 4),
  ( '2014-10-31 00:00:00', 13, 4, 5),
  ( '2014-10-31 00:00:00', 8, 4, 7),
  ( '2014-10-31 00:00:00', 13, 4, 8),
  ( '2014-10-31 00:00:00', 13, 4, 9),
  ( '2014-10-31 00:00:00', 13, 4, 14),
  ( '2014-10-31 00:00:00', 23, 5, 1),
  ( '2014-10-31 00:00:00', 22, 5, 2),
  ( '2014-10-31 00:00:00', 8, 5, 3),
  ( '2014-10-31 00:00:00', 23, 5, 4),
  ( '2014-10-31 00:00:00', 23, 5, 5),
  ( '2014-10-31 00:00:00', 5, 5, 7),
  ( '2014-10-31 00:00:00', 16, 5, 8),
  ( '2014-10-31 00:00:00', 16, 5, 9),
  ( '2014-10-31 00:00:00', 2, 5, 11),
  ( '2014-10-31 00:00:00', 8, 5, 14),
  ( '2014-10-31 00:00:00', 11, 6, 1),
  ( '2014-10-31 00:00:00', 17, 6, 2),
  ( '2014-10-31 00:00:00', 8, 6, 5),
  ( '2014-10-31 00:00:00', 2, 7, 3),
  ( '2014-10-31 00:00:00', 2, 7, 7),
  ( '2014-10-31 00:00:00', 1, 16, 4),
  ( '2014-10-31 00:00:00', 1, 28, 2),
  ( '2014-10-31 00:00:00', 1, 28, 4),
  ( '2014-10-31 00:00:00', 1, 28, 8),
  ( '2014-10-31 00:00:00', 1, 28, 10),
  ( '2014-10-31 00:00:00', 2, 28, 15),
  ( '2014-11-01 00:00:00', 14, 1, 1),
  ( '2014-11-01 00:00:00', 14, 1, 2),
  ( '2014-11-01 00:00:00', 14, 1, 3),
  ( '2014-11-01 00:00:00', 14, 1, 4),
  ( '2014-11-01 00:00:00', 14, 1, 5),
  ( '2014-11-01 00:00:00', 14, 1, 6),
  ( '2014-11-01 00:00:00', 14, 1, 7),
  ( '2014-11-01 00:00:00', 14, 1, 8),
  ( '2014-11-01 00:00:00', 14, 1, 9),
  ( '2014-11-01 00:00:00', 14, 1, 10),
  ( '2014-11-01 00:00:00', 14, 1, 11),
  ( '2014-11-01 00:00:00', 13, 1, 12),
  ( '2014-11-01 00:00:00', 14, 1, 13),
  ( '2014-11-01 00:00:00', 14, 1, 14),
  ( '2014-11-01 00:00:00', 14, 1, 15),
  ( '2014-11-01 00:00:00', 14, 2, 1),
  ( '2014-11-01 00:00:00', 14, 2, 2),
  ( '2014-11-01 00:00:00', 14, 2, 3),
  ( '2014-11-01 00:00:00', 14, 2, 4),
  ( '2014-11-01 00:00:00', 14, 2, 5),
  ( '2014-11-01 00:00:00', 14, 2, 7),
  ( '2014-11-01 00:00:00', 14, 2, 8),
  ( '2014-11-01 00:00:00', 14, 2, 9),
  ( '2014-11-01 00:00:00', 14, 2, 10),
  ( '2014-11-01 00:00:00', 14, 2, 11),
  ( '2014-11-01 00:00:00', 13, 2, 13),
  ( '2014-11-01 00:00:00', 14, 2, 14),
  ( '2014-11-01 00:00:00', 14, 2, 15),
  ( '2014-11-01 00:00:00', 17, 3, 1),
  ( '2014-11-01 00:00:00', 17, 3, 2),
  ( '2014-11-01 00:00:00', 17, 3, 3),
  ( '2014-11-01 00:00:00', 17, 3, 4),
  ( '2014-11-01 00:00:00', 17, 3, 5),
  ( '2014-11-01 00:00:00', 2, 3, 7),
  ( '2014-11-01 00:00:00', 17, 3, 8),
  ( '2014-11-01 00:00:00', 17, 3, 9),
  ( '2014-11-01 00:00:00', 9, 3, 10),
  ( '2014-11-01 00:00:00', 16, 3, 11),
  ( '2014-11-01 00:00:00', 17, 3, 14),
  ( '2014-11-01 00:00:00', 5, 3, 15),
  ( '2014-11-01 00:00:00', 13, 4, 1),
  ( '2014-11-01 00:00:00', 13, 4, 2),
  ( '2014-11-01 00:00:00', 13, 4, 3),
  ( '2014-11-01 00:00:00', 13, 4, 4),
  ( '2014-11-01 00:00:00', 13, 4, 5),
  ( '2014-11-01 00:00:00', 8, 4, 7),
  ( '2014-11-01 00:00:00', 13, 4, 8),
  ( '2014-11-01 00:00:00', 13, 4, 9),
  ( '2014-11-01 00:00:00', 13, 4, 14),
  ( '2014-11-01 00:00:00', 23, 5, 1),
  ( '2014-11-01 00:00:00', 22, 5, 2),
  ( '2014-11-01 00:00:00', 8, 5, 3),
  ( '2014-11-01 00:00:00', 23, 5, 4),
  ( '2014-11-01 00:00:00', 23, 5, 5),
  ( '2014-11-01 00:00:00', 5, 5, 7),
  ( '2014-11-01 00:00:00', 16, 5, 8),
  ( '2014-11-01 00:00:00', 16, 5, 9),
  ( '2014-11-01 00:00:00', 2, 5, 11),
  ( '2014-11-01 00:00:00', 8, 5, 14),
  ( '2014-11-01 00:00:00', 11, 6, 1),
  ( '2014-11-01 00:00:00', 17, 6, 2),
  ( '2014-11-01 00:00:00', 8, 6, 5),
  ( '2014-11-01 00:00:00', 2, 7, 3),
  ( '2014-11-01 00:00:00', 2, 7, 7),
  ( '2014-11-01 00:00:00', 1, 16, 4),
  ( '2014-11-01 00:00:00', 1, 28, 2),
  ( '2014-11-01 00:00:00', 1, 28, 4),
  ( '2014-11-01 00:00:00', 1, 28, 8),
  ( '2014-11-01 00:00:00', 1, 28, 10),
  ( '2014-11-01 00:00:00', 2, 28, 15),
  ( '2014-11-02 00:00:00', 14, 1, 1),
  ( '2014-11-02 00:00:00', 14, 1, 2),
  ( '2014-11-02 00:00:00', 14, 1, 3),
  ( '2014-11-02 00:00:00', 14, 1, 4),
  ( '2014-11-02 00:00:00', 14, 1, 5),
  ( '2014-11-02 00:00:00', 14, 1, 6),
  ( '2014-11-02 00:00:00', 14, 1, 7),
  ( '2014-11-02 00:00:00', 14, 1, 8),
  ( '2014-11-02 00:00:00', 14, 1, 9),
  ( '2014-11-02 00:00:00', 14, 1, 10),
  ( '2014-11-02 00:00:00', 14, 1, 11),
  ( '2014-11-02 00:00:00', 13, 1, 12),
  ( '2014-11-02 00:00:00', 14, 1, 13),
  ( '2014-11-02 00:00:00', 14, 1, 14),
  ( '2014-11-02 00:00:00', 14, 1, 15),
  ( '2014-11-02 00:00:00', 14, 2, 1),
  ( '2014-11-02 00:00:00', 14, 2, 2),
  ( '2014-11-02 00:00:00', 14, 2, 3),
  ( '2014-11-02 00:00:00', 14, 2, 4),
  ( '2014-11-02 00:00:00', 14, 2, 5),
  ( '2014-11-02 00:00:00', 14, 2, 7),
  ( '2014-11-02 00:00:00', 14, 2, 8),
  ( '2014-11-02 00:00:00', 14, 2, 9),
  ( '2014-11-02 00:00:00', 14, 2, 10),
  ( '2014-11-02 00:00:00', 14, 2, 11),
  ( '2014-11-02 00:00:00', 13, 2, 13),
  ( '2014-11-02 00:00:00', 14, 2, 14),
  ( '2014-11-02 00:00:00', 14, 2, 15),
  ( '2014-11-02 00:00:00', 17, 3, 1),
  ( '2014-11-02 00:00:00', 17, 3, 2),
  ( '2014-11-02 00:00:00', 17, 3, 3),
  ( '2014-11-02 00:00:00', 17, 3, 4),
  ( '2014-11-02 00:00:00', 17, 3, 5),
  ( '2014-11-02 00:00:00', 2, 3, 7),
  ( '2014-11-02 00:00:00', 17, 3, 8),
  ( '2014-11-02 00:00:00', 17, 3, 9),
  ( '2014-11-02 00:00:00', 9, 3, 10),
  ( '2014-11-02 00:00:00', 16, 3, 11),
  ( '2014-11-02 00:00:00', 17, 3, 14),
  ( '2014-11-02 00:00:00', 10, 3, 15),
  ( '2014-11-02 00:00:00', 13, 4, 1),
  ( '2014-11-02 00:00:00', 13, 4, 2),
  ( '2014-11-02 00:00:00', 13, 4, 3),
  ( '2014-11-02 00:00:00', 13, 4, 4),
  ( '2014-11-02 00:00:00', 13, 4, 5),
  ( '2014-11-02 00:00:00', 8, 4, 7),
  ( '2014-11-02 00:00:00', 13, 4, 8),
  ( '2014-11-02 00:00:00', 13, 4, 9),
  ( '2014-11-02 00:00:00', 13, 4, 14),
  ( '2014-11-02 00:00:00', 23, 5, 1),
  ( '2014-11-02 00:00:00', 23, 5, 2),
  ( '2014-11-02 00:00:00', 8, 5, 3),
  ( '2014-11-02 00:00:00', 23, 5, 4),
  ( '2014-11-02 00:00:00', 23, 5, 5),
  ( '2014-11-02 00:00:00', 5, 5, 7),
  ( '2014-11-02 00:00:00', 16, 5, 8),
  ( '2014-11-02 00:00:00', 16, 5, 9),
  ( '2014-11-02 00:00:00', 2, 5, 11),
  ( '2014-11-02 00:00:00', 8, 5, 14),
  ( '2014-11-02 00:00:00', 11, 6, 1),
  ( '2014-11-02 00:00:00', 18, 6, 2),
  ( '2014-11-02 00:00:00', 8, 6, 5),
  ( '2014-11-02 00:00:00', 3, 7, 2),
  ( '2014-11-02 00:00:00', 2, 7, 3),
  ( '2014-11-02 00:00:00', 2, 7, 7),
  ( '2014-11-02 00:00:00', 1, 16, 4),
  ( '2014-11-02 00:00:00', 1, 28, 2),
  ( '2014-11-02 00:00:00', 1, 28, 4),
  ( '2014-11-02 00:00:00', 1, 28, 8),
  ( '2014-11-02 00:00:00', 1, 28, 10),
  ( '2014-11-02 00:00:00', 2, 28, 15);