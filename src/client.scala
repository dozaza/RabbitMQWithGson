import com.google.gson._
import com.rabbitmq.client.{QueueingConsumer, ConnectionFactory}
import java.io.{FileWriter, File}
import java.lang.reflect.Type
import javax.xml.parsers.{DocumentBuilder, DocumentBuilderFactory}
import marketdata.MarketData
import org.w3c.dom.{Element, NodeList, Document}
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

  val EQUITY_KEY = "marketData.CN.Equities2"

  val FUTURE_KEY = "marketData.CN.Futures"

  var HOST = ""

  var count = 0

  private def readConfig(): Unit = {
    val file: File = new File("")
    val strCurrentPath: String = file.getAbsolutePath

    val strXmlpath: String = strCurrentPath + System.getProperty("file.separator") + "config.xml"
    System.out.println("Read " + strXmlpath)

    val factory: DocumentBuilderFactory = DocumentBuilderFactory.newInstance
    val builder: DocumentBuilder = factory.newDocumentBuilder
    val document: Document = builder.parse(new File(strXmlpath))
    val rootElement: Element = document.getDocumentElement

    val list: NodeList = rootElement.getElementsByTagName("Rabbit")
    if (null == list || list.getLength <= 0) {
      throw new RuntimeException("No \"Rabbit\" tag exists")
    }

    val configElement: Element = list.item(0).asInstanceOf[Element]
    val hostId = configElement.getAttribute("value")

    val hostList: NodeList = configElement.getElementsByTagName("HostList")
    if(null == hostList || hostList.getLength <= 0) {
      throw new RuntimeException("No \"HostList\" tag exists")
    }

    val hosts: NodeList = hostList.item(0).asInstanceOf[Element].getElementsByTagName("Host")
    if(null == hosts || hosts.getLength <= 0) {
      throw new RuntimeException("No \"Host\" tag exists")
    }

    var i = 0
    while(i < hosts.getLength) {
      val element: Element = hosts.item(i).asInstanceOf[Element]
      if(element.getAttribute("id") == hostId) {
        HOST = element.getAttribute("host")
        return
      }
      i += 1
    }

    throw new RuntimeException("No host id \"" + hostId + "\" exists")
  }

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

  def startRMQThread() = {
    val rmqt = new RmqThread
    val t = new Thread(rmqt)
    t.start()
  }

  def startCountThread() = {
    val count = new FluxCounter
    val t = new Thread(count)
    t.start
  }

  def main(args: Array[String]) = {

    readConfig()

    val current = System.currentTimeMillis()/1000;
    val seconds: Long = 1380006191
    val date = new java.util.Date(1380006191L*1000)
    println(date)

    startRMQThread()
    startCountThread()
  }
}
