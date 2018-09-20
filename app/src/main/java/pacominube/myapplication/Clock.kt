package pacominube.myapplication

import java.util.*

class Clock {
    fun getTimeInMillis() : Long {
        return Calendar.getInstance().timeInMillis
    }
}