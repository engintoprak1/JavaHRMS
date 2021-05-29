--
-- PostgreSQL database dump
--

-- Dumped from database version 13.2
-- Dumped by pg_dump version 13.2

-- Started on 2021-05-28 21:07:38

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

DROP DATABASE "Hrms";
--
-- TOC entry 3033 (class 1262 OID 16782)
-- Name: Hrms; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE "Hrms" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Turkish_Turkey.1254';


ALTER DATABASE "Hrms" OWNER TO postgres;

\connect "Hrms"

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 200 (class 1259 OID 16984)
-- Name: employers; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.employers (
    user_id integer NOT NULL,
    company_name character varying(50) NOT NULL,
    web_site character varying(50) NOT NULL,
    phone_number character(11) NOT NULL,
    company_verified boolean NOT NULL
);


ALTER TABLE public.employers OWNER TO postgres;

--
-- TOC entry 205 (class 1259 OID 17071)
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.hibernate_sequence OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 16991)
-- Name: job_positions; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.job_positions (
    id integer NOT NULL,
    position_name character varying NOT NULL
);


ALTER TABLE public.job_positions OWNER TO postgres;

--
-- TOC entry 201 (class 1259 OID 16989)
-- Name: jobPositions_Id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.job_positions ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public."jobPositions_Id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 1501051
    CACHE 1
);


--
-- TOC entry 203 (class 1259 OID 16999)
-- Name: job_seekers; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.job_seekers (
    user_id integer NOT NULL,
    first_name character varying(50) NOT NULL,
    last_name character varying(50) NOT NULL,
    nationality_id character(11) NOT NULL,
    date_of_birth date NOT NULL
);


ALTER TABLE public.job_seekers OWNER TO postgres;

--
-- TOC entry 204 (class 1259 OID 17004)
-- Name: system_employees; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.system_employees (
    user_id integer NOT NULL,
    role character varying NOT NULL
);


ALTER TABLE public.system_employees OWNER TO postgres;

--
-- TOC entry 206 (class 1259 OID 17438)
-- Name: users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.users (
    id integer NOT NULL,
    email character varying(200) NOT NULL,
    password character varying(50) NOT NULL,
    email_verified boolean NOT NULL,
    email_verify_code character varying NOT NULL
);


ALTER TABLE public.users OWNER TO postgres;

--
-- TOC entry 207 (class 1259 OID 17461)
-- Name: users_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.users ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.users_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 1501051
    CACHE 1
);


--
-- TOC entry 3020 (class 0 OID 16984)
-- Dependencies: 200
-- Data for Name: employers; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.employers (user_id, company_name, web_site, phone_number, company_verified) VALUES (4, 'şirket', 'şirket.io', '05425122312', false);
INSERT INTO public.employers (user_id, company_name, web_site, phone_number, company_verified) VALUES (5, 'şirket', 'şirket.io', '05425122312', false);


--
-- TOC entry 3022 (class 0 OID 16991)
-- Dependencies: 202
-- Data for Name: job_positions; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.job_positions (id, position_name) OVERRIDING SYSTEM VALUE VALUES (1, 'Software Developer');
INSERT INTO public.job_positions (id, position_name) OVERRIDING SYSTEM VALUE VALUES (2, 'Software Architect');
INSERT INTO public.job_positions (id, position_name) OVERRIDING SYSTEM VALUE VALUES (4, 'Junior Developer');


--
-- TOC entry 3023 (class 0 OID 16999)
-- Dependencies: 203
-- Data for Name: job_seekers; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.job_seekers (user_id, first_name, last_name, nationality_id, date_of_birth) VALUES (1, 'engin', 'toprak', '12312312312', '2021-05-25');
INSERT INTO public.job_seekers (user_id, first_name, last_name, nationality_id, date_of_birth) VALUES (2, 'engin', 'toprak', '12312312322', '2021-05-25');
INSERT INTO public.job_seekers (user_id, first_name, last_name, nationality_id, date_of_birth) VALUES (3, 'engin', 'toprak', '12313312312', '2021-05-25');
INSERT INTO public.job_seekers (user_id, first_name, last_name, nationality_id, date_of_birth) VALUES (8, 'Engin', 'Toprak', '21212121213', '2021-05-25');


--
-- TOC entry 3024 (class 0 OID 17004)
-- Dependencies: 204
-- Data for Name: system_employees; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3026 (class 0 OID 17438)
-- Dependencies: 206
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.users (id, email, password, email_verified, email_verify_code) OVERRIDING SYSTEM VALUE VALUES (2, 'deneme1@hotmail.com', '123', false, 'e0205b6c-7833-473d-a60c-d245318db673');
INSERT INTO public.users (id, email, password, email_verified, email_verify_code) OVERRIDING SYSTEM VALUE VALUES (3, 'deneme2@hotmail.com', '123', false, 'a90ca8c4-07b3-4823-b393-e60491c623c0');
INSERT INTO public.users (id, email, password, email_verified, email_verify_code) OVERRIDING SYSTEM VALUE VALUES (4, 'şirketemail@hotmail.com', '123', false, '2d2cb75e-d333-4a01-91ba-1de1e4b1532f');
INSERT INTO public.users (id, email, password, email_verified, email_verify_code) OVERRIDING SYSTEM VALUE VALUES (5, 'şirketemail1@hotmail.com', '123', false, '0dfdaff7-f156-4946-997d-0018816f1a5e');
INSERT INTO public.users (id, email, password, email_verified, email_verify_code) OVERRIDING SYSTEM VALUE VALUES (1, 'deneme@hotmail.com', '123', true, 'f8ec8102-ba80-4270-a428-6989c98e70c1');
INSERT INTO public.users (id, email, password, email_verified, email_verify_code) OVERRIDING SYSTEM VALUE VALUES (8, 'engin.toprak41@hotmail.com', '12345', true, 'f54c9aca-c454-434f-916c-1dfd39ac089b');


--
-- TOC entry 3034 (class 0 OID 0)
-- Dependencies: 205
-- Name: hibernate_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.hibernate_sequence', 1, true);


--
-- TOC entry 3035 (class 0 OID 0)
-- Dependencies: 201
-- Name: jobPositions_Id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."jobPositions_Id_seq"', 4, true);


--
-- TOC entry 3036 (class 0 OID 0)
-- Dependencies: 207
-- Name: users_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.users_id_seq', 8, true);


--
-- TOC entry 2876 (class 2606 OID 17040)
-- Name: job_positions UK_employers_PositionName; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.job_positions
    ADD CONSTRAINT "UK_employers_PositionName" UNIQUE (position_name);


--
-- TOC entry 2880 (class 2606 OID 17084)
-- Name: job_seekers UK_job_seekers_nationalty_id; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.job_seekers
    ADD CONSTRAINT "UK_job_seekers_nationalty_id" UNIQUE (nationality_id);


--
-- TOC entry 2874 (class 2606 OID 16988)
-- Name: employers employers_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employers
    ADD CONSTRAINT employers_pkey PRIMARY KEY (user_id);


--
-- TOC entry 2878 (class 2606 OID 16998)
-- Name: job_positions jobPositions_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.job_positions
    ADD CONSTRAINT "jobPositions_pkey" PRIMARY KEY (id);


--
-- TOC entry 2882 (class 2606 OID 17003)
-- Name: job_seekers jobSeekers_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.job_seekers
    ADD CONSTRAINT "jobSeekers_pkey" PRIMARY KEY (user_id);


--
-- TOC entry 2884 (class 2606 OID 17011)
-- Name: system_employees systemEmployees_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.system_employees
    ADD CONSTRAINT "systemEmployees_pkey" PRIMARY KEY (user_id);


--
-- TOC entry 2886 (class 2606 OID 17445)
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


--
-- TOC entry 2887 (class 2606 OID 17446)
-- Name: employers employers_user_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employers
    ADD CONSTRAINT employers_user_id_fkey FOREIGN KEY (user_id) REFERENCES public.users(id);


--
-- TOC entry 2888 (class 2606 OID 17451)
-- Name: job_seekers job_seekers_user_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.job_seekers
    ADD CONSTRAINT job_seekers_user_id_fkey FOREIGN KEY (user_id) REFERENCES public.users(id);


--
-- TOC entry 2889 (class 2606 OID 17456)
-- Name: system_employees system_employees_user_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.system_employees
    ADD CONSTRAINT system_employees_user_id_fkey FOREIGN KEY (user_id) REFERENCES public.users(id);


-- Completed on 2021-05-28 21:07:39

--
-- PostgreSQL database dump complete
--

