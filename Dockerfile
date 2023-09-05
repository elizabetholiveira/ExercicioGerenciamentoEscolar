# Imagem Oficial do OpenJDK 11 como base
FROM openjdk:11-jre

# Cópia do arquivo JAR para o contêiner
COPY out/artifacts/gerenciamentoEscolar_jar/gerenciamentoEscolar.jar /app/gerenciamentoEscolar.jar

# Definir o diretório de trabalho como /app
WORKDIR /app

# Expor a porta que o Spring Boot está usando
EXPOSE 8080

# Comando para executar o Spring Boot
CMD ["java", "-jar", "gerenciamentoEscolar.jar"]