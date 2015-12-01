package co.rytikov.builditbigger;

import android.test.AndroidTestCase;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class JokeAsyncTaskTest extends AndroidTestCase {
    private static boolean called;

    protected void setUp() throws Exception {
        super.setUp();
        called = false;
    }

    public void testAsyncResponse() {
        final CountDownLatch signal = new CountDownLatch(1);



        JokeAsyncTask joke = new JokeAsyncTask(new JokeAsyncTask.CallBack() {
            @Override
            public void showJoke(String result) {
                called = true;
                assertNotNull(result);
                signal.countDown();
            }
            @Override
            public void noJoke(String s) {
                called = true;
                fail(s);
            }
        });

        joke.execute();

        try {
            signal.await(40, TimeUnit.SECONDS);
            assertTrue(called);
        } catch (InterruptedException e) {
            fail(e.getMessage());
        }
    }
}