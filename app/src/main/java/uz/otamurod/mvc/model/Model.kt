package uz.otamurod.mvc.model

import java.util.*

/** Model */
class Model : Observable() {
    val list: MutableList<Int>

    init {
        list = ArrayList(3)
        list.add(0)
        list.add(0)
        list.add(0)
    }

    fun getValueAtIndex(index: Int): Int {
        return list[index]
    }

    fun setValueAtIndex(index: Int) {
        list[index] += 1
        /** Update data */
        setChanged()
        notifyObservers()
    }
}