# Mercadona - Supermarché

## Introduction
Mercadona est une application de gestion de supermarché conçue pour faciliter la gestion des produits, les promotions et l'administration des utilisateurs. Ce projet est structuré en une application front-end Angular et une API back-end Spring Boot.

## Fonctionnalités

- **Authentification et autorisation** : Gère les sessions utilisateur et sécurise les routes contre les accès non autorisés.
- **Gestion des utilisateurs** : Permet l'inscription, la modification et la suppression des utilisateurs.
- **CRUD de produits** : API pour créer, lire, mettre à jour et supprimer des informations de produits.
- **Gestion des promotions** : Interface pour gérer les promotions et les offres spéciales.
- **Analytique** : Fournit des statistiques et des analyses sur les données utilisateur et de vente.
- **Sécurité** : Implémente des mesures de sécurité telles que le hachage des mots de passe et la prévention des injections SQL.
- **API RESTful** : Offre une interface RESTful pour une intégration facile avec le frontend ou des services tiers.
- **Intégration de la base de données** : Connecte et gère les transactions avec la base de données.
- **Logs** : Enregistre les activités de l'application pour le débogage et l'audit.
- **Tests** : Comprend des tests unitaires et d'intégration pour assurer la stabilité du code.


## Prérequis
Pour exécuter l'application en local, vous devez avoir installé :
- [Node.js](https://nodejs.org/)
- [Java JDK](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Maven](https://maven.apache.org/)

## Installation
Pour mettre en place l'environnement de développement, suivez ces étapes :

1. Clonez le dépôt: https://github.com/obaran/Mercadona
2. Importez le projet dans votre IDE préféré.
3. Installez les dépendances : `mvn install` (pour Maven).
4. Configurez votre base de données en suivant les instructions spécifiques dans le fichier `src/main/resources/application.properties`.
5. Lancez l'application : `mvn spring-boot:run` ou exécutez l'application via votre IDE.

## Licence

Ce projet est distribué sous la licence MIT. Voir `LICENSE` pour plus d'informations contacter moi par mail Onur Baran :  o.baranonur@gmail.com
