FROM amazoncorretto:21-alpine3.19

WORKDIR /app
# Тут пишется путь к вашему jar файлу, найдите его и убедитесь, что он такой же
ADD build/libs/kotlin-template-1.0.0-SNAPSHOT.jar app.jar

CMD ["java", "-jar", "app.jar"]