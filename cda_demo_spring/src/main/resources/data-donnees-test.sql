INSERT INTO etat (id, nom)
VALUES (1, "neuf"),
       (2, "occasion"),
       (3, "correct");

INSERT INTO etiquette (id, nom)
VALUES (1, "saint valentin"),
       (2, "promo"),
       (3, "noël"),
       (4, "best seller");

INSERT INTO produit (id, nom, code, description, prix, etat_id)
VALUES (1, 'Asus Zenbook A14', 'aza14', 'Ordinateur portable léger avec processeur Snapdragon X Elite', 1299.99, 1),
       (2, 'MSI Vision X AI 2nd', 'msixa2', 'PC de bureau avec écran tactile vertical', 4099.99, 2),
       (3, 'Lenovo Legion Go S', 'llgs', 'Console portable gaming sous SteamOS', 499.99, 3);


INSERT INTO etiquette_produit (produit_id, etiquette_id)
VALUES (1, 1),
       (1, 4),
       (2, 4);
