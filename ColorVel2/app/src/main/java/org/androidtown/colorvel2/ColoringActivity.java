package org.androidtown.colorvel2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class ColoringActivity extends AppCompatActivity {

    LinearLayout toolLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coloring);

        // ImageView simple_image = (ImageView)findViewById(R.id.simple_image);
        // setImage(simple_image);

        toolLayout = (LinearLayout)findViewById(R.id.toolLayout); //XML에 있는 toolLayout을 활성화
        toolLayout.setVisibility(View.GONE); //화면에 toolLayout을 숨겨놓음
    }

    /*private void setImage(ImageView imageView){
        Intent receivedIntent = getIntent();

        int images = (int)receivedIntent.getExtras().get("images");
        imageView.setImageResource(images);
    }*/

    public void onClick(View v){
        switch(v.getId()){
            case R.id.moreButton: //moreButton이 눌렸을 때
                /* toolLayout 감췄다 나타내기 */
                    if (toolLayout.getVisibility() == View.GONE) //toolLayout이 화면에 보이지 않는 상태라면
                    toolLayout.setVisibility(View.VISIBLE); //화면에 보이기
                else if (toolLayout.getVisibility() == View.VISIBLE) //toolLayout이 화면에 보이는 상태라면
                    toolLayout.setVisibility(View.GONE); //화면에서 감추기

            case R.id.saveButton:
                /* 저장 버튼 (저장 확인 대화상자) */
                //AlertDialog.Builder alert = new AlertDialog.Builder(ColoringActivity.this);
                //alert.setTitle("저장");
                //alert.setMessage("저장되었습니다.");
                //alert.show();
                Toast.makeText(ColoringActivity.this, "저장되었습니다.", Toast.LENGTH_LONG).show(); //저장되었다는 토스트메세지 띄우기

            case R.id.eraseButton:
                /* 지우개 버튼 */

            case R.id.backButton:
                /* 이전 버튼 */

            case R.id.brushButton:
                /* 브러쉬 버튼 */

            case R.id.touchButton:
                /* 확대 버튼 */

                break;
        }
    }
}
