package app.os.counter;

import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
    implements GestureDetector.OnGestureListener{
    public static final String TAG ="MainActivity";
    Button plus1,plus5,plus10,zero,regist,save;
    TextView countDisplay;
    CounterListFragment counterListFragment;
    int count=0;
    int devide =16;
    Point deviceSize;
    //スワイプなどのディスプレイ上での動作を特定する
    GestureDetectorCompat detector;

    FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        detector =new GestureDetectorCompat(this,this);

        DisplayMetrics metric=new DisplayMetrics();
        WindowManager winman =
                (WindowManager)getSystemService(Context.WINDOW_SERVICE);
        deviceSize = new Point(winman.getDefaultDisplay().getWidth(),
                winman.getDefaultDisplay().getHeight());


        fragmentManager =getSupportFragmentManager();

        plus1 =(Button)findViewById(R.id.plus1);
        plus5 =(Button)findViewById(R.id.plus5);
        plus10 =(Button)findViewById(R.id.plus10);
        zero =(Button)findViewById(R.id.zero);
        regist =(Button)findViewById(R.id.registe);
        save =(Button)findViewById(R.id.save);
        countDisplay =(TextView)findViewById(R.id.textView);
        counterListFragment =(CounterListFragment)fragmentManager.findFragmentById(R.id.counterlistfragment);


        countDisplay.setText(String.valueOf(count));

        plus1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                countDisplay.setText(String.valueOf(count));
            }
        });
        plus5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count+=5;
                countDisplay.setText(String.valueOf(count));
            }
        });
        plus10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count+=10;
                countDisplay.setText(String.valueOf(count));
            }
        });
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count=0;
                countDisplay.setText(String.valueOf(count));
            }
        });
        regist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        fragmentManager.beginTransaction().hide(counterListFragment).commit();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        detector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return true;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return true;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
//        Log.d(TAG, "onScroll:"+String.valueOf(distanceX)+":"+String.valueOf(distanceY));
        return true;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
//        Log.d(TAG, "onFling: Start:"+e1.getX()+":"+e1.getY()+"\n"+
//                            "End:"+e2.getX()+":"+e2.getY());
        if(deviceSize.x/devide>e1.getX()&&(e2.getX()-e1.getX()>0)){
//            Log.d(TAG, "onFling: 左スライドが行われている");
            if(counterListFragment.isHidden())
                fragmentManager.beginTransaction().setCustomAnimations(android.R.anim.slide_in_left,
                        android.R.anim.slide_out_right).show(counterListFragment).commit();
//            plus5.setEnabled(false);plus10.setEnabled(false);zero.setEnabled(false);
            plus5.setClickable(false);plus10.setClickable(false);zero.setClickable(false);
        }
        //戻す

        else if(((counterListFragment.getView().getWidth())>e1.getX())&&(e1.getX()-e2.getX()>0)){
//            Log.d(TAG, "onFling: "+String.valueOf(counterListFragment.getView().getWidth())+"y"+counterListFragment.getView().getHeight());
            if(!counterListFragment.isHidden()){
                fragmentManager.beginTransaction().hide(counterListFragment).commit();
//                plus5.setEnabled(true);plus10.setEnabled(true);zero.setEnabled(true);
                plus5.setClickable(true);plus10.setClickable(true);zero.setClickable(true);
            }
        }
        return true;
    }
}
