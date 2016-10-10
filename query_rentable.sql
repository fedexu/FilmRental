SELECT d.id, 
       d.title, 
       CASE 
         WHEN d.copiesb IS NULL THEN d.copies 
         ELSE (d.copies - d.copiesb)
       END AS e 
FROM   (SELECT * 
        FROM   (SELECT id       AS idb, 
                       title    AS titleb, 
                       b.copies AS CopiesB 
                FROM   videorental.films AS a, 
                       (SELECT filmid, 
                               Count(*) AS Copies 
                        FROM   videorental.rents 
                        WHERE  returned IS NULL 
                        GROUP  BY filmid) AS b 
                WHERE  a.id = b.filmid 
                       AND b.copies < a.copies) AS c 
               RIGHT JOIN (SELECT * FROM Films WHERE approved = 1) as f 
                       ON f.id = c.idb) AS d; 