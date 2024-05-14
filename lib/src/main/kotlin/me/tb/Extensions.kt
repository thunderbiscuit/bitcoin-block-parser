package me.tb

import java.nio.ByteBuffer
import java.nio.ByteOrder

fun UByteArray.littleEndianToUInt(): UInt {
    require(this.size == 4) { "UByteArray must be 4 bytes to return UInt" }
    val buffer = ByteBuffer.wrap(this.toByteArray())
    buffer.order(ByteOrder.LITTLE_ENDIAN)
    val number = buffer.int.toUInt()
    return number
}
