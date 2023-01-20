#secure same/exact base image by using SHA256 hash of the image
FROM adoptopenjdk:11-jre-openj9@sha256:db3504a5a4c1572c0879027cf5124a5598318aaecefbb9971d80d9a3ba98b0a5

RUN mkdir /app

#never run container as a root, unless needed.
RUN groupadd javauser && useradd -g javauser -m javauser && chown -R javauser:javauser /app

ARG PACKAGE_NAME
ENV PACKAGE_NAME_ENV $PACKAGE_NAME

WORKDIR '/app'
COPY build/libs/${PACKAGE_NAME_ENV}-1.0.jar /app/

USER javauser

ENV JAVA_OPTS=-Xtune:virtualized -XX:IdleTuningMinIdleWaitTime=30 -Xshareclasses:name=integration_system_scc,cacheDir=/opt/java/.scc,readonly,nonFatal

ENTRYPOINT java ${JAVA_OPTS} -jar /app/${PACKAGE_NAME_ENV}-1.0.jar