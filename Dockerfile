FROM openjdk:8-jdk-alpine
VOLUME /tmp
ENTRYPOINT ["java","-cp","app:app/lib/*","com.ibm.touchlessFG.demo.TouchlessFileGenerationServiceDemoOAuthUserApplication"]