FROM ubuntu:latest

RUN apt-get update && apt-get install -y socat

WORKDIR /leak-char

COPY src/leak-chars .
COPY src/flag.txt /
COPY entry.sh /

RUN chmod +x leak-chars
RUN chmod +x /entry.sh
RUN chmod 444 /flag.txt

CMD ["/entry.sh"]