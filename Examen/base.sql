--
-- PostgreSQL database dump
--

-- Dumped from database version 13.1
-- Dumped by pg_dump version 13.1

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
-- Name:  Ingredient; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public." Ingredient" (
    "Code" integer NOT NULL,
    "Name" character varying NOT NULL,
    "Measurement" character varying(255) NOT NULL,
    "Amount" integer NOT NULL,
    "Provider" character varying,
    "Photo" bytea,
    "Type" character varying NOT NULL,
    "Cost" real NOT NULL,
    "GOST" character varying,
    "Packaging" integer,
    "Characteristic" character varying
);


ALTER TABLE public." Ingredient" OWNER TO postgres;

--
-- Name: Decoration; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Decoration" (
    "Code" integer NOT NULL,
    "Name" character varying NOT NULL,
    "Measurement" character varying NOT NULL,
    "Amount" integer NOT NULL,
    "Provider" character varying,
    "Photo" bytea,
    "Type" character varying NOT NULL,
    "Cost" real NOT NULL,
    "Weight" real NOT NULL
);


ALTER TABLE public."Decoration" OWNER TO postgres;

--
-- Name: Equipment; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Equipment" (
    "Marking" character varying NOT NULL,
    "Type" character varying NOT NULL,
    "Characteristic" character varying
);


ALTER TABLE public."Equipment" OWNER TO postgres;

--
-- Name: Equipment type; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Equipment type" (
    "Type" character varying NOT NULL
);


ALTER TABLE public."Equipment type" OWNER TO postgres;

--
-- Name: Order; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Order" (
    "Number" integer NOT NULL,
    "Date" date NOT NULL,
    "Name" character varying NOT NULL,
    "Product" character varying NOT NULL,
    " Сustomer" character varying NOT NULL,
    "Manager" character varying,
    "Cost" real,
    "EndDate" date,
    "Photo" bytea
);


ALTER TABLE public."Order" OWNER TO postgres;

--
-- Name: Product; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Product" (
    "Name" character varying NOT NULL,
    "Size" character varying NOT NULL
);


ALTER TABLE public."Product" OWNER TO postgres;

--
-- Name: Provider; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Provider" (
    "Name" character varying NOT NULL,
    "Adress" character varying,
    "Time" integer NOT NULL
);


ALTER TABLE public."Provider" OWNER TO postgres;

--
-- Name: Specification decoration; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Specification decoration" (
    "Product" character varying NOT NULL,
    "Decoration" integer NOT NULL,
    "Amount" integer NOT NULL
);


ALTER TABLE public."Specification decoration" OWNER TO postgres;

--
-- Name: Specification ingredients; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Specification ingredients" (
    "Product" character varying NOT NULL,
    "Ingredient" integer NOT NULL,
    "Amount" integer NOT NULL
);


ALTER TABLE public."Specification ingredients" OWNER TO postgres;

--
-- Name: Specification operation; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Specification operation" (
    "Product" character varying NOT NULL,
    "Operation" character varying NOT NULL,
    "Number" integer NOT NULL,
    "Type" character varying,
    "Time" character varying NOT NULL
);


ALTER TABLE public."Specification operation" OWNER TO postgres;

--
-- Name: Specification semi-finished products; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Specification semi-finished products" (
    "Product" character varying NOT NULL,
    "Semi-finished products" character varying NOT NULL,
    "Amount" integer NOT NULL
);


ALTER TABLE public."Specification semi-finished products" OWNER TO postgres;

--
-- Name: User; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."User" (
    "Login" character(255) NOT NULL,
    "Password" character(255) NOT NULL,
    "Role" character(255) NOT NULL,
    "Name" character varying,
    "Photo" bytea
);


ALTER TABLE public."User" OWNER TO postgres;

--
-- Data for Name:  Ingredient; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public." Ingredient" ("Code", "Name", "Measurement", "Amount", "Provider", "Photo", "Type", "Cost", "GOST", "Packaging", "Characteristic") FROM stdin;
\.


--
-- Data for Name: Decoration; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."Decoration" ("Code", "Name", "Measurement", "Amount", "Provider", "Photo", "Type", "Cost", "Weight") FROM stdin;
\.


--
-- Data for Name: Equipment; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."Equipment" ("Marking", "Type", "Characteristic") FROM stdin;
\.


--
-- Data for Name: Equipment type; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."Equipment type" ("Type") FROM stdin;
\.


--
-- Data for Name: Order; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."Order" ("Number", "Date", "Name", "Product", " Сustomer", "Manager", "Cost", "EndDate", "Photo") FROM stdin;
\.


--
-- Data for Name: Product; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."Product" ("Name", "Size") FROM stdin;
\.


--
-- Data for Name: Provider; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."Provider" ("Name", "Adress", "Time") FROM stdin;
\.


--
-- Data for Name: Specification decoration; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."Specification decoration" ("Product", "Decoration", "Amount") FROM stdin;
\.


--
-- Data for Name: Specification ingredients; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."Specification ingredients" ("Product", "Ingredient", "Amount") FROM stdin;
\.


--
-- Data for Name: Specification operation; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."Specification operation" ("Product", "Operation", "Number", "Type", "Time") FROM stdin;
\.


--
-- Data for Name: Specification semi-finished products; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."Specification semi-finished products" ("Product", "Semi-finished products", "Amount") FROM stdin;
\.


--
-- Data for Name: User; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."User" ("Login", "Password", "Role", "Name", "Photo") FROM stdin;
\.


--
-- Name:  Ingredient  Ingredient_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public." Ingredient"
    ADD CONSTRAINT " Ingredient_pkey" PRIMARY KEY ("Code");


--
-- Name: Decoration Decoration_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Decoration"
    ADD CONSTRAINT "Decoration_pkey" PRIMARY KEY ("Code");


--
-- Name: Equipment type Equipment type_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Equipment type"
    ADD CONSTRAINT "Equipment type_pkey" PRIMARY KEY ("Type");


--
-- Name: Equipment Equipment_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Equipment"
    ADD CONSTRAINT "Equipment_pkey" PRIMARY KEY ("Marking");


--
-- Name: Order Order_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Order"
    ADD CONSTRAINT "Order_pkey" PRIMARY KEY ("Number", "Date");


--
-- Name: Product Product_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Product"
    ADD CONSTRAINT "Product_pkey" PRIMARY KEY ("Name");


--
-- Name: Provider Provider_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Provider"
    ADD CONSTRAINT "Provider_pkey" PRIMARY KEY ("Name");


--
-- Name: Specification decoration Specification decoration_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Specification decoration"
    ADD CONSTRAINT "Specification decoration_pkey" PRIMARY KEY ("Product", "Decoration");


--
-- Name: Specification ingredients Specification ingredients_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Specification ingredients"
    ADD CONSTRAINT "Specification ingredients_pkey" PRIMARY KEY ("Product", "Ingredient");


--
-- Name: Specification operation Specification operation_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Specification operation"
    ADD CONSTRAINT "Specification operation_pkey" PRIMARY KEY ("Product", "Operation", "Number");


--
-- Name: Specification semi-finished products Specification semi-finished products_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Specification semi-finished products"
    ADD CONSTRAINT "Specification semi-finished products_pkey" PRIMARY KEY ("Product", "Semi-finished products");


--
-- Name: User User_Login_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."User"
    ADD CONSTRAINT "User_Login_key" UNIQUE ("Login");


--
-- Name: User User_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."User"
    ADD CONSTRAINT "User_pkey" PRIMARY KEY ("Login", "Password");


--
-- Name: Decoration Provider_key; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Decoration"
    ADD CONSTRAINT "Provider_key" FOREIGN KEY ("Provider") REFERENCES public."Provider"("Name");


--
-- Name: Specification decoration Specification decoration_Decoration_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Specification decoration"
    ADD CONSTRAINT "Specification decoration_Decoration_fkey" FOREIGN KEY ("Decoration") REFERENCES public."Decoration"("Code");


--
-- Name: Specification decoration Specification decoration_Product_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Specification decoration"
    ADD CONSTRAINT "Specification decoration_Product_fkey" FOREIGN KEY ("Product") REFERENCES public."Product"("Name");


--
-- Name: Specification ingredients Specification ingredients_Ingredient_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Specification ingredients"
    ADD CONSTRAINT "Specification ingredients_Ingredient_fkey" FOREIGN KEY ("Ingredient") REFERENCES public." Ingredient"("Code");


--
-- Name: Specification ingredients Specification ingredients_Product_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Specification ingredients"
    ADD CONSTRAINT "Specification ingredients_Product_fkey" FOREIGN KEY ("Product") REFERENCES public."Product"("Name");


--
-- Name: Specification operation Specification operation_Product_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Specification operation"
    ADD CONSTRAINT "Specification operation_Product_fkey" FOREIGN KEY ("Product") REFERENCES public."Product"("Name");


--
-- Name: Specification semi-finished products Specification semi-finished product_Semi-finished products_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Specification semi-finished products"
    ADD CONSTRAINT "Specification semi-finished product_Semi-finished products_fkey" FOREIGN KEY ("Semi-finished products") REFERENCES public."Product"("Name");


--
-- Name: Specification semi-finished products Specification semi-finished products_Product_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Specification semi-finished products"
    ADD CONSTRAINT "Specification semi-finished products_Product_fkey" FOREIGN KEY ("Product") REFERENCES public."Product"("Name");


--
-- Name: Order customer_key; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Order"
    ADD CONSTRAINT customer_key FOREIGN KEY (" Сustomer") REFERENCES public."User"("Login");


--
-- Name: Order manager_key; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Order"
    ADD CONSTRAINT manager_key FOREIGN KEY ("Manager") REFERENCES public."User"("Login");


--
-- Name: Order product_key; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Order"
    ADD CONSTRAINT product_key FOREIGN KEY ("Product") REFERENCES public."Product"("Name");


--
-- Name:  Ingredient provide_key; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public." Ingredient"
    ADD CONSTRAINT provide_key FOREIGN KEY ("Provider") REFERENCES public."Provider"("Name") NOT VALID;


--
-- Name: Equipment type_key; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Equipment"
    ADD CONSTRAINT type_key FOREIGN KEY ("Type") REFERENCES public."Equipment type"("Type");


--
-- PostgreSQL database dump complete
--

