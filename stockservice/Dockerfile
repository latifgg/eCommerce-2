# OpenJDK 21 tabanlı bir Docker image kullan
FROM openjdk:21-jdk-slim

# Çalışma dizinini belirle
WORKDIR /app

# Micronaut derleme sonrası çıkan JAR dosyasını container içine kopyala
COPY build/libs/stockservice-0.1-all.jar app.jar

# application.properties dosyasını container içine kopyala (Eğer gerekiyorsa)
COPY src/main/resources/application.yml /app/application.yml

# Container başlatıldığında Micronaut uygulamasını çalıştır
ENTRYPOINT ["java", "-jar", "app.jar"]
