package com.example.sampleapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.OutlinedTextField

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home(navController: NavController) {
    val image = painterResource(R.drawable.happypaw)
    var expanded by remember { mutableStateOf(false) }
    var selectedOption by remember { mutableStateOf("Select Animal") }
    val options = listOf("Dog", "Cat") // Dropdown options

    Wrapper {
        Column(modifier = Modifier.fillMaxSize()) {
            // Header Row
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "LOGO", style = TextStyle(
                        fontSize = 28.sp,
                        color = Color(0xFF526EA3),
                        fontWeight = FontWeight.Bold,
                    )
                )
                Icon(
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = "avatarIcon",
                    modifier = Modifier.size(35.dp)
                )
            }

            Spacer(modifier = Modifier.height(30.dp))

            // Search Box
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color(0xFFBBD4F6), shape = RoundedCornerShape(4.dp))
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp, vertical = 8.dp),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "SearchIcon",
                        modifier = Modifier.size(35.dp)
                    )
                    Text("hello", modifier = Modifier.padding(horizontal = 6.dp))
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            // Image Box
            Box(modifier = Modifier.fillMaxWidth()) {
                Image(
                    painter = image,
                    contentDescription = "Paws and Fins",
                    modifier = Modifier.size(398.dp, 176.dp),
                    contentScale = ContentScale.Crop
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            // Feature Product Text
            Text(
                "Feature Product", style = TextStyle(
                    fontSize = 20.sp
                )
            )

            Spacer(modifier = Modifier.height(20.dp))

            // Dropdown Menu
            FilterDropdown()
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FilterDropdown() {
    var expanded by remember { mutableStateOf(false) }
    var selectedOption by remember { mutableStateOf("Filter") } // Initially show "Filter"
    val options = listOf("Dog", "Cat") // Dropdown options

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = !expanded }
    ) {
        Box(
            modifier = Modifier
                .background(Color(0xFFD0E1F9), shape = RoundedCornerShape(24.dp)) // Light blue color and rounded corners
                .padding(horizontal = 18.dp, vertical = 10.dp)
                .clickable { expanded = true } // Make the whole box clickable
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = selectedOption,
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color.Black
                    ),
                    modifier = Modifier.padding(horizontal = 4.dp)
                )
                Icon(
                    imageVector = Icons.Default.ArrowDropDown, // Dropdown arrow
                    contentDescription = null,
                    tint = Color.Black
                )
            }
        }

        // Dropdown Menu
        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            options.forEach { option ->
                DropdownMenuItem(
                    text = { Text(option) },
                    onClick = {
                        selectedOption = option
                        expanded = false
                    }
                )
            }
        }
    }
}