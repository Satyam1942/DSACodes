
SELECT Signups.user_id , 
ROUND(COUNT(CASE WHEN Confirmations.action = 'confirmed' THEN 1 ELSE NULL END)/COUNT(Signups.user_id),2) as confirmation_rate
FROM Signups LEFT JOIN Confirmations ON Signups.user_id = Confirmations.user_id  GROUP BY Signups.user_id ;