package ddwucom.mobile.week10.customadaptertest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private ArrayList<MyData> myDataList;
    private LayoutInflater layoutInflater;

    public MyAdapter(Context context, int layout, ArrayList<MyData> myDataList){
        this.context = context;
        this.layout = layout;
        this.myDataList = myDataList;
        layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    /*
    static class ViewHolder{
        TextView textNo;
        TextView textName;
        TextView textPhone;
        Button btnCheck;
    }

     */

    public int getCount(){
        return myDataList.size();
    }

    public Object getItem(int i){
        return myDataList.get(i);
    }

    public long getItemId(int i){
        return myDataList.get(i).get_id();
    }

    public View getView(int i, View view, ViewGroup viewGroup){

        final int position = i;


        if(view == null){
            view = layoutInflater.inflate(layout, viewGroup, false);
        }

        TextView tvNo = view.findViewById (R.id.tvNo);
        TextView tvName = view.findViewById (R.id.tvName);
        TextView tvPhone = view.findViewById (R.id.tvPhone);
        Button btnCheck = view.findViewById (R.id.btnCheck);
        btnCheck.setFocusable(false);

        tvNo.setText(String.valueOf(myDataList.get(position).get_id()));
        tvName.setText(String.valueOf(myDataList.get(position).getName()));
        tvPhone.setText(String.valueOf(myDataList.get(position).getPhone()));
        tvName.setOnTouchListener(new View.OnTouchListener(){

            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Toast.makeText(context, "Touch", Toast.LENGTH_SHORT).show();
                return true;
            }
        });

        btnCheck.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View view) {
                Toast.makeText(context, myDataList.get(position).getPhone() + "??????", Toast.LENGTH_SHORT).show();
            }
        });

        return view;


        /*
        ViewHolder holder;

        if(view == null){
            view = layoutInflater.inflate(layout, viewGroup, false);

            holder = new ViewHolder();
            holder.textNo = view.findViewById (R.id.tvNo);
            holder.textName = view.findViewById (R.id.tvName);
            holder.textPhone = view.findViewById (R.id.tvPhone);
            holder.btnCheck = view.findViewById (R.id.btnCheck);
            view.setTag(holder);
        } else{
            holder = (ViewHolder)view.getTag();
        }

        holder.textNo.setText(Integer.valueOf((int) myDataList.get(position).get_id()).toString());
        holder.textName.setText(myDataList.get(position).getName());
        holder.textPhone.setText(myDataList.get(position).getPhone());
        holder.btnCheck.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View view) {
                Toast.makeText(context, myDataList.get(position).getPhone() + "??????", Toast.LENGTH_SHORT).show();
            }
        });



        // TextView ???????????? ?????? ?????? Toast ??????
        holder.textNo.setOnClickListener(new TextView.OnClickListener(){

            @Override
            public void onClick(View view) {
                Toast.makeText(context, "textNo ??????", Toast.LENGTH_SHORT).show();
            }
        });

        holder.textName.setOnClickListener(new TextView.OnClickListener(){

            @Override
            public void onClick(View view) {
                Toast.makeText(context, "textName ??????", Toast.LENGTH_SHORT).show();
            }
        });

        holder.textPhone.setOnClickListener(new TextView.OnClickListener(){

            @Override
            public void onClick(View view) {
                Toast.makeText(context, "textPhone ??????", Toast.LENGTH_SHORT).show();
            }
        });



        return view;

         */

    }
}
