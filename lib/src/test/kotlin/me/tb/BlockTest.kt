package me.tb

import kotlin.test.Test

class BlockTest {
    @Test
    fun `Block header is correctly parsed`() {
        // Block header for block 800,000
        val header: UByteArray = "00601d3455bb9fbd966b3ea2dc42d0c22722e4c0c1729fad17210100000000000000000055087fab0c8f3f89f8bcfd4df26c504d81b0a88e04907161838c0c53001af09135edbd64943805175e955e06fc0000000000000000".hexToUByteArray()
        val block: Block = Block(header)
        println(block.blockHeader)
    }
}
