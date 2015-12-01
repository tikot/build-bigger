package co.rytikov.builditbigger;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.util.Log;

import android.widget.ProgressBar;


import co.rytikov.udacity.jokes.views.JokeActivity;

public class MainActivityFragment extends Fragment implements JokeAsyncTask.CallBack {
    public ProgressBar progress;

    public void tellJoke() {
        progress.setVisibility(ProgressBar.VISIBLE);
        new JokeAsyncTask(this).execute();
    }

    @Override
    public void showJoke(String result) {
        Intent intent = new Intent(getContext(), JokeActivity.class);
        intent.putExtra(JokeActivity.THE_JOKE, result);

        progress.setVisibility(ProgressBar.INVISIBLE);
        startActivity(intent);
    }

    @Override
    public void noJoke(String s) {
        Log.e("noJoke", s);
        progress.setVisibility(ProgressBar.INVISIBLE);
        Snackbar.make(getView(), R.string.no_joke, Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }
}
