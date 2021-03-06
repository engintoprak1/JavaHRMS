PGDMP                         y            Hrms    13.3    13.3 S    8           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            9           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            :           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            ;           1262    16478    Hrms    DATABASE     c   CREATE DATABASE "Hrms" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Turkish_Turkey.1254';
    DROP DATABASE "Hrms";
                postgres    false            ?            1259    16782    cities    TABLE     a   CREATE TABLE public.cities (
    id integer NOT NULL,
    city character varying(50) NOT NULL
);
    DROP TABLE public.cities;
       public         heap    postgres    false            ?            1259    16780    cities_id_seq    SEQUENCE     ?   ALTER TABLE public.cities ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.cities_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 11231231
    CACHE 1
);
            public          postgres    false    211            ?            1259    33224 	   cv_skills    TABLE     ]   CREATE TABLE public.cv_skills (
    skill_id integer NOT NULL,
    cv_id integer NOT NULL
);
    DROP TABLE public.cv_skills;
       public         heap    postgres    false            ?            1259    33164    cvs    TABLE     &  CREATE TABLE public.cvs (
    id integer NOT NULL,
    photo character varying(500) NOT NULL,
    github_address character varying(200) NOT NULL,
    linkedin_address character varying(200) NOT NULL,
    cover_letter character varying(500) NOT NULL,
    github_adress character varying(255)
);
    DROP TABLE public.cvs;
       public         heap    postgres    false            ?            1259    16479 	   employers    TABLE     ?   CREATE TABLE public.employers (
    user_id integer NOT NULL,
    company_name character varying(50) NOT NULL,
    web_site character varying(50) NOT NULL,
    phone_number character(11) NOT NULL,
    company_verified boolean NOT NULL
);
    DROP TABLE public.employers;
       public         heap    postgres    false            ?            1259    33159    foreign_languages    TABLE     ?   CREATE TABLE public.foreign_languages (
    id integer NOT NULL,
    language character varying(100) NOT NULL,
    level integer NOT NULL,
    cv_id integer
);
 %   DROP TABLE public.foreign_languages;
       public         heap    postgres    false            ?            1259    16482    hibernate_sequence    SEQUENCE     {   CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.hibernate_sequence;
       public          postgres    false            ?            1259    16484    job_positions    TABLE     m   CREATE TABLE public.job_positions (
    id integer NOT NULL,
    position_name character varying NOT NULL
);
 !   DROP TABLE public.job_positions;
       public         heap    postgres    false            ?            1259    16490    jobPositions_Id_seq    SEQUENCE     ?   ALTER TABLE public.job_positions ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public."jobPositions_Id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 1501051
    CACHE 1
);
            public          postgres    false    202            ?            1259    16538    job_advertisements    TABLE     ?  CREATE TABLE public.job_advertisements (
    id integer NOT NULL,
    job_position_id integer NOT NULL,
    job_description character varying(250) NOT NULL,
    city_id integer NOT NULL,
    min_salary double precision NOT NULL,
    max_salary double precision NOT NULL,
    open_position_count integer NOT NULL,
    application_deadline date NOT NULL,
    employer_id integer NOT NULL,
    is_active boolean NOT NULL,
    create_date date NOT NULL
);
 &   DROP TABLE public.job_advertisements;
       public         heap    postgres    false            ?            1259    16543    job_advertisement_id_seq    SEQUENCE     ?   ALTER TABLE public.job_advertisements ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.job_advertisement_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 1231313
    CACHE 1
);
            public          postgres    false    208            ?            1259    33154    job_experiences    TABLE     ?   CREATE TABLE public.job_experiences (
    id integer NOT NULL,
    workplace_name character varying(100) NOT NULL,
    "position" character varying(100) NOT NULL,
    start_date date NOT NULL,
    departure_date date,
    cv_id integer
);
 #   DROP TABLE public.job_experiences;
       public         heap    postgres    false            ?            1259    24976    job_seeker_school_departments    TABLE     ?   CREATE TABLE public.job_seeker_school_departments (
    school_department_id integer NOT NULL,
    job_seeker_id integer NOT NULL,
    start_date date NOT NULL,
    graduation_date date,
    job_seeker_school_department_id integer NOT NULL
);
 1   DROP TABLE public.job_seeker_school_departments;
       public         heap    postgres    false            ?            1259    16492    job_seekers    TABLE     ?   CREATE TABLE public.job_seekers (
    user_id integer NOT NULL,
    first_name character varying(50) NOT NULL,
    last_name character varying(50) NOT NULL,
    nationality_id character(11) NOT NULL,
    date_of_birth date NOT NULL,
    cv_id integer
);
    DROP TABLE public.job_seekers;
       public         heap    postgres    false            ?            1259    24967    school_departments    TABLE     ?   CREATE TABLE public.school_departments (
    id integer NOT NULL,
    department_name character varying(100) NOT NULL,
    school_id integer
);
 &   DROP TABLE public.school_departments;
       public         heap    postgres    false            ?            1259    24974    school_departments_id_seq    SEQUENCE     ?   ALTER TABLE public.school_departments ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.school_departments_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 11231231
    CACHE 1
);
            public          postgres    false    213            ?            1259    24962    schools    TABLE     j   CREATE TABLE public.schools (
    id integer NOT NULL,
    school_name character varying(100) NOT NULL
);
    DROP TABLE public.schools;
       public         heap    postgres    false            ?            1259    24970    schools_id_seq    SEQUENCE     ?   ALTER TABLE public.schools ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.schools_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 11231231
    CACHE 1
);
            public          postgres    false    212            ?            1259    33208    skillls    TABLE     c   CREATE TABLE public.skillls (
    id integer NOT NULL,
    name character varying(255) NOT NULL
);
    DROP TABLE public.skillls;
       public         heap    postgres    false            ?            1259    33206    skillls_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.skillls_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.skillls_id_seq;
       public          postgres    false    221            <           0    0    skillls_id_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.skillls_id_seq OWNED BY public.skillls.id;
          public          postgres    false    220            ?            1259    16495    system_employees    TABLE     l   CREATE TABLE public.system_employees (
    user_id integer NOT NULL,
    role character varying NOT NULL
);
 $   DROP TABLE public.system_employees;
       public         heap    postgres    false            ?            1259    16501    users    TABLE     ?   CREATE TABLE public.users (
    id integer NOT NULL,
    email character varying(200) NOT NULL,
    password character varying(50) NOT NULL,
    email_verified boolean NOT NULL,
    email_verify_code character varying NOT NULL
);
    DROP TABLE public.users;
       public         heap    postgres    false            ?            1259    16507    users_id_seq    SEQUENCE     ?   ALTER TABLE public.users ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.users_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 1501051
    CACHE 1
);
            public          postgres    false    206            l           2604    33211 
   skillls id    DEFAULT     h   ALTER TABLE ONLY public.skillls ALTER COLUMN id SET DEFAULT nextval('public.skillls_id_seq'::regclass);
 9   ALTER TABLE public.skillls ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    221    220    221            *          0    16782    cities 
   TABLE DATA                 public          postgres    false    211   ?b       5          0    33224 	   cv_skills 
   TABLE DATA                 public          postgres    false    222   8c       2          0    33164    cvs 
   TABLE DATA                 public          postgres    false    219   Rc                 0    16479 	   employers 
   TABLE DATA                 public          postgres    false    200   lc       1          0    33159    foreign_languages 
   TABLE DATA                 public          postgres    false    218   Ed       '          0    16538    job_advertisements 
   TABLE DATA                 public          postgres    false    208   _d       0          0    33154    job_experiences 
   TABLE DATA                 public          postgres    false    217   ?e       !          0    16484    job_positions 
   TABLE DATA                 public          postgres    false    202   ?e       /          0    24976    job_seeker_school_departments 
   TABLE DATA                 public          postgres    false    216   Ff       #          0    16492    job_seekers 
   TABLE DATA                 public          postgres    false    204   `f       ,          0    24967    school_departments 
   TABLE DATA                 public          postgres    false    213   )g       +          0    24962    schools 
   TABLE DATA                 public          postgres    false    212   Cg       4          0    33208    skillls 
   TABLE DATA                 public          postgres    false    221   ]g       $          0    16495    system_employees 
   TABLE DATA                 public          postgres    false    205   wg       %          0    16501    users 
   TABLE DATA                 public          postgres    false    206   ?g       =           0    0    cities_id_seq    SEQUENCE SET     ;   SELECT pg_catalog.setval('public.cities_id_seq', 3, true);
          public          postgres    false    210            >           0    0    hibernate_sequence    SEQUENCE SET     @   SELECT pg_catalog.setval('public.hibernate_sequence', 1, true);
          public          postgres    false    201            ?           0    0    jobPositions_Id_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public."jobPositions_Id_seq"', 6, true);
          public          postgres    false    203            @           0    0    job_advertisement_id_seq    SEQUENCE SET     G   SELECT pg_catalog.setval('public.job_advertisement_id_seq', 15, true);
          public          postgres    false    209            A           0    0    school_departments_id_seq    SEQUENCE SET     H   SELECT pg_catalog.setval('public.school_departments_id_seq', 1, false);
          public          postgres    false    215            B           0    0    schools_id_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('public.schools_id_seq', 1, false);
          public          postgres    false    214            C           0    0    skillls_id_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('public.skillls_id_seq', 1, false);
          public          postgres    false    220            D           0    0    users_id_seq    SEQUENCE SET     ;   SELECT pg_catalog.setval('public.users_id_seq', 12, true);
          public          postgres    false    207            p           2606    16510 '   job_positions UK_employers_PositionName 
   CONSTRAINT     m   ALTER TABLE ONLY public.job_positions
    ADD CONSTRAINT "UK_employers_PositionName" UNIQUE (position_name);
 S   ALTER TABLE ONLY public.job_positions DROP CONSTRAINT "UK_employers_PositionName";
       public            postgres    false    202            t           2606    16512 (   job_seekers UK_job_seekers_nationalty_id 
   CONSTRAINT     o   ALTER TABLE ONLY public.job_seekers
    ADD CONSTRAINT "UK_job_seekers_nationalty_id" UNIQUE (nationality_id);
 T   ALTER TABLE ONLY public.job_seekers DROP CONSTRAINT "UK_job_seekers_nationalty_id";
       public            postgres    false    204            ~           2606    16786    cities cities_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.cities
    ADD CONSTRAINT cities_pkey PRIMARY KEY (id);
 <   ALTER TABLE ONLY public.cities DROP CONSTRAINT cities_pkey;
       public            postgres    false    211            ?           2606    33171    cvs cv_pkey 
   CONSTRAINT     I   ALTER TABLE ONLY public.cvs
    ADD CONSTRAINT cv_pkey PRIMARY KEY (id);
 5   ALTER TABLE ONLY public.cvs DROP CONSTRAINT cv_pkey;
       public            postgres    false    219            ?           2606    33228    cv_skills cv_skills_pkey 
   CONSTRAINT     c   ALTER TABLE ONLY public.cv_skills
    ADD CONSTRAINT cv_skills_pkey PRIMARY KEY (cv_id, skill_id);
 B   ALTER TABLE ONLY public.cv_skills DROP CONSTRAINT cv_skills_pkey;
       public            postgres    false    222    222            n           2606    16514    employers employers_pkey 
   CONSTRAINT     [   ALTER TABLE ONLY public.employers
    ADD CONSTRAINT employers_pkey PRIMARY KEY (user_id);
 B   ALTER TABLE ONLY public.employers DROP CONSTRAINT employers_pkey;
       public            postgres    false    200            ?           2606    33163 '   foreign_languages foreign_language_pkey 
   CONSTRAINT     e   ALTER TABLE ONLY public.foreign_languages
    ADD CONSTRAINT foreign_language_pkey PRIMARY KEY (id);
 Q   ALTER TABLE ONLY public.foreign_languages DROP CONSTRAINT foreign_language_pkey;
       public            postgres    false    218            r           2606    16516    job_positions jobPositions_pkey 
   CONSTRAINT     _   ALTER TABLE ONLY public.job_positions
    ADD CONSTRAINT "jobPositions_pkey" PRIMARY KEY (id);
 K   ALTER TABLE ONLY public.job_positions DROP CONSTRAINT "jobPositions_pkey";
       public            postgres    false    202            v           2606    16518    job_seekers jobSeekers_pkey 
   CONSTRAINT     `   ALTER TABLE ONLY public.job_seekers
    ADD CONSTRAINT "jobSeekers_pkey" PRIMARY KEY (user_id);
 G   ALTER TABLE ONLY public.job_seekers DROP CONSTRAINT "jobSeekers_pkey";
       public            postgres    false    204            |           2606    16542 )   job_advertisements job_advertisement_pkey 
   CONSTRAINT     g   ALTER TABLE ONLY public.job_advertisements
    ADD CONSTRAINT job_advertisement_pkey PRIMARY KEY (id);
 S   ALTER TABLE ONLY public.job_advertisements DROP CONSTRAINT job_advertisement_pkey;
       public            postgres    false    208            ?           2606    33158 $   job_experiences job_experiences_pkey 
   CONSTRAINT     b   ALTER TABLE ONLY public.job_experiences
    ADD CONSTRAINT job_experiences_pkey PRIMARY KEY (id);
 N   ALTER TABLE ONLY public.job_experiences DROP CONSTRAINT job_experiences_pkey;
       public            postgres    false    217            ?           2606    33189 @   job_seeker_school_departments job_seeker_school_departments_pkey 
   CONSTRAINT     ?   ALTER TABLE ONLY public.job_seeker_school_departments
    ADD CONSTRAINT job_seeker_school_departments_pkey PRIMARY KEY (job_seeker_school_department_id);
 j   ALTER TABLE ONLY public.job_seeker_school_departments DROP CONSTRAINT job_seeker_school_departments_pkey;
       public            postgres    false    216            ?           2606    24973 *   school_departments school_departmends_pkey 
   CONSTRAINT     h   ALTER TABLE ONLY public.school_departments
    ADD CONSTRAINT school_departmends_pkey PRIMARY KEY (id);
 T   ALTER TABLE ONLY public.school_departments DROP CONSTRAINT school_departmends_pkey;
       public            postgres    false    213            ?           2606    24966    schools schools_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.schools
    ADD CONSTRAINT schools_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.schools DROP CONSTRAINT schools_pkey;
       public            postgres    false    212            ?           2606    33213    skillls skillls_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.skillls
    ADD CONSTRAINT skillls_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.skillls DROP CONSTRAINT skillls_pkey;
       public            postgres    false    221            x           2606    16520 %   system_employees systemEmployees_pkey 
   CONSTRAINT     j   ALTER TABLE ONLY public.system_employees
    ADD CONSTRAINT "systemEmployees_pkey" PRIMARY KEY (user_id);
 Q   ALTER TABLE ONLY public.system_employees DROP CONSTRAINT "systemEmployees_pkey";
       public            postgres    false    205            z           2606    16522    users users_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.users DROP CONSTRAINT users_pkey;
       public            postgres    false    206            ?           2606    16523     employers employers_user_id_fkey    FK CONSTRAINT        ALTER TABLE ONLY public.employers
    ADD CONSTRAINT employers_user_id_fkey FOREIGN KEY (user_id) REFERENCES public.users(id);
 J   ALTER TABLE ONLY public.employers DROP CONSTRAINT employers_user_id_fkey;
       public          postgres    false    206    2938    200            ?           2606    24989 9   job_seeker_school_departments fk5nwqkvsu1404gj1fh36b8l3an    FK CONSTRAINT     ?   ALTER TABLE ONLY public.job_seeker_school_departments
    ADD CONSTRAINT fk5nwqkvsu1404gj1fh36b8l3an FOREIGN KEY (job_seeker_id) REFERENCES public.job_seekers(user_id);
 c   ALTER TABLE ONLY public.job_seeker_school_departments DROP CONSTRAINT fk5nwqkvsu1404gj1fh36b8l3an;
       public          postgres    false    216    204    2934            ?           2606    25022 9   job_seeker_school_departments fka0na8bsbr1iw2ekbcn3bs797e    FK CONSTRAINT     ?   ALTER TABLE ONLY public.job_seeker_school_departments
    ADD CONSTRAINT fka0na8bsbr1iw2ekbcn3bs797e FOREIGN KEY (school_department_id) REFERENCES public.school_departments(id);
 c   ALTER TABLE ONLY public.job_seeker_school_departments DROP CONSTRAINT fka0na8bsbr1iw2ekbcn3bs797e;
       public          postgres    false    216    2946    213            ?           2606    25027 .   school_departments fkcmuykdrusdjh98n0388uig474    FK CONSTRAINT     ?   ALTER TABLE ONLY public.school_departments
    ADD CONSTRAINT fkcmuykdrusdjh98n0388uig474 FOREIGN KEY (school_id) REFERENCES public.schools(id);
 X   ALTER TABLE ONLY public.school_departments DROP CONSTRAINT fkcmuykdrusdjh98n0388uig474;
       public          postgres    false    2944    212    213            ?           2606    33234 %   cv_skills fkd2scg9kwiyj00a94hx12aqruy    FK CONSTRAINT     ?   ALTER TABLE ONLY public.cv_skills
    ADD CONSTRAINT fkd2scg9kwiyj00a94hx12aqruy FOREIGN KEY (skill_id) REFERENCES public.skillls(id);
 O   ALTER TABLE ONLY public.cv_skills DROP CONSTRAINT fkd2scg9kwiyj00a94hx12aqruy;
       public          postgres    false    221    222    2956            ?           2606    33219 '   job_seekers fkd774iwrhy12ldf3d34o6b2x2r    FK CONSTRAINT     ?   ALTER TABLE ONLY public.job_seekers
    ADD CONSTRAINT fkd774iwrhy12ldf3d34o6b2x2r FOREIGN KEY (cv_id) REFERENCES public.cvs(id);
 Q   ALTER TABLE ONLY public.job_seekers DROP CONSTRAINT fkd774iwrhy12ldf3d34o6b2x2r;
       public          postgres    false    2954    204    219            ?           2606    33229 %   cv_skills fkdlywrwi9o5bi68xfk2ctkmp98    FK CONSTRAINT     ?   ALTER TABLE ONLY public.cv_skills
    ADD CONSTRAINT fkdlywrwi9o5bi68xfk2ctkmp98 FOREIGN KEY (cv_id) REFERENCES public.cvs(id);
 O   ALTER TABLE ONLY public.cv_skills DROP CONSTRAINT fkdlywrwi9o5bi68xfk2ctkmp98;
       public          postgres    false    219    222    2954            ?           2606    33239 -   foreign_languages fkmkew0d4hpevu76nhgdrriywqb    FK CONSTRAINT     ?   ALTER TABLE ONLY public.foreign_languages
    ADD CONSTRAINT fkmkew0d4hpevu76nhgdrriywqb FOREIGN KEY (cv_id) REFERENCES public.cvs(id);
 W   ALTER TABLE ONLY public.foreign_languages DROP CONSTRAINT fkmkew0d4hpevu76nhgdrriywqb;
       public          postgres    false    219    218    2954            ?           2606    33214 +   job_experiences fktrph8jydnco1g0h9c158t1hg9    FK CONSTRAINT     ?   ALTER TABLE ONLY public.job_experiences
    ADD CONSTRAINT fktrph8jydnco1g0h9c158t1hg9 FOREIGN KEY (cv_id) REFERENCES public.cvs(id);
 U   ALTER TABLE ONLY public.job_experiences DROP CONSTRAINT fktrph8jydnco1g0h9c158t1hg9;
       public          postgres    false    217    219    2954            ?           2606    16787 2   job_advertisements job_advertisements_city_id_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.job_advertisements
    ADD CONSTRAINT job_advertisements_city_id_fkey FOREIGN KEY (city_id) REFERENCES public.cities(id) NOT VALID;
 \   ALTER TABLE ONLY public.job_advertisements DROP CONSTRAINT job_advertisements_city_id_fkey;
       public          postgres    false    211    2942    208            ?           2606    16792 6   job_advertisements job_advertisements_employer_id_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.job_advertisements
    ADD CONSTRAINT job_advertisements_employer_id_fkey FOREIGN KEY (employer_id) REFERENCES public.employers(user_id) NOT VALID;
 `   ALTER TABLE ONLY public.job_advertisements DROP CONSTRAINT job_advertisements_employer_id_fkey;
       public          postgres    false    200    208    2926            ?           2606    16775 :   job_advertisements job_advertisements_job_position_id_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.job_advertisements
    ADD CONSTRAINT job_advertisements_job_position_id_fkey FOREIGN KEY (job_position_id) REFERENCES public.job_positions(id) NOT VALID;
 d   ALTER TABLE ONLY public.job_advertisements DROP CONSTRAINT job_advertisements_job_position_id_fkey;
       public          postgres    false    2930    202    208            ?           2606    16528 $   job_seekers job_seekers_user_id_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.job_seekers
    ADD CONSTRAINT job_seekers_user_id_fkey FOREIGN KEY (user_id) REFERENCES public.users(id);
 N   ALTER TABLE ONLY public.job_seekers DROP CONSTRAINT job_seekers_user_id_fkey;
       public          postgres    false    204    206    2938            ?           2606    16533 .   system_employees system_employees_user_id_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.system_employees
    ADD CONSTRAINT system_employees_user_id_fkey FOREIGN KEY (user_id) REFERENCES public.users(id);
 X   ALTER TABLE ONLY public.system_employees DROP CONSTRAINT system_employees_user_id_fkey;
       public          postgres    false    2938    205    206            *   t   x???v
Q???W((M??L?K?,?L-V??L?Q ?+5??\??<]<???#?C\}?}B]!d??????zpbvbQe???5?'5?4?ydCqIb^Ri?L5??TZTv' /PK      5   
   x???          2   
   x???             ?   x????
?@??O17D\sѩC!Һ??D??+?Z?4?E/?W?z?P??f?c?(^m?dM?W??b?T?G???ʔD?d?OyV??S?Z????????Q?[g??Ȱ?a?\?V1X????d??9F??W?h?S??3??z?*????#?+?k??&9?j੩?P?????7p????????????|?C?a<??3      1   
   x???          '     x????J?0F??^tRI?[??+?"?B[?*?$B?MB????)????7????×UV֐??pj?|S?????V?qi?C0s???B??0nh/??Pa'???liI??L??Yi.?nP5H??h???'??#??n??{O??P+F?iω?sc?cV??]^?C?R??o??eV??#???!??c? ?s?x??8?W޺}?????4J???:?????b职$?q??????p????7Iq??.???J?????͏?8?j????      0   
   x???          !   ?   x???v
Q???W((M??L???O?/?/?,???+V??L?Q?q??sS5??\??<]<???#?C\}?}B]!d??????zp~ZIybQ??KjYjN~Aj???5?'-?3B?α(9#?$5??f֙??*???/???̀?Tf????Z?? ??[      /   
   x???          #   ?   x??б
?0?ݧ?M??h?P???AU????M?Q?X??W?I?"w??%ix? J?3?Cъr??
?9o????+**?P?PɞA˖(??d?0??Y??]M??A??.\Oq???l.oB?c0]?X3%???{??y????q????N?É7?$?N??FE8;?ŉ??ȚӲ>>	?J      ,   
   x???          +   
   x???          4   
   x???          $   
   x???          %     x?ŕˊA???????s?^?? ?@\u?&??D?i|_@|/?'&Ɲ??*??n??????L??٢?Lw???Wuv??U?uVi??հں??s???x???:??|??!41?Tw???l?j2}]????????7???q^]?a5?i?։n?6???Ьe?/Sv?]*???W?????? ?	??D?4ܼ???w~B`?#8???  ?/?q??rH
?????(???Z?˴|?yY?Z&????!?%??b?$<I?r???x
c?.g??a?kuD2?T&'S? t??e?}{? ?I?2?? ??`?56X?4??t??|?7?}?m?R\?B?'(R낃 ? ?E.?*q??/h??Ŗ??k7i?{t??q??ߎ???Vt>b?Q]??A?$?V????QX???j?֛????r0?b)#d???J1m\?FUZ??	?Km???L?s???J?c?*????93?6"???=E???op|N?^3???????(?EeAEd,pg?j??~??Z?     