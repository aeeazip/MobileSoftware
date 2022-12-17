package ddwucom.mobile.finalreport;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {
    private final Context context;
    private int layout;
    private ArrayList<MyData> list;
    private LayoutInflater layoutInflater;

    public MyAdapter(Context context, int layout, ArrayList<MyData> list){
        this.context = context;
        this.layout = layout;
        this.list = list;
        layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    static class ViewHolder{
        TextView tvNo;
        ImageView imageView;
        TextView name;
        TextView company;
        TextView explanation;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return list.get(i).get_id();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        int position = i;
        ViewHolder holder;

        if(view == null){
            view = layoutInflater.inflate(layout, viewGroup, false);

            holder = new ViewHolder();
            holder.tvNo = view.findViewById (R.id.tvNo);
            holder.imageView = view.findViewById (R.id.foodImage);
            holder.name = view.findViewById (R.id.foodName);
            holder.company = view.findViewById (R.id.company);
            holder.explanation = view.findViewById(R.id.explanation);
            view.setTag(holder);
        } else{
            holder = (ViewHolder)view.getTag();
        }

        holder.tvNo.setText(Integer.valueOf((int) list.get(position).get_id()).toString());
        holder.name.setText(list.get(position).getName());
        holder.company.setText(list.get(position).getCompany ());
        holder.explanation.setText(list.get(position).getExplanation ());

        switch(list.get(position).getImageSrc()){
            case "chapagetti":
                holder.imageView.setImageResource (R.mipmap.chapagetti);
                break;
            case "shin":
                holder.imageView.setImageResource (R.mipmap.shin);
                break;
            case "raccoon":
                holder.imageView.setImageResource (R.mipmap.raccoon);
                break;
            case "samyang":
                holder.imageView.setImageResource (R.mipmap.samyang);
                break;
            case "hotchicken":
                holder.imageView.setImageResource (R.mipmap.hotchicken);
                break;
        }

        return view;
    }
}
