INSERT INTO POSTS(ID, USER_ID, BODY)
VALUES(7, 3,'A new post on the froum');

UPDATE POSTS
SET BODY = 'To delete'
WHERE ID = 7;

DELETE FROM POSTS
WHERE ID = 7;

COMMIT;

SELECT * FROM POSTS;