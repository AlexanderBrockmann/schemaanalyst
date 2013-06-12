DROP TABLE TEST12649;

DROP TABLE STAFF;

CREATE TABLE STAFF 
(
     SALARY  INTEGER,
     EMPNAME CHAR(20),
     GRADE   DECIMAL,
     EMPNUM  CHAR(3) PRIMARY KEY NOT NULL
);

CREATE TABLE TEST12649
(
	TNUM1 NUMERIC(5) NOT NULL,
        TNUM2 NUMERIC(5) NOT NULL,
        TCHAR CHAR(3),
        CONSTRAINT CND12649A PRIMARY KEY(TNUM1, TNUM2),
        CONSTRAINT CND12649B CHECK(TNUM2 > 0),
        CONSTRAINT CND12649C FOREIGN KEY(TCHAR)
        REFERENCES STAFF(EMPNUM)
);