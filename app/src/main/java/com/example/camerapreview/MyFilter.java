package com.example.camerapreview;

import androidx.annotation.NonNull;

import com.otaliastudios.cameraview.filter.BaseFilter;

public class MyFilter extends BaseFilter {
    private final static String FRAGMENT_SHADER = "#extension GL_OES_EGL_image_external : require\n"
            + "precision mediump float;\n"
            + "varying vec2 "+DEFAULT_FRAGMENT_TEXTURE_COORDINATE_NAME+";\n"
            + "uniform samplerExternalOES sTexture;\n" + "void main() {\n"
            + "  vec4 color = texture2D(sTexture, "+DEFAULT_FRAGMENT_TEXTURE_COORDINATE_NAME+");\n"
            + "  float colorR = (color.r + color.g + color.b) / 2.0;\n"
            + "  float colorG = (color.r + color.g + color.b) / 4.0;\n"
            + "  float colorB = (color.r + color.g + color.b) / 1.0;\n"
            + "  gl_FragColor = vec4(colorR, colorG, colorB, 0.1);\n"
            + "}\n";
public MyFilter(){

}
    @NonNull
    @Override
    public String getFragmentShader() {
        return FRAGMENT_SHADER;
    }
}
