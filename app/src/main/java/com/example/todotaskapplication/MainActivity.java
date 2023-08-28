package com.ZacharyTaylor.todotasks;

import android.graphics.Paint;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.todotaskapplication.ListView;
import com.example.todotaskapplication.R;
import com.example.todotaskapplication.string;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<String> toDolist;
    ArrayAdapter<String> arrayAdapter;
    ListView listView;

    EditText editText;

    @override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toDoList = new ArrayList<>();
        arrayAdapter = new ArrayAdapter<>( context: this, R.layout.list_view_layout,toDolist);
        listview = findViewById(R.id.id_list_view);

        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()   {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView textView = (TextView) view;
                textView.setPaintFlags(textView.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            }
        });

        editText = findViewById(R.id.id_edit_text);
    }

    public void addItemToList(View view)  {
        toDolist.add(editText.getText().toString());
        arrayAdapter.notidyDataSetChanged();

        editText.setText("");
    }
}
