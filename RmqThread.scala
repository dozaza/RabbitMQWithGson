import com.google.gson.GsonBuilder
import com.rabbitmq.client.{QueueingConsumer, ConnectionFactory}

/**
 * Created with IntelliJ IDEA.
 * System: Ubuntu
 * User: baoan @datayes
 * Date: 9/24/13
 * Time: 2:56 PM
 */
class RmqThread extends Runnable {

  override def run() = {
    val factory = new ConnectionFactory
    factory.setHost(client.HOST)

    val connection = factory.newConnection()
    val channel = connection.createChannel()

    val args = new java.util.HashMap[String, Object];
    args.put("x-max-length", new java.lang.Integer(10000));

    val queueName = channel.queueDeclare(client.QUEUE_NAME, false, false, true, args).getQueue

    channel.queueBind(queueName, client.EXCHANGE_NAME, client.EQUITY_KEY)
    val consumer = new QueueingConsumer(channel)
    channel.basicConsume(queueName, true, consumer)

    println("queue name: " + queueName)
    println("waiting for RabbitMQ messages")


    val builder = new GsonBuilder
    builder.registerTypeAdapter(classOf[BigDecimal], new BigDecimalSerializer)
    builder.registerTypeAdapter(classOf[BigDecimal], new BigDecimalDeserializer)

    val gson = builder.create()
    //val message = """{"XSHE":{"marketMetaData":{"length":392,"timestamp":1379983986,"millisecond":0,"exchangeId":5,"localMillSecond":737,"versionId":0,"localTimestamp":1379983989},"id":"300141","securityId":3444,"name":"????","closingPrice":8.73,"openingPrice":0.0,"tradePrice":0.0,"totalTradeValue":0.0,"highestTradePrice":0.0,"lowestTradePrice":100000.0,"totalTradeQuantity":0,"tradeCount":0,"priceEarningRatio":[28.46,0.0],"priceRisesFall":[0.0,0.0],"contractPosition":0,"bidBook":[{"price":0.0,"amount":0},{"price":0.0,"amount":0},{"price":0.0,"amount":0},{"price":0.0,"amount":0},{"price":0.0,"amount":0}],"askBook":[{"price":0.0,"amount":0},{"price":0.0,"amount":0},{"price":0.0,"amount":0},{"price":0.0,"amount":0},{"price":0.0,"amount":0}]}}"""
    //val marketdata = gson.fromJson(message, classOf[MarketData])
    //println(marketdata)


    /*
    val file = new File("./check")

    if(file.exists())
      file.delete
    else {
      file.createNewFile()
    }

    val fileWriter = new FileWriter(file)
    */

    while(true)  {
      val delivery = consumer.nextDelivery()
      val message = new String(delivery.getBody)
      val routingKey = delivery.getEnvelope.getRoutingKey

      if(routingKey == client.EQUITY_KEY) {
        //fileWriter.write(message.substring(message.indexOf("securityId"), message.indexOf("securityId")+18) + "  ")
        //fileWriter.write(message + "\n")
        client.count += 1
        //if(message.contains("XSHG"))
          //println(message)
        //else
          //println("not XSHG   ")
        //fileWriter.write(count + "\n")
        //println(message)
        //val check = checkIsArray(message)
        //val marketdata = gson.fromJson(check, classOf[MarketData])
        //println(marketdata)
      }
    }
  }

}
