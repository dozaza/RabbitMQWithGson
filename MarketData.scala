import com.google.gson.annotations.SerializedName

class MarketData {
  @SerializedName("XSHG")
  private var metaDataXSHG: MarketMetaData = null
  @SerializedName("XSHE")
  private var metaDataXSHE: MarketMetaData = null
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
  private var priceEarningRatio: BigDecimal = BigDecimal(0)
  private var bidBook: Array[BidData] = Array.empty[BidData]

  def getMetaDataXSHG = metaDataXSHG
  def setMetaDataXSHG(metaDataXSHG: MarketMetaData) = {this.metaDataXSHG = metaDataXSHG}

  def getMetaDataXSHE = metaDataXSHE
  def setMetaDataXSHE(metaDataXSHE: MarketMetaData) = {this.metaDataXSHE = metaDataXSHE}

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
  def setPriceEarningRatio(priceEarningRatio: BigDecimal) = {this.priceEarningRatio = priceEarningRatio}

  def getBidBook = bidBook
  def setBidBook(bidBook: Array[BidData]) = {this.bidBook = bidBook}

  override def toString = {
    val xshg = if(metaDataXSHG != null) "XSHG: " + metaDataXSHG.toString + ", " else ""
    val xshe = if(metaDataXSHE != null) "XSHE: " + metaDataXSHE.toString + ", " else ""

    "(MarketData) " + xshg + xshe + "id: " + id + ", " + "securityId: " + securityId + ", " +
    "name: " + name + ", " + "closingPrice: " + closingPrice + ", " + "openingPrice: " + openingPrice +
    ", " + "totalTradeValue: " + totalTradeValue + ", " + "highestTradePrice" + highestTradePrice + ", " +
    "lowestTradePrice: " + lowestTradePrice + ", " + "tradePrice: " + tradePrice + ", " +
    "totalTradeQuantity: " + totalTradeQuantity + ", " + "priceEarningRatio: " + priceEarningRatio + ", " +
    "bidBook: " + bidBook.mkString(", ")
  }

}
