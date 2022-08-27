CREATE TABLE image (
    id              BIGSERIAL   PRIMARY KEY,
    image_name      TEXT        NOT NULL,
    created         TIMESTAMP   NOT NULL,
    image_data      BYTEA       NOT NULL
)
