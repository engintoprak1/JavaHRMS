--
-- PostgreSQL database dump
--

-- Dumped from database version 13.2
-- Dumped by pg_dump version 13.2

-- Started on 2021-05-10 02:30:15

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
-- TOC entry 3030 (class 1262 OID 16782)
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
    "UserId" integer NOT NULL,
    "CompanyName" character varying(50) NOT NULL,
    "WebSite" character varying(50) NOT NULL,
    "PhoneNumber" character(11) NOT NULL
);


ALTER TABLE public.employers OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 16991)
-- Name: jobPositions; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."jobPositions" (
    "Id" integer NOT NULL,
    "PositionName" character varying NOT NULL
);


ALTER TABLE public."jobPositions" OWNER TO postgres;

--
-- TOC entry 201 (class 1259 OID 16989)
-- Name: jobPositions_Id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public."jobPositions" ALTER COLUMN "Id" ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public."jobPositions_Id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 1501051
    CACHE 1
);


--
-- TOC entry 203 (class 1259 OID 16999)
-- Name: jobSeekers; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."jobSeekers" (
    "UserId" integer NOT NULL,
    "FirstName" character varying(50) NOT NULL,
    "LastName" character varying(50) NOT NULL,
    "NationalityId" character(11) NOT NULL,
    "DateOfBirth" date NOT NULL
);


ALTER TABLE public."jobSeekers" OWNER TO postgres;

--
-- TOC entry 204 (class 1259 OID 17004)
-- Name: systemEmployees; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."systemEmployees" (
    "UserId" integer NOT NULL,
    "Roles" character varying NOT NULL,
    "CompanyVerified" boolean NOT NULL
);


ALTER TABLE public."systemEmployees" OWNER TO postgres;

--
-- TOC entry 206 (class 1259 OID 17014)
-- Name: users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.users (
    "Id" integer NOT NULL,
    "Email" character varying(50) NOT NULL,
    "Password" character varying NOT NULL,
    "EmailVerified" boolean NOT NULL
);


ALTER TABLE public.users OWNER TO postgres;

--
-- TOC entry 205 (class 1259 OID 17012)
-- Name: users_Id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.users ALTER COLUMN "Id" ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public."users_Id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 1231231
    CACHE 1
);


--
-- TOC entry 3018 (class 0 OID 16984)
-- Dependencies: 200
-- Data for Name: employers; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3020 (class 0 OID 16991)
-- Dependencies: 202
-- Data for Name: jobPositions; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3021 (class 0 OID 16999)
-- Dependencies: 203
-- Data for Name: jobSeekers; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3022 (class 0 OID 17004)
-- Dependencies: 204
-- Data for Name: systemEmployees; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3024 (class 0 OID 17014)
-- Dependencies: 206
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3031 (class 0 OID 0)
-- Dependencies: 201
-- Name: jobPositions_Id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."jobPositions_Id_seq"', 1, false);


--
-- TOC entry 3032 (class 0 OID 0)
-- Dependencies: 205
-- Name: users_Id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."users_Id_seq"', 1, false);


--
-- TOC entry 2882 (class 2606 OID 17038)
-- Name: users UK_Users_Email; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT "UK_Users_Email" UNIQUE ("Email");


--
-- TOC entry 2874 (class 2606 OID 17040)
-- Name: jobPositions UK_employers_PositionName; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."jobPositions"
    ADD CONSTRAINT "UK_employers_PositionName" UNIQUE ("PositionName");


--
-- TOC entry 2872 (class 2606 OID 16988)
-- Name: employers employers_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employers
    ADD CONSTRAINT employers_pkey PRIMARY KEY ("UserId");


--
-- TOC entry 2876 (class 2606 OID 16998)
-- Name: jobPositions jobPositions_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."jobPositions"
    ADD CONSTRAINT "jobPositions_pkey" PRIMARY KEY ("Id");


--
-- TOC entry 2878 (class 2606 OID 17003)
-- Name: jobSeekers jobSeekers_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."jobSeekers"
    ADD CONSTRAINT "jobSeekers_pkey" PRIMARY KEY ("UserId");


--
-- TOC entry 2880 (class 2606 OID 17011)
-- Name: systemEmployees systemEmployees_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."systemEmployees"
    ADD CONSTRAINT "systemEmployees_pkey" PRIMARY KEY ("UserId");


--
-- TOC entry 2884 (class 2606 OID 17021)
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY ("Id");


--
-- TOC entry 2885 (class 2606 OID 17056)
-- Name: employers employers_UserId_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employers
    ADD CONSTRAINT "employers_UserId_fkey" FOREIGN KEY ("UserId") REFERENCES public.users("Id");


--
-- TOC entry 2886 (class 2606 OID 17061)
-- Name: jobSeekers jobSeekers_UserId_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."jobSeekers"
    ADD CONSTRAINT "jobSeekers_UserId_fkey" FOREIGN KEY ("UserId") REFERENCES public.users("Id");


--
-- TOC entry 2887 (class 2606 OID 17051)
-- Name: systemEmployees systemEmployees_UserId_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."systemEmployees"
    ADD CONSTRAINT "systemEmployees_UserId_fkey" FOREIGN KEY ("UserId") REFERENCES public.users("Id");


-- Completed on 2021-05-10 02:30:16

--
-- PostgreSQL database dump complete
--

