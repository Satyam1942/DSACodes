# Write your MySQL query statement below
SELECT name 
from Employee as e INNER JOIN (SELECT managerId from Employee  GROUP BY managerId HAVING COUNT(managerId)>=5) as m
ON e.id = m.managerId ; 
