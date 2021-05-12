package sg.edu.np.practical2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Random;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;

public class ListActivity extends AppCompatActivity {
    static ArrayList<user> obj = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        Random rand = new Random();

        for (int i = 0; i < 20; i++)
        {

            int randName = rand.nextInt();
            int randDesc = rand.nextInt();
            int randFollowed = rand.nextInt();

            user u = new user();
            u.setName("Dave " + randName);
            u.setDesc("Description " + randDesc);

            if(randFollowed % 2 == 0)
            {
                u.setFollowed(true);
            }
            else
            {
                u.setFollowed(false);
            }

            obj.add(u);


        }

        RecyclerView rv = findViewById(R.id.rv);
        UsersAdapter adapter = new UsersAdapter( this, obj);
        LinearLayoutManager lm = new LinearLayoutManager(this);
        rv.setLayoutManager(lm);
        rv.setAdapter(adapter);
//        img.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                AlertDialog.Builder builder1 = new AlertDialog.Builder(ListActivity.this);
//                builder1.setMessage("MADness");
//                builder1.setTitle("Profile");
//                builder1.setCancelable(true);
//
//                builder1.setPositiveButton(
//                        "View",
//                        new DialogInterface.OnClickListener() {
//                            public void onClick(DialogInterface dialog, int id) {
//                                Random rand = new Random();
//                                int number = rand.nextInt();
//                                Intent goToMainActivity = new Intent(ListActivity.this, MainActivity.class);
//                                goToMainActivity.putExtra("randomInt", number);
//                                startActivity(goToMainActivity);
//                            }
//                        });
//                builder1.setNegativeButton(
//                        "Close",
//                        new DialogInterface.OnClickListener() {
//                            public void onClick(DialogInterface dialog, int id) {
//                                dialog.cancel();
//                            }
//                        });
//
//                AlertDialog alert11 = builder1.create();
//                alert11.show();
//            }
//        });
    }


}