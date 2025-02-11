# OpenJDK 21 tabanlı bir Docker image kullan
FROM openjdk:21-jdk-slim

# Çalışma dizinini belirle
WORKDIR /app

# Gradle ile derleme yapıldıktan sonra çıkan JAR dosyasını container içine kopyala
COPY build/libs/productservice-0.0.1-SNAPSHOT.jar app.jar

# application.properties dosyasını container içine kopyala
COPY src/main/resources/application.properties /app/application.properties

# Container başlatıldığında Spring Boot uygulamasını çalıştır
ENTRYPOINT ["java", "-jar", "app.jar"]
