package marketdata

import com.google.gson.annotations.SerializedName



private[marketdata] class MarketDataContent   {

  private var marketMetaData: MarketMetaData = null
  private var id: String = ""
  private var securityId: Long = 0
  private var name: String = ""
  private var closingPrice: BigDecimal = BigDecimal(0)
  private var openingPrice: BigDecimal = BigDecimal(0)
  private var totalTradeValue: BigDecimal = BigDecimal(0)
  private var highestTradePrice: BigDecimal = BigDecimal(0)
  private var lowestTradePrice: BigDecimal = BigDecimal(0)
  private var tradePrice: BigDecimal = BigDecimal(0)
  private var totalTradeQuantity: BigDecimal = BigDecimal(0)
  private var priceEarningRatio: Array[BigDecimal] = Array(BigDecimal(0))
  private var priceRisesFall: Array[BigDecimal] = Array(BigDecimal(0))
  private var contractPosition: Long = 0
  private var bidBook: Array[PricingData] = Array.empty[PricingData]
  private var askBook: Array[PricingData] = Array.empty[PricingData]

  def getMarketMetaData = marketMetaData
  def setMarketMetaData(marketMetaData: MarketMetaData) = {this.marketMetaData = marketMetaData}

  def getId = id
  def setId(id: String) = {this.id = id}

  def getSecurityId = securityId
  def setSecurityId(securityId: Long) = {this.securityId = securityId}

  def getName = name
  def setName(name: String) = {this.name = name}

  def getClosingPrice = closingPrice
  def setClosingPrice(closingPrice: BigDecimal) = {this.closingPrice = closingPrice}

  def getOpeningPrice = openingPrice
  def setOpeningPrice(openingPrice: BigDecimal) = {this.openingPrice = openingPrice}

  def getTotalTradeValue = totalTradeValue
  def setTotalTradeValue(totalTradeValue: BigDecimal) = {this.totalTradeValue = totalTradeValue}

  def getHighestTradePrice = highestTradePrice
  def setHighestTradePrice(highestTradePrice: BigDecimal) = {this.highestTradePrice = highestTradePrice}

  def getLowestTradePrice = lowestTradePrice
  def setLowestTradePrice(lowestTradePrice: BigDecimal) = {this.lowestTradePrice = lowestTradePrice}

  def getTradePrice = tradePrice
  def setTradePrice(tradePrice: BigDecimal) = {this.tradePrice = tradePrice}

  def getTotalTradeQuantity = totalTradeQuantity
  def setTotalTradeQuantity(totalTradeQuantity: BigDecimal) = {this.totalTradeQuantity = totalTradeQuantity}

  def getPriceEarningRatio = priceEarningRatio
  def setPriceEarningRatio(priceEarningRatio: Array[BigDecimal]) = {this.priceEarningRatio = priceEarningRatio}

  def getPriceRisesFall = priceRisesFall
  def setPriceRisesFall(priceRisesFall: Array[BigDecimal]) = {this.priceRisesFall = priceRisesFall}

  def getContractPosition = contractPosition
  def setContractPosition(contractPosition: Long) = {this.contractPosition = contractPosition}

  def getBidBook = bidBook
  def setBidBook(bidBook: Array[PricingData]) = {this.bidBook = bidBook}

  def getAskBook = askBook
  def setAskBook(askBook: Array[PricingData]) = {this.askBook = askBook}

  override def toString = {
    marketMetaData.toString + "id: " + id + ", " + "securityId: " + securityId + ", " +
      "name: " + name + ", " + "closingPrice: " + closingPrice + ", " + "openingPrice: " + openingPrice +
      ", " + "totalTradeValue: " + totalTradeValue + ", " + "highestTradePrice" + highestTradePrice +
      ", " + "lowestTradePrice: " + lowestTradePrice + ", " + "tradePrice: " + tradePrice + ", " +
      "totalTradeQuantity: " + totalTradeQuantity + ", " + "priceEarningRatio: [" +
      priceEarningRatio.mkString(", ") + "], " + "priceRisesFall: [" + priceRisesFall.mkString(", ") +
      "], " + "contractPosition: " + contractPosition + ", " + "bidBook: [" + bidBook.mkString(", ") +
      "], " + "askBook: [" + askBook.mkString(", ") + "]"
  }

}

private[marketdata] class MarketMetaData {

  private var length: Long = 0
  private var timestamp: BigDecimal = BigDecimal(0)
  private var millisecond:Int = 0
  private var exchangeId: Long = 0
  private var localMillSecond: Int = 0
  private var versionId: Long = 0
  private var localTimestamp: BigDecimal = BigDecimal(0)

  def getLength = length
  def setLength(length: Long) = {this.length = length}

  def getTimestamp = timestamp
  def setTimestamp(timestamp: BigDecimal) = {this.timestamp = timestamp}

  def getMillisecond = millisecond
  def setMillisecond(millisecond: Int) = {this.millisecond = millisecond}

  def getExchangeId = exchangeId
  def setExchangeId(exchangeId: Int) = {this.exchangeId = exchangeId}

  def getLocalMillSecond = localMillSecond
  def setLocalMillSecond(localMillSecond: Int) = {this.localMillSecond = localMillSecond}

  def getVersionId = versionId
  def setVersionId(versionId: Long) = {this.versionId = versionId}

  def getLocalTimestamp = localTimestamp
  def setLocalTimestamp(localTimestamp: BigDecimal) = {this.localTimestamp = localTimestamp}

  override def toString = {
    "(MarketMetaData) " + "length: " + length + ", timestamp: " + timestamp + ", millisecond: " +
      millisecond + ", exchangeId: " + exchangeId + ", localMillSecond: " + localMillSecond +
      ", versionId: " + versionId + ", localTimestamp: " + localTimestamp
  }
}

private[marketdata] class PricingData {

  private var price: BigDecimal = BigDecimal(0)
  private var amount: BigDecimal = BigDecimal(0)

  def getPrice = price
  def setPrice(price: BigDecimal) = {this.price = price}

  def getAmount = amount
  def setAmount(amount: BigDecimal) = {this.amount = amount}

  override def toString = {
    "(PricingData) price: " + price + ", amount: " + amount
  }

}

class MarketData {
  @SerializedName("XSHG")
  private var dataXSHG: MarketDataContent = null
  @SerializedName("XSHE")
  private var dataXSHE: MarketDataContent = null


  def getDataXSHG = dataXSHG
  def setDataXSHG(dataXSHG: MarketDataContent) = {this.dataXSHG = dataXSHG}

  def getDataXSHE = dataXSHE
  def setDataXSHE(dataXSHE: MarketDataContent) = {this.dataXSHE = dataXSHE}

  override def toString = {
    val xshg = if(dataXSHG != null) "XSHG: " + dataXSHG.toString + ", " else ""
    val xshe = if(dataXSHE != null) "XSHE: " + dataXSHE.toString + ", " else ""

    "(MarketData) " + xshg + xshe
  }
}
