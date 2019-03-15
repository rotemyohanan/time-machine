```javascript
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
```
