package dev.playground.app

import androidx.ui.graphics.Color
import dev.playground.app.model.SimpleModel

object MockData {
    val accountValue = "$12,132.49"

    val accountList = listOf(
        SimpleModel(
            name = "Checking",
            value = "$ 2,215.13",
            description = "*****1234",
            color = Color(0xFF005D57)
        ),
        SimpleModel(
            name = "Home Savings",
            value = "$ 8,676.88",
            description = "*****5678",
            color = Color(0xFF04B97F)
        ),
        SimpleModel(
            name = "Car Savings",
            value = "$ 987.48",
            description = "*****9012",
            color = Color(0xFF37EFBA)
        ),
        SimpleModel(
            name = "Vacation",
            value = "$ 253",
            description = "*****3456",
            color = Color(0xFF005D57)
        )
    )

    val billsValue = "$1,810.00"

    val billDetails = listOf(
        SimpleModel(
            name = "RedPay Credit",
            value = "$ -45.36",
            description = "*****Jan 29",
            color = Color(0xFF005D57)
        ),
        SimpleModel(
            name = "Rent",
            value = "$ -1,200.00",
            description = "*****Feb 9",
            color = Color(0xFF04B97F)
        ),
        SimpleModel(
            name = "TabFine Credit",
            value = "$ -87.33",
            description = "*****Feb 22",
            color = Color(0xFF37EFBA)
        ),
        SimpleModel(
            name = "ABC Loans",
            value = "$ -400.00",
            description = "*****Feb 29",
            color = Color(0xFF005D57)
        )
    )
}