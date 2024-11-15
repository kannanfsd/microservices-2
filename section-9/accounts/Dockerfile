#Start with a base image containing Java runtime
FROM openjdk:17-ea-17-slim

#Information around who maintains the image
#LABEL key="kannanfsd.com"
MAINTAINER kannanfsd.com

#Add the application jar to the image
COPY target/accounts-0.0.1-SNAPSHOT.jar accounts-0.0.1-SNAPSHOT.jar

#execute the application
ENTRYPOINT [ "java", "-jar", "accounts-0.0.1-SNAPSHOT.jar" ]