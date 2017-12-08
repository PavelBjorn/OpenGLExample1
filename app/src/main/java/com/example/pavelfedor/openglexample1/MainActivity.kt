package com.example.pavelfedor.openglexample1

import android.app.ActivityManager
import android.content.Context
import android.opengl.GLSurfaceView
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var surface: GLSurfaceView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // commit comment after amend second try

        if (!supportES2()){
            Toast.makeText(this, "OpenGl ES 2.0 is not supported", Toast.LENGTH_LONG).show()
            finish()
            return
        }

        surface = GLSurfaceView(this).apply {
            setEGLContextClientVersion(2)
            setRenderer(OpenGLRenderer())
        }

        setContentView(surface)
    }

    override fun onResume() {
        super.onResume()
        surface.onResume()
    }

    override fun onPause() {
        surface.onPause()
        super.onPause()
    }

    private fun supportES2(): Boolean = (getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager)
            .deviceConfigurationInfo.reqGlEsVersion >= 0x20000

}
