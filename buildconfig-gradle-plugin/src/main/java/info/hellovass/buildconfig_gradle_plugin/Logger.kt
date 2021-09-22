package info.hellovass.buildconfig_gradle_plugin

import org.gradle.api.invocation.Gradle
import org.gradle.internal.logging.text.StyledTextOutput
import org.gradle.internal.logging.text.StyledTextOutputFactory
import org.gradle.kotlin.dsl.support.serviceOf

class Logger private constructor(gradle: Gradle) {

    private val out: StyledTextOutput = gradle.serviceOf<StyledTextOutputFactory>()
        .create("abinary-output")

    fun normal(message: String) {
        out.style(StyledTextOutput.Style.Normal)?.run {
            println(message)
        }
    }

    fun header(message: String) {
        out.style(StyledTextOutput.Style.Header)?.run {
            println(message)
        }
    }

    fun userInput(message: String) {
        out.style(StyledTextOutput.Style.UserInput)?.run {
            println(message)
        }
    }

    fun identifier(message: String) {
        out.style(StyledTextOutput.Style.Identifier)?.run {
            println(message)
        }
    }

    fun description(message: String) {
        out.style(StyledTextOutput.Style.Description)?.run {
            println(message)
        }
    }

    fun progressStatus(message: String) {
        out.style(StyledTextOutput.Style.ProgressStatus)?.run {
            println(message)
        }
    }

    fun success(message: String) {
        out.style(StyledTextOutput.Style.Success)?.run {
            println(message)
        }
    }

    fun successHeader(message: String) {
        out.style(StyledTextOutput.Style.SuccessHeader)?.run {
            println(message)
        }
    }

    fun failure(message: String) {
        out.style(StyledTextOutput.Style.Failure)?.run {
            println(message)
        }
    }

    fun failureHeader(message: String) {
        out.style(StyledTextOutput.Style.FailureHeader)?.run {
            println(message)
        }
    }

    fun info(message: String) {
        out.style(StyledTextOutput.Style.Info)?.run {
            println(message)
        }
    }

    fun error(message: String) {
        out.style(StyledTextOutput.Style.Error)?.run {
            println(message)
        }
    }

    companion object {

        @Volatile
        private var INSTANCE: Logger? = null

        fun getInstance(gradle: Gradle) = INSTANCE ?: synchronized(Logger::class) {
            INSTANCE ?: Logger(gradle).also {
                INSTANCE = it
            }
        }
    }
}