package net.meilcli.benchmark

import org.openjdk.jmh.annotations.Benchmark
import org.openjdk.jmh.annotations.Scope
import org.openjdk.jmh.annotations.Setup
import org.openjdk.jmh.annotations.State
import java.util.TreeSet

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

    @Benchmark
    fun containsCenter_ArrayList(): Boolean {
        return arrayList.contains(centerValue)
    }

    @Benchmark
    fun containsCenter_LinkedHashSet(): Boolean {
        return linkedHashSet.contains(centerValue)
    }

    @Benchmark
    fun containsCenter_HashSet(): Boolean {
        return hashSet.contains(centerValue)
    }

    @Benchmark
    fun containsCenter_TreeSet(): Boolean {
        return treeSet.contains(centerValue)
    }

    @Benchmark
    fun containsLast_ArrayList(): Boolean {
        return arrayList.contains(lastValue)
    }

    @Benchmark
    fun containsLast_HashSet(): Boolean {
        return hashSet.contains(lastValue)
    }

    @Benchmark
    fun containsLast_LinkedHashSet(): Boolean {
        return linkedHashSet.contains(lastValue)
    }

    @Benchmark
    fun containsLast_TreeSet(): Boolean {
        return treeSet.contains(lastValue)
    }

    @Benchmark
    fun containsUnknown_ArrayList(): Boolean {
        return arrayList.contains(unknownValue)
    }

    @Benchmark
    fun containsUnknown_HashSet(): Boolean {
        return hashSet.contains(unknownValue)
    }

    @Benchmark
    fun containsUnknown_LinkedHashSet(): Boolean {
        return linkedHashSet.contains(unknownValue)
    }

    @Benchmark
    fun containsUnknown_TreeSet(): Boolean {
        return treeSet.contains(unknownValue)
    }
}