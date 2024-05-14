/*
 * Copyright 2024 thunderbiscuit and contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the ./LICENSE.txt file.
 */

package me.tb

class BlockHeader(rawHeader: UByteArray) {
    init {
        require(rawHeader.size == 80) { "Block header must be 80 bytes" }
    }

    val version = rawHeader.copyOfRange(0, 4)
    val prevBlockHash = rawHeader.copyOfRange(4, 36)
    val merkleRoot = rawHeader.copyOfRange(36, 68)
    val timestamp = rawHeader.copyOfRange(68, 72)
    val bits = rawHeader.copyOfRange(72, 76)
    val nonce = rawHeader.copyOfRange(76, 80)

    override fun toString(): String {
        return "BlockHeader(version=${version.littleEndianToUInt()}, prevBlockHash=${prevBlockHash.reversedArray().toHexString()}, merkleRoot=${merkleRoot.reversedArray().toHexString()}, timestamp=${timestamp.littleEndianToUInt()}, bits=${bits.toHexString()}, nonce=${nonce.toHexString()})"
    }
}
