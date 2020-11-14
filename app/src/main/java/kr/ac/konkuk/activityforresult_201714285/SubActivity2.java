package kr.ac.konkuk.activityforresult_201714285;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;


    public class SubActivity2 extends AppCompatActivity {
        EditText edit;
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.sub2);
            edit = (EditText)findViewById(R.id.edit);
            Button ok = (Button)findViewById(R.id.ok);
            Button cancel = (Button)findViewById(R.id.cancel);
            ok.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {//ok버튼을 누리면
                    Intent intent = new Intent();//intent 객체를 생성하고
                    intent.putExtra("b", edit.getText().toString());//data b에 editText에서 입력된 값을 저장합니다.
                    setResult(RESULT_OK, intent);//응답으로 b를 보냅니다.
                    finish();//현재 activity를 종료합니다.
                }
            });
            cancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {//cancel을 누르면
                    setResult(RESULT_CANCELED);//작업을 취소합니다.
                    finish();//현재 activity를 종료합니다.
                }
            });
        }
    }

