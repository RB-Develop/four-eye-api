CREATE TABLE participant
(
    id         int,
    status     varchar,
    first_name varchar,
    last_name  varchar,
    age        int,

    PRIMARY KEY (id, status)
);

CREATE TABLE changes
(
    id             int,
    status         varchar,
    target_table   varchar,
    change         varchar,
    username       varchar,
    approving_user varchar,

    PRIMARY KEY (id)
);