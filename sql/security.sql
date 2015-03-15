-- DROPS
DROP SEQUENCE security.plan_id_seq cascade;
DROP SEQUENCE security.user_id_seq cascade;

DROP TABLE security.plan cascade;
DROP TABLE security.role cascade;
DROP TABLE security."user" cascade;
DROP TABLE security.user_role cascade;

/* CREATE TABLES */

-- PLAN
CREATE TABLE security.plan
(
  id bigserial NOT NULL,
  dt_created timestamp without time zone NOT NULL,
  dt_updated timestamp without time zone NOT NULL,
  user_created bigint,
  user_updated bigint,
  days_for_expire bigint NOT NULL,
  description character varying(256) NOT NULL,
  name character varying(128) NOT NULL,
  value numeric(19,2) NOT NULL,
  CONSTRAINT pk_plan PRIMARY KEY (id)
);

-- ROLE

CREATE TABLE security.role
(
  role character varying(128) NOT NULL,
  dt_created timestamp without time zone NOT NULL,
  dt_updated timestamp without time zone NOT NULL,
  user_created bigint,
  user_updated bigint,
  description character varying(258) NOT NULL,
  CONSTRAINT pk_role PRIMARY KEY (role)
);
-- USER
CREATE TABLE security."user"
(
  id bigserial NOT NULL,
  dt_created timestamp without time zone NOT NULL,
  dt_updated timestamp without time zone NOT NULL,
  user_created bigint,
  user_updated bigint,
  birthday date,
  email character varying(255) NOT NULL,
  dt_last_login timestamp without time zone,
  name character varying(50) NOT NULL,
  password character varying(512) NOT NULL,
  status bigint NOT NULL,
  version bigint,
  id_plan bigint,
  CONSTRAINT pk_user PRIMARY KEY (id),
   CONSTRAINT fk_plan FOREIGN KEY (id_plan)
      REFERENCES security.plan (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT uk_user_email UNIQUE (email)
);



CREATE TABLE security.user_role
(
  id_user bigint NOT NULL,
  id_role character varying(128) NOT NULL,
  CONSTRAINT pk_user_role PRIMARY KEY (id_user, id_role),
  CONSTRAINT fk_user_role_role FOREIGN KEY (id_role)
      REFERENCES security.role (role) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_user_role_user FOREIGN KEY (id_user)
      REFERENCES security."user" (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);

/* INSERTS */

--ROLES
INSERT INTO security.role(
            role, dt_created, dt_updated, user_created, user_updated, description)
    VALUES ('Admin','2013-01-01 00:00:00','2013-01-01 00:00:00',1,1,'Admin Role');
    
INSERT INTO security.role(
            role, dt_created, dt_updated, user_created, user_updated, description)
    VALUES ('Enabled','2013-01-01 00:00:00','2013-01-01 00:00:00',1,1,'Enabled Role');    

INSERT INTO security.role(
            role, dt_created, dt_updated, user_created, user_updated, description)
    VALUES ('Transporte','2013-01-01 00:00:00','2013-01-01 00:00:00',1,1,'Transporte Role');      

-- USER admin@mksdev.com PASSWORD 123 
INSERT INTO security."user"(
            id, dt_created, dt_updated, user_created, user_updated, birthday, 
            email, dt_last_login, name, password, status, version)
    VALUES (1,'2013-01-01 00:00:00','2013-01-01 00:00:00',null,null,'2013-01-01','admin@mksdev.com','2013-08-13 16:19:03.582','Administrador','pmWkWSBCL51Bfkhn79xPuKBKHz//H6B+mY6G9/eieuM=',1,0);

--ENABLE ALL ROLES
INSERT INTO security.user_role(
            id_user, id_role)
    VALUES (1,'Admin');
    
INSERT INTO security.user_role(
            id_user, id_role)
    VALUES (1,'Enabled');
    
INSERT INTO security.user_role(
            id_user, id_role)
    VALUES (1,'Transporte');  


--FIM