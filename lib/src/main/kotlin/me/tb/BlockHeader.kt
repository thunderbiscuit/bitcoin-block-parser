/*
 * Copyright 2024 thunderbiscuit and contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the ./LICENSE.txt file.
 */

package me.tb

public class BlockHeader(rawHeader: UByteArray) {
    init {
        require(rawHeader.size == 80) { "Block header must be 80 bytes" }
    }

    public val version: UByteArray = rawHeader.copyOfRange(0, 4)
    public val prevBlockHash: UByteArray = rawHeader.copyOfRange(4, 36)
    public val merkleRoot: UByteArray = rawHeader.copyOfRange(36, 68)
    public val timestamp: UByteArray = rawHeader.copyOfRange(68, 72)
    public val bits: UByteArray = rawHeader.copyOfRange(72, 76)
    public val nonce: UByteArray = rawHeader.copyOfRange(76, 80)

    override fun toString(): String {
        return "BlockHeader(version=${version.littleEndianToUInt()}, prevBlockHash=${prevBlockHash.reversedArray().toHexString()}, merkleRoot=${merkleRoot.reversedArray().toHexString()}, timestamp=${timestamp.littleEndianToUInt()}, bits=${bits.toHexString()}, nonce=${nonce.toHexString()})"
    }
}
