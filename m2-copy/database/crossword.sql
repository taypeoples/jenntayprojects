BEGIN TRANSACTION;

DROP TABLE IF EXISTS crossword;

CREATE TABLE crossword (
	word_id serial NOT NULL PRIMARY KEY,
	clue varchar(100) NOT NULL,
	word varchar(50) NOT NULL,
	puzzle_id int NOT NULL
);

INSERT INTO crossword (clue, word, puzzle_id)
VALUES ('Main Character on the Muppets', 'KERMIT', 1), ('Creator of the Muppets', 'JIMHENSON', 1), ('Drummer in the Muppets Band', 'ANIMAL', 1), ('Kermits on-again off-again partner', 'MISSPIGGY', 1), ('Actor who played Ebenezer Scrooge in The Muppet Christmas Carol', 'MICHAELCAINE', 1), ('The franchise that purchased The Muppets in 2004', 'DISNEY', 1), ('Television series following toddler versions of the Muppets characters', 'MUPPETBABIES', 1), ('With a long hooked nose this blue daredevil preformed stunts under this name', 'THEGREATGONZO', 1), ('Character named after a landmark Hilton Hotel in New York City', 'STATLER', 1), ('Designer of Miss Piggy', 'BONNIEERICKSON', 1), ('Assistant to Dr. Bunsen Honeydew in the Muppet Labs', 'BEAKER', 1), ('The catchphrase Jozzie Bear uses after a joke', 'WOCKAWOCKA', 1), ('The main antagonist from Muppets Most Wanted', 'CONSTANTINE', 1), ('Name of the town where the muppet boarding house is located in Muppets from Space', 'HENSONVILLE', 1), ('House band of the Muppet Show', 'THEELECTRICMAYHAM', 1), ('Rowlf the dog was made nationally famous on the variety show hosted by this country singer', 'JIMMYDEAN', 1), ('The famous chef of the Muppets originates from this country', 'SWEDEN', 1), ('Number of arms Pepe the King Prawn has', 'FOUR', 1), ('The Muppets got their name from a combination of marionette and one other word', 'PUPPET', 1), ('This song sung by Kermit reached number 25 on the Billboard Hot 100', 'RAINBOWCONNECTION', 1);

COMMIT;



