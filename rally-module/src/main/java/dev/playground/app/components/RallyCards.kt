package dev.playground.app.components

import androidx.compose.Composable
import androidx.compose.unaryPlus
import androidx.ui.core.Alignment
import androidx.ui.core.Text
import androidx.ui.core.dp
import androidx.ui.foundation.ColoredRect
import androidx.ui.foundation.VerticalScroller
import androidx.ui.graphics.Color
import androidx.ui.layout.*
import androidx.ui.material.*
import androidx.ui.material.surface.Card
import androidx.ui.material.surface.Surface
import dev.playground.app.model.SimpleModel
import dev.playground.app.style.colorSet1
import dev.playground.app.style.rallyGreen

@Composable
fun ValueDetailsCard(
    title: String,
    value: String,
    details: List<SimpleModel>
) {
    Card {
        Column(mainAxisSize = LayoutSize.Expand) {
            TextValueColumn(title, value)
            Divider(color = rallyGreen, height = 1.dp)
            Column(modifier = padding(12.dp), mainAxisSize = LayoutSize.Expand) {
                DetailsRowView(details) { row ->
                    with(row) { RallyAccountRow(name, description, this.value, color) }
                    RallyDivider()
                }
                Button(text = "See All", style = TextButtonStyle())
            }
        }
    }
}

@Composable
fun GraphDetailView(
    title: String,
    value: String,
    details: List<SimpleModel>,
    proportions: List<Float>,
    colorSet: List<Color> = colorSet1
) {
    VerticalScroller {
        Column {
            GraphValue(title, value, proportions, colorSet)
            HeightSpacer(height = 10.dp)
            Card {
                DetailsRowView(details) { row ->
                    with(row) { RallyAccountRow(name, description, this.value, color) }
                    RallyDivider()
                }
            }
        }
    }
}

@Composable
fun RallyAccountRow(name: String, number: String, amount: String, color: Color) {
    FlexRow(padding(vertical = 12.dp)) {
        inflexible {
            ColoredRect(color = color, width = 4.dp, height = 36.dp)
            WidthSpacer(width = 8.dp)
            Column(mainAxisSize = LayoutSize.Expand, crossAxisAlignment = CrossAxisAlignment.Start) {
                Text(text = name, style = +themeTextStyle { body1 })
                Text(text = number, style = +themeTextStyle { subtitle1 })
            }
        }
        expanded(flex = 1.0f) {
            FixedSpacer(width = 0.dp, height = 0.dp)
        }
        inflexible {
            Text(text = amount, style = +themeTextStyle { h6 })
        }
    }
}

@Composable
fun GraphValue(
    title: String,
    value: String,
    proportions: List<Float>,
    colorSet: List<Color>
) {
    Stack(padding(16.dp)) {
        aligned(Alignment.Center) {
            Container(height = 300.dp, expanded = true) {
                DrawAnimatedCircle(proportions, colorSet)
            }
            TextValueColumn(title, value)
        }
    }
}

@Composable
fun RallyAlertCard(title: String, action: String, text: String, secondaryAction: String) {
    Column(padding(12.dp)) {
        TextButtonRow(title, action) { }
        Divider(padding(vertical = 12.dp), color = +themeColor { background }, height = 2.dp)
        TextButtonFlexRow(text, secondaryAction) { }
    }
}

//
@Composable
fun DetailsRowView(details: List<SimpleModel>, block: @Composable() (SimpleModel) -> Unit) {
    Column(modifier = padding(12.dp), mainAxisSize = LayoutSize.Expand) {
        for (row in details) {
            block(row)
        }
    }
}

@Composable
fun TextButtonFlexRow(text: String, button: String, onClick: () -> Unit) {
    FlexRow {
        expanded(flex = 1.0f) {
            Text(style = +themeTextStyle { body1 }, text = text)
        }
        inflexible {
            Button(text = button, onClick = onClick, style = TextButtonStyle())
        }
    }
}

@Composable
fun TextButtonRow(text: String, button: String, onClick: () -> Unit) {
    Row(
        mainAxisSize = LayoutSize.Expand,
        mainAxisAlignment = MainAxisAlignment.SpaceBetween
    ) {
        Text(text = text, style = +themeTextStyle { subtitle2 })
        Button(text = button, onClick = onClick, style = TextButtonStyle())
    }
}

@Composable
fun TextValueColumn(text: String, value: String) {
    Column(modifier = padding(12.dp)) {
        Text(text = text, style = +themeTextStyle { body1 })
        Text(text = value, style = +themeTextStyle { h3 })
    }
}

@Composable
fun RallyDivider() = Divider(color = +themeColor { background }, height = 2.dp)

@Composable
fun Scaffold(appBar: @Composable() () -> Unit, children: @Composable() () -> Unit) {
    FlexColumn {
        inflexible {
            appBar()
        }
        expanded(flex = 1.0f) {
            Surface(color = +themeColor { background }) {
                children()
            }
        }
    }
}