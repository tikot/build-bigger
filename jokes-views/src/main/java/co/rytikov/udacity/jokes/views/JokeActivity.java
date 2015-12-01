package co.rytikov.udacity.jokes.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity {

    public final static String THE_JOKE = "co.rytikov.udacity.jokes.THE_JOKE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);

        String joke = getIntent().getStringExtra(THE_JOKE);
        if (joke.isEmpty()) {
            Log.i("THE_JOKE", "The intent needs a joke to tell");
            finish();
            return;
        }
        TextView tell = (TextView) findViewById(R.id.the_joke);
        tell.setText(joke);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (android.R.id.home == item.getItemId()) {
            super.onBackPressed();
            return true;
        }
        else {
            return super.onOptionsItemSelected(item);
        }
    }
}
