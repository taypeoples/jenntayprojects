BEGIN TRANSACTION;

DROP TABLE IF EXISTS crossword;

CREATE TABLE crossword (
	word_id serial NOT NULL PRIMARY KEY,
	clue varchar(100) NOT NULL,
	word varchar(50) NOT NULL
);

INSERT INTO crossword (clue, word)
VALUES ('Main Character on the Muppets', 'KERMIT'), ('Creator of the Muppets', 'JIMHENSON'), ('Drummer in the Muppets Band', 'ANIMAL');

COMMIT;


