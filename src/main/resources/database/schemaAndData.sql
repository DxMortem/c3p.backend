CREATE SCHEMA c3p AUTHORIZATION c3p;

CREATE TABLE c3p.client
(
    client_id     INT         NOT NULL PRIMARY KEY,
    name          varchar(75) NOT NULL,
    address       varchar(75) NOT NULL,
    phone         varchar(15),
    email         varchar(50) NOT NULL,
    contract_date TIMESTAMP   NOT NULL
);

CREATE TABLE c3p.employee
(
    employee_id INT PRIMARY KEY,
    name        varchar(75)          NOT NULL,
    phone       varchar(15)          NOT NULL,
    hiring_date TIMESTAMP            NOT NULL,
    active      BOOLEAN DEFAULT true NOT NULL
);

CREATE TABLE c3p.activity
(
    activity_id INT PRIMARY KEY,
    name        varchar(50) NOT NULL
);

CREATE TABLE c3p.inspection
(
    inspection_id varchar(36) NOT NULL PRIMARY KEY,
    client        INT REFERENCES c3p.client (client_id),
    employee      INT REFERENCES c3p.employee (employee_id),
    inspector     INT REFERENCES c3p.employee (employee_id),
    start_date    TIMESTAMP,
    finish_date   TIMESTAMP,
    state         varchar(36),
    novelty       BOOLEAN
);

CREATE TABLE c3p.inspection_activity
(
    inspection_activity_id varchar(36) PRIMARY KEY,
    inspection_id          varchar(36) REFERENCES c3p.inspection (inspection_id),
    activity_id            INT REFERENCES c3p.activity (activity_id),
    improvement_action     BOOLEAN,
    comments               varchar(100)

);

GRANT USAGE ON SCHEMA c3p TO c3p;
GRANT SELECT, INSERT, UPDATE, DELETE ON ALL TABLES IN SCHEMA c3p TO c3p;

GRANT USAGE ON SCHEMA c3p TO grafana;
GRANT SELECT ON ALL TABLES IN SCHEMA c3p TO grafana;


INSERT INTO c3p.client
VALUES (1, 'Conjunto el prado', 'av siempre viva 123', '3211231232', 'conjuntoelprado@gmail.com', NOW()),
       (2, 'Conjunto paseo de San Diego', 'av siempre viva 1234', '3211231332', 'conjuntopaseosandiego@gmail.com',
        NOW()),
        (3, 'Torres de Aranjuez', 'av siempre viva 12345', '321123133234', 'torres@gmail.com');

INSERT INTO c3p.employee
VALUES (1, 'Supervisor', '3211231232', NOW(), true),
       (2, 'Aseador', '3211231232', NOW(), true),
       (3, 'Fumigador', '3211231232', NOW(), true),
       (4, 'Conserje', '3211231232', NOW(), true);

INSERT INTO c3p.activity
VALUES (1, 'Shut de basura'),
       (2, 'Torres'),
       (3, 'Porteria'),
       (4, 'Barandas'),
       (5, 'Jardineria'),
       (6, 'Ingreso al conjunto'),
       (7, 'Administracion'),
       (8, 'Parqueaderos'),
       (9, 'Pasillos'),
       (10, 'Zona Verde'),
       (11, 'Puertas'),
       (12, 'Vidrios'),
       (13, 'Salon Comunal'),
       (14, 'Presentacion personal');

INSERT INTO c3p.inspection
VALUES ('23452aa0-46e2-4d9e-b530-c9d49199efc1', 1, 2, 1, NOW(), NULL, 'IN_PROGRESS', FALSE)
     , ('23452aa0-46e2-4d9e-b530-c9d49199efc2', 1, 2, 1, NULL, NULL, 'PROGRAMMED', FALSE)
     , ('23452aa0-46e2-4d9e-b530-c9d49199efc3', 1, 2, 1, NOW() - INTERVAL '1 days', NOW(), 'FINISHED', FALSE)
     , ('23452aa0-46e2-4d9e-b530-c9d49199efc4', 1, 2, 1, NOW() - INTERVAL '3 days', NOW(), 'FINISHED', TRUE)
     , ('23452aa0-46e2-4d9e-b530-c9d49199efc5', 1, 2, 1, NOW() - INTERVAL '4 days', NOW(), 'FINISHED', TRUE);

INSERT INTO c3p.inspection_activity
VALUES ('23452aa0-46e2-4d9e-b530-c9d49199eee1', '23452aa0-46e2-4d9e-b530-c9d49199efc4', 1, TRUE, 'comment'),
       ('23452aa0-46e2-4d9e-b530-c9d49199eee2', '23452aa0-46e2-4d9e-b530-c9d49199efc4', 2, FALSE, NULL),
       ('23452aa0-46e2-4d9e-b530-c9d49199eee3', '23452aa0-46e2-4d9e-b530-c9d49199efc4', 3, FALSE, NULL),
       ('23452aa0-46e2-4d9e-b530-c9d49199eee4', '23452aa0-46e2-4d9e-b530-c9d49199efc5', 1, FALSE, NULL);
