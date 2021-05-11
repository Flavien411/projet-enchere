/*CREATE DATABASE BDD_ENCHERES
go*/

USE BDD_ENCHERES
GO

CREATE TABLE UTILISATEUR (
    no_utilisateur   INTEGER IDENTITY(1,1) NOT NULL,
    pseudo           VARCHAR(50) NOT NULL,
    nom              VARCHAR(50) NOT NULL,
    prenom           VARCHAR(30) NOT NULL,
    email            VARCHAR(50) NOT NULL,
    telephone        VARCHAR(15),
    rue              VARCHAR(100) NOT NULL,
    code_postal      INTEGER NOT NULL,
    ville            VARCHAR(100) NOT NULL,
    mot_de_passe     VARCHAR(30) NOT NULL,
    credit           INTEGER NOT NULL,
    administrateur   bit NULL
)

ALTER TABLE UTILISATEUR ADD constraint utilisateur_pk PRIMARY KEY (no_utilisateur)


CREATE TABLE ARTICLE_VENDU (
    no_article                    INTEGER IDENTITY(1,1) NOT NULL,
    nom_article                   VARCHAR(30) NOT NULL,
    description                   VARCHAR(300) NOT NULL,
	date_debut_encheres           DATE NOT NULL,
    date_fin_encheres             DATE NOT NULL,
    mise_a_prix                   INTEGER,
    prix_vente                    INTEGER,
	etat_vente					  VARCHAR(30) NOT NULL,
	no_categorie				  INTEGER NOT NULL,
	no_acheteur					  INTEGER NULL,
	no_vendeur					  INTEGER NOT NULL,
)

ALTER TABLE ARTICLE_VENDU ADD constraint article_vendu_pk PRIMARY KEY (no_article)


CREATE TABLE CATEGORIE (
    no_categorie   INTEGER IDENTITY(1,1) NOT NULL,
    libelle        VARCHAR(50) NOT NULL
)

ALTER TABLE CATEGORIE ADD constraint categorie_pk PRIMARY KEY (no_categorie)


CREATE TABLE ENCHERE (
    date_enchere     datetime NOT NULL,
	montant_enchere  INTEGER NOT NULL,
    no_utilisateur   INTEGER NOT NULL,
    no_article       INTEGER NOT NULL,
)

ALTER TABLE ENCHERE ADD constraint enchere_pk PRIMARY KEY (no_utilisateur, no_article)

CREATE TABLE RETRAIT (
	no_article         INTEGER NOT NULL,
    rue              VARCHAR(100) NOT NULL,
    code_postal      VARCHAR(15) NOT NULL,
    ville            VARCHAR(100) NOT NULL
)

ALTER TABLE RETRAIT ADD constraint retrait_pk PRIMARY KEY  (no_article)


/*Foreign keys*/

ALTER TABLE ARTICLE_VENDU
    ADD CONSTRAINT enchere_acheteur_fk FOREIGN KEY ( no_acheteur ) 
		REFERENCES UTILISATEUR ( no_utilisateur )
			ON DELETE NO ACTION 
				ON UPDATE no action 

ALTER TABLE ARTICLE_VENDU
    ADD CONSTRAINT vente_vendeur_fk FOREIGN KEY ( no_vendeur )
        REFERENCES UTILISATEUR ( no_utilisateur )
			ON DELETE NO ACTION 
				ON UPDATE no action 

ALTER TABLE ARTICLE_VENDU
    ADD CONSTRAINT article_vends_categories_fk FOREIGN KEY ( no_categorie )
        REFERENCES categorie ( no_categorie )
			ON DELETE NO ACTION 
			   ON UPDATE no action 

ALTER TABLE ENCHERE
    ADD CONSTRAINT enchere_article_vendu_fk FOREIGN KEY ( no_article )
		REFERENCES ARTICLE_VENDU ( no_article )
			ON DELETE NO ACTION 
				ON UPDATE no action 

ALTER TABLE ENCHERE
    ADD CONSTRAINT enchere_utilisateur_fk FOREIGN KEY ( no_utilisateur )
		REFERENCES UTILISATEUR ( no_utilisateur )
			ON DELETE NO ACTION 
				ON UPDATE no action 

ALTER TABLE RETRAIT
    ADD CONSTRAINT retrait_article_vendu_fk FOREIGN KEY ( no_article )
        REFERENCES ARTICLE_VENDU ( no_article )
			ON DELETE NO ACTION 
				ON UPDATE no action 

