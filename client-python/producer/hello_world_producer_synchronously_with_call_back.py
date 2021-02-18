import socket

from confluent_kafka import Producer


def call_back(err, msg):
    if err is not None:
        print("Failed to deliver message: %s: %s" % (str(msg), str(err)))
    else:
        print("Message produced: %s" % (str(msg)))
        print("Topic name : ", msg.topic)
        print("offset  : ", msg.offset)
        print("timestamp  : ", msg.timestamp)


conf = {'bootstrap.servers': "broker-1:19092,broker-2:29092,broker-3:39092",
        'client.id': socket.gethostname()}
producer = Producer(conf)
producer.produce(topic='hello-world-topic', key=None, value="Hello World from Python", callback=call_back)
producer.flush()  # can be used to make writes synchronous.
