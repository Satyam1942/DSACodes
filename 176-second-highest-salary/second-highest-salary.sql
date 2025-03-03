# Write your MySQL query statement below
select
case
when (select count(distinct salary) from Employee) <= 1 then null
else coalesce(( 
    select e1.salary 
    from (select distinct salary from Employee) e1 left join (select distinct salary from Employee) e2 
    on e1.salary < e2.salary
    group by e1.salary having count(e2.salary) = 1
),0)
end as SecondHighestSalary;
  