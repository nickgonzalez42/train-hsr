USE `trainapp`;
INSERT INTO `trains` (`route_id`, `departure_time`, `arrival_time`, `max_capacity`, `current_capacity`)
SELECT
	FLOOR(RAND() * (SELECT MAX(id) FROM `routes`)) + 1 AS `route_id`,
	DATE_ADD(NOW(), INTERVAL FLOOR(RAND() * 365) DAY) + INTERVAL FLOOR(RAND() * 24) HOUR + INTERVAL FLOOR(RAND() * 60) MINUTE AS `departure_time`,
	NULL AS `arrival_time`,
	FLOOR(RAND() * 1300 + 500) AS `max_capacity`,
	NULL AS `current_capacity`
FROM
	`routes` r
CROSS JOIN
	(SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4 UNION ALL SELECT 5) AS t1 -- Adjust the number of rows as needed
CROSS JOIN
	(SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4 UNION ALL SELECT 5) AS t2 -- Adjust the number of rows as needed
LIMIT 10000; -- Specify the number of items you want to generate (e.g., 10)

SET SQL_SAFE_UPDATES = 0;
UPDATE `trains`
SET `arrival_time` = DATE_ADD(`departure_time`, INTERVAL (SELECT `distance` FROM `routes` WHERE `id` = `trains`.`route_id`) / 130 + .5 HOUR)
WHERE `arrival_time` IS NULL;

UPDATE `trains`
SET `current_capacity` = FLOOR(RAND()*(`max_capacity`))
WHERE `current_capacity` IS NULL;
