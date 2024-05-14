/*
 * Copyright 2024 thunderbiscuit and contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the ./LICENSE.txt file.
 */

package me.tb

import me.tb.txparser.BitcoinBytesReader
import me.tb.txparser.txelements.VarInt

class BlockReader(private var rawBlock: UByteArray) : BitcoinBytesReader {
    override fun get(): UByteArray {
        return rawBlock
    }

    override fun getNext(length: Int): UByteArray {
        if (length > rawBlock.size) {
            throw IllegalArgumentException("Requested length $length exceeds remaining block data ${rawBlock.size}")
        }
        val data = rawBlock.copyOfRange(0, length)
        rawBlock = rawBlock.copyOfRange(length, rawBlock.size)
        return data
    }

    override fun getNextVarint(): VarInt {
        val varint = VarInt(rawBlock.copyOfRange(0, 9))
        rawBlock = rawBlock.copyOfRange(varint.length, rawBlock.size)
        return varint
    }

    override fun isEmpty(): Boolean {
        return rawBlock.isEmpty()
    }
}
