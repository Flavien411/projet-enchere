USE BDD_ENCHERES;
GO

BEGIN TRAN T1;

INSERT INTO ARTICLE_VENDU (nom_article, description, date_debut_encheres, date_fin_encheres, mise_a_prix, prix_vente, etat_vente, no_categorie, no_vendeur)
	VALUES('Piano', 'Piano 88 touches noir de marque Steinway, bon état', '2019-12-17', '2019-12-24', 800, 1250, 'Vente en cours',4,1);

COMMIT TRAN T1;
ROLLBACK TRAN T1;