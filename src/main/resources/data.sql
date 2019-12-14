INSERT INTO STUDENT (student_id, name, surname, student_number) VALUES
    (1, 'Степан', 'Ярмоленко', 'ВС103644АЕ'),
    (2, 'Петро', 'Кособуцький', 'ТУ147АЕС'),
    (3, 'Роман', 'Бандера', 'СС121212АК'),
    (4, 'test', 'test', 'test');

INSERT INTO DORMITORY (DORMITORY_ID, NUMBER, PRICE) VALUES
    (1, 1, 400.0),
    (2, 2, 500.0);

INSERT INTO ROOM (ROOM_ID, TITLE, DORMITORY_ID) VALUES
    (1, '101a', 1),
    (2, '101b', 1),
    (3, '201a', 2),
    (4, '201b', 2);

INSERT INTO ROOM_SLOTS (ROOM_ID, IS_AVAILABLE) VALUES
    (1, true),
    (1, false),
    (2, true),
    (2, true),
    (3, false),
    (3, false),
    (4, true),
    (4, false);
