
```javascsript
SELECT salesorder.order_is
FROM salesorder, customer
WHERE customer.name = 'Florence' AND
      salesorder.customer_id = customr.customer_id;


//Join between tables that are indirectly related


SELECT customer.name AS customer_name,
       employee.name AS employee_name,
       part.name AS part_name
FROM salesorder, customer, employee, part
WHERE salesorder.customer_id = customr.customer_id AND
      salesorder.employee_id = employee.employee_id AND
      salesorder.part_id = part.part_id AND
      salesorder.order_id = 41367;


// DISTINCT keyword - returns only 1 Result
// COUNT - coutns returns the number of the results

SELECT DISTINCT customer.name AS customer_name,
       employee.name AS employee_name,
       part.name AS part_name,
        COUNT(*)
FROM salesorder, customer, employee, part
WHERE salesorder.customer_id = customr.customer_id AND
      salesorder.employee_id = employee.employee_id AND
      salesorder.part_id = part.part_id AND
      salesorder.order_id = 41367;


SELECT
  COUNT(invoice_total) AS number_of_invoices
FROM invoices
WHERE invoice_date > '2019-07-01'



-------------------------------

SELECT
  'First half of 2019' AS date_range
  SUM(invoice_total) AS total_sales
  SUM(payment_total) AS total_payments
  SUM(invoice_total - payment_total) AS what_we_expect
FROM number_of_invoices
WHERE invoice_date BETWEEN '2019-01-01' AND '2019-06-30'
UNION
SELECT
  'Second half of 2019' AS date_range
  SUM(invoice_total) AS total_sales
  SUM(payment_total) AS total_payments
  SUM(invoice_total - payment_total) AS what_we_expect
FROM number_of_invoices
WHERE invoice_date BETWEEN '2019-07-01' AND '2019-12-31'
```
