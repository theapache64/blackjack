package app

import kotlinx.html.js.onClickFunction
import logo.logo
import react.*
import react.dom.*
import ticker.ticker
import kotlin.browser.window

interface AppState : RState {
    var num: Int
}

class App : RComponent<RProps, AppState>() {

    override fun AppState.init() {
        num = 24
    }

    override fun RBuilder.render() {

        div("App-header") {
            logo()
            h2 {
                +"Welcome to React with Kotlin ${state.num}"
            }
        }
        p("App-intro") {
            +"To get started, edit "
            code { +"app/App.kt" }
            +" and save to reload."
        }
        p("App-ticker") {
            ticker()
        }
        button {
            +"Click Me!"
            attrs.onClickFunction = {
                setState {
                    num = state.num + 1
                }
            }
        }
    }

}

fun RBuilder.app() = child(App::class) {}
