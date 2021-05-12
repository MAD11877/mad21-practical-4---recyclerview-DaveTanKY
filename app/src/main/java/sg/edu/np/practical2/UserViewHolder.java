package sg.edu.np.practical2;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class UserViewHolder extends RecyclerView.ViewHolder{

    public TextView name, age;
    public View view;
    public UserViewHolder(@NonNull View itemView) {
        super(itemView);

        name = itemView.findViewById(R.id.txtName);
        age = itemView.findViewById(R.id.txtAge);
        view = itemView;
    }
}
