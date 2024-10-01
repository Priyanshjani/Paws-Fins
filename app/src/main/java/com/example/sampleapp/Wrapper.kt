package com.example.sampleapp

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Wrapper(content: @Composable () -> Unit){
    Box(modifier = Modifier.padding(horizontal = 16.dp, vertical = 30.dp)){
        content();
    }
    
}