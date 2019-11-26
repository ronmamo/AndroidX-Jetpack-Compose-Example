package dev.playground.app.view

import androidx.compose.Composable
import androidx.ui.core.dp
import androidx.ui.foundation.VerticalScroller
import androidx.ui.layout.Column
import androidx.ui.layout.HeightSpacer
import androidx.ui.layout.LayoutSize
import androidx.ui.layout.Padding
import dev.playground.app.MockData.accountList
import dev.playground.app.MockData.accountValue
import dev.playground.app.MockData.billDetails
import dev.playground.app.MockData.billsValue
import dev.playground.app.components.GraphDetailView
import dev.playground.app.components.RallyAlertCard
import dev.playground.app.components.ValueDetailsCard

@Composable
fun RallyOverviewCard() {
    VerticalScroller {
        Padding(16.dp) {
            Column(mainAxisSize = LayoutSize.Expand) {
                RallyAlertCard(
                    "Alerts", "See All",
                    "Heads up, you've used up 90% of your Shopping budget for this month.", "Sort"
                )
                HeightSpacer(height = 10.dp)
                ValueDetailsCard(
                    "Accounts",
                    accountValue,
                    accountList
                )
                HeightSpacer(height = 10.dp)
                ValueDetailsCard(
                    "Bills",
                    billsValue,
                    billDetails
                )
            }
        }
    }
}

@Composable
fun RallyAccountsCard() = GraphDetailView(
    "Total",
    accountValue,
    accountList,
    listOf(0.595f, 0.045f, 0.095f, 0.195f, 0.045f)
)

@Composable
fun RallyBillsCard() = GraphDetailView(
    "Due",
    billsValue,
    billDetails,
    listOf(0.65f, 0.25f, 0.03f, 0.05f)
)
