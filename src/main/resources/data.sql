INSERT INTO STUDENT (student_id, name, surname, student_number) VALUES
    (1, 'tttt', 'tttt', '228228228228'),
    (2, 'aaaa', 'aaaa', '66666666666'),
    (3, 'vvvvv', 'vvvv', '111111111111');

INSERT INTO DORMITORY (DORMITORY_ID, NUMBER, PRICE) VALUES
    (1, '11', '15000$'),
    (2, '8', '40гривень'),
    (3, '7', '50грн');

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