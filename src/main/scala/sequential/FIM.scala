package sequential

import sequential.Apriori.Itemset

trait FIM {

  def findFrequentItemsets(transactions: List[Itemset], minSupport: Double): List[Itemset]

  def execute(transactions: List[Itemset], minSupport: Double): List[Itemset] = {
    executionTime = 0
    if (t0 == 0)
      t0 = System.currentTimeMillis()
    val itemsets = findFrequentItemsets(transactions, minSupport)
    if (executionTime == 0)
      executionTime = System.currentTimeMillis() - t0
    println(f"Elapsed time: ${executionTime/1000d}%1.2f seconds. Class: ${getClass.getSimpleName}. Items: ${transactions.size}")
    t0 = 0
    itemsets
  }

  def execute(fileName: String, separator: String, minSupport: Double): List[Itemset] = {
    t0 = System.currentTimeMillis()
    execute(Util.parseTransactions(fileName, separator), minSupport)
  }

  def executeByText(transactions: String, minSupport: Double): List[Itemset] = {
    execute(Util.parseTransactionsByText(transactions), minSupport)
  }

  var executionTime: Long = 0
  var t0: Long = 0

}
