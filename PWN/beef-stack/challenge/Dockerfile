FROM ubuntu:latest

RUN apt-get update && apt-get install socat libc6-i386 libc6 -y && apt-get clean && rm -rf /var/lib/apt/lists/*

WORKDIR /beef

COPY src/beef-stack /beef/beef-stack
COPY src/flag.txt /flag.txt
COPY src/password /beef/password
COPY entry.sh /entry.sh

RUN chmod +x beef-stack
RUN chmod 444 /flag.txt
RUN chmod +x /entry.sh

CMD ["/entry.sh"]