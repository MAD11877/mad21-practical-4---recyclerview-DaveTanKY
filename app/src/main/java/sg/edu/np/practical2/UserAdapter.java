package sg.edu.np.practical2;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserViewHolder> {
    Context context;
    ArrayList<user> data;
    public UserAdapter(Context c, ArrayList<user> d)
    {
        context = c;
        data = d;
    }


    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item = null;

//        if(viewType == 0) // multiples of three
//        {
//            item = LayoutInflater.from(parent.getContext()).inflate(R.layout.vh_user_right, parent, false);
//        }
//        else
//        {
//            item = LayoutInflater.from(parent.getContext()).inflate(R.layout.vh_user, parent, false);
//
//        }

        item = LayoutInflater.from(parent.getContext()).inflate(R.layout.vh_user, parent, false);
        Log.d("rv", "on Create View Holder");
        return new UserViewHolder(item);

    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {

        Log.d("RV", "On Bind View Holder" + position);
        user u = data.get(position);
        holder.name.setText(u.getName());
        holder.age.setText("" + u.getAge());
//        holder.view.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                AlertDialog.Builder alert = new AlertDialog.Builder(context);
//                alert.setTitle("Hello")
//                        .setCancelable(true)
//                        .show();
//
//                Intent i = new Intent(context, MainActivity.class);
//                i.putExtra("userInput", u.getName());
//                context.startActivity(i);
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public int getItemViewType(int position) {
        if (data.get(position).getAge() % 3 == 0)
            return 0;
        return 1;
    }
}
