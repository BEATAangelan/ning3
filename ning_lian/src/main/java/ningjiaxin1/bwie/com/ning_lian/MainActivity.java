package ningjiaxin1.bwie.com.ning_lian;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {
    private UserDao dao;
   private WaterFallView water;
private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        water = findViewById(R.id.water);
        initView();
    }
    public void initView(){
        dao = new UserDao(this);
        List<UserBean> select = dao.select();
        for(int i=0;i<select.size();i++){
            textView = new TextView(MainActivity.this);
            textView.setText(select.get(i).getName());
            water.addView(textView);
        }
        final EditText edit = findViewById(R.id.edit);
        final UUID uuid = UUID.randomUUID();
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textView = new TextView(MainActivity.this);
                textView.setText(edit.getText());
                textView.setTextColor(Color.BLUE);
                textView.setBackgroundResource(R.drawable.shape);
                water.addView(textView);
                dao.add(textView.getText().toString(),uuid.toString());
            }
        });
    }
}
