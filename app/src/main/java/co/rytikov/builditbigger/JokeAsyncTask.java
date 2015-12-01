package co.rytikov.builditbigger;

import android.os.AsyncTask;
import android.util.Pair;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;

import co.rytikov.builditbigger.backend.myApi.MyApi;

class JokeAsyncTask extends AsyncTask<Void, Void, Pair<Boolean, String>> {
    private static MyApi myApiService = null;
    private CallBack callBack;

    public JokeAsyncTask(CallBack c) {
        callBack = c;
    }

    public interface CallBack {
        void showJoke(String result);
        void noJoke(String s);
    }

    @Override
    protected Pair doInBackground(Void... voids) {
        if(myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    .setRootUrl("http://10.0.3.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
                  // end options for devappserver
            myApiService = builder.build();
        }

        try {
            return new Pair<>(true, myApiService.telljoke().execute().getData());
        } catch (IOException e) {
            return new Pair<>(false, e.getMessage());
        }
    }

    @Override
    protected void onPostExecute(Pair<Boolean, String> result) {
        if (result.first) callBack.showJoke(result.second);
        else callBack.noJoke(result.second);
    }
}