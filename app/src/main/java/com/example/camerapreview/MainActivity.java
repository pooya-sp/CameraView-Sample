package com.example.camerapreview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.otaliastudios.cameraview.CameraView;
import com.otaliastudios.cameraview.filter.Filters;
import com.otaliastudios.cameraview.filter.NoFilter;
import com.otaliastudios.cameraview.filters.AutoFixFilter;
import com.otaliastudios.cameraview.filters.BlackAndWhiteFilter;
import com.otaliastudios.cameraview.filters.BrightnessFilter;
import com.otaliastudios.cameraview.filters.ContrastFilter;
import com.otaliastudios.cameraview.filters.CrossProcessFilter;
import com.otaliastudios.cameraview.filters.DocumentaryFilter;
import com.otaliastudios.cameraview.filters.DuotoneFilter;
import com.otaliastudios.cameraview.filters.FillLightFilter;
import com.otaliastudios.cameraview.filters.GammaFilter;
import com.otaliastudios.cameraview.filters.GrainFilter;
import com.otaliastudios.cameraview.filters.GrayscaleFilter;
import com.otaliastudios.cameraview.filters.HueFilter;
import com.otaliastudios.cameraview.filters.InvertColorsFilter;
import com.otaliastudios.cameraview.filters.LomoishFilter;
import com.otaliastudios.cameraview.filters.PosterizeFilter;
import com.otaliastudios.cameraview.filters.SaturationFilter;
import com.otaliastudios.cameraview.filters.SepiaFilter;
import com.otaliastudios.cameraview.filters.SharpnessFilter;
import com.otaliastudios.cameraview.filters.TemperatureFilter;
import com.otaliastudios.cameraview.filters.TintFilter;
import com.otaliastudios.cameraview.filters.VignetteFilter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button nextFilterButton;
    private Button prevFilterButton;

    private Filters[] filters = {
            Filters.NONE,

            Filters.AUTO_FIX,

            Filters.BLACK_AND_WHITE,

            Filters.BRIGHTNESS,

            Filters.CONTRAST,

            Filters.CROSS_PROCESS,

            Filters.DOCUMENTARY,

            Filters.DUOTONE,

            Filters.FILL_LIGHT,

            Filters.GAMMA,

            Filters.GRAIN,

            Filters.GRAYSCALE,

            Filters.HUE,

            Filters.INVERT_COLORS,

            Filters.LOMOISH,

            Filters.POSTERIZE,

            Filters.SATURATION,

            Filters.SEPIA,

            Filters.SHARPNESS,

            Filters.TEMPERATURE,

            Filters.TINT,

            Filters.VIGNETTE,
    };
int currentFilter = 0;
private CameraView camera;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         camera = findViewById(R.id.CameraView);
        nextFilterButton = findViewById(R.id.NextFilter);
        prevFilterButton = findViewById(R.id.PrevFilter);
        nextFilterButton.setOnClickListener(this);
        prevFilterButton.setOnClickListener(this);
        camera.setLifecycleOwner(this);
        // set custom filter
       // camera.setFilter(new MyFilter());
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.NextFilter) {
            if(currentFilter==filters.length -1){
                currentFilter = 0;
            }else{
                currentFilter++;
            }
            camera.setFilter(filters[currentFilter].newInstance());
        } else if  (v.getId() == R.id.PrevFilter){
            if(currentFilter==0){
                currentFilter = filters.length -1;
            }else{
                currentFilter--;
            }
            camera.setFilter(filters[currentFilter].newInstance());
        }
    }
}