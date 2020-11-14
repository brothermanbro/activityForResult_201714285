package kr.ac.konkuk.activityforresult_201714285;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
static final int GET_STRING = 1;// SubActivity를 구별할수 있도록 request code를 정합니다.

TextView text1;
TextView text2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button)findViewById(R.id.button);
        text1 = (TextView)findViewById(R.id.textView2);
        text2 = (TextView)findViewById(R.id.textView3);
      button.setOnClickListener(new View.OnClickListener(){
          public void onClick(View arg0){
              Intent in = new Intent(MainActivity.this,SubActivity.class);//버튼을 누르면 SubActivity를 불러오게 합니다.
              startActivityForResult(in,GET_STRING);//SubActivity에 request code를 지정하고 시작합니다.
          }
      });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {//startActivityForResult로 생성한 activity의 응답을 받습니다.

        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == GET_STRING) {//requestCode로 SubActivity를 구별합니다.
            if (resultCode == RESULT_OK) {//SubActivity에서 보낸 2개의 데이터를 받습니다.
                text1.setText(data.getStringExtra("a"));//data a를 text1에 저장하고 출력합니다.
                text2.setText(data.getStringExtra("c"));//data c를 text2에 저장하고 출력합니다.
            }
        }

    }
}
