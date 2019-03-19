# logzka

sudo kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic mylogz


sudo kafka-console-producer.sh --broker-list localhost:9092 --topic mylogz


sudo kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic mylogz --from-beginning
