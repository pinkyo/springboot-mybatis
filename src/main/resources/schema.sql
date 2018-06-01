CREATE TABLE user (
    id varchar(36) NOT NULL,
    name varchar(255),
    sex varchar(255),
    PRIMARY KEY (id),
    UNIQUE(name)
);