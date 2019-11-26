package dev.playground.app

import androidx.compose.Composable
import androidx.compose.state
import androidx.compose.unaryPlus
import androidx.ui.material.MaterialTheme
import androidx.ui.material.Tab
import androidx.ui.material.TabRow
import androidx.ui.tooling.preview.Preview
import dev.playground.app.components.Scaffold
import dev.playground.app.style.materialColors
import dev.playground.app.style.materialTypography
import dev.playground.app.view.RallyAccountsCard
import dev.playground.app.view.RallyBillsCard
import dev.playground.app.view.RallyOverviewCard

@Composable
fun RallyApp(startActivity: (Any) -> Unit = { }) {
    MaterialTheme(
        colors = materialColors,
        typography = materialTypography
    ) {

        var currentScreen by +state { RallyViews.Overview }

        Scaffold(appBar = {
            TabRow(
                RallyViews.values().toList(),
                selectedIndex = currentScreen.ordinal
            ) { i, screen ->
                Tab(text = screen.name, selected = currentScreen.ordinal == i) {
                    currentScreen = screen
                }
            }
        }) {
            currentScreen.body()
        }
    }
}

@Preview
@Composable
fun DefaultPreview() {
    RallyApp { }
}

enum class RallyViews(val body: () -> Unit) {
    Overview({ RallyOverviewCard() }),
    Accounts({ RallyAccountsCard() }),
    Bills({ RallyBillsCard() })
}
