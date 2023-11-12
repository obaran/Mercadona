# Utiliser une image de base officielle Java avec une JRE.
FROM openjdk:11-jre-slim

# Copier le fichier jar compilé dans l'image.
COPY target/Mercadona-0.0.1-SNAPSHOT.jar app.jar

# Exécuter l'application.
ENTRYPOINT ["java","-jar","/app.jar"]
