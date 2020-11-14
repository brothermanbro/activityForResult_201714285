package kr.ac.konkuk.activityforresult_201714285;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class SubActivity extends AppCompatActivity {
    EditText edit;
    TextView text;
    static final int GET_STRING2 = 2;//SubActivity2를 구별할 requestCode를 생성합니다.

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sub);
        edit = (EditText) findViewById(R.id.edit);
        Button ok = (Button) findViewById(R.id.ok);
        Button cancel = (Button) findViewById(R.id.cancel);
        Button sub2 = (Button) findViewById(R.id.subActivity2);
        text = (TextView) findViewById(R.id.textView);
        sub2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(SubActivity.this, SubActivity2.class);//버튼을 누르면 SubActivity2를 불러오게 합니다.
                startActivityForResult(in, GET_STRING2);//SubActivity2에 request code를 지정하고 시작합니다.
            }
        });

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();//인텍트 객체를 생성하고
                intent.putExtra("a", edit.getText().toString());//data name을 a로 정하고 에디트 텍스트의 값을 a에 저장합니다.
                intent.putExtra("c",text.getText().toString());//data name을 c로 정하고 텍스트에 저장 되어 있는 SubActivity2에서 받은 값을 c에 저장합니다.
                setResult(RESULT_OK, intent);//MainActivity로 응답을 보냅니다.
                finish();//헌재 activity를 종료합니다.
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(RESULT_CANCELED);// 작업을 츼소하고
                finish();//종료합니다.
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {//startActivityForResult로 생성한 activity의 응답을 받습니다.

        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == GET_STRING2) {//requestCode로 SubActivity2를 구별합니다.
            if (resultCode == RESULT_OK) {//SubActivity2에서 보낸 data를 받습니다.
                text.setText(data.getStringExtra("b"));//data b를 text에 저장하고 출력합니다.

            }
        }

    }
}
