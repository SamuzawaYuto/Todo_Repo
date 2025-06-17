INSERT INTO users (userId, password, userName) VALUES
    ('Admin2025','$2a$12$kKHZF8LrajC7mjj50QF7ruEji6X9nkZHU2DQRkOTEdG07rUvC3heC','Admin');

INSERT INTO todos (title, date, time, area, url, memo, userId) 
VALUES ('買い物', '2023-10-20', '14:00', 'スーパー', 'http://example.com', '牛乳を買う','Admin2025'),
('あいうえお', '1111-11-11', '11:11', 'かきくけこ', 'さしすせそ', 'たちつてと','Admin2025'),
('阿部寛', '1964-06-22', '00:00', '神奈川県横浜市', 'http://abehiroshi.la.coocan.jp/', 'A型','Admin2025');

