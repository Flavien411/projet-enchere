USE BDD_ENCHERES;
GO

BEGIN TRAN T1;

INSERT INTO Utilisateur (pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur)
	VALUES('Popol21', 'Aijon', 'Gilles', 'gil.aijon@gmail.com', '0617283941', 'rue du Maréchal Pétain', '03200', 'Vichy',
			 'FranceInsoumise123', 100, 0);

COMMIT TRAN T1;
ROLLBACK TRAN T1;
