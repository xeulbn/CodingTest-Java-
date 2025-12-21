SELECT user_id, product_id from ONLINE_SALE
group by user_id, product_id HAVING COUNT(*) >= 2 ORDER BY user_id ASC, product_id DESC;