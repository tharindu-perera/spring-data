FROM ubuntu:latest

RUN apt-get update
RUN apt-get install mongodb-10gen

RUN mkdir -p /data/db

EXPOSE 27017
CMD ["usr/bin/mongod", "--smallfiles"]