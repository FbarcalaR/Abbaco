USE abbaco;

CREATE TABLE `cashflowsclassifiers` (
  `id` varchar(36) NOT NULL,
  `code` int(11) NOT NULL,
  `name` varchar(40) NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `cashflows` (
  `id` varchar(36) NOT NULL,
  `classificationId` varchar(36) NOT NULL,
  `title` varchar(50) NOT NULL,
  `date` date NOT NULL,
  `amount` decimal(10,2) NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`classificationId`) REFERENCES `cashflowsclassifiers` (`id`)
);
