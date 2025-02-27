# Write your MySQL query statement below
select s1.score as score,
(select count(distinct s2.score)+1 from Scores as s2 where s1.score<s2.score) as 'rank'
from Scores as s1 order by s1.score desc;
