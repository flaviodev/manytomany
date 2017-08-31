
CREATE TABLE tab_anexo (
  id_anexo serial,
  text_nome character varying(100) NOT NULL,
  CONSTRAINT anexo_pk PRIMARY KEY (id_anexo)
);

CREATE TABLE tab_correspondencia (
  id_correspondencia serial,
  text_destinatario character varying(100) NOT NULL,
  CONSTRAINT correspondencia_pk PRIMARY KEY (id_correspondencia)
);

CREATE TABLE tab_registro_movimento (
  id_registro_movimento serial,
  anexo_fk bigint NOT NULL,
  correspondencia_fk bigint NOT NULL,
  CONSTRAINT resgistro_movimento_pk PRIMARY KEY (id_resgistro_movimento),
  CONSTRAINT resgistro_movimento_anexo_fk FOREIGN KEY (anexo_fk)
      REFERENCES tab_anexo (id_anexo) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT resgistro_movimento_correspondencia_fk FOREIGN KEY (correspondencia_fk)
      REFERENCES tab_correspondencia (id_correspondencia) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION      
);
