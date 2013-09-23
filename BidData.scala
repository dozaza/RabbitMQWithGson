class BidData {

  private var price: BigDecimal = BigDecimal(0)
  private var amount: BigDecimal = BigDecimal(0)

  def getPrice = price
  def setPrice(price: BigDecimal) = {this.price = price}

  def getAmount = amount
  def setAmount(amount: BigDecimal) = {this.amount = amount}

  override def toString = {
    "(BidData) price: " + price + ", amount: " + amount
  }

}
