package com.axaim.dlk.logzka.main

import java.time.Duration
import java.time.temporal.ChronoUnit
import java.util

import org.apache.kafka.clients.consumer.KafkaConsumer

import scala.collection.JavaConverters._

object LogzkaLive extends App {

  import java.util.Properties

  val TOPIC="mylogz"

  val  props = new Properties()
  props.put("bootstrap.servers", "localhost:9092")

  props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
  props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
  props.put("group.id", "something")

  val consumer = new KafkaConsumer[String, String](props)

  consumer.subscribe(util.Collections.singletonList(TOPIC))

  while(true){
    val records=consumer.poll(Duration.of(1, ChronoUnit.DAYS))
    for (record<-records.asScala){
      println(record)
      println(record.value())
    }
  }
}