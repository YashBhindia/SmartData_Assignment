SELECT SUM(claimed_charge) AS total_claimed_charge
FROM document
WHERE status = 'EXPORTED';


SELECT d.insured_name, d.insured_address, d.claimed_charge
FROM document d
JOIN batch b ON d.batch_id = b.id
WHERE d.status = 'TO_REPRICE'
AND b.customer_id IN (1, 2);
