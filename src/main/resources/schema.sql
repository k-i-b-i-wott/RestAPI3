CREATE TABLE  IF NOT EXISTS Run(
    id INT NOT NULL,
    title varchar(256) NOT NULL,
    started_On TIMESTAMP NOT NULL,
    completed_On TIMESTAMP NOT NULL,
    miles INT NOT NULL,
    location varchar(256) NOT NULL,
    PRIMARY KEY (id)
);