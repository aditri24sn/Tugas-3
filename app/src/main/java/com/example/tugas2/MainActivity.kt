package com.example.tugas2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import kotlin.math.roundToInt

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculatorTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CalculatorApp()
                }
            }
        }
    }
}

@Composable
fun CalculatorApp() {
    var display by remember { mutableStateOf("0") }
    var previousValue by remember { mutableStateOf(0.0) }
    var operation by remember { mutableStateOf("") }
    var waitingForOperand by remember { mutableStateOf(false) }

    fun inputNumber(num: String) {
        if (waitingForOperand) {
            display = num
            waitingForOperand = false
        } else {
            display = if (display == "0") num else display + num
        }
    }

    fun inputOperation(nextOperation: String) {
        val inputValue = display.toDouble()

        if (previousValue == 0.0) {
            previousValue = inputValue
        } else if (operation.isNotEmpty()) {
            val currentValue = previousValue
            val result = when (operation) {
                "+" -> currentValue + inputValue
                "-" -> currentValue - inputValue
                "×" -> currentValue * inputValue
                "÷" -> if (inputValue != 0.0) currentValue / inputValue else currentValue
                else -> inputValue
            }

            display = if (result == result.roundToInt().toDouble()) {
                result.roundToInt().toString()
            } else {
                String.format("%.8f", result).trimEnd('0').trimEnd('.')
            }

            previousValue = result
        }

        waitingForOperand = true
        operation = nextOperation
    }

    fun calculate() {
        val inputValue = display.toDouble()

        if (previousValue != 0.0 && operation.isNotEmpty()) {
            val result = when (operation) {
                "+" -> previousValue + inputValue
                "-" -> previousValue - inputValue
                "×" -> previousValue * inputValue
                "÷" -> if (inputValue != 0.0) previousValue / inputValue else previousValue
                else -> inputValue
            }

            display = if (result == result.roundToInt().toDouble()) {
                result.roundToInt().toString()
            } else {
                String.format("%.8f", result).trimEnd('0').trimEnd('.')
            }

            previousValue = 0.0
            operation = ""
            waitingForOperand = true
        }
    }

    fun clear() {
        display = "0"
        previousValue = 0.0
        operation = ""
        waitingForOperand = false
    }

    fun deleteLast() {
        if (display.length > 1) {
            display = display.dropLast(1)
        } else {
            display = "0"
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        // Display
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            colors = CardDefaults.cardColors(containerColor = Color(0xFF2D3748))
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(9.dp),
                contentAlignment = Alignment.CenterEnd
            ) {
                Text(
                    text = display,
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    textAlign = TextAlign.End,
                    maxLines = 1
                )
            }
        }

        // Buttons
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            // Row 1: C, DEL, ÷
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                CalculatorButton(
                    text = "C",
                    onClick = { clear() },
                    modifier = Modifier.weight(2f),
                    backgroundColor = Color(0xFFE53E3E),
                    textColor = Color.White
                )
                CalculatorButton(
                    text = "DEL",
                    onClick = { deleteLast() },
                    modifier = Modifier.weight(1f),
                    backgroundColor = Color(0xFF718096),
                    textColor = Color.White
                )
                CalculatorButton(
                    text = "÷",
                    onClick = { inputOperation("÷") },
                    modifier = Modifier.weight(1f),
                    backgroundColor = Color(0xFF3182CE),
                    textColor = Color.White
                )
            }

            // Row 2: 7, 8, 9, ×
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                CalculatorButton("7", { inputNumber("7") }, Modifier.weight(1f))
                CalculatorButton("8", { inputNumber("8") }, Modifier.weight(1f))
                CalculatorButton("9", { inputNumber("9") }, Modifier.weight(1f))
                CalculatorButton(
                    text = "×",
                    onClick = { inputOperation("×") },
                    modifier = Modifier.weight(1f),
                    backgroundColor = Color(0xFF3182CE),
                    textColor = Color.White
                )
            }

            // Row 3: 4, 5, 6, -
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                CalculatorButton("4", { inputNumber("4") }, Modifier.weight(1f))
                CalculatorButton("5", { inputNumber("5") }, Modifier.weight(1f))
                CalculatorButton("6", { inputNumber("6") }, Modifier.weight(1f))
                CalculatorButton(
                    text = "-",
                    onClick = { inputOperation("-") },
                    modifier = Modifier.weight(1f),
                    backgroundColor = Color(0xFF3182CE),
                    textColor = Color.White
                )
            }

            // Row 4: 1, 2, 3, +
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                CalculatorButton("1", { inputNumber("1") }, Modifier.weight(1f))
                CalculatorButton("2", { inputNumber("2") }, Modifier.weight(1f))
                CalculatorButton("3", { inputNumber("3") }, Modifier.weight(1f))
                CalculatorButton(
                    text = "+",
                    onClick = { inputOperation("+") },
                    modifier = Modifier.weight(1f),
                    backgroundColor = Color(0xFF3182CE),
                    textColor = Color.White
                )
            }

            // Row 5: 0, =
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                CalculatorButton(
                    text = "0",
                    onClick = { inputNumber("0") },
                    modifier = Modifier.weight(3f)
                )
                CalculatorButton(
                    text = "=",
                    onClick = { calculate() },
                    modifier = Modifier.weight(1f),
                    backgroundColor = Color(0xFF38A169),
                    textColor = Color.White
                )
            }
        }
    }
}

@Composable
fun CalculatorButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    backgroundColor: Color = Color(0xFFF7FAFC),
    textColor: Color = Color.Black
) {
    Button(
        onClick = onClick,
        modifier = modifier.height(64.dp),
        shape = RoundedCornerShape(12.dp),
        colors = ButtonDefaults.buttonColors(containerColor = backgroundColor)
    ) {
        Text(
            text = text,
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium,
            color = textColor
        )
    }
}

@Composable
fun CalculatorTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        content = content
    )
}

@Preview(showBackground = true)
@Composable
fun CalculatorPreview() {
    CalculatorTheme {
        CalculatorApp()
    }
}