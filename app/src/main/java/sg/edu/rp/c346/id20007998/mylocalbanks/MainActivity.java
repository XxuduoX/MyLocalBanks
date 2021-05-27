package sg.edu.rp.c346.id20007998.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tvDBS;
    TextView tvOCBC;
    TextView tvUOB;

    String worldClicked="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvDBS=findViewById(R.id.tvDBS);
        tvOCBC=findViewById(R.id.tvOCBC);
        tvUOB=findViewById(R.id.tvUOB);

        registerForContextMenu(tvDBS);
        registerForContextMenu(tvOCBC);
        registerForContextMenu(tvUOB);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_language, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            tvDBS.setText(getString(R.string.dbs));
            tvOCBC.setText(getString(R.string.ocbc));
            tvUOB.setText(getString(R.string.uob));
            return true;
        } else if (id == R.id.ChineseSelection) {
            tvDBS.setText(getString(R.string.c_dbs));
            tvOCBC.setText(getString(R.string.c_ocbc));
            tvUOB.setText(getString(R.string.c_uob));
            return true;
        } else {
            tvDBS.setText(getString(R.string.error_translation));
            tvOCBC.setText(getString(R.string.error_translation));
            tvUOB.setText(getString(R.string.error_translation));
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu_contact, menu);
        if(v==tvDBS) {
            worldClicked = "1st";
        }else if(v==tvOCBC){
            worldClicked="2nd";
        }else if(v==tvUOB){
            worldClicked="3rd";
        }

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int id=item.getItemId();
        if(worldClicked.equalsIgnoreCase("1st")){
            if(id==R.id.WebsiteSelection){
                Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse(getString(R.string.urlDBS)));
                startActivity(intent);


            }else if(id==R.id.ContactSelection){
                Intent intentCall=new Intent(Intent.ACTION_DIAL, Uri.parse("tel: "+getString(R.string.telDBS)));
                startActivity(intentCall);

            }else if(id==R.id.FavouriteSelection){
                if (tvDBS.getCurrentTextColor()!=getResources().getColor(android.R.color.holo_red_dark)){
                    tvDBS.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
                }else{
                    tvDBS.setTextColor(getResources().getColor(android.R.color.black));
                }
            }
        }else if(worldClicked.equalsIgnoreCase("2nd")){
            if(id==R.id.WebsiteSelection){
                Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse(getString(R.string.urlOCBC)));
                startActivity(intent);

            }else if(id==R.id.ContactSelection){
                Intent intentCall=new Intent(Intent.ACTION_DIAL, Uri.parse("tel: "+getString(R.string.telOCBC)));
                startActivity(intentCall);

            }else if(id==R.id.FavouriteSelection){
                if (tvOCBC.getCurrentTextColor()!=getResources().getColor(android.R.color.holo_red_dark)){
                    tvOCBC.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
                }else{
                    tvOCBC.setTextColor(getResources().getColor(android.R.color.black));
                }

            }
        }else if(worldClicked.equalsIgnoreCase("3rd")){
            if(id==R.id.WebsiteSelection){
                Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse(getString(R.string.urlUOB)));
                startActivity(intent);

            }else if(id==R.id.ContactSelection){
                Intent intentCall=new Intent(Intent.ACTION_DIAL, Uri.parse("tel: "+getString(R.string.telUOB)));
                startActivity(intentCall);

            }else if(id==R.id.FavouriteSelection){
                if (tvUOB.getCurrentTextColor()!=getResources().getColor(android.R.color.holo_red_dark)){
                    tvUOB.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
                }else{
                    tvUOB.setTextColor(getResources().getColor(android.R.color.black));
                }
            }
        }
        return super.onContextItemSelected(item);
    }


}