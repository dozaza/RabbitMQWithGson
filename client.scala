import com.google.gson._
import com.rabbitmq.client.{QueueingConsumer, ConnectionFactory}
import java.io.{FileWriter, File}
import java.lang.reflect.Type
import marketdata.MarketData
import scala.collection.mutable
import scala._
import scala.runtime.RichInt

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

  val QUEUE_NAME = "PMS_TEST_RMQ_CLIENT"

  val EXCHANGE_NAME = "rtmdd.marketData.CN"

  val EQUITY_KEY = "marketData.CN.Equities"

  val FUTURE_KEY = "marketData.CN.Futures"

  val HOST = "10.20.136.21"

  def checkIsArray(message: String): String = {

    val temp = checkIsArrayImplement(message, """"priceEarningRatio":""")
    val result = checkIsArrayImplement(temp, """"priceRisesFall":""")
    result
  }

  def checkIsArrayImplement(message: String, check: String): String = {
    val posPE = message.indexOf(check)
    if(posPE != -1) {
      val quote = message.indexOf(",", posPE)
      if(message.substring(posPE + check.length, posPE + check.length + 1) != "[") {
        message.substring(0, posPE+check.length) + "[" + message.substring(posPE+check.length, quote) + "]" +
          message.substring(quote)
      }
      else {
        message
      }
    }
    else {
      message
    }
  }

  def startThread() = {
    val rmqt = new RmqThread
    val t = new Thread(rmqt)
    t.start()
  }

  def main(args: Array[String]) = {

    val current = System.currentTimeMillis()/1000;
    val seconds: Long = 1380006191
    val date = new java.util.Date(1380006191L*1000)
    println(date)

    startThread()
  }
}
