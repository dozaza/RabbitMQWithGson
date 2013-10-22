/**
 * Created with IntelliJ IDEA.
 * System: Ubuntu
 * User: baoan @datayes
 * Date: 9/27/13
 * Time: 11:51 AM
 */
class FluxCounter extends Runnable{

  override def run() = {
    while(true) {
      Thread.sleep(10000)
      println(client.count)
      client.count = 0
    }
  }

}
