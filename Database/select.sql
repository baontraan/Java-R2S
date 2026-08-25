-- Lap01

use Sales;

Insert into customers (customer_name, contact_name, address, city, postal_code, country) values 
	('Trần Bình', 'Trọng', 'Quận 8', 'HCM', 70000, 'VN'), 
	('Tran Bao', 'An', 'Bình Thạnh', 'HCM', 70000, 'VN'), 
	('Tasty', 'Finn', 'Streetroad 19B', 'Liverpool', 'L1 0AA', 'UK');

select * from customers;

select distinct country
from customers;

select *
from customers
where country = "VN";

select country, count(customer_id) as NumberOfCustomers
from customers
group by country;

select country, count(customer_id) as NumberOfCustomers
from customers
group by country
having count(customer_id) >= 2;

select customer_id, customer_name, country
from customers
order by customer_name asc;

-- Lap02

use bikestores;

select first_name, last_name, email
from customers;

select *
from customers
where state = "CA";

select *
from customers
order by first_name asc;

select city, count(customer_id) as customer_count
from customers
where state = "CA"
group by city;

select city, count(customer_id) as customer_count
from customers
where state = "CA"
group by city
having count(customer_id) > 10;

select product_name, model_year
from products
where list_price between 1000 and 2000;

select first_name, email
from staffs
where active = 1;

select product_name, brand_id
from products
where model_year = 2016 and list_price > 1000;

select order_id, customer_id
from orders
where shipped_date is not null;

select product_id, list_price, quantity
from order_items
where discount > 0 and quantity = 2;

select store_id, count(product_id)
from stocks
group by store_id
having count(product_id) > 5
order by count(product_id);

select first_name, last_name, email
from customers
where email like "%@yahoo.com"
order by first_name;

select category_id, avg(list_price) as avg_price 
from products
group by category_id
having avg(list_price) > 500
order by avg(list_price) desc;

select brand_id, count(product_id) as total_products
from products
group by brand_id
having count(product_id) >= 2
order by count(product_id) desc;





