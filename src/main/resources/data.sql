INSERT INTO STUDENT (student_id, name, surname, student_number) VALUES
    (1, 'Степан', 'Ярмоленко', 'ВС103644АЕ'),
    (2, 'Петро', 'Кособуцький', 'ТУ147АЕС'),
    (3, 'Роман', 'Бандера', 'СС121212АК');

INSERT INTO DORMITORY (DORMITORY_ID, NUMBER, PRICE) VALUES
    (1, '11', '3000 гривень'),
    (2, '8', '2800 гривень'),
    (3, '7', '2000 гривень');

INSERT INTO ROOM (ROOM_ID, NUMBER, DORMITORY_ID) VALUES
    (1, '606', 1),
    (2, '404', 1);

INSERT INTO ROOM_SLOTS (ROOM_ID, IS_AVAILABLE) VALUES
    (1, true),
    (1, false),
    (1, false),
    (1, true),
    (1, false),
    (1, true),
    (1, true),
    (1, false),
    (2, true),
    (2, true),
    (2, false),
    (2, true),
    (2, false),
    (2, true),
    (2, true),
    (2, true);