import com.google.gson._
import com.rabbitmq.client.{QueueingConsumer, ConnectionFactory}
import java.io.{FileWriter, File}
import java.lang.reflect.Type
import scala._

private class BigDecimalSerializer extends JsonSerializer[BigDecimal] {

  def serialize(src: BigDecimal, typeOfSrc: Type, context: JsonSerializationContext): JsonElement = {
    new JsonPrimitive(src.bigDecimal)
  }
}

private class BigDecimalDeserializer extends JsonDeserializer[BigDecimal] {

  def deserialize(json: JsonElement, typeOfT: Type, context: JsonDeserializationContext): BigDecimal = {
    BigDecimal(json.getAsJsonPrimitive.getAsBigDecimal)
  }
}


object client {

  private val EXCHANGE_NAME = "rtmdd.marketData.CN"

  private val EQUITY_KEY = "marketData.CN.Equities"

  private val FUTURE_KEY = "marketData.CN.Futures"

  private val HOST = "10.20.136.21"

  def main(args: Array[String]) = {

    val factory = new ConnectionFactory
    factory.setHost(HOST)

    val connection = factory.newConnection()
    val channel = connection.createChannel()
    val queueName = channel.queueDeclare().getQueue

    channel.queueBind(queueName, EXCHANGE_NAME, EQUITY_KEY)
    val consumer = new QueueingConsumer(channel)
    channel.basicConsume(queueName, true, consumer)

    println("queue name: " + queueName)
    println("waiting for RabbitMQ messages")

    val builder = new GsonBuilder
    builder.registerTypeAdapter(classOf[BigDecimal], new BigDecimalSerializer)
    builder.registerTypeAdapter(classOf[BigDecimal], new BigDecimalDeserializer)

    val gson = builder.create()

    val message = """"""
    val marketdata = gson.fromJson(message, classOf[MarketData])
    println(marketdata)

    /*
    val file = new File("./check")

    if(file.exists())
      file.delete
    else {
      file.createNewFile()
    }

    val fileWriter = new FileWriter(file)
    */
    /*
    while(true)  {
      val delivery = consumer.nextDelivery()
      val message = new String(delivery.getBody)
      val routingKey = delivery.getEnvelope.getRoutingKey

      if(routingKey == EQUITY_KEY) {
        //fileWriter.write(message.substring(message.indexOf("securityId"), message.indexOf("securityId")+18) + "  ")
        //fileWriter.write(message + "\n")
        //print(message)
        //fileWriter.write(count + "\n")
        println(message)
        val marketdata = gson.fromJson(message, classOf[MarketData])
        println(marketdata)
      }
    }
    */
  }
}
