
ALTER SEQUENCE comments_id_seq RESTART WITH 800;
ALTER SEQUENCE conditions_id_seq RESTART WITH 800;



INSERT INTO spots(name, latitude, longitude, facing)
VALUES ('Klitmoeller', 57.0580, 8.4497, 330),
       ('Romo', 55.14984782624461, 8.434518642109415, 230),
       ('Tarifa', 36.01819566049079, -5.643668880250834, 300),
       ('El Gouna', 27.42584857749048, 33.75977917851108, 60),
       ('Vassiliki', 38.62086601021241, 20.59414429573016, 190),
       ('Dakhla',23.680998247694227, -15.885611656837215, 100);


-- INSERT INTO feedbacks(id,spot_id)
-- VALUES (98,1),
--        (99,2);

INSERT INTO users(id, username, password, role)
VALUES (gen_random_uuid(), 'Bert', 'password','USER');

INSERT INTO users(id, username, password, role)
VALUES (gen_random_uuid(), 'Berta', 'password','ADMIN');

INSERT INTO users(id, username, password, role)
VALUES (gen_random_uuid(), 'Bernd', 'password','USER');




INSERT INTO comments(text, user_id, spot_id, date)
SELECT 'What a Spot! Runs best on hight tide!', ID, 1, '2024-06-04' FROM users WHERE username = 'Bert';

INSERT INTO comments(text, user_id,spot_id, date)
SELECT 'Had a blast with NW swell and S Wind!', ID, 2, '2024-06-05' FROM users WHERE username = 'Bert';

-- Kitesurf Session 1
INSERT INTO comments(text, user_id, spot_id, date)
SELECT 'Awesome waves and perfect wind conditions today!', ID, 5, '2024-06-10' FROM users WHERE username = 'Bert';

-- Kitesurf Session 2
INSERT INTO comments(text, user_id, spot_id, date)
SELECT 'Epic jumps and smooth landings at Spot 8!', ID, 4, '2024-06-15' FROM users WHERE username = 'Bert';

-- Kitesurf Session 3
INSERT INTO comments(text, user_id, spot_id, date)
SELECT 'Great time testing new equipment at Spot 12!', ID, 3, '2024-06-20' FROM users WHERE username = 'Bert';

-- Kitesurf Session 4
INSERT INTO comments(text, user_id, spot_id, date)
SELECT 'Wind was on fire at Spot 3 today!', ID, 3, '2024-06-25' FROM users WHERE username = 'Bert';

-- Kitesurf Session 5
INSERT INTO comments(text, user_id, spot_id, date)
SELECT 'Big waves and perfect barrels at Spot 6!', ID, 4, '2024-07-01' FROM users WHERE username = 'Bert';

-- Kitesurf Session 6
INSERT INTO comments(text, user_id, spot_id, date)
SELECT 'Unbelievable sunset session at Spot 10!', ID, 3, '2024-07-07' FROM users WHERE username = 'Bert';

-- Kitesurf Session 7
INSERT INTO comments(text, user_id, spot_id, date)
SELECT 'Perfect conditions for freestyle tricks at Spot 4!', ID, 4, '2024-07-12' FROM users WHERE username = 'Bert';

-- Kitesurf Session 8
INSERT INTO comments(text, user_id, spot_id, date)
SELECT 'Challenging waves made it an exciting session at Spot 7!', ID, 1, '2024-07-18' FROM users WHERE username = 'Bert';

-- Kitesurf Session 9
INSERT INTO comments(text, user_id, spot_id, date)
SELECT 'Enjoyed a long downwinder from Spot 1 to Spot 13!', ID, 1, '2024-07-22' FROM users WHERE username = 'Bert';

-- Kitesurf Session 10
INSERT INTO comments(text, user_id, spot_id, date)
SELECT 'Windy day made for great speed runs at Spot 11!', ID, 4, '2024-07-28' FROM users WHERE username = 'Bert';

-- Kitesurf Session 11
INSERT INTO comments(text, user_id, spot_id, date)
SELECT 'Landed my first kiteloop handle pass at Spot 9!', ID, 5, '2024-08-02' FROM users WHERE username = 'Bert';

-- Kitesurf Session 12
INSERT INTO comments(text, user_id, spot_id, date)
SELECT 'Spectacular jumps during the morning session at Spot 2!', ID, 2, '2024-08-08' FROM users WHERE username = 'Bert';

-- Kitesurf Session 13
INSERT INTO comments(text, user_id, spot_id, date)
SELECT 'Wind was a bit gusty, but still had a fun session at Spot 5!', ID, 5, '2024-08-14' FROM users WHERE username = 'Bert';

-- Kitesurf Session 14
INSERT INTO comments(text, user_id, spot_id, date)
SELECT 'Testing out the new hydrofoil at Spot 8!', ID, 2, '2024-08-20' FROM users WHERE username = 'Bert';

-- Kitesurf Session 15
INSERT INTO comments(text, user_id, spot_id, date)
SELECT 'Great vibes and good company at Spot 12 today!', ID, 2, '2024-08-25' FROM users WHERE username = 'Bert';


INSERT INTO events(name, description, date)
VALUES ('Beginner Workshop', 'learn the Basic',  '2024-06-04'),
       ('Improve your Waterstart', 'Get your ass out of the Water','2024-04-02'),

       ('Advanced Technique', 'Catch that f*** handle', '2024-08-09');

-- INSERT INTO conditions(wind_direction, rating, spot_id)
-- VALUES (110,9,3),
--        (130,9,3),
--        (140,8,3),
--        (290,1,3),
--        (340,1,3),
--        (270,9,1),
--        (270,9,1),
--        (90,0,1),
--        (70,1,1),
--        (180,5,1);

INSERT INTO conditions(wind_direction, wind_speed, rating, spot_id)
VALUES
     (10, 17, 2, 1),
     (20, 15, 6, 1),
     (30, 20, 7, 1),
     (40, 23, 6, 1),
     (50, 30, 0, 1),
     (60, 35, 0, 1),
     (70, 34, 0, 1),
     (80, 20, 0, 1),
     (90, 35, 0, 1),
    (100, 20, 0, 1),
    (110, 25, 0, 1),
    (120, 30, 0, 1),
    (130, 35, 0, 1),
    (140, 40, 0, 1),
    (150, 30, 0, 1),
    (160, 15, 0, 1),
    (170, 35, 0, 1),
    (180, 25, 0, 1),
    (190, 30, 0, 1),
    (200, 15, 0, 1),
    (210, 40, 0, 1),
    (220, 30, 0, 1),
    (230, 25, 4, 1),
    (240, 20, 7, 1),
    (250, 25, 9, 1),
    (260, 30, 8, 1),
    (265, 30, 10, 1),
    (270, 35, 6, 1),
    (272, 35, 10, 1),
    (280, 40, 7, 1),
    (286, 40, 9, 1),
    (290, 20, 5, 1),
    (300, 25, 9, 1),
    (310, 20, 2, 1),
    (320, 25, 9, 1),
    (330, 30, 6, 1),
    (340, 35, 4, 1),
    (350, 40, 7, 1);

INSERT INTO conditions(wind_direction, wind_speed, rating, spot_id)
VALUES
    (10, 17, 2, 2),
    (20, 15, 6, 2),
    (30, 20, 7, 2),
    (40, 23, 6, 2),
    (50, 30, 0, 2),
    (60, 35, 0, 2),
    (70, 34, 0, 2),
    (80, 20, 0, 2),
    (90, 35, 0, 2),
    (100, 20, 0, 2),
    (110, 25, 0, 2),
    (120, 30, 0, 2),
    (130, 35, 0, 2),
    (140, 40, 0, 2),
    (150, 30, 0, 2),
    (160, 15, 0, 2),
    (170, 35, 0, 2),
    (180, 25, 0, 2),
    (190, 30, 0, 2),
    (200, 15, 0, 2),
    (210, 40, 0, 2),
    (220, 30, 0, 2),
    (230, 25, 4, 2),
    (240, 20, 7, 2),
    (250, 25, 9, 2),
    (260, 30, 8, 2),
    (265, 30, 10, 2),
    (270, 35, 6, 2),
    (272, 35, 10, 2),
    (280, 40, 7, 2),
    (286, 40, 9, 2),
    (290, 20, 5, 2),
    (300, 25, 9, 2),
    (310, 20, 2, 2),
    (320, 25, 9, 2),
    (330, 30, 6, 2),
    (340, 35, 4, 2),
    (350, 40, 7, 2);


INSERT INTO conditions(wind_direction, wind_speed, rating, spot_id)
VALUES
    (10, 17, 0, 3),
    (20, 15, 0, 3),
    (30, 20, 0, 3),
    (40, 23, 0, 3),
    (50, 30, 0, 3),
    (60, 35, 0, 3),
    (70, 34, 0, 3),
    (80, 20, 0, 3),
    (90, 35, 0, 3),
    (100, 20, 5, 3),
    (110, 25, 7, 3),
    (120, 30, 7, 3),
    (130, 35, 7, 3),
    (140, 40, 6, 3),
    (150, 30, 6, 3),
    (160, 15, 6, 3),
    (170, 35, 6, 3),
    (180, 25, 6, 3),
    (190, 30, 5, 3),
    (200, 15, 5, 3),
    (210, 40, 4, 3),
    (220, 30, 4, 3),
    (230, 25, 4, 3),
    (240, 20, 4, 3),
    (250, 25, 4, 3),
    (260, 30, 7, 3),
    (270, 35, 7, 3),
    (280, 40, 7, 3),
    (290, 20, 0, 3),
    (300, 25, 0, 3),
    (310, 20, 0, 3),
    (320, 25, 0, 3),
    (330, 30, 0, 3),
    (340, 35, 0, 3),
    (350, 40, 0, 3);

INSERT INTO conditions(wind_direction, wind_speed, rating, spot_id)
VALUES
    (10, 17, 2, 4),
    (20, 15, 6, 4),
    (30, 20, 7, 4),
    (40, 23, 6, 4),
    (50, 30, 0, 4),
    (60, 35, 0, 4),
    (70, 34, 0, 4),
    (80, 20, 0, 4),
    (90, 35, 0, 4),
    (100, 20, 0, 4),
    (110, 25, 0, 4),
    (120, 30, 0, 4),
    (130, 35, 0, 4),
    (140, 40, 0, 4),
    (150, 30, 0, 4),
    (160, 15, 0, 4),
    (170, 35, 0, 4),
    (180, 25, 0, 4),
    (190, 30, 0, 4),
    (200, 15, 0, 4),
    (210, 40, 0, 4),
    (220, 30, 0, 4),
    (230, 25, 4, 4),
    (240, 20, 7, 4),
    (250, 25, 9, 4),
    (260, 30, 8, 4),
    (270, 35, 6, 4),
    (280, 40, 7, 4),
    (290, 20, 5, 4),
    (300, 25, 9, 4),
    (310, 20, 2, 4),
    (320, 25, 9, 4),
    (330, 30, 6, 4),
    (340, 35, 4, 4),
    (350, 40, 7, 4);

INSERT INTO conditions(wind_direction, wind_speed, rating, spot_id)
VALUES
    (10, 17, 0, 5),
    (20, 15, 0, 5),
    (30, 20, 0, 5),
    (40, 23, 0, 5),
    (50, 30, 0, 5),
    (60, 35, 0, 5),
    (70, 34, 0, 5),
    (80, 20, 0, 5),
    (90, 35, 0, 5),
    (100, 20, 5, 5),
    (110, 25, 7, 5),
    (120, 30, 7, 5),
    (130, 35, 7, 5),
    (140, 40, 6, 5),
    (150, 30, 6, 5),
    (160, 15, 6, 5),
    (170, 35, 6, 5),
    (180, 25, 6, 5),
    (190, 30, 5, 5),
    (200, 15, 5, 5),
    (210, 40, 4, 5),
    (220, 30, 4, 5),
    (230, 25, 4, 5),
    (240, 20, 4, 5),
    (250, 25, 4, 5),
    (260, 30, 7, 5),
    (270, 35, 7, 5),
    (280, 40, 7, 5),
    (290, 20, 0, 5),
    (300, 25, 0, 5),
    (310, 20, 0, 5),
    (320, 25, 0, 5),
    (330, 30, 0, 5),
    (340, 35, 0, 5),
    (350, 40, 0, 5);

INSERT INTO conditions(wind_direction, wind_speed, rating, spot_id)
VALUES
    (10, 17, 0, 6),
    (20, 15, 0, 6),
    (30, 20, 0, 6),
    (40, 23, 0, 6),
    (50, 30, 0, 6),
    (60, 35, 0, 6),
    (70, 34, 0, 6),
    (80, 20, 0, 6),
    (90, 35, 0, 6),
    (100, 20, 5, 6),
    (110, 25, 7, 6),
    (120, 30, 7, 6),
    (130, 35, 7, 6),
    (140, 40, 6, 6),
    (150, 30, 6, 6),
    (160, 15, 6, 6),
    (170, 35, 6, 6),
    (180, 25, 6, 6),
    (190, 30, 5, 6),
    (200, 15, 5, 6),
    (210, 40, 4, 6),
    (220, 30, 4, 6),
    (230, 25, 4, 6),
    (240, 20, 4, 6),
    (250, 25, 4, 6),
    (260, 30, 7, 6),
    (270, 35, 7, 6),
    (280, 40, 7, 6),
    (290, 20, 0, 6),
    (300, 25, 0, 6),
    (310, 20, 0, 6),
    (320, 25, 0, 6),
    (330, 30, 0, 6),
    (340, 35, 0, 6),
    (350, 40, 0, 6);


