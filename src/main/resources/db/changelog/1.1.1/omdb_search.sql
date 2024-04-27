-- liquibase formatted sql
-- changeset aevsyukov_1@edu.hse.ru:1
alter table omdb_search alter column json_data type jsonb using json_data::jsonb;
-- rollback alter table omdb_search rollback alter column json_data;