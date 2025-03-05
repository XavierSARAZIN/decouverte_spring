En guise d'introduction à Springboot, voici les étapes qui nous ont permis de mettre en place notre projet, et d'implementer les premieres fonctionnalités.

Installation de Spring Boot sur IntelliJ Ultimate

Spring Boot est un framework Java permettant de simplifier le développement d’applications basées sur Spring. IntelliJ IDEA Ultimate offre un support avancé pour Spring Boot, facilitant la gestion des dépendances, le développement, et le débogage.

Création d’un nouveau projet Maven avec OpenJDK 21, en ajoutant les dépendances Spring Web et Lombok

Maven est un outil de gestion de projet et de dépendances en Java. Lors de la création d’un projet, OpenJDK 21 est utilisé comme environnement d’exécution, Spring Web permet de développer des applications web et API, tandis que Lombok réduit le code boilerplate en générant automatiquement les getters, setters et autres méthodes courantes. Tomcat, intégré à Spring Boot, sert de serveur local.

Installation et configuration du plugin SonarQube pour l’analyse du code

SonarQube est un outil d’analyse statique qui permet d’évaluer la qualité du code en détectant les bugs, vulnérabilités et mauvaises pratiques. L’intégration dans IntelliJ via un plugin permet d’effectuer ces analyses directement dans l’environnement de développement.

Création d’une API Rest

Une API REST (Representational State Transfer) permet la communication entre applications via le protocole HTTP. En Spring Boot, cela se fait en définissant des contrôleurs REST qui exposent des endpoints permettant l’échange de données sous format JSON.

Exploration des annotations Spring pour la gestion des composants et des dépendances

Spring Boot utilise de nombreuses annotations, comme @RestController, @Service, @Repository, pour gérer automatiquement l’injection de dépendances et la configuration des composants, ce qui réduit la nécessité d’une configuration manuelle.

Intégration de Docker pour déployer une instance MySQL et gérer la base de données

Docker permet de créer des conteneurs isolés pour exécuter des services tels qu’une base de données MySQL. En utilisant un fichier docker-compose.yml, on peut déployer et configurer facilement une instance MySQL accessible par l’application Spring Boot.

Utilisation de Hibernate et Spring Data JPA pour mapper les objets en base de données

Hibernate est un ORM (Object-Relational Mapping) qui permet d’interagir avec une base de données relationnelle en manipulant des objets Java. Spring Data JPA simplifie encore cette interaction en réduisant le code nécessaire pour écrire des requêtes.

Interaction avec la base de données via des DAO (Data Access Objects)

Les DAO sont des classes qui encapsulent l’accès aux données en fournissant des méthodes pour interagir avec la base de données. En Spring, ces DAO sont généralement définis via des interfaces JpaRepository, permettant une gestion simplifiée des requêtes.

Utilisation de JetClient pour tester nos requêtes serveur et le transfert des données avec la BDD

JetClient est un outil permettant d’envoyer des requêtes HTTP pour tester les endpoints d’une API REST. Il est utilisé pour valider le bon fonctionnement des requêtes et vérifier les réponses retournées par le serveur.

Implémentation du mappage et affichage des données dans le navigateur

Les données récupérées depuis la base de données sont souvent converties en objets JSON et affichées dans une interface web, soit via des templates HTML avec Thymeleaf, soit via une application front-end qui consomme l’API REST.

Implémentation des opérations CRUD en Java

CRUD (Create, Read, Update, Delete) désigne les opérations de base pour manipuler les données. En Spring Boot, ces opérations sont implémentées via des services et contrôleurs qui gèrent les requêtes HTTP correspondantes (POST, GET, PUT, DELETE).

Création d’un formulaire HTML / JavaScript pour interagir avec l’API et tester les opérations CRUD

Un formulaire en HTML et JavaScript permet d’envoyer des requêtes à l’API REST pour tester les fonctionnalités CRUD. L’utilisation d’AJAX ou de Fetch API facilite l’envoi de requêtes et l’affichage des réponses dynamiquement sur la page web.
