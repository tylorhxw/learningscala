package patternmatching

/**
 * Created by huang_xw on 2015/08/25.
 */
abstract class Trade()

case class Sell(stockSymbol: String, quantity: Int) extends Trade

case class Buy(stockSymbol: String, quantity: Int) extends Trade

case class Hedge(stockSymbol: String, quantity: Int) extends Trade

class TradeProcessor {
  def processTransaction(request: Trade): Unit = {
    request match {
      case Sell(stock, 1000) => printf("Selling 1000-units of " + stock)
      case Sell(stock, quantity) => printf("Selling %d units of %s\n", quantity, stock)
      case Buy(stock, quantity) if (quantity > 2000) => printf("Buying %d (large) units of %s\n", quantity, stock)
      case Buy(stock, quantity) => printf("Buying %d units of %s\n", quantity, stock)
    }
  }
  processTransaction(new Sell("baidu",10000))
  processTransaction(new Buy("ali",1000))
  processTransaction(new Buy("tencent",20000))
}
