package sg.edu.np.practical2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        TextView name = findViewById(R.id.nameTxt);
        TextView desc = findViewById(R.id.descriptionTxt);
        Button follow = findViewById(R.id.followBtn);
        Button message = findViewById(R.id.messageBtn);

        user newUser = new user("Dave", "Description about Dave", 1, false, 20);


        Intent receivingEnd = getIntent();
        int randomInt = receivingEnd.getIntExtra("randomInt",0);

        message.setText("MESSAGE");
        name.setText(newUser.name + randomInt);
        desc.setText(newUser.desc);


        ArrayList<user> data = new ArrayList<user>();
        for(int i = 0; i < 20; i++)
        {
            user u = new user();
            u.setAge(i+1);
            u.setName("Name " + i);

            data.add(u);
        }

        RecyclerView rv = findViewById(R.id.rv);
        UserAdapter adapter = new UserAdapter( this, data);
        LinearLayoutManager lm = new LinearLayoutManager(this);
        rv.setLayoutManager(lm);
        rv.setAdapter(adapter);

        if (newUser.followed == false)
        {
            follow.setText("FOLLOW");
        }
        else
        {
            follow.setText("UNFOLLOW");
        }

        follow.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Context context = getApplicationContext();
                CharSequence toastMessage = "";
                int duration = Toast.LENGTH_SHORT;
                if(newUser.followed == true)
                {
                    toastMessage = "Unfollowed";
                    follow.setText("FOLLOW");
                    newUser.followed = false;
                }
                else
                {
                    toastMessage = "Followed";
                    follow.setText("UNFOLLOW");
                    newUser.followed = true;
                }
                Toast toast = Toast.makeText(context, toastMessage, duration);
                toast.show();
            }
        });

    }
}