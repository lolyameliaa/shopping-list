package com.example.shoppinglist.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

// ---------------- DARK THEME ----------------
private val DarkColorScheme = darkColorScheme(
    primary = RedDarkPrimaryContainer,
    onPrimary = RedDarkOnPrimaryContainer,
    primaryContainer = RedDarkPrimaryContainer,
    onPrimaryContainer = RedDarkOnPrimaryContainer,
    secondary = RedDarkSecondaryContainer,
    onSecondaryContainer = RedDarkOnSecondaryContainer,
    background = RedDarkBackground,
    onBackground = RedDarkOnBackground,
    surface = RedSurfaceDark,
    onSurface = RedOnSurfaceDark
)

private val LightColorScheme = lightColorScheme(
    primary = RedLight,
    onPrimary = RedOn,
    primaryContainer = RedPrimaryContainer,
    onPrimaryContainer = RedOnPrimaryContainer,
    secondary = RedSecondary,
    onSecondaryContainer = RedOnSecondaryContainer,
    background = RedBackground,
    onBackground = RedOnBackground,
    surface = RedSurface,
    onSurface = RedOnSurface
)

@Composable
fun ShoppingListTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}
