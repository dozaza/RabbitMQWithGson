class MarketMetaData {

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
}
