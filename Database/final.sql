create database sms;

use sms;

create table Customers (
	customer_id int auto_increment primary key,
    customer_name varchar(255) not null
);

create table Employee (
	employee_id int auto_increment primary key,
    employee_name varchar(255) not null,
    salary decimal(10, 2) not null,
    supervisor_id int,
    foreign key(supervisor_id) references Employee(employee_id)
);

create table Product (
	product_id int auto_increment primary key,
    product_name varchar(255) not null,
    list_price decimal(10, 2) not null
);

create table Orders (
	order_id int auto_increment primary key,
    order_date datetime not null,
    customer_id int not null,
    employee_id int not null,
    total decimal(10, 2),
    foreign key(customer_id) references Customers(customer_id),
    foreign key(employee_id) references Employee(employee_id)
);

create table LineItem (
	order_id int not null,
    product_id int not null,
    quantity int not null,
    price decimal(10, 2),
    foreign key(order_id) references Orders(order_id),
    foreign key(product_id) references Product(product_id)
);

insert into Customers(customer_name) values 
	("Dương Ngọc Ý Vy"),
	("Ngô Hữu Bằng"),
	("Nguyễn Hải Đăng");
    
insert into Employee(employee_name, salary, supervisor_id) values
	("Quản lý", 100000.25, null),
    ("Nhân viên bán hàng 1", 45500.00, 1),
    ("Nhân viên bán hàng 2", 40000.00, 1);
    
insert into Product(product_name, list_price) values
	("Máy lạnh Panasonic", 15000.55),
    ("Tủ lạnh Toshiba", 20000.00),
    ("Bộ bàn ghế gỗ", 35500.00);
    
insert into Orders(order_date, customer_id, employee_id, total) values
	("2026-08-27 17:35:30", 1, 2, 15000.55),
    ("2026-08-27 15:00:58", 1, 2, 35500.00),
    ("2026-08-27 16:40:03", 2, 3, 20000.00);
    
insert into LineItem(order_id, product_id, quantity, price) values 
	(7, 1, 1, 15000.55),
    (8, 2, 1, 35500.00),
    (9, 3, 1, 20000.00);

-- 1. Trả về danh sách tất cả khách hàng có trong bảng đơn hàng
-- => Những khách hàng nào chưa mua hàng, sẽ ko có tên trong Orders

select c.customer_id, c.customer_name, o.order_id
from Customers as c
inner join Orders as o on o.customer_id = c.customer_id;

-- 2 Lọc toàn bộ đơn hàng của khách hàng theo customer_id

delimiter //

create procedure sp_getOrdersByCustomerId(in customer_id int)
begin
	select	o.order_id,
			o.order_date,
            o.customer_id,
            o.employee_id,
            o.total
    from Orders as o
    where o.customer_id = customer_id;
end //

delimiter ;

call sp_getOrdersByCustomerId(2);

-- 3 Lọc chi tiết đơn hàng theo id của đơn hàng dc truyền vào

delimiter //

create procedure sp_getLineItemByOrderId(in order_id int)
begin
	select *
    from LineItem as l
    where l.order_id = order_id;
end //

delimiter ;

call sp_getLineItemByOrderId(8);

-- 4 Tính tổng giá trị của đơn hàng theo order id truyền vào

delimiter //

create function fnc_sumOrdersById(order_id int)
returns decimal(10, 2) reads sql data
begin
	declare order_total decimal(10, 2);
    select sum(quantity * price) into order_total
    from LineItem as l
    where l.order_id = order_id;
    return order_total;
end //

delimiter ;

select fnc_sumOrdersById(8);

-- 5 Viết Store Procedure thêm khách hàng vào DB

delimiter //

create procedure sp_addNewCustomer(in customer_name varchar(255))
begin
	insert into Customers(customer_name) values (customer_name);
end //

delimiter ;

call sp_addNewCustomer("Đỗ Lê Hưng Quốc");

select *
from Customers;

-- 6 Xóa khách hàng khỏi DB, đảm bảo xóa luôn đơn hàng và chi tiết đơn hàng của họ (nếu có)

delimiter //

create procedure sp_deleteCustomerAndOurOrders(in customer_id int)
begin
	delete from LineItem
    where order_id in (select order_id from Orders as o where o.customer_id = customer_id);
    
    delete from Orders 
    where o.customer_id = customer_id;
    
    delete from Customers
    where c.customer_id = customer_id;
end //

delimiter ;

call sp_deleteCustomerAndOurOrders(1);

-- 7 Cập nhật thông tin khách hàng

delimiter //

create procedure sp_UpdateCustomerInfoById(in customer_id int, customer_name varchar(255))
begin
	Update Customers as c
    set c.customer_name = customer_name
    where c.customer_id = customer_id;
end //

delimiter ;

call sp_updateCustomerInfoById(4, "Đỗ Lê Hưng Quốc Updated");

-- 8 Tạo order mới vào DB

delimiter //

create procedure sp_createNewOrder(in c_order_date datetime, in c_customer_id int, in c_employee_id int, in c_total decimal(10, 2))
begin
	insert into Orders (order_date, customer_id, employee_id, total) values
    (c_order_date, c_customer_id, c_employee_id, c_total);
end //

delimiter ;

call sp_createNewOrder("2026-08-27 19:15:01", 3, 3, 1870.00);

-- 9 Tạo chi tiết đơn hàng mới trong DB

delimiter //

create procedure sp_createNewLineItem(in l_order_id int, l_product_id int, in l_quantity int, l_price decimal(10, 2))
begin
	insert into LineItem(order_id, product_id, quantity, price) values
    (l_order_id, l_product_id, l_quantity, l_price);
end //

delimiter ;

call sp_createNewLineItem(10, 7, 1, 1870.00);

-- 10 Cập nhật tổng đơn hàng trong DB

delimiter //

create procedure sp_updateOrdersTotalById(in u_order_id int)
begin
	update Orders as o
    set o.total = (select sum(quantity * price) from LineItem as l where l.order_id = u_order_id)
    where o.order_id = u_order_id;
end //

delimiter ;

call sp_updateOrdersTotalById(9);




