package com.mehboob.myapplication;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;
import com.github.dhaval2404.imagepicker.ImagePicker;
import com.mehboob.myapplication.databinding.ActivityMainBinding;
public class MainActivity extends AppCompatActivity {
ActivityMainBinding binding;
public static Uri imgUri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.appCompatButton.setOnClickListener(view -> ImagePicker.with(this)
                .crop()	    			                //Crop image(Optional), Check Customization for more option
                .compress(1024)			                //Final image size will be less than 1 MB(Optional)
                .maxResultSize(1080, 1080)	//Final image resolution will be less than 1080 x 1080(Optional)
                .start());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
       try{
           if (resultCode == Activity.RESULT_OK) {
               if (data != null) {
                   imgUri=data.getData();
               }
               if (!imgUri.equals(""))
               startActivity(new Intent(MainActivity.this, FinalActivity.class));

           }

       }catch (Exception e){
           Toast.makeText(this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
       }
    }
}