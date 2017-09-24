CREATE TABLE user (
    id integer NOT NULL AUTO_INCREMENT,
    name varchar(255),
    sex varchar(255),
    PRIMARY KEY (id),
    UNIQUE(name)
);