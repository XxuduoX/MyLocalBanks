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
            tvDBS.setText("DBS");
            tvOCBC.setText("OCBC");
            tvUOB.setText("UOB");
            return true;
        } else if (id == R.id.ChineseSelection) {
            tvDBS.setText("星展银行");
            tvOCBC.setText("华侨银行");
            tvUOB.setText("大华银行");
            return true;
        } else {
            tvDBS.setText("Error translation");
            tvOCBC.setText("Error translation");
            tvUOB.setText("Error translation");
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
                Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse("https://www.dbs.com.sg"));
                startActivity(intent);


            }else if(id==R.id.ContactSelection){
                Intent intentCall=new Intent(Intent.ACTION_DIAL, Uri.parse("tel: "+18001111111l));
                startActivity(intentCall);

            }
        }else if(worldClicked.equalsIgnoreCase("2nd")){
            if(id==R.id.WebsiteSelection){
                Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse("https://www.ocbc.com"));
                startActivity(intent);

            }else if(id==R.id.ContactSelection){
                Intent intentCall=new Intent(Intent.ACTION_DIAL, Uri.parse("tel: "+18003633333l));
                startActivity(intentCall);

            }
        }else if(worldClicked.equalsIgnoreCase("3rd")){
            if(id==R.id.WebsiteSelection){
                Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse("https://www.uob.com.sg"));
                startActivity(intent);

            }else if(id==R.id.ContactSelection){
                Intent intentCall=new Intent(Intent.ACTION_DIAL, Uri.parse("tel: "+18002222121l));
                startActivity(intentCall);

            }
        }
        return super.onContextItemSelected(item);
    }


}