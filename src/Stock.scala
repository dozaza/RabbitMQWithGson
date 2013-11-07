import scala.Float
import scala.Long
import scala.Predef.String

/**
 * Created with IntelliJ IDEA.
 * System: Ubuntu
 * User: baoan @datayes
 * Date: 10/30/13
 * Time: 3:28 PM
 */
class Stock extends Head with Serializable {
  private val serialVersionUID: Long = 2299012709889314366L

  private var ticker: String = ""
  private var shortNM: String = ""
  private var prevClosePrice: Float = 0f
  private var openPrice: Float = 0f
  private var volume: Long = 0l
  private var value: Float = 0f
  private var deal: Int = 0
  private var cntrctPosition: Long = 0l
  private var highPrice: Float = 0f
  private var lowPrice: Float = 0f
  private var lastPrice: Float = 0f
  private var priceDelta1: Float = 0f
  private var priceDelta2: Float = 0f
  private var peRatio1: Float = 0f
  private var peRatio2: Float = 0f
  private var bidBook: List[Book] = null
  private var askBook: List[Book] = null

  def getTicker: String = {
    return ticker
  }

  def setTicker(ticker: String) {
    this.ticker = ticker
  }


  def getShortNM: String = {
    return shortNM
  }


  def setShortNM(shortNM: String) {
    this.shortNM = shortNM
  }


  def getPrevClosePrice: Float = {
    return prevClosePrice
  }


  def setPrevClosePrice(prevClosePrice: Float) {
    this.prevClosePrice = prevClosePrice
  }


  def getOpenPrice: Float = {
    return openPrice
  }


  def setOpenPrice(openPrice: Float) {
    this.openPrice = openPrice
  }


  def getVolume: Long = {
    return volume
  }


  def setVolume(volume: Long) {
    this.volume = volume
  }


  def getValue: Float = {
    return value
  }


  def setValue(value: Float) {
    this.value = value
  }


  def getDeal: Int = {
    return deal
  }


  def setDeal(deal: Int) {
    this.deal = deal
  }


  def getCntrctPosition: Long = {
    return cntrctPosition
  }


  def setCntrctPosition(cntrctPosition: Long) {
    this.cntrctPosition = cntrctPosition
  }


  def getHighPrice: Float = {
    return highPrice
  }


  def setHighPrice(highPrice: Float) {
    this.highPrice = highPrice
  }


  def getLowPrice: Float = {
    return lowPrice
  }


  def setLowPrice(lowPrice: Float) {
    this.lowPrice = lowPrice
  }


  def getLastPrice: Float = {
    return lastPrice
  }


  def setLastPrice(lastPrice: Float) {
    this.lastPrice = lastPrice
  }


  def getPriceDelta1: Float = {
    return priceDelta1
  }


  def setPriceDelta1(priceDelta1: Float) {
    this.priceDelta1 = priceDelta1
  }


  def getPriceDelta2: Float = {
    return priceDelta2
  }


  def setPriceDelta2(priceDelta2: Float) {
    this.priceDelta2 = priceDelta2
  }


  def getPeRatio1: Float = {
    return peRatio1
  }


  def setPeRatio1(peRatio1: Float) {
    this.peRatio1 = peRatio1
  }


  def getPeRatio2: Float = {
    return peRatio2
  }


  def setPeRatio2(peRatio2: Float) {
    this.peRatio2 = peRatio2
  }


  def getBidBook: List[Book] = {
    return bidBook
  }


  def setBidBook(bidBook: List[Book]) {
    this.bidBook = bidBook
  }


  def getAskBook: List[Book] = {
    return askBook
  }


  def setAskBook(askBook: List[Book]) {
    this.askBook = askBook
  }

  override def toString =
  {
    "Stock_java [ticker=" + ticker + ", shortNM=" + shortNM + ", prevClosePrice=" + prevClosePrice + ", openPrice=" + openPrice + ", volume=" + volume + ", value=" + value + ", deal=" + deal + ", cntrctPosition=" + cntrctPosition + ", highPrice=" + highPrice + ", lowPrice=" + lowPrice + ", lastPrice=" + lastPrice + ", priceDelta1=" + priceDelta1 + ", priceDelta2=" + priceDelta2 + ", peRatio1=" + peRatio1 + ", peRatio2=" + peRatio2 + ", bidBook=" + bidBook + ", askBook=" + askBook + ", getTimestamp()=" + getTimestamp + ", getLocalTimestamp()=" + getLocalTimestamp + ", getSecID()=" + getSecID + ", getDyID()=" + getDyID + ", getUtcOffset()=" + getUtcOffset + ", getExchangeCD()=" + getExchangeCD + ", getCurrencyCD()=" + getCurrencyCD + "]"
  }
}
