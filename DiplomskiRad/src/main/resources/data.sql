INSERT INTO genres (genre_name) 
VALUES 
    ('Roman'),
    ('Triler'),
    ('Drama'),
    ('Naučna fantastika'),
    ('Horor'),
    ('Biografija'),
    ('Komedija'),
    ('Ljubavni');
	

INSERT INTO Authors (author_name, last_name, biography, date_of_birth)
VALUES 
('Ivo', 'Andrić', 'Dobitnik Nobelove nagrade za književnost, autor romana "Na Drini ćuprija".', '1892-10-09'),
('Mesa', 'Selimović', 'Poznat po romanima "Derviš i smrt" i "Tvrđava".', '1910-04-26'),
('Branko', 'Ćopić', 'Pisac romana, pripovedaka i pesama za decu i odrasle.', '1915-01-01');

INSERT INTO Publishers (publisher_name,publisher_city)
VALUES 
('Laguna','Beograd'),
('Vulkan izdavaštvo','Beograd'),
('Dereta','Kragujevac');

INSERT INTO Books (isbn, date_of_publish, title, description, price, discount, picture_path, quantity, author_id, publisher_id)
VALUES 
('978-86-521-1200-5', '1945-01-01', 'Na Drini ćuprija', 'Roman koji opisuje život više generacija u Višegradu.', 1200.00, 0.00, 'assets/books/nadrinicuprija.jpg', 10, 1, 1),

('978-86-7658-100-3', '1966-01-01', 'Derviš i smrt', 'Filozofski roman o sukobu ličnosti i vlasti, unutrašnjim borbama i slobodi.', 1100.00, 10.00, 'assets/books/dervisismrt.jpg', 15, 2, 2),

('978-86-331-2500-9', '1949-01-01', 'Ježeva kućica', 'Omiljena pesma-priča za decu o ježu koji čuva svoj dom.', 800.00, 5.00, 'assets/books/jezevakucica.jpg', 20, 3, 3);




-- Na Drini ćuprija (istorijski, roman)
INSERT INTO Book_Genres (Book_ID, Genre_ID) VALUES (1, 1);

-- Derviš i smrt (filozofski, roman)
INSERT INTO Book_Genres (Book_ID, Genre_ID) VALUES (2, 2);

-- Ježeva kućica (dečija književnost, bajka)
INSERT INTO Book_Genres (Book_ID, Genre_ID) VALUES (3, 3);

-- Dodajemo i da jedna knjiga može imati više žanrova:
INSERT INTO Book_Genres (Book_ID, Genre_ID) VALUES (1, 2);  -- Na Drini ćuprija je i filozofski roman
INSERT INTO Book_Genres (Book_ID, Genre_ID) VALUES (2, 1);  -- Derviš i smrt može biti i istorijski
INSERT INTO Book_Genres (Book_ID, Genre_ID) VALUES (3, 1);  -- Ježeva kućica dobija tag "klasik"
