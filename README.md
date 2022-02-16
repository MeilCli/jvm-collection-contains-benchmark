# jvm-collection-contains-benchmark
## Benchmark Code
```kt
@State(Scope.Benchmark)
open class CollectionContainsBenchmark {

    companion object {

        private const val maxCount = 10_0000
        private const val centerValue = (maxCount / 2).toString()
        private const val lastValue = (maxCount - 1).toString()
        private const val unknownValue = "-1"
    }

    private val arrayList = mutableListOf<String>()
    private val hashSet = HashSet<String>()
    private val linkedHashSet = mutableSetOf<String>()
    private val treeSet = TreeSet<String>()

    @Setup
    fun initialize() {
        for (i in 0 until maxCount) {
            arrayList.add(i.toString())
            hashSet.add(i.toString())
            linkedHashSet.add(i.toString())
            treeSet.add(i.toString())
        }
    }
}
```
each benchmark method is simply calling `contains()`

## Result
```
Benchmark                                                   Mode  Cnt          Score          Error  Units
CollectionContainsBenchmark.containsCenter_ArrayList       thrpt    5       3953.065 ±      719.410  ops/s
CollectionContainsBenchmark.containsCenter_HashSet         thrpt    5  163921952.438 ± 20750185.060  ops/s
CollectionContainsBenchmark.containsCenter_LinkedHashSet   thrpt    5  138491293.839 ±  7933632.653  ops/s
CollectionContainsBenchmark.containsCenter_TreeSet         thrpt    5   23703747.775 ±  2580928.349  ops/s
CollectionContainsBenchmark.containsLast_ArrayList         thrpt    5        897.624 ±       27.885  ops/s
CollectionContainsBenchmark.containsLast_HashSet           thrpt    5  146885601.707 ± 62044417.280  ops/s
CollectionContainsBenchmark.containsLast_LinkedHashSet     thrpt    5  133386940.678 ± 10181101.768  ops/s
CollectionContainsBenchmark.containsLast_TreeSet           thrpt    5   12124646.546 ±   877554.961  ops/s
CollectionContainsBenchmark.containsUnknown_ArrayList      thrpt    5       1046.529 ±       84.081  ops/s
CollectionContainsBenchmark.containsUnknown_HashSet        thrpt    5  321479276.677 ± 48345621.809  ops/s
CollectionContainsBenchmark.containsUnknown_LinkedHashSet  thrpt    5  241420837.758 ± 44298652.063  ops/s
CollectionContainsBenchmark.containsUnknown_TreeSet        thrpt    5   33482539.128 ±  3676612.476  ops/s
```

