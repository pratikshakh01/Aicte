package com.example.aicte;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class rvadapter extends RecyclerView.Adapter<rvadapter.ViewHolder> {

    Context context ;
    ArrayList <Student> list;
    View.OnClickListener listner;
    public rvadapter(Context context ,ArrayList<Student> list)
    {
        this.context = context;
        this.list = list ;
    }

    public rvadapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.data,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    Student student = list.get(position);
    holder.sname.setText(student.getName());
    holder.susn.setText(student.getUsn());
    holder.sbranch.setText(student.getBranch());
    //holder.ssec.setText(student.getSec());
    holder.spoints.setText(student.getPoints());
    holder.showremark.setText(student.getRemarks());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView sname ;
        public TextView susn ;
        public TextView sbranch ;
        public Button update;
        public TextView spoints ;
        public TextView remarks;
        public TextView getusn;
        public TextView updatepoint ;
        public  TextView showremark ;
  //      DatabaseReference databaseReference;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            sname = (TextView) itemView.findViewById(R.id.sname);
            susn = itemView.findViewById(R.id.susn);
            showremark = itemView.findViewById(R.id.textView4);
            sbranch = itemView.findViewById(R.id.sbranch);
            getusn = itemView.findViewById(R.id.susn);
            spoints = itemView.findViewById(R.id.spoints);
            updatepoint = itemView.findViewById(R.id.editTextTextPersonName6);
            remarks = itemView.findViewById(R.id.editTextTextPersonName7);
            update = itemView.findViewById(R.id.button5);
            DatabaseReference databaseReference;
            FirebaseDatabase firebaseDatabase ;
            firebaseDatabase = FirebaseDatabase.getInstance();
            databaseReference = firebaseDatabase.getReference("Mentor");




            update.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                databaseReference.addValueEventListener(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot snapshot) {
//                        for(DataSnapshot dataSnapshot : snapshot.child(usn).child(point).getChildren());
//                            Student value = (Student) snapshot.getValue();
//                            value.getPoints();
                    String get_points = spoints.getText().toString();
                    String update_remark = showremark.getText().toString();
                    String get_remarks = update_remark+"\n"+ remarks.getText().toString();

                    String updatepoints = updatepoint.getText().toString();
                    String get_usn = getusn.getText().toString();

                    int p1= Integer.parseInt(get_points);
                    int p2=Integer.parseInt(updatepoints);
                    int sum=p1+p2;
                    updatepoints=String.valueOf(sum);

                    databaseReference.child(get_usn).child("points").setValue(updatepoints);
                    databaseReference.child(get_usn).child("remarks").setValue(get_remarks);



//                    }
//
//                    @Override
//                    public void onCancelled(@NonNull DatabaseError error) {
//
//                    }
//                });
//                    String get_points = susn.getText().toString();
//                    String get_remarks = spoints.getText().toString();
//
//                    databaseReference.child("points").setValue(get_points);
//                    databaseReference.child("remarks").setValue(get_remarks);
                    notifyDataSetChanged();

                }
            });

        }


    }
}
