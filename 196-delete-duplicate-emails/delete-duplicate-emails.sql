# Write your MySQL query statement below
delete from Person where id  not in  (select * from (select MIN(id) from Person group by email) as temp);