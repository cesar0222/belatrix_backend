DROP TABLE IF EXISTS TBL_LOG_VALUES;

CREATE TABLE TBL_LOG_VALUES (
  id INT IDENTITY(1,1)  PRIMARY KEY,
  logMessage VARCHAR(250) NOT NULL,
  logType INTEGER NOT NULL
);