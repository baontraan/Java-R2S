-- Lap 01

use Sales;


insert into employees (last_name, first_name, birth_date, supervisor_id) values 
('Trần Văn An','Nguyễn', '2005-12-28',null),
('Bao An', 'Tran', '2006-12-28',1);

insert into orders (customer_id, employee_id, order_date) values 
(1,1,"2026-08-26 15:31:20");

update orders
set customer_id = 2
where order_id = 1;

-- Lọc ra mã đơn hàng của khách hàng

select c.customer_id, c.customer_name, o.order_id
from customers as c
inner join orders as o on c.customer_id = o.customer_id;

-- Trả về họ tên của người giám sát nhân viên có mã là 2

select *
from employees;

select e1.employee_id, concat(e1.last_name, " ", e1.first_name) as "Employee Name", 
	   e2.employee_id as "Supervisor ID",
       concat(e2.last_name, " ", e2.first_name) as "Supervisor Name"
from employees as e1
inner join employees as e2 on e1.supervisor_id = e2.employee_id;

select *
from customers;

select c1.customer_id, c1.customer_name, c1.country
from customers as c1
inner join customers as c2 on c1.customer_id <> c2.customer_id
where c1.country = c2.country;


select * 
from employees;

select *
from customers;

select *
from orders;

-- Lọc thông tin đơn hàng của khách hàng và thông tin nhân viên phụ trách đơn hàng đó

select o.order_id, c.customer_name,
	   concat(e.last_name, " ", e.first_name) as "Employee Name",
       o.order_date
from customers as c
inner join orders as o on c.customer_id = o.customer_id
inner join employees as e on e.employee_id = o.employee_id;

-- Lap 02

use BikeStores;

select p.product_name, p.list_price, b.brand_name
from products as p
inner join brands as b on b.brand_id = p.brand_id
where p.list_price > 1000;

select c.customer_id, c.first_name, c.last_name, o.order_id, o.order_status
from customers as c
inner join orders as o on c.customer_id = o.customer_id
where o.order_status = 4;

select s1.first_name as "Employee FirstName",
	   s1.last_name as "Employee LastName",
       s1.email as "Employee Email",
       s2.first_name as "Manager FirstName",
       s2.last_name as "Manager LastName",
       s2.email as "Manager Email"
from staffs as s1
left join staffs as s2 on s1.manager_id = s2.staff_id;



select p.product_name, b.brand_name
from products as p
left join brands as b on p.brand_id = b.brand_id;

select p.product_name, p.model_year, b.brand_name
from products as p
inner join brands as b on p.brand_id = b.brand_id
where p.model_year >= 2016;


select oit.order_id, p.product_name, oit.quantity
from order_items as oit
inner join products as p on p.product_id = oit.product_id;



select p.product_name, c.category_name
from products as p
inner join categories as c on p.category_id = c.category_id
where c.category_name = "Mountain Bikes";

select p.product_name, p.list_price, c.category_name, b.brand_name
from products as p
inner join brands as b on p.brand_id = b.brand_id
inner join categories as c on p.category_id = c.category_id
where c.category_name = "Electric Bikes" and p.list_price > 500;


select c.customer_id, c.first_name, c.last_name, o.order_id, o.shipped_date
from customers as c
inner join orders as o on c.customer_id = o.customer_id
where o.shipped_date is null;

select s.store_name, count(o.order_id) as order_count
from stores as s
left join orders as o on o.store_id = s.store_id
group by s.store_name;


select o.order_id, s.first_name, s.last_name, o.order_date
from orders as o
inner join staffs as s on o.staff_id = s.staff_id
where o.store_id = 1;

select concat(c.first_name, " ", c.last_name) as customer_name,
	   o.order_id,
       o.order_date
from customers as c
inner join orders as o on o.customer_id = c.customer_id
where year(o.order_date) = 2016;

select s.first_name, s.last_name, o.order_id, o.order_date
from staffs as s
inner join orders as o on o.staff_id = s.staff_id
where o.order_date >= current_date() - interval 12 month;	




