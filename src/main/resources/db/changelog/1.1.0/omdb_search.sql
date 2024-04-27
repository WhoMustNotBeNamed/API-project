-- liquibase formatted sql
-- changeset aevsyukov_1@edu.hse.ru:1 logicalFilePath:1.1.0/omdb_search.sql
create table omdb_search
(
    id   uuid default gen_random_uuid(),
    title varchar(255),
    year varchar(255),
    json_data text
)
-- rollback delete omdb_search;
