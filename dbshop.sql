--
-- PostgreSQL database dump
--

-- Dumped from database version 10.11
-- Dumped by pg_dump version 10.11

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

--
-- Name: shop; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA shop;


ALTER SCHEMA shop OWNER TO postgres;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: authorities; Type: TABLE; Schema: shop; Owner: postgres
--

CREATE TABLE shop.authorities (
    username character varying(50) NOT NULL,
    authority character varying(50) NOT NULL
);


ALTER TABLE shop.authorities OWNER TO postgres;

--
-- Name: order_items; Type: TABLE; Schema: shop; Owner: postgres
--

CREATE TABLE shop.order_items (
    id bigint NOT NULL,
    order_id bigint,
    product_id bigint
);


ALTER TABLE shop.order_items OWNER TO postgres;

--
-- Name: order_items_id_seq; Type: SEQUENCE; Schema: shop; Owner: postgres
--

CREATE SEQUENCE shop.order_items_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE shop.order_items_id_seq OWNER TO postgres;

--
-- Name: order_items_id_seq; Type: SEQUENCE OWNED BY; Schema: shop; Owner: postgres
--

ALTER SEQUENCE shop.order_items_id_seq OWNED BY shop.order_items.id;


--
-- Name: orders; Type: TABLE; Schema: shop; Owner: postgres
--

CREATE TABLE shop.orders (
    id bigint NOT NULL,
    username character varying(50)
);


ALTER TABLE shop.orders OWNER TO postgres;

--
-- Name: orders_id_seq; Type: SEQUENCE; Schema: shop; Owner: postgres
--

CREATE SEQUENCE shop.orders_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE shop.orders_id_seq OWNER TO postgres;

--
-- Name: orders_id_seq; Type: SEQUENCE OWNED BY; Schema: shop; Owner: postgres
--

ALTER SEQUENCE shop.orders_id_seq OWNED BY shop.orders.id;


--
-- Name: products; Type: TABLE; Schema: shop; Owner: postgres
--

CREATE TABLE shop.products (
    id bigint NOT NULL,
    title character varying(255),
    price integer
);


ALTER TABLE shop.products OWNER TO postgres;

--
-- Name: products_id_seq; Type: SEQUENCE; Schema: shop; Owner: postgres
--

CREATE SEQUENCE shop.products_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE shop.products_id_seq OWNER TO postgres;

--
-- Name: products_id_seq; Type: SEQUENCE OWNED BY; Schema: shop; Owner: postgres
--

ALTER SEQUENCE shop.products_id_seq OWNED BY shop.products.id;


--
-- Name: users; Type: TABLE; Schema: shop; Owner: postgres
--

CREATE TABLE shop.users (
    username character varying(50) NOT NULL,
    password character varying(100) NOT NULL,
    enabled boolean NOT NULL
);


ALTER TABLE shop.users OWNER TO postgres;

--
-- Name: order_items id; Type: DEFAULT; Schema: shop; Owner: postgres
--

ALTER TABLE ONLY shop.order_items ALTER COLUMN id SET DEFAULT nextval('shop.order_items_id_seq'::regclass);


--
-- Name: orders id; Type: DEFAULT; Schema: shop; Owner: postgres
--

ALTER TABLE ONLY shop.orders ALTER COLUMN id SET DEFAULT nextval('shop.orders_id_seq'::regclass);


--
-- Name: products id; Type: DEFAULT; Schema: shop; Owner: postgres
--

ALTER TABLE ONLY shop.products ALTER COLUMN id SET DEFAULT nextval('shop.products_id_seq'::regclass);


--
-- Data for Name: authorities; Type: TABLE DATA; Schema: shop; Owner: postgres
--

COPY shop.authorities (username, authority) FROM stdin;
Tim	ROLE_ADMIN
Renat	ROLE_USER
Dina	ROLE_SELLER
\.


--
-- Data for Name: order_items; Type: TABLE DATA; Schema: shop; Owner: postgres
--

COPY shop.order_items (id, order_id, product_id) FROM stdin;
1	1	2
2	1	4
3	1	5
4	2	2
5	2	4
6	3	2
7	3	4
8	4	2
9	4	4
29	13	4
30	13	2
31	13	3
37	16	4
38	16	2
39	17	3
40	17	2
\.


--
-- Data for Name: orders; Type: TABLE DATA; Schema: shop; Owner: postgres
--

COPY shop.orders (id, username) FROM stdin;
1	Renat
2	Tim
3	Renat
4	Tim
13	Renat
16	Tim
17	Tim
\.


--
-- Data for Name: products; Type: TABLE DATA; Schema: shop; Owner: postgres
--

COPY shop.products (id, title, price) FROM stdin;
2	cheese	370
4	bread	39
5	potato	20
3	milk	33
\.


--
-- Data for Name: users; Type: TABLE DATA; Schema: shop; Owner: postgres
--

COPY shop.users (username, password, enabled) FROM stdin;
Dina	{noop}cola	t
Tim	{noop}sir	t
Renat	{noop}far	t
\.


--
-- Name: order_items_id_seq; Type: SEQUENCE SET; Schema: shop; Owner: postgres
--

SELECT pg_catalog.setval('shop.order_items_id_seq', 40, true);


--
-- Name: orders_id_seq; Type: SEQUENCE SET; Schema: shop; Owner: postgres
--

SELECT pg_catalog.setval('shop.orders_id_seq', 17, true);


--
-- Name: products_id_seq; Type: SEQUENCE SET; Schema: shop; Owner: postgres
--

SELECT pg_catalog.setval('shop.products_id_seq', 5, true);


--
-- Name: order_items order_items_pkey; Type: CONSTRAINT; Schema: shop; Owner: postgres
--

ALTER TABLE ONLY shop.order_items
    ADD CONSTRAINT order_items_pkey PRIMARY KEY (id);


--
-- Name: orders orders_pkey; Type: CONSTRAINT; Schema: shop; Owner: postgres
--

ALTER TABLE ONLY shop.orders
    ADD CONSTRAINT orders_pkey PRIMARY KEY (id);


--
-- Name: products products_pkey; Type: CONSTRAINT; Schema: shop; Owner: postgres
--

ALTER TABLE ONLY shop.products
    ADD CONSTRAINT products_pkey PRIMARY KEY (id);


--
-- Name: users users_pkey; Type: CONSTRAINT; Schema: shop; Owner: postgres
--

ALTER TABLE ONLY shop.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (username);


--
-- Name: authorities authorities_username_fkey; Type: FK CONSTRAINT; Schema: shop; Owner: postgres
--

ALTER TABLE ONLY shop.authorities
    ADD CONSTRAINT authorities_username_fkey FOREIGN KEY (username) REFERENCES shop.users(username);


--
-- Name: order_items order_items_order_id_fkey; Type: FK CONSTRAINT; Schema: shop; Owner: postgres
--

ALTER TABLE ONLY shop.order_items
    ADD CONSTRAINT order_items_order_id_fkey FOREIGN KEY (order_id) REFERENCES shop.orders(id);


--
-- Name: order_items order_items_product_id_fkey; Type: FK CONSTRAINT; Schema: shop; Owner: postgres
--

ALTER TABLE ONLY shop.order_items
    ADD CONSTRAINT order_items_product_id_fkey FOREIGN KEY (product_id) REFERENCES shop.products(id);


--
-- PostgreSQL database dump complete
--

