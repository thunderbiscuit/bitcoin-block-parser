/*
 * Copyright 2024 thunderbiscuit and contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the ./LICENSE.txt file.
 */

package me.tb

class Block(rawBlock: UByteArray) {
    private val blockReader = BlockReader(rawBlock)
    val blockHeader = BlockHeader(blockReader.getNext(80))
    val txCount = blockReader.getNextVarint().value
}
