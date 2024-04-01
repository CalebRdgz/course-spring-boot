DROP TABLE IF EXISTS "books";
DROP TABLE IF EXISTS "authors";
--create the table 'authors'
CREATE TABLE "authors" (
    "id" bigint DEFAULT nextval('authors_id_seq') NOT NULL,
    "name" text,
    "age" integer,
    CONSTRAINT "authors_pkey" PRIMARY KEY ("id") --constraint = rules to limit the type of data
);
--create the table 'books'
CREATE TABLE "books" (
    "isbn" text NOT NULL,
    "title" text,
    "author_id" bigint,
    CONSTRAINT "books_pkey" PRIMARY KEY ("isbn"), --the isbn is the primary key for this row
    CONSTRAINT "fk_author" FOREIGN KEY (author_id)
    REFERENCES authors(id)
);