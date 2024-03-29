PGDMP     7                    y            clubedaleitura    13.4    13.4 #    �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    49607    clubedaleitura    DATABASE     n   CREATE DATABASE clubedaleitura WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Portuguese_Brazil.1252';
    DROP DATABASE clubedaleitura;
                postgres    false            �            1259    49612 	   seq-amigo    SEQUENCE     t   CREATE SEQUENCE public."seq-amigo"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 "   DROP SEQUENCE public."seq-amigo";
       public          postgres    false            �            1259    49647    amigo    TABLE     �   CREATE TABLE public.amigo (
    idamigo bigint DEFAULT nextval('public."seq-amigo"'::regclass) NOT NULL,
    nome character varying(100) NOT NULL,
    telefone character varying(20)
);
    DROP TABLE public.amigo;
       public         heap    postgres    false    202            �            1259    49610 	   seq-caixa    SEQUENCE     t   CREATE SEQUENCE public."seq-caixa"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 "   DROP SEQUENCE public."seq-caixa";
       public          postgres    false            �            1259    49626    caixa    TABLE     �   CREATE TABLE public.caixa (
    idcaixa bigint DEFAULT nextval('public."seq-caixa"'::regclass) NOT NULL,
    cor character varying(100) NOT NULL
);
    DROP TABLE public.caixa;
       public         heap    postgres    false    201            �            1259    49614    seq-emprestimo    SEQUENCE     y   CREATE SEQUENCE public."seq-emprestimo"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 '   DROP SEQUENCE public."seq-emprestimo";
       public          postgres    false            �            1259    49653 
   emprestimo    TABLE     �   CREATE TABLE public.emprestimo (
    idemprestimo bigint DEFAULT nextval('public."seq-emprestimo"'::regclass) NOT NULL,
    idamigo bigint NOT NULL,
    idrevista bigint NOT NULL,
    dataemprestimo date NOT NULL,
    datadevolucao date
);
    DROP TABLE public.emprestimo;
       public         heap    postgres    false    203            �            1259    49608    seq-revista    SEQUENCE     v   CREATE SEQUENCE public."seq-revista"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 $   DROP SEQUENCE public."seq-revista";
       public          postgres    false            �            1259    49634    revista    TABLE     +  CREATE TABLE public.revista (
    idrevista bigint DEFAULT nextval('public."seq-revista"'::regclass) NOT NULL,
    colecao character varying(100) NOT NULL,
    "num-edicao" bigint NOT NULL,
    "ano-revista" character varying(4),
    disponibilidade boolean NOT NULL,
    idcaixa bigint NOT NULL
);
    DROP TABLE public.revista;
       public         heap    postgres    false    200            �            1259    49616    seq-usuario    SEQUENCE     v   CREATE SEQUENCE public."seq-usuario"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 $   DROP SEQUENCE public."seq-usuario";
       public          postgres    false            �            1259    49618    usuario    TABLE     �   CREATE TABLE public.usuario (
    idusuario bigint DEFAULT nextval('public."seq-usuario"'::regclass) NOT NULL,
    usuario character varying(40) NOT NULL,
    senha character varying(20) NOT NULL
);
    DROP TABLE public.usuario;
       public         heap    postgres    false    204            �          0    49647    amigo 
   TABLE DATA           8   COPY public.amigo (idamigo, nome, telefone) FROM stdin;
    public          postgres    false    208   �&       �          0    49626    caixa 
   TABLE DATA           -   COPY public.caixa (idcaixa, cor) FROM stdin;
    public          postgres    false    206   �&       �          0    49653 
   emprestimo 
   TABLE DATA           e   COPY public.emprestimo (idemprestimo, idamigo, idrevista, dataemprestimo, datadevolucao) FROM stdin;
    public          postgres    false    209   '       �          0    49634    revista 
   TABLE DATA           l   COPY public.revista (idrevista, colecao, "num-edicao", "ano-revista", disponibilidade, idcaixa) FROM stdin;
    public          postgres    false    207   6'       �          0    49618    usuario 
   TABLE DATA           <   COPY public.usuario (idusuario, usuario, senha) FROM stdin;
    public          postgres    false    205   S'       �           0    0 	   seq-amigo    SEQUENCE SET     :   SELECT pg_catalog.setval('public."seq-amigo"', 1, false);
          public          postgres    false    202            �           0    0 	   seq-caixa    SEQUENCE SET     :   SELECT pg_catalog.setval('public."seq-caixa"', 1, false);
          public          postgres    false    201            �           0    0    seq-emprestimo    SEQUENCE SET     ?   SELECT pg_catalog.setval('public."seq-emprestimo"', 1, false);
          public          postgres    false    203            �           0    0    seq-revista    SEQUENCE SET     <   SELECT pg_catalog.setval('public."seq-revista"', 1, false);
          public          postgres    false    200            �           0    0    seq-usuario    SEQUENCE SET     ;   SELECT pg_catalog.setval('public."seq-usuario"', 1, true);
          public          postgres    false    204            D           2606    49633    caixa caixa_cor_key 
   CONSTRAINT     M   ALTER TABLE ONLY public.caixa
    ADD CONSTRAINT caixa_cor_key UNIQUE (cor);
 =   ALTER TABLE ONLY public.caixa DROP CONSTRAINT caixa_cor_key;
       public            postgres    false    206            L           2606    49652    amigo pk_amigo 
   CONSTRAINT     Q   ALTER TABLE ONLY public.amigo
    ADD CONSTRAINT pk_amigo PRIMARY KEY (idamigo);
 8   ALTER TABLE ONLY public.amigo DROP CONSTRAINT pk_amigo;
       public            postgres    false    208            F           2606    49631    caixa pk_caixa 
   CONSTRAINT     Q   ALTER TABLE ONLY public.caixa
    ADD CONSTRAINT pk_caixa PRIMARY KEY (idcaixa);
 8   ALTER TABLE ONLY public.caixa DROP CONSTRAINT pk_caixa;
       public            postgres    false    206            N           2606    49658    emprestimo pk_emprestimo 
   CONSTRAINT     t   ALTER TABLE ONLY public.emprestimo
    ADD CONSTRAINT pk_emprestimo PRIMARY KEY (idemprestimo, idamigo, idrevista);
 B   ALTER TABLE ONLY public.emprestimo DROP CONSTRAINT pk_emprestimo;
       public            postgres    false    209    209    209            H           2606    49639    revista pk_revista 
   CONSTRAINT     W   ALTER TABLE ONLY public.revista
    ADD CONSTRAINT pk_revista PRIMARY KEY (idrevista);
 <   ALTER TABLE ONLY public.revista DROP CONSTRAINT pk_revista;
       public            postgres    false    207            @           2606    49623    usuario pk_usuario 
   CONSTRAINT     W   ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT pk_usuario PRIMARY KEY (idusuario);
 <   ALTER TABLE ONLY public.usuario DROP CONSTRAINT pk_usuario;
       public            postgres    false    205            J           2606    49641 &   revista revista_colecao_num-edicao_key 
   CONSTRAINT     t   ALTER TABLE ONLY public.revista
    ADD CONSTRAINT "revista_colecao_num-edicao_key" UNIQUE (colecao, "num-edicao");
 R   ALTER TABLE ONLY public.revista DROP CONSTRAINT "revista_colecao_num-edicao_key";
       public            postgres    false    207    207            B           2606    49625    usuario usuario_usuario_key 
   CONSTRAINT     Y   ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT usuario_usuario_key UNIQUE (usuario);
 E   ALTER TABLE ONLY public.usuario DROP CONSTRAINT usuario_usuario_key;
       public            postgres    false    205            P           2606    49659    emprestimo fk_amigo    FK CONSTRAINT     �   ALTER TABLE ONLY public.emprestimo
    ADD CONSTRAINT fk_amigo FOREIGN KEY (idamigo) REFERENCES public.amigo(idamigo) ON UPDATE CASCADE ON DELETE CASCADE;
 =   ALTER TABLE ONLY public.emprestimo DROP CONSTRAINT fk_amigo;
       public          postgres    false    208    2892    209            O           2606    49642    revista fk_caixa    FK CONSTRAINT     �   ALTER TABLE ONLY public.revista
    ADD CONSTRAINT fk_caixa FOREIGN KEY (idcaixa) REFERENCES public.caixa(idcaixa) ON UPDATE CASCADE ON DELETE CASCADE;
 :   ALTER TABLE ONLY public.revista DROP CONSTRAINT fk_caixa;
       public          postgres    false    207    206    2886            Q           2606    49664    emprestimo fk_revista    FK CONSTRAINT     �   ALTER TABLE ONLY public.emprestimo
    ADD CONSTRAINT fk_revista FOREIGN KEY (idrevista) REFERENCES public.revista(idrevista) ON UPDATE CASCADE ON DELETE CASCADE;
 ?   ALTER TABLE ONLY public.emprestimo DROP CONSTRAINT fk_revista;
       public          postgres    false    209    2888    207            �      x������ � �      �      x������ � �      �      x������ � �      �      x������ � �      �      x�3�LL��̃�\1z\\\ 8Z     